public class Practice{


        public static int print(int n){

            if(n == 0){
                return n;
            }
            if(n == 1){
                return n;
            }
            
            return print(n-1) + print(n-2);
           
        }



        public static boolean isPrime(int n){

         if (n <= 1) {
             return false;
              }
                //number divided itself or 1
                for(int i=2; i<n;i++){
                    if(n % i == 0){
                        return false;
                    }
                }

                return true;
        }


        public static int sumOfNatural(int n){

                if(n==0){
                return 0;
                }

            return n+sumOfNatural(n-1);
        }


        // reverse array using recursion

        public static void revereArray(int [] arr,int start,int end){

                if(start >= end){
                    return;
                }
                // what we need to do
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                revereArray(arr,start+1,end-1);


        }



    public static void printPrime(int n){
            int count=0;
        for(int i=0; i<n;i++){
            if(isPrime(i)){
                count++;
                System.out.println(i);
            }
        }

        System.out.println("Prime Numbers are"+count);
    }

    public static void printArr(int arr[]){

        for(int  i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }


        public static boolean isPalindrome(String str , int start,int end){

            if(start >= end){
                return true;
            }

            if(str.charAt(start) != str.charAt(end)){
                return false;
            }

            return isPalindrome(str,start+1,end-1);

        }

    public static void main(String args[]){

            // System.out.println(print(6));
            // System.out.println(isPrime(6));
            // printPrime(600);
            System.out.println(sumOfNatural(5));

        //     int arr[] =  {1,2,3,4,5};
        // printArr(arr);
        // revereArray(arr,0,arr.length-1);
        // printArr(arr);
        String str = "SAMAS";
            System.out.println(isPalindrome(str,0,str.length()-1));
    }
}