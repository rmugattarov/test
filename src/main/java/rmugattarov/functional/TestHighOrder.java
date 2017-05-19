package rmugattarov.functional;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * Created by rmugattarov on 19.05.2017.
 */
public class TestHighOrder {
    public static void main(String[] args) {
        Function<String, UnaryOperator<String>> f = x -> y -> 'y' + x + 'y';
        System.out.println(f.apply("1").apply("2"));
    }
}
