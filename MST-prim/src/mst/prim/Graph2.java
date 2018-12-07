package mst.prim;

import java.util.*;

public class Graph2 {

    public int n;	//number of vertice
    public int[][] A;	//the adjacency matrix

    public Graph2() {
        n = 0;
        A = null;
    }

    public Graph2(int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }

    public int prim(int r) {
        int TotalWeight = 0;
        PriorityQueue<PrimNode> newQueue;
        PrimNode currentNode; //current node being processed
        PrimNode adjNode; //adjacent nodes of currentNode
        PriorityQueue<PrimNode> Queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            // if i==r then 0 else infinity
            Queue.add(new PrimNode(i, i == r ? 0 : Integer.MAX_VALUE));
        }

        while (Queue.size() > 0) {
            currentNode = Queue.poll();
            TotalWeight = TotalWeight + currentNode.key;
            Iterator iteration = Queue.iterator();
            newQueue = new PriorityQueue<>();

            while (iteration.hasNext()) {
                adjNode = (PrimNode) iteration.next();
                if (adjNode.key > A[currentNode.id][adjNode.id]) {
                    if (A[currentNode.id][adjNode.id] > 0) {
                        adjNode.key = A[currentNode.id][adjNode.id];
                    }
                }
                newQueue.add(adjNode);
            }
            Queue = newQueue;
        }
        return TotalWeight;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 9;
        int A[][] = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Graph2 g = new Graph2(n, A);
        System.out.println(g.prim(0));
    }
}
