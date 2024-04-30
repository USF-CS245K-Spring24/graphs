package exercise04_30;

import java.util.Arrays;

public class Graph {
    private Edge[] graph; // adjacency list for this graph
    private int timeCounter = 0;

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }

    /**
     * DFS implementation that also computes discovery and finish times
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited, and false otherwise
     * @param discovery array of "discovery" times when each vertex is visited
     * @param finish  array of "finish" times (when we are done with each vertex because we explored all of its neighbors)
     */
    public void dfsWithDiscoverFinishTimes(int vertex, boolean[] visited, int[] discovery, int[] finish) {
        visited[vertex] = true;
        // FILL IN CODE: update discovery and finish time for vertex
        // System.out.println(vertex);
        Edge curr = graph[vertex];
        while (curr != null) {
            if (!visited[curr.neighbor]) {
                dfsWithDiscoverFinishTimes(curr.neighbor, visited, discovery, finish);
            }
            curr = curr.next;
        }

    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     * @return array of finish times, that may be used by some other algorithms
     */
    public int[] dfsMain() {
        boolean visited[]  = new boolean[graph.length];
        int discovery[]  = new int[graph.length];
        int finish[]  = new int[graph.length];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfsWithDiscoverFinishTimes(i, visited, discovery, finish);
        }
        for (int i = 0; i < discovery.length; i++) {
            System.out.println(i + ", d: " + discovery[i] + " f: " + finish[i]);
        }
        return finish;
    }

    public int[] topologicalSort(int[] finish) {
        int[] ordering = new int[finish.length];
        int index = 0;
        for (int i = ordering.length - 1; i >= 0; i--) {
            ordering[index] = finish[i];
            index++;
        }
        return ordering;
    }



    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Edge edge10 = new Edge(0);
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Edge edge05 = new Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Edge edge26 = new Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Edge edge54 = new Edge(4);
        Edge edge56 = new Edge(6);
        g.addEdge(5, edge56);
        g.addEdge(5, edge54);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);
        int[] finishTimes = g.dfsMain();
        int[] ordering = g.topologicalSort(finishTimes);
        System.out.println("Topological sort: " + Arrays.toString(ordering));

    }
}

