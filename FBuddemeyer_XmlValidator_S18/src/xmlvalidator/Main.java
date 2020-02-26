package xmlvalidator;

import static sbcc.Core.*;
import java.util.regex.*;

import java.io.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.*;
import java.util.*;
import java.util.regex.Pattern;
import static java.lang.System.*;
import static org.apache.commons.lang3.StringUtils.*;

public class Main {

	public static void main(String[] args) throws Exception {

		/*
		 * BasicStringStack stack = new BasicStringStack();
		 * 
		 * String tester =
		 * " <hey> hhhhhhhdhdh  jfjfjfj <self /> fjjf <yo> fjfjfjfjf </yo> jfjfjjf<!-- bob --> ffkk ff <bob/>"
		 * ;
		 * 
		 * ArrayList<String> a = new ArrayList<String>();
		 * 
		 * // String content = readFile(readLine()); Pattern p =
		 * Pattern.compile("<(.|\\n)+?>");
		 * 
		 * Matcher matcher = p.matcher(tester); int excludeCount = 0; while
		 * (matcher.find()) { if (matcher.group(0).contains("/>") ||
		 * matcher.group(0).contains("<!--") || matcher.group(0).contains("<?"))
		 * excludeCount++; else a.add(matcher.group(0)); println(matcher.start());
		 * println(matcher.end());
		 */
		// Build a regular expression pattern
		/*
		 * String expr = "<[^<>]+>"; Pattern p = Pattern.compile(expr);
		 * 
		 * String text = readFileToString(new File("invalid.xml"));
		 * 
		 * // Get a matcher to process our XML string Matcher m = p.matcher(text);
		 * 
		 * // Find all of the matches for expr in text while (m.find())
		 * out.println(m.group() + " located at " + m.start());
		 */
	}

}
