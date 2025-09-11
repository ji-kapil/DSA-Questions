public class Sprial {
    public static void sprialClockwise(int[][] a) {

        int rowMin = 0 , colMin = 0 ;
        int rowMax = a.length -1 , colMax = a[0].length -1 ;
        int value = 1 ;
        while (value <= a.length*a[0].length){

            // top
            for (int i = colMin; i <=colMax; i++) {
                a[rowMin][i] = value ++; 
            } 
            rowMin++;

            // right 
            for (int i =rowMin; i <=rowMax ; i++) {
                a[i][colMax] = value++;
            }
            colMax -- ;

            //bottom
            for (int i = colMax; i >=colMin; i--) {
                a[rowMax][i] = value ++;
            }
            rowMax --;

            // left
            for (int i = rowMax; i >= rowMin; i--) {
                a[i][colMin] = value ++ ;
            } 
            colMin ++ ;
        }

        printSprial(a);
    }



    public static void sprialAnticlockwise(int [][] a){

        int rowMin = 0 , colMin = 0 ;
        int rowMax = a.length -1 , colMax = a[0].length -1 ;
        int value = 1 ;
        while (value <= a.length*a[0].length){

            // left
            for (int i = rowMin; i <= rowMax; i++) {
                a[i][colMin] = value ++ ;
            } 
            colMin ++ ;

            //bottom
            for (int i = colMin; i <=colMax; i++) {
                a[rowMax][i] = value ++;
            }
            rowMax --;

            // right 
            for (int i =rowMax; i >=rowMin ; i--) {
                a[i][colMax] = value++;
            }
            colMax -- ;

            // top
            for (int i = colMax; i >=colMin; i--) {
                a[rowMin][i] = value ++; 
            } 
            rowMin++;
        }

        printSprial(a);
    }

    public static void printSprial(int[][] a){
         for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <a[0].length; j++) {

                if (a[i][j] <= 9) {
                    System.out.print( "0" + a[i][j] + " ");
                } else {
                    System.out.print(a[i][j] + " ");
                }
            }

            System.out.println();
        }
    }

    // main - start the code 
    public static void main(String[] args) {
        int n = 5 ; // change according to needs
        int m = 6 ; // change according to needs


        int[][] a = new int[n][m];

        System.out.println("Clockwise sprial ");
        sprialClockwise(a);

        System.out.println();

        System.out.println("Anti Clockwise sprial ");
        sprialAnticlockwise(a);
    }
}

// output 
   
   // Clockwise sprial 
    // 01 02 03 04 05 
    // 16 17 18 19 06
    // 15 24 25 20 07
    // 14 23 22 21 08
    // 13 12 11 10 09

    // Anti Clockwise sprial 
    // 01 16 15 14 13
    // 02 17 24 23 12
    // 03 18 25 22 11
    // 04 19 20 21 10
    // 05 06 07 08 09
