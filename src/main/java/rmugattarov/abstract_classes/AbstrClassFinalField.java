package rmugattarov.abstract_classes;

/**
 * Created by rmugattarov on 15.09.2016.
 */
public class AbstrClassFinalField {
    public static abstract class A {
        protected final String s;
        protected A() {
            s = "asd";
        }

        public String getS() {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(new A(){}.getS());
    }
}
