package exercise04_23;

import java.util.Stack;

public class Graph {
    private Edge[] graph; // adjacency list for this graph

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

    public int getNumVertices() {
        return graph.length;
    }

    public void printNeighbors(int vertexId) {
        // FILL IN CODE

    }

    /** A helper method fod dfsMain - runs DFS once from the given source vertex
     *
     * @param vertex source vertex
     * @param visited an array, where for each vertex id we store true if it has been visited,
     * and false otherwise
     */
    public void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        // iterate over edges of vertex
        Edge tmp = graph[vertex];
        // FILL IN CODE:
        // Iterate over outgoing edges of this vertex
        // For each edge, get the neighbor, and if it has not been visited, called dfs recursively on the neighbor

    }

    /**
     * Iterative DFS implementation that uses a stack.
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited, and false otherwise
     */
    public void dfsWithStack(int vertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex); // push the source vertex onto the stack

        while (!stack.isEmpty()) {
            // pop the vertex nextV from the stack
            int nextV = stack.pop();
            // mark it as visited and print it
            // iterate over the neighbors of nextV
            Edge tmp = graph[nextV];
            // if the neighbor has not been visited, push it onto the stack
            // FILL IN CODE
        }
    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfs(i, visited);
        }
    }



    void bfs(int vertex, boolean visited[]) {
        Queue queue = new ArrayQueue();
        queue.enqueue(vertex);
        visited[vertex] = true;
        System.out.println(vertex);
        while (!queue.empty()) {
            int nextV = (int)queue.dequeue();

            // Iterate over outgoing edges; add every non-visited neighbor to the queue
            // and mark as visited

        } // white queue is not empty
    }


    /** Runs BFS starting from every vertex that has not been visited.
     *
     */
    public void bfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                bfs(i, visited);
        }
    }

    public void printAdjacencyList() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + ": ");
            Edge head = graph[i];
            while (head != null) {
                System.out.print(head.neighbor + " ");
                head = head.next;
            }
            System.out.println();
        }
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
        g.addEdge(5, edge54);
        g.addEdge(5, edge56);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);

        g.printAdjacencyList();
        // g.dfsMain();
        // g.bfsMain();
    }
}

