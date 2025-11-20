public class Test {
    public static void method1 ()throws Exception {
        System.out.println("inside method1");
        throw new Exception("thrown from method1");

    }
    public static void method2()throws Exception {
        System.out.println("inside method2");
        method1();
    }

}
