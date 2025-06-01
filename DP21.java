// Longest Common Substring: (length of substring).

public class DP21 {
    static int[][] t;
    static int maxLength=0;

    public static int LCS(String s1, String s2, int x, int y, int[][] t) {
        if(x == 0 || y == 0){
            return 0;
        }

        if(t[x][y] != 0){
            return t[x][y];
        }

        if(s1.charAt(x-1) == s2.charAt(y-1)) {
            t[x][y] = 1+LCS(s1, s2, x-1, y-1, t);
        } else {
            t[x][y] = 0;
        }

        maxLength = Math.max(maxLength, t[x][y]);

        LCS(s1, s2, x-1, y, t);
        LCS(s1, s2, x, y-1, t);

        return t[x][y];
    }
    public static void main(String[] args) {
        String s1="abcde";
        String s2="abcfe";
        int x=s1.length();
        int y=s2.length();

        t=new int[x+1][y+1];
        for(int i=0; i<=x; i++){
            for(int j=0; j<=y; j++){
                if(i == 0){
                    t[i][j] = 0;
                }
                if(j == 0){
                    t[i][j] = 0;
                }
            }
        }

        LCS(s1, s2, x, y, t);

        System.out.println(maxLength);
    }
}