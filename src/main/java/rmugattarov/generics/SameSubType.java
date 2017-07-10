package rmugattarov.generics;

/**
 * Created by rmugattarov on 10.07.2017.
 */
public class SameSubType<T extends CharSequence> {
    private T arg;

    public SameSubType(T arg) {
        this.arg = arg;
    }

    public void set(T arg) {
        this.arg = arg;
    }

    public static void main(String[] args) {
        SameSubType<A> aSameSubType = new SameSubType<A>(new A());
//        aSameSubType.set(new B());
    }

    private static class A implements CharSequence {

        @Override
        public int length() {
            return 0;
        }

        @Override
        public char charAt(int index) {
            return 0;
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return null;
        }
    }

    private static class B implements CharSequence {

        @Override
        public int length() {
            return 0;
        }

        @Override
        public char charAt(int index) {
            return 0;
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return null;
        }
    }
}
