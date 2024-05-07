package exercise05_07;

public class DisjointSetsMain {
    public static void main(String[] args) {
        DisjointSets dsets = new DisjointSets();
        dsets.createSets(9);
        dsets.union(1, 6);
        dsets.union(2, 3);
        dsets.union(1, 2);

        dsets.union(4, 7);
        dsets.union(5, 8);
        dsets.union(4, 1);
        System.out.println(dsets);

    }
}
