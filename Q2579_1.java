import java.util.Scanner;

public class Q2579_1 {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		int[] in = new int[n+1];
		int[][] p = new int[n+1][2];
		
		for(int i = 1 ; i <= n; i++)
			in[i] = keyboard.nextInt();
		
		p[1][0] = in[1];
		
		for(int i = 2; i<= n; i++) {
			p[i][0] = big(p[i-2][0], p[i-2][1]) + in[i];  
			p[i][1] = p[i-1][0] + in[i];
		}
		
		System.out.println(big(p[n][0],p[n][1]));
	}
	
	public static int big(int a, int b) {
		return a > b ? a : b;
	}
	
//	n 번쨰 계단을 가는데 두 가지의 경로가 있다.
//	1) n-2에서 점프해서 n으로 가는 경우
//	2) n-1에서 한 칸 올라와서 n으로 가는 경우
//
//	위 두 가지 상황에 대한 점수를 기록하는 배열 p를 정의하자.
//	p[n][0] = n-2 계단에서 점프해서 n칸을 밟는 점수
//	p[n][1] = n-1 계단에서 한 칸 올라와서 n칸을 밟는 점수
//
//	자 이제, 우리가 4번째 계단을 지금 올라간다고 생각해보자.
//	1) 3->4 경로. 
//	계단 3까지 올라왔을 때의 최고 누적 점수 + 계단4의 점수 = 계단4까지 올라왔을 떄의 최고 누적 점수이다.
//	계단 3은 1->3 경우와, 2->3 경우가 있다.
//	하지만 2->3은 사용할 수가 없다.
//	왜냐하면 2->3->4이 되어 연속된 세 개의 계단을 갈 수 없기 때문이다.
//	따라서  1->3만 사용할 수 있다.
//	p[n][1] = p[n-1][0] + 계단 4점수
//
//	2)2->4 경로
//	계단2는 1->2 경우와, 0->2경우가 있다.
//	1->2->4 와, 0->2->4 두 가지 모두 가능하기 때문에
//	이중 더 큰 값을 사용해야한다.
//	p[n][0] = big(p[n-2][0], p[n-2][1]) + 계단4점수
//
//	그리고 p[n][0]과 p[n][1] 를 비교하여 더 큰 값을 뽑아내면
//	n계단에 올랐을 때 얻을 수 있는 최고 점수를 알 수 있다.
}
