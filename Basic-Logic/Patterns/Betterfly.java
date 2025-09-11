public class Betterfly {

    public static void betterfly(int n){

        // half betterfly - upper
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <=2*(n-i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        
        //  half betterfly - lower
        for (int i = n; i >=1; i--) {
            for (int j = 1; j <=i; j++) {
                System.out.print("* ");
            }
            for (int j = 1; j <=2*(n-i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // main - start the code
    public static void main(String[] args){
        int n = 4 ;  // change it according to needs


        System.out.println("Betterfuly pattern");
        betterfly(n);
    }
}

        //    output - 
        
        //    Betterfuly pattern
        //     *             * 
        //     * *         * *
        //     * * *     * * *
        //     * * * * * * * *
        //     * * * * * * * *
        //     * * *     * * *
        //     * *         * *
        //     *             *
