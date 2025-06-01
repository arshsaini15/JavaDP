// Climbing Stairs -> Tabulation
// put value of base case in array and start from the next index of the array

import java.util.Arrays;


public class DP5 {
    public static int countWays(int n, int ways[]){
        // if(n == 0){
        //     return 1;
        // }

        // if(n < 0){
        //     return 0;
        // }

        ways[0] = 1;
        ways[1] = 1;


        if(ways[n] != -1){
            return ways[n];
        }

        for(int i=2; i<=n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }

    public static void main(String[] args) {
        int n=5;
        int ways[] = new int[n+1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n, ways));
    }
}