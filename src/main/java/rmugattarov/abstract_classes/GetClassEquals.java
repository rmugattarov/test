package rmugattarov.abstract_classes;

/**
 * Created by rmugattarov on 07.10.2016.
 */
public class GetClassEquals {
    private static abstract class AbstractClass {
        private String s;

        protected AbstractClass(String s) {
            if (s == null) {
                this.s = "";
            } else {
                this.s = s;
            }
        }

        @Override
        public int hashCode() {
            return s.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj.getClass() != getClass()) {
                return false;
            }
            return this.s.equals(((AbstractClass)obj).s);
        }

    }

    private static class ConcreteClass extends AbstractClass{

        public ConcreteClass(String s) {
            super(s);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj.getClass() != getClass()) {
                return false;
            }
            return super.equals(obj);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ConcreteClass("123").equals(new ConcreteClass("123")));
    }
}

