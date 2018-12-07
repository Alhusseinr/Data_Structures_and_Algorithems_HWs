package mst.prim;

public class PrimNode implements Comparable<PrimNode> {

    public int id;
    public int key;

    public PrimNode(int id, int key) {
        this.id = id;
        this.key = key;
    }

    public int compareTo(PrimNode o) {
        return (this.key - o.key);
    }
}
