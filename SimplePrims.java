import java.util.*;

class PrimsWithAdjList {

    static class Edge {
        int vertex, weight;

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    int V;
    List<List<Edge>> adj;

    PrimsWithAdjList(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add undirected edge
    void addEdge(int u, int v, int w) {
        adj.get(u).add(new Edge(v, w));
        adj.get(v).add(new Edge(u, w));
    }

    void primMST() {
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];           // Minimum weight edge to each vertex
        int[] parent = new int[V];        // Stores MST structure
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Start from vertex 0
        key[0] = 0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            if (inMST[u]) continue;
            inMST[u] = true;

            for (Edge edge : adj.get(u)) {
                int v = edge.vertex;
                int weight = edge.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Edge(v, key[v]));
                }
            }
        }

        // Print the MST
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + key[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        PrimsWithAdjList graph = new PrimsWithAdjList(V);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}
