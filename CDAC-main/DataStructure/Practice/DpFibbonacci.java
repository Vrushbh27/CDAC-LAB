class DpFibbonacci{

    public static void printArr(int []arr){
        for(int i  : arr){
            System.out.print(i);
        }
        System.out.println();
    }
    public static int fib(int n){

        if( n<=1) return n;
        
        int dp[] = new int[n+1];

        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<=n;i++){
            dp[i]=dp[i-1]+ dp[i-2];
        }

        printArr(dp);

        return dp[n];


    }


    public static void main(String[] args) {

                System.out.println(fib(5));

    }

}