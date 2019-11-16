package rmugattarov.classloading;

public class GetClassLoader {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println("new Object()");
        System.out.println(o.getClass().getClassLoader());

        int[] intarr = new int[0];
        System.out.println("new int[0]");
        System.out.println(intarr.getClass().getClassLoader());

        Object[] objarr = new Object[0];
        System.out.println("new Object[0]");
        System.out.println(objarr.getClass().getClassLoader());

        String s = new String("");
        System.out.println("new String(\"\")");
        System.out.println(s.getClass().getClassLoader());

        String[] sarr = new String[0];
        System.out.println("new String[0]");
        System.out.println(sarr.getClass().getClassLoader());

        GetClassLoader getClassLoader = new GetClassLoader();
        System.out.println("new GetClassLoader()");
        System.out.println(getClassLoader.getClass().getClassLoader());
    }
}
