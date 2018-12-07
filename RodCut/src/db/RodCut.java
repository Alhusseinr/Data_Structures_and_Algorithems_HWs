package db;

public class RodCut {
    int n;
    int[] p;
    int[] r;
    int[] s;

    public RodCut () {
        n = 10;
        p = new int[11];
        p[0] = 0;
        p[1] = 1;
        p[2] = 5;
        p[3] = 8;
        p[4] = 9;
        p[5] = 10;
        p[6] = 17;
        p[7] = 17;
        p[8] = 20;
        p[9] = 24;
        p[10] = 30;
    }

    public int memoized_cut_rod () {
        r = new int[n + 1];
        for(int i = 0; i < n; i++){
            r[i] = -1;
        }
        return memoized_cut_rod_aux(p, n, r);
    }

    public int memoized_cut_rod_aux (int p[], int n, int r[]) {
        int q;
        if(r[n] >= 0){
            return r[n];
        }
        if(n == 0){
            q = 0;
        }else{
            q = -1;
            for(int i = 1; i < n; i++){
                q = Math.max(q, p[i] + memoized_cut_rod_aux(p, n - i,r));
            }
        }
        r[n] = q;
        return q;
    }

    public int bottom_up_cut_rod () {
        int q;
        r = new int[n + 1];
        r[0] = 0;
        for(int j = 1; j < n; j++){
            q = -1;
            for(int i = 1; i < j; i++){
                q = Math.max(q, p[i] + r[j - i]);
            }
            r[j] = q;
        }
        return r[n];
    }

    public void extended_bottom_up_cut_rod () {
        int q;
        r = new int[n + 1];
        s = new int[n + 1];
        r[0] = 0;

        for(int j = 1; j < n; j++){
            q = -1;
            for(int i = 1; i < j; i++){
                if(q < p[i] + r[j - 1]){
                    q = p[i] + r[j - 1];
                    s[j] = i;
                }
            }
            r[j] = q;
        }
        System.out.println(r[n] + s[n]);
    }

    public void print_cut_rod_solution () {
        for (int i = 0; i <= n; i++) {
            System.out.print(i + "\t");
        }
        System.out.print("\n");
        for (int i = 0; i <= n; i++) {
            System.out.print(r[i] + "\t");
        }
        System.out.print("\n");
        for (int i = 0; i <= n; i++) {
            System.out.print(s[i] + "\t");
        }
        System.out.print("\n");
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RodCut rc;

        rc = new RodCut();
        System.out.println("memoized_cut_rod starts ------------------");
        System.out.println(rc.memoized_cut_rod());
        System.out.println("memoized_cut_rod ends ------------------");
        System.out.print("\n\n");

        System.out.println("bottom_up_cut_rod starts ------------------");
        System.out.println(rc.bottom_up_cut_rod());
        System.out.println("bottom_up_cut_rod ends ------------------");
        System.out.print("\n\n");

        System.out.println("extended_bottom_up_cut_rod starts ------------------");
        rc.extended_bottom_up_cut_rod();
        rc.print_cut_rod_solution();
        System.out.println("extended_bottom_up_cut_rod ends ------------------");
        System.out.print("\n\n");
    }

}