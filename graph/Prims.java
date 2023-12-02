package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int distance;
    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}
class Mst {
    int node;
    int distance;
    int parent;
    public Mst(int distance, int node, int parent) {
        this.distance = distance;
        this.node = node;
        this.parent = parent;
    }
}
public class Prims {
    public static void main(String[] args) {
        int v = 3;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        
        for(int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new ArrayList<>(List.of(1, 5)));
        adj.get(1).add(new ArrayList<>(List.of(0, 5)));

        adj.get(0).add(new ArrayList<>(List.of(2, 1)));
        adj.get(2).add(new ArrayList<>(List.of(0, 1)));
    
        adj.get(1).add(new ArrayList<>(List.of(2, 3)));
        adj.get(2).add(new ArrayList<>(List.of(1, 3)));

        int weightResult = spanningTreeWeight(v, adj);
        System.out.println("Minimum Spanning Tree Weight: " + weightResult);

        ArrayList<ArrayList<Integer>> mstResult = mst(v, adj);
        System.out.println("Minimum Spanning Tree: " + mstResult);
    }
    private static int spanningTreeWeight(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        boolean[] visited = new boolean[v];
        pq.add(new Pair(0, 0));
        int sum = 0;

        while(pq.size() > 0) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if(visited[node] == false) {
                visited[node] = true;
                sum += wt;

                for(int i = 0; i < adj.get(node).size(); i++) {
                    int edW = adj.get(node).get(i).get(1);
                    int adjNode = adj.get(node).get(i).get(0);
                    if(visited[adjNode] == false) {
                        pq.add(new Pair(edW, adjNode));
                    }
                }
            }
        }
        return sum;
    }
    private static ArrayList<ArrayList<Integer>> mst(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Mst> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        boolean[] visited = new boolean[v];
        pq.add(new Mst(0, 0, 0));
        ArrayList<ArrayList<Integer>> mst = new ArrayList<ArrayList<Integer>>();

        while(pq.size() > 0) {
            int node = pq.peek().node;
            int parent = pq.peek().parent;
            pq.remove();

            if(visited[node] == false) {
                visited[node] = true;

                if(node != parent) {
                    mst.add(new ArrayList<>(List.of(node, parent)));
                }

                for(int i = 0; i < adj.get(node).size(); i++) {
                    int edW = adj.get(node).get(i).get(1);
                    int adjNode = adj.get(node).get(i).get(0);
                    int adjParent = node;
                    if(visited[adjNode] == false) {
                        pq.add(new Mst(edW, adjNode, adjParent));
                    }
                }
            }
        }
        return mst;
    }
}
