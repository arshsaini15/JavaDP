// Fibonacci Number In SC(1), TC(N)

public class DP3 {
    public static void main(String[] args) {
        int n = 8;
        int prev0 = 0;
        int prev1 = 1;
        
        for(int i=2; i<=n; i++){
            int curr = prev0 + prev1;
            prev0 = prev1;
            prev1 = curr;
        }

        System.out.println(prev1);
    }
}