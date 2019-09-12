package rmugattarov.classloading;

public class TestClassLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Addressing parent's final static field");
        System.out.println(Child.parentsFinalStaticField);

        System.out.println("\nAddressing parent's non final static field");
        System.out.println(Child.parentsNonFinalStaticField);

        System.out.println("\nAddressing child's final static field");
        System.out.println(Child.childsFinalStaticField);

        System.out.println("\nAddressing child's non final static field");
        System.out.println(Child.childsNonFinalStaticField);
    }
}
