import java.io.*;
import java.util.*;

public class Journey {

	BufferedReader br;
	PrintWriter out;
	StringTokenizer st;
	boolean eof;

	List<Integer>[] g;

	int[] farDown, farDown2;
	int[] far;

	void dfs(int v, int p) { 
		for (int to : g[v]) {
			if (to != p) {
                dfs(to, v);
                System.out.println("to is"+to+" and "+"v is "+v);
				if (farDown[to] + 1 > farDown[v]) {                       //TO NODES ARE AT DIFFERENT LEVEL
					farDown2[v] = farDown[v];
                    farDown[v] = farDown[to] + 1;
                    System.out.println(farDown2[v]+"----"+farDown[v]);
				} else if (farDown[to] + 1 > farDown2[v]) {
                    farDown2[v] = farDown[to] + 1;                               //FD2[] - KEEPS TRACK OF NO. OF CHILDREN
                    System.out.println(farDown2[v]+"!!!!");
				}
			}
		}
	}

	void dfs2(int v, int p, int upFar) {

//		System.err.println(v + " " + p + " " + upFar);

		far[v] = Math.max(upFar, farDown[v]);
		for (int to : g[v]) {
			if (to != p) {
				int newUpFar = upFar + 1;
				if (farDown[v] == farDown[to] + 1) {
					if (farDown2[v] != -1) {
						newUpFar = Math.max(newUpFar, farDown2[v] + 1);
					}
					else{
                        System.out.println("++++++++");
                    }
				} else {
					newUpFar = Math.max(newUpFar, farDown[v] + 1);
					System.out.println(v+"------!!!@@"+to);
                }
                System.out.println(newUpFar+"#"+ v+" #"+ to);
				dfs2(to, v, newUpFar);
			}
		}
	}

	void solve() throws IOException {
		int n = nextInt();
		int m = nextInt();

		g = new List[n];
		for (int i = 0; i < n; i++) {
			g[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			int v1 = nextInt() - 1;
			int v2 = nextInt() - 1;
			g[v1].add(v2);
			g[v2].add(v1);
		}

		farDown = new int[n];
		farDown2 = new int[n];
		Arrays.fill(farDown2, -1);
		dfs(0, -1);

		far = new int[n];

		dfs2(0, -1, 0);
		int diam = -1;
		for (int x : far) {
            System.out.print(x+"  *");
			diam = Math.max(diam, x);
		}

		while (m-- > 0) {
			int st = nextInt() - 1;
			int times = nextInt();
			long outp = far[st] + (long) (times - 1) * diam;
			out.println(outp);
		}
	}

	Journey() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		new Journey();
	}

	String nextToken() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
				eof = true;
				return null;
			}
		}
		return st.nextToken();
	}

	String nextString() {
		try {
			return br.readLine();
		} catch (IOException e) {
			eof = true;
			return null;
		}
	}

	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
}
