
void main() {
//    Create a method that throws an exception and another method that calls it. Demonstrate how exceptions propagate.
    try {
        Test test = new Test();
        test.method2();

    } catch (Exception e) {
        System.out.println("Caught in main: " + e.getMessage());
    }
    System.out.println("main end");


}
