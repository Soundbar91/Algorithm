package Silver.II;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24479 {
    static int N;
    static int M;
    static int R;
    static int depth = 1;
    static boolean[] visit;
    static int[] node;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];
        node = new int[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 1; i < graph.size(); i++) Collections.sort(graph.get(i));

        dfs(R);

        for (int i = 1; i < node.length; i++) sb.append(node[i]).append('\n');
        System.out.print(sb);
    }

    public static void dfs(int startPoint){
        visit[startPoint] = true;
        node[startPoint] = depth;

        for (int i = 0; i < graph.get(startPoint).size(); i++){
            int point = graph.get(startPoint).get(i);

            if (!visit[point]){
                visit[point] = true;
                depth++;
                dfs(point);
            }
        }
    }
}
