package rmugattarov.inner_classes;

/**
 * Created by rmugattarov on 16.09.2016.
 */
public class InnerClass {
    private String s = "123";
    private Inner inner = this.new Inner();

    private class Inner {
        @Override
        public String toString() {
            return " Inner " + s;
        }
    }

    @Override
    public String toString() {
        return " InnerClass {inner : " + inner + "} ";
    }

    public static void main(String[] args) {
        System.out.println(new InnerClass());
    }
}
