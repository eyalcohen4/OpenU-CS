public class CharList {
	private CharNode _head;
	
	public CharList(CharNode cn) {
		_head = cn;
	}
	
	public String toString() {
		CharNode temp = _head;
		String s="";
		while (temp != null) {
			s += temp.getValue();
			temp = temp.getNext();
		}
		return s;
	}
		
	public static boolean isTrans (CharList list1, CharList list2) {
		return isTrans (list1._head, list2._head);
	}
	
	private static boolean isTrans (CharNode p1, CharNode p2) {
		if (p1 == null)
			if (p2 == null)
				return true;
			else
				return false;
		char ch = p1.getValue();
		CharNode ptemp = new CharNode (' ',null);
		int count1 = isTrans(p1, ch, ptemp);
		p1 = ptemp.getNext();
		int count2 = isTrans(p2, ch, ptemp);
		p2 = ptemp.getNext();
		return  (count2 >= count1) && isTrans (p1, p2);
	}
	
	private static int isTrans (CharNode p, char ch, CharNode ptemp){
		if (p == null) {
			ptemp.setNext(p);
			return 0;
		}
		if (p.getValue() == ch)
			return isTrans (p.getNext(), ch, ptemp) + 1;
		else{
			ptemp.setNext(p);
			return 0;
		}
	}		
}