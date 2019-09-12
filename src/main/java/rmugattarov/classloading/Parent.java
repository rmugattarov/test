package rmugattarov.classloading;

public class Parent {
    protected static final String parentsFinalStaticField = "finalStaticField";
    protected static String parentsNonFinalStaticField = "nonFinalStaticField";

    static {
        System.out.println("Parent's static block");
    }
}
