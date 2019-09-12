package rmugattarov.classloading;

public class Child extends Parent {
    protected static final String childsFinalStaticField = "childsFinalStaticField";
    protected static String childsNonFinalStaticField = "childsNonFinalStaticField";
    static {
        System.out.println("Child's static block");
    }
}
