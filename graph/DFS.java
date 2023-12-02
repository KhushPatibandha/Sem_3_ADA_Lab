package graph;

import java.util.ArrayList;

public class DFS {
    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean visited[] = new boolean[v];
        int currNode = 0;
        visited[0] = true;

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(4);

        adj.get(4).add(3);
        
        dfs(currNode, visited, adj, dfs);

        System.out.println("DFS traversal starting from vertex 0: " + dfs);

    }
    public static void dfs(int node, boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {
        visited[node] = true;
        dfs.add(node);

        for(Integer it : adj.get(node)) {
            if(visited[it] == false) {
                dfs(it, visited, adj, dfs);
            }
        }
    }
}
