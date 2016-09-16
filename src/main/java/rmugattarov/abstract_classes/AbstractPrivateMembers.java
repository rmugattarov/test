package rmugattarov.abstract_classes;

/**
 * Created by rmugattarov on 16.09.2016.
 */
public class AbstractPrivateMembers {
    public static abstract class A {
        private String s = "123";
    }
    public static class B extends A {
        @Override
        public String toString() {
            return " B {s : ";
        }
    }
}
