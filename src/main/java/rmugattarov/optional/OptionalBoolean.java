package rmugattarov.optional;

import java.util.Optional;

public class OptionalBoolean {
    public static void main(String[] args) {
//        Object o = new Object();
        Object o = null;
        boolean b;
        b = Optional.ofNullable(o)
                .map(Object::hashCode)
                .map(i -> i != 0)
                .orElse(false);
        System.out.println(b);

    }
}
