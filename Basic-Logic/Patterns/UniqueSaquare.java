public class UniqueSaquare {
      public static void squareNumber(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.min(Math.min(i, j), Math.min(n - 1 - i, n - 1 - j)) + 1;
                System.out.print(val + " "); 
            }
            System.out.println();
        }
    }

}
