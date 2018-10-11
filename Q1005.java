import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1005 {
//	static int[] v = new int[1001];
//	static int[] p = new int[1001];
	static int[] v;
	static int[] p;
	
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// nextToken()을 통해 띄어쓰기(" ")를 제거하고 남은 숫자를 스트링 형태에서 int로 형변환하여 arr에 저장. k++를 이용해
			// 인덱스 증가
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			v = new int[n+1];
			p = new int[n+1];

			for (int q = 0; q <= n; q++) {
				v[q] = -1;
				p[q] = -1;
			}

//			v = new int[n+1];

			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

			for (int q = 1; q <= n; q++) { // time

				v[q] = Integer.parseInt(st2.nextToken());
			}

			// 서순

//			p = new int[n+1];

			for (int z = 1; z <= k; z++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st3.nextToken());
				int b = Integer.parseInt(st3.nextToken());

				ArrayList<Integer> arr = null;
				if (map.containsKey(b)) {
					arr = map.get(b);
				} else {
					arr = new ArrayList<Integer>();
				}
				arr.add(a);
				map.put(b, arr);
			}

			int f = Integer.parseInt(br.readLine());
			bw.write(dp(f) + "\n");
			map.clear();

		}
		br.close();
		bw.close();
	}

	public static int dp(int n) {
		int max = -1;
		if (p[n] > 0) {
			return p[n];
		}

		ArrayList<Integer> arr = null;
		if (map.containsKey(n)) {
			arr = map.get(n);
			for (int z : arr) {
				int r = dp(z);
				if (max < r) {
					max = r;
				}
			}
		} else {
			return v[n];
		}
		
		p[n] = v[n] + max;

		return p[n];
	}
}
