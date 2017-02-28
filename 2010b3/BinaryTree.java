public class BinaryTree {

	public static int min (int a, int b) {
		if (a <= b)
			return a;
		else
			return b;	
	}
	
	public static boolean isLeaf (Node t) {
		if (t.getLeftSon() == null && t.getRightSon() == null)
			return true;
		else
			return false;
	}
	
	public static int f(Node t) {
		if (t == null)
			return 0;
		return 1 + min (f(t.getLeftSon()), f (t.getRightSon()));
	}
	
	public static Node what (Node t) {
		return what (t, f(t));
	}
	
	private static Node what (Node t, int num) {
		if ((t == null) || ((num == 1) && (isLeaf(t))))
			return t;
		Node temp = what(t.getLeftSon(), num-1);
		if (temp != null)
			return temp;
		return what (t.getRightSon(), num-1);
	}
}

	