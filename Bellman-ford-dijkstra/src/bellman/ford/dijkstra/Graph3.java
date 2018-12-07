package bellman.ford.dijkstra;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Graph3 {

    int n;      //Vertices
    int[][] A;  //Adjacency Matrix
    int[] d;	//shortest distance

    /**
     * @param args
     */
    public Graph3() {

    }

    public Graph3(int _n, int[][] _A) {
        n = _n;
        A = _A;
        d = new int[n];
    }

    public void initialize_single_source(int s) {
        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[s] = 0;
    }

    public void relax(int u, int v) {
        if (d[v] > (d[u] + A[u][v])) {
            d[v] = d[u] + A[u][v];
        }
    }

    public boolean bellman_ford(int s) {
        initialize_single_source(s);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int v = 0; v < n; v++) {
                    if (A[j][v] != 0) {
                        relax(j, v);
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++) {
                for (int v = 0; v < n; v++) {
                    if (A[j][v] != 0) {
                        if (d[v] > d[j] + A[j][v]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void dijkstra(int s) {
        initialize_single_source(s);
        int TotalWeight = 0;
        PriorityQueue<PrimNode> newQueue;
        PrimNode currentNode; //current node being processed
        PrimNode adjNode; //adjacent nodes of currentNode
        PriorityQueue<PrimNode> Queue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            // if i==r then 0 else infinity
            Queue.add(new PrimNode(i, i == s ? 0 : Integer.MAX_VALUE));
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
                        relax(currentNode.id, adjNode.id);
                    }
                }
                newQueue.add(adjNode);
            }
            Queue = newQueue;
        }
    }

    public void display_distance() {
        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + d[i]);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 5;
        int[][] A = {
            {0, 6, 0, 7, 0},
            {0, 0, 5, 8, -4},
            {0, -2, 0, 0, 0},
            {0, 0, -3, 0, 9},
            {2, 0, 7, 0, 0}
        };
        Graph3 g1 = new Graph3(n, A);
        g1.bellman_ford(0);
        g1.display_distance();

        System.out.println("-----------------------");

        int[][] B = {
            {0, 10, 0, 5, 0},
            {0, 0, 1, 2, 0},
            {0, 0, 0, 0, 4},
            {0, 3, 9, 0, 2},
            {7, 0, 6, 0, 0}
        };
        Graph3 g2 = new Graph3(n, B);
        g2.dijkstra(0);
        g2.display_distance();
    }

}
