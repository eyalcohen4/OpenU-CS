import java.util.Random;

public class IntVector
{
	private int []_arr;
	
	public IntVector(int size){ _arr = new int[size];}
	
	public void fillArray() {
		Random generator = new Random();
		for (int i=0; i<_arr.length; i++)
			_arr[i] = generator.nextInt(20)-10;
	}

	public void printArray() {
		System.out.print ("Array is: ");
		for (int i=0; i<_arr.length; i++)
			System.out.print (_arr[i]+ " ");
		System.out.println();
	}
	
	public int what2() {
		int max, sum = 0, tempsum;
		for (int i=0; i<_arr.length; i++)
			sum += _arr[i];
		max = sum;
		for (int i=0; i<_arr.length; i++) {
			tempsum = sum;
			if (tempsum > max)
					max = tempsum;
			for (int j=_arr.length -1; j>= i+1; j--) {
				tempsum -=_arr[j];
				if (tempsum > max)
					max = tempsum;
			}
			sum -= _arr[i];
		}
		return max;
	}
				
	public int what () {
		int m=_arr[0];
		for (int i=0; i<_arr.length; i++)
			for (int j=i; j<_arr.length; j++) {
				int s=_arr[i];
				for (int k=i+1; k<=j; k++)
					s+= _arr[k];
				if (s > m)
					m=s;
			}
		return m;
	}
}
		