import java.util.Scanner;

public class Q2579 {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		int[][] p = new int[n+1][n+1];
		int[] v = new int[n+1];
		
		for(int i = 1; i <= n; i++)
			v[i] = keyboard.nextInt();
		
		p[0][1] = v[1]; p[0][2] = v[2]; p[1][2] = v[1] + v[2];
		p[1][3] = v[1] + v[3]; p[2][3] = v[2] + v[3];
		
		for(int i = 4; i <= n ;i++) {
			p[i-2][i] = big(v[i] + p[i-3][i-2], v[i] + p[i-4][i-2]);
			p[i-1][i] = v[i] + p[i-3][i-1];
		}
		
		System.out.println(big(p[n-1][n], p[n-2][n]));
		
		
	}
	
	public static int big(int a, int b) {
		return a > b ? a : b;
	}
}
