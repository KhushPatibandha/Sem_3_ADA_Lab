package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;
    public Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
public class Dijkstra {
    public static void main(String[] args) {
        int v = 3;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Test Case #1 
        // adj.get(0).add(new ArrayList<>(List.of(1, 9)));
        // adj.get(1).add(new ArrayList<>(List.of(0, 9)));
        // int[] result = dijkstra(v, adj, 0);
        
        // Test Case #2
        adj.get(0).add(new ArrayList<>(List.of(1, 1)));
        adj.get(0).add(new ArrayList<>(List.of(2, 6)));

        adj.get(1).add(new ArrayList<>(List.of(0, 1)));
        adj.get(1).add(new ArrayList<>(List.of(2, 3)));

        adj.get(2).add(new ArrayList<>(List.of(0, 6)));
        adj.get(2).add(new ArrayList<>(List.of(1, 3)));
        int[] result = dijkstra(v, adj, 2);

        
        System.out.println("Shortest distances from source vertex: " + Arrays.toString(result));
    }
    private static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] distance = new int[v];
        for(int i = 0; i < v; i++) {
            distance[i] = (int)(1e8);
        }
        distance[s] = 0;
        pq.add(new Pair(0, s));

        while(!pq.isEmpty()) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for(ArrayList<Integer> it : adj.get(node)) {
                int edW = it.get(1);
                int adjNode = it.get(0);
                
                if(wt + edW < distance[adjNode]) {
                    distance[adjNode] = wt + edW;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }

        return distance;        
    }
}
