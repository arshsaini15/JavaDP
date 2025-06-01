// Maximum Sum Of Non Adjacent Elements -> include(i+2), exclude(i+1)

import java.util.Arrays;

public class DP9 {
    public static int MaximumSum(int elements[], int n){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return elements[0];
        }

        int incl = MaximumSum(elements, n-2) + elements[n];
        int excl = MaximumSum(elements, n-1) + 0;

        return Math.max(incl, excl);
    }

    public static int solveMem(int nums[], int n, int dp[]){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return nums[0];
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int incl = solveMem(nums, n-2, dp) + nums[n];
        int excl = solveMem(nums, n-1, dp) + 0;

        dp[n] = Math.max(incl, excl);

        return dp[n];
    }

    public static void main(String[] args) {
        int elements[] = {9,9,8,2};
        int n=elements.length;
        // System.out.println(MaximumSum(elements, n-1));

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(solveMem(elements, n-1, dp));
    }   
}