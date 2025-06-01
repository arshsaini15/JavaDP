public class DP15 {
    static int t[][];
    public static void main(String[] args) {
        int arr[]={1,2,7};
        int sum=0;
        for(int num: arr){
            sum += num;
        }
        int n=arr.length;
        t = new int[n+1][sum+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=sum; j++){
                if(i == n){
                    if(checkSum(arr, arr[i])){
                        t[i][j] = 
                    }
                }
            }
        }

        System.out.println(subsetSum(arr, sum, t));
    }
}