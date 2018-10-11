import java.util.Scanner;

public class Q1149 {
	public static void main(String args[]) {

		int[][] dp;
		int[][] v;

		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		dp = new int[n + 1][3];
		v = new int[n + 1][3];

		for (int i = 1; i <= n; i++)
			for (int k = 0; k < 3; k++)
				dp[i][k] = keyboard.nextInt();

		for (int i = 1; i <= n; i++)
			for (int k = 0; k < 3; k++) {
				v[i][k] = dp[i][k] + min(v[i - 1][(k + 1) % 3], v[i - 1][(k + 2) % 3]);
			}

		System.out.println(min(min(v[n][0], v[n][1]), v[n][2]));

	}

	public static int min(int a, int b) {
		return a > b ? b : a;
	}
}
