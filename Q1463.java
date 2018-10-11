import java.util.HashMap;
import java.util.Scanner;

public class Q1463 {
	static HashMap<Integer,Integer> history = new HashMap<Integer,Integer>();
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		System.out.println(dp(n));
		
	}
	
	public static int dp(int n) {
		int a=100000000, b=100000000,c=100000000;
		
		if(n==1)return 0;
	
		if(history.containsKey(n)) return history.get(n);
		
		
		if(n % 3 == 0) a = dp(n/3);
		
		if(n % 2 == 0) b = dp(n/2);
			
		c = dp(n-1);
		
		int m = min(min(a,b),c) + 1;
		history.put(n,m);
		return m;
	}
	
	
	public static int min(int a, int b) {
		return a > b ? b : a;
	}
}
