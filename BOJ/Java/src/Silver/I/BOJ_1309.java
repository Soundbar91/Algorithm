package Silver.I;

import java.io.*;

public class BOJ_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        dp[1] = 3;
        dp[2] = 7;

        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] * 2 + dp[i- 2]) % 9901;
        }
        System.out.print(dp[n]);
    }
}