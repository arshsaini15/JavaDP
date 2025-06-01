// Fibonacci Number Using Tabulation.

import java.util.ArrayList;
import java.util.Collections;

public class DP2 {

    public static int fibo(int n, ArrayList<Integer> dp){
        dp.set(0,0);
        dp.set(1,1);

        for(int i=2; i<=n; i++){
            dp.set(i, dp.get(i-1) + dp.get(i-2));
            
        }

        return dp.get(n);
    }

    public static void main(String[] args) {
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(9, -1));
        System.out.print(fibo(8, dp));
    }
}