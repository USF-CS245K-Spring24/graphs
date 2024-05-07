package exercise05_07;

/** A class that represents the Disjoint Sets data structure. Please refer
 * to the lecture slides.
 * This class is used in Kruskal's. Do not change anything in this class.
 * */
public class DisjointSets {
    private int[] parent;

    public void createSets(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }

    /**
     * Returns the root of the "tree" that x belongs to.
     * @param x node id
     * @return root of the tree  (representative of the set)
     */
    public int find(int x) {
        // FILL IN CODE

        return -1; // change
    }

    /**
     * Merges the trees of x and y.
     * @param x node id
     * @param y node id
     */
    public void union(int x, int y) {
        // FILL IN CODE
        // find the roots

        // check if both nodes are already part of one tree
        // point a shorter tree to a taller one

    }

    /**
     * Returns the root of the "tree" that x belongs to.
     * Uses path compression heuristic.
     * @param x node id
     * @return root of the tree that x belongs to
     */
    public int findWithPathCompression(int x) {
        // FILL IN CODE


        return x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parent.length; i++) {
            sb.append(i + ":" + parent[i] + "; ");
        }
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}

