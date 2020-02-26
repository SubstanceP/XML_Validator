package xmlvalidator;

import java.util.*;

public class BasicStringStack implements StringStack {

	ArrayList<String> stack = new ArrayList<String>();


	@Override
	public void push(String item) {
		stack.add(item);
	}


	@Override
	public String pop() {
		// TODO Auto-generated method stub
		String last;
		if (stack.size() > 0) {
			last = stack.get(stack.size() - 1);
			stack.remove((stack.size() - 1));
		} else
			last = null;
		return last;
	}


	@Override
	public String peek(int position) {
		String pos;
		if (position < 0 || position > stack.size() - 1)
			pos = null;
		else
			pos = stack.get(stack.size() - position - 1);
		return pos;
	}


	@Override
	public int getCount() {
		return stack.size();
	}

}
