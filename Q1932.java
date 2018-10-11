import java.util.Scanner;

public class Q1932 {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		int[][] in = new int[n+1][n+1];
		int[][] p = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++)
			for(int k = 1; k <= i ; k++)
				in[i][k] = keyboard.nextInt();
		
		for(int i = 1; i <= n; i++)
			for(int k = 1; k<= n; k++) {
				p[i][k] = in[i][k] + max(p[i-1][k] , p[i-1][k-1]);
			}
		
		int biggest = 0;
		for(int k =1 ; k <= n; k++) {
			if(biggest < p[n][k]) biggest = p[n][k];
		}
		
		System.out.println(biggest);
		
		
	}
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
}
