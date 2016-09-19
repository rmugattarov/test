package rmugattarov.equals;

/**
 * Created by rmugattarov on 19.09.2016.
 */
public class EmptyObjects {

    public static void main(String[] args) {
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());

        System.out.println(new EmptyObjects().hashCode());
        System.out.println(new EmptyObjects().hashCode());
        System.out.println(new EmptyObjects().hashCode());
        System.out.println(new EmptyObjects().hashCode());
        System.out.println(new EmptyObjects().hashCode());
    }
}
