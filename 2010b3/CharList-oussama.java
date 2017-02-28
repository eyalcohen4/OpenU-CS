public class CharList {
	private CharNode _head;
	private String _str;

	public static void main(String args[]) {
		CharList orgCList = new CharList();
		orgCList.stringToCharList("abbcd");

		String[] strs = { "abbcd", "aaaabbcd", "abbcdddddd", "aabbccdd",
				"abbbccd", "a", "abcd", "aaccbbdd" };
		for (int j = 0; j < strs.length; j++) {

			CharList toCheckCList = new CharList();

			toCheckCList.stringToCharList(strs[j]);

			System.out.println("org=" + orgCList.getString() + ", toCheck="
					+ toCheckCList.getString() + "  Result="
					+ isTrans(orgCList, toCheckCList));
		}

	}

	public CharList() {
		_head = null;
	}

	public void addNode(CharNode node) {
		if (_head == null) {
			_head = node;
		} else {
			node.setNext(_head);
			_head = node;
		}
	}

	public String getString() {
		return _str;
	}

	public void stringToCharList(String str) {
		_str = str;
		for (int i = str.length(); i > 0; i--) {
			CharNode node = new CharNode(str.charAt(i - 1), null);
			addNode(node);

		}

	}

	public static boolean isTrans(CharList list1, CharList list2) {
		CharNode h1 = list1._head;
		CharNode h2 = list2._head;

		if (h1 == null) {
			if (h2 == null) {
				return true;
			} else {
				return false;
			}
		} else if (h2 == null) {
			return false;
		}

		return isTrans(h1, h2, h1.getValue());
	}

	private static boolean isTrans(CharNode h1, CharNode h2, char lastToCheck) {
		if (h1 == null) {
			if (h2 == null) {
				return true;
			} else {
				return isTrans(h1, h2.getNext(), lastToCheck);
			}
		} else if (h2 == null) {
			return false;
		}

		if (h1.getValue() == h2.getValue()) {
			return isTrans(h1.getNext(), h2.getNext(), h1.getValue());
		} else if (h2.getValue() == lastToCheck) {
			return isTrans(h1, h2.getNext(), lastToCheck);
		}

		return false;
	}
}
