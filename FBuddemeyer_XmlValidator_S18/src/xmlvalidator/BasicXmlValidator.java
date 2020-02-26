package xmlvalidator;

import static sbcc.Core.*;

import java.io.*;
import java.util.regex.*;

import org.apache.commons.lang3.*;

import static org.apache.commons.lang3.StringUtils.*;

public class BasicXmlValidator implements XmlValidator {
	private String getName(String match) {
		if (match.startsWith("</"))
			match = match.substring(2, match.length() - 1);
		else {
			match = match.substring(1, match.length() - 1);
		}
		return match.split(" ")[0];
	}


	@Override
	public String[] validate(String xmlDocument) {
		BasicStringStack tagName = new BasicStringStack();
		BasicStringStack tagLineNumber = new BasicStringStack();

		String expr = "<[^<>]+>";
		Pattern p = Pattern.compile(expr);
		// String text = readFile(xmlDocument);
		Matcher m = p.matcher(xmlDocument);

		// Find all of the matches for expr in text
		while (m.find()) {
			String match = m.group();
			if (!match.contains("<?") && !match.contains("<!") && !match.contains("/>")) {
				if (!match.contains("</")) {
					// add or statement for whitespace
					tagName.push(getName(match));
					int lineNumber = countMatches(xmlDocument.substring(0, m.start()), "\n") + 1;
					String lineNum = Integer.toString(lineNumber);
					tagLineNumber.push(lineNum);
					// println("open pushed");
				} else {
					if (tagName.getCount() == 0) {
						// println("orph");
						String[] orphanClose = new String[100];
						orphanClose[0] = "Orphan closing tag";
						orphanClose[1] = getName(match);
						int lineNumber = countMatches(xmlDocument.substring(0, m.start()), "\n") + 1;
						String lineNum = Integer.toString(lineNumber);
						orphanClose[2] = lineNum;
						return orphanClose;
					}

					if (getName(match).equals(tagName.peek(0))) {
						tagName.pop();
						tagLineNumber.pop();
						// println("popped");
					} else {
						// println("error mismatch");
						String[] errorMismatch = new String[100];
						errorMismatch[0] = "Tag mismatch";
						errorMismatch[1] = tagName.peek(0);
						errorMismatch[2] = tagLineNumber.peek(0);
						errorMismatch[3] = getName(match);// match.substring(match.indexOf("/") + 1,
															// match.indexOf(">"));
						int lineNumber = countMatches(xmlDocument.substring(0, m.start()), "\n") + 1;
						String lineNum = Integer.toString(lineNumber);
						errorMismatch[4] = lineNum;
						return errorMismatch;
					}
				}
			}
		}
		if (tagName.getCount() > 0) {
			String[] orphanOpen = new String[100];
			orphanOpen[0] = "Unclosed tag at end";
			orphanOpen[1] = tagName.peek(0);
			orphanOpen[2] = tagLineNumber.peek(0);
			return orphanOpen;
		} else {
			return null;
		}
	}
}
