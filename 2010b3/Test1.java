import java.util.Scanner;

public class Test1 {

	public static void main (String[] args) {
		String answer;
		System.out.println ("QUESTION #1");
		System.out.println ("***********");
		do {
			System.out.print ("Enter 1st String: ");
			CharList list1 = ScanString();
			System.out.println ("list1 = " + list1);
			System.out.print ("Enter 2nd String: ");
			CharList list2 = ScanString();
			System.out.println ("list2 = " + list2);
			System.out.println ("isTrans (list1, list2) = " + CharList.isTrans(list1,list2));
			System.out.print ("\nMore tests y/n?");
			Scanner scan = new Scanner (System.in);
			answer = scan.nextLine();
		} while (answer.charAt(0) == 'y');	

		System.out.println ("\nQUESTION #2");
		System.out.println ("***********");
		IntVector iv = new IntVector (10);
		for (int i=1; i<10; i++){
			iv.fillArray();
			iv.printArray();
			int what = iv.what();
			int what2 = iv.what2();
			System.out.println ("what  = " + what);
			System.out.println ("what2 = " + what2); 
			if (what != what2){
				System.out.println ("error!!!!!!!!!");
				return;
			}			
		}
			
		System.out.println ("\nQUESTION #3");
		System.out.println ("***********");
		Node[] n = new Node[10];
		n[1]=new Node (25,null,null);
		n[2]=new Node (50,null,null);
		n[3]=new Node (5,n[2],n[1]);
		n[4]=new Node (45,null,null);
		n[5]=new Node (30,n[4],null);
		n[6]=new Node (20,n[5],n[3]);
		n[7]=new Node (10,null,null);
		n[0]=new Node (40,n[6],n[7]);
		System.out.println ("method f():");
		for (int i=0;i < 8; i++)
			System.out.println ("f(" + n[i].getNumber()+") = " + BinaryTree.f(n[i]));
		System.out.println ("\nmethod what():");
		for (int i=0;i < 8; i++)
			if (BinaryTree.what(n[i]) != null)
				System.out.println ("what(" + n[i].getNumber()+") = " + BinaryTree.what(n[i]).getNumber());
			else
				System.out.println ("what(" + n[i].getNumber()+") = null"); 

		System.out.println ("\nQUESTION #5");
		System.out.println ("***********");
		String s="apple";
		System.out.println ("String is:    " + s);
		System.out.println ("f1 is:        " + Question4.f1(s));
		System.out.println ("f2 is:        " + Question4.f2(s));
		System.out.println ("what is:      " + Question4.what(Question4.f1(s),Question4.f2(s)));
		System.out.println ("something is: " + Question4.something(s));

		System.out.println();
		s="hello-world-how-original";
		System.out.println ("String is:    " + s);
		System.out.println ("f1 is:        " + Question4.f1(s));
		System.out.println ("f2 is:        " + Question4.f2(s));
		System.out.println ("what is:      " + Question4.what(Question4.f1(s),Question4.f2(s)));
		System.out.println ("something is: " + Question4.something(s));
	}	

	public static CharList ScanString() {			
		Scanner scan = new Scanner (System.in);
		String s = scan.nextLine();
		CharNode[] cn = new CharNode[s.length()];
		CharNode temp = null;
		for (int i=s.length()-1; i>=0;i--) {
			cn[i]=new CharNode(s.charAt(i),temp);
			temp = cn[i];
		}
		CharList list1 = new CharList(cn[0]);
		return list1;
	}

}
	