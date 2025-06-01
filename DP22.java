// Printing LCS.

public class DP22 {
    static int[][] t;

    public static int LCS(String a, String b, int m, int n, int[][] t) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (t[m][n] != 0) {
            return t[m][n];
        }

        if (a.charAt(m - 1) == b.charAt(n - 1)) {
            t[m][n] = 1 + LCS(a, b, m - 1, n - 1, t);
        } else {
            t[m][n] = Math.max(LCS(a, b, m - 1, n, t), LCS(a, b, m, n - 1, t));
        }

        return t[m][n];
    }

    public static void printLCS(String a, String b, int m, int n, int[][] t) {
        StringBuilder lcs = new StringBuilder();

        while(m>0 && n>0){
            if(a.charAt(m - 1) == b.charAt(n - 1)) {
                lcs.append(a.charAt(m - 1));
                m--;
                n--;
            } else if (t[m - 1][n] >= t[m][n - 1]) {
                m--;
            } else {
                n--;
            }
        }

        System.out.println("LCS: " + lcs.reverse().toString());
    }

    public static void main(String[] args) {
        String a = "acbcf";
        String b = "abcdaf";
        int l1 = a.length();
        int l2 = b.length();

        t = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                t[i][j] = 0;
            }
        }

        System.out.println("Length of LCS: " + LCS(a, b, l1, l2, t));
        printLCS(a, b, l1, l2, t);
    }
}