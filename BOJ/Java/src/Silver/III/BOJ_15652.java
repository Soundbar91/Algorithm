package Silver.III;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
    static int[] node;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        node = new int[M];

        dfs(0, 0);

        System.out.print(sb);
    }

    public static void dfs(int index, int depth){

        if (depth == M){
            for (int i : node){
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = index; i < N; i++){
            node[depth] = i + 1;
            dfs(i, depth + 1);
        }
    }
}
