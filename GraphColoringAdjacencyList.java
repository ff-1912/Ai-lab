import java.util.*;

class SimpleGraphColoring {

    static class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u);  // undirected
        }

        boolean isSafe(int v, int[] colors, int c) {
            for (int neighbor : adj.get(v)) {
                if (colors[neighbor] == c)
                    return false;
            }
            return true;
        }

        boolean colorGraph(int v, int[] colors, int m) {
            if (v == V) return true;

            for (int c = 1; c <= m; c++) {
                if (isSafe(v, colors, c)) {
                    colors[v] = c;
                    if (colorGraph(v + 1, colors, m)) return true;
                    colors[v] = 0; // backtrack
                }
            }
            return false;
        }

        void solve(int m) {
            int[] colors = new int[V];
            if (colorGraph(0, colors, m)) {
                System.out.println("Coloring possible:");
                for (int i = 0; i < V; i++) {
                    System.out.println("Vertex " + i + " -> Color " + colors[i]);
                }
            } else {
                System.out.println("Coloring not possible with " + m + " colors.");
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        int m = 3;  // number of colors
        g.solve(m);
    }
}
