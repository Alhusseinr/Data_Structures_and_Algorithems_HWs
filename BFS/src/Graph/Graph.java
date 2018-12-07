package graph;

import ds.Queue;
import ds.Vertex;

public class Graph {

    public int n;        //number of vertice
    public int[][] A;	//the adjacency matrix
    private final int WHITE = 2;
    private final int GRAY = 3;
    private final int BLACK = 4;

    public Graph() {
        n = 0;
        A = null;
    }

    public Graph(int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }
    public int[] bfs(int s) {

        int[] visitedIndices = new int[n];
        int visitedCounter = 0;
        Vertex[] vertices = new Vertex[n];
        Vertex s_ = new Vertex();
        for (int i = 0; i < n; i++) {

            visitedIndices[i] = 0;
            vertices[i] = new Vertex();
            vertices[i].color = WHITE;
            vertices[i].d = Integer.MAX_VALUE;
            vertices[i].i = i;
            vertices[i].parent = null;

            if (i == s) {
                s_ = vertices[i];
                s_.color = GRAY;
                s_.d = 0;
                s_.parent = null;
            }
        }

        Queue queue = new Queue(n);
        queue.enqueue(s);
        visitedIndices[visitedCounter++] = s;

        while (queue.GetNumberOfElements() > 0) {
            Vertex u = vertices[queue.dequeue()];

            for (int i = 0; i < n; i++) {
                if (A[u.i][i] == 1) {
                    if (vertices[i].color == WHITE) {
                        visitedIndices[visitedCounter++] = vertices[i].i;
                        vertices[i].color = GRAY;
                        vertices[i].d = u.d + 1;
                        vertices[i].parent = u.i;
                        queue.enqueue(vertices[i].i);

                    }
                }
            }
            u.color = BLACK;

        }
        return visitedIndices;
    }

    public void print_array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ": " + array[i]);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 8;
        int[][] A
                = {{0, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 1, 0}};
        Graph g = new Graph(n, A);
        g.print_array(g.bfs(1));
    }

}
