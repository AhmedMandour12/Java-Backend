public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Outer try block");

            try {
                System.out.println("Inner try block");
                int x = 10 / 0;   // ArithmeticException happens here
            }
            catch (NullPointerException e) {
                System.out.println("Inner catch: This will NOT run");
            }

            System.out.println("This line will not execute");

        }
        catch (ArithmeticException e) {
            System.out.println("Outer catch: Caught ArithmeticException -> " + e.getMessage());
        }


    }
}
