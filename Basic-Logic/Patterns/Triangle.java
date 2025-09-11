public class Triangle {

    // 0-1 Triangle function 
    public static void ZeroOneTriangle(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i; j++) {
               
                if(((i+j)%2 == 0)){
                    System.out.print("1 ");
                }
                else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }


    // Pascal Triangle function
    public static void PascalTriangle(int rows){

        for (int i = 0; i < rows; i++) {
            // Print leading spaces
            for (int space = 0; space < rows - i - 1; space++) {
                System.out.print(" ");
            }

            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1); // Binomial coefficient logic
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5 ;

        System.out.println("0-1 Triangle");
        ZeroOneTriangle(n);  // call to 0-1 function


        System.out.println();
        System.out.println("Pascal Triangle");
        PascalTriangle(n);  // call to Pacal Triangle function
    }
}

// output 
   
    //             0-1 Triangle
    //             1 
    //             0 1
    //             1 0 1
    //             0 1 0 1
    //             1 0 1 0 1

    //            Pascal Triangle
    //                1
    //               1 1
    //              1 2 1
    //             1 3 3 1
    //            1 4 6 4 1

