package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

        // Test Case #1
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
        edges.add(new ArrayList<>(Arrays.asList(1, 0, 3)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, -1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 0, 1)));
        int[] result = bellmanFord(3, edges, 2);
        
        // Test Case #2
        // edges.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        // edges.add(new ArrayList<>(Arrays.asList(1, 2, -4)));
        // edges.add(new ArrayList<>(Arrays.asList(2, 0, 2)));
        // edges.add(new ArrayList<>(Arrays.asList(2, 3, 3)));
        // edges.add(new ArrayList<>(Arrays.asList(0, 3, 1)));
        // int[] result = bellmanFord(4, edges, 1);


        if (result[0] == -1) {
            System.out.println("Graph contains a negative cycle.");
        } else {
            System.out.println("Shortest distances from source vertex to all the other vertices is " + Arrays.toString(result));
        }
    }
    private static int[] bellmanFord(int v, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] distance = new int[v];
        for(int i = 0; i < v; i++) {
            distance[i] = (int)(1e8);
        }
        distance[s] = 0;

        for(int i = 0; i < v; i++) {
            for(ArrayList<Integer> it : edges) {
                int a = it.get(0);
                int b = it.get(1);
                int wt = it.get(2);
                if(distance[a] != 1e8 && distance[a] + wt < distance[b]) {
                    distance[b] = distance[a] + wt;
                }
            }
        }
        
        // nth relaxation to check negative cycle
        for(ArrayList<Integer> it : edges) {
            int a = it.get(0);
            int b = it.get(1);
            int wt = it.get(2);
            
            if(distance[a] != 1e8 && distance[a] + wt < distance[b]) {
                int temp[] = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return distance;
    }
}
