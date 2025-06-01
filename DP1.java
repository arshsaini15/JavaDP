// Fibonacci Number Using Memoization.

import java.util.ArrayList;
import java.util.Collections;

public class DP1 {

    public static  int fibo(int n, ArrayList<Integer> dp) {
        if(n == 0 || n == 1){
            return n;
        }

        if(dp.get(n) != -1){
            return dp.get(n);
        }

        dp.set(n, fibo(n-1, dp) + fibo(n-2, dp));
        return dp.get(n);
    }

    public static void main(String args[]){
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(9, -1));
        System.out.println(fibo(8, dp));
    }
}