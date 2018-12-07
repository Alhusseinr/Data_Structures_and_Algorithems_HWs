package db;

public class LCS {

    public static int lcs_length (String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] b = new int[m][n];
        int[][] c = new int[m + 1][n + 1];

        for (int i = 1; i < m; i++){
            c[i][0] = 0;
        }
        for (int j = 0; j < n; j++){
            c[0][j] = 0;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (c[i][j] == b[i][j]){
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                }
                else if (c[i - 1][j] >= c[i][j - 1]){
                    c[i][j] = c[i - 1][j];
                    c[i][j] = 2;
                }
                else{
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }
            }
        }
        return c[m][n] & b[m - 1][n - 1];
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(LCS.lcs_length("ABCBDAB", "BDCABA"));
        System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
    }

}