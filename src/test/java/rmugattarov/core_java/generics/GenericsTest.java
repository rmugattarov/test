package rmugattarov.core_java.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmugattarov on 11.01.2016.
 */
public class GenericsTest {
    public static class A {
    }

    public static class B extends A {
    }

    @Test
    public void test() {
        List<A> listA = new ArrayList<A>();
        listA.add(new A());
        List<B> listB = new ArrayList<B>();
        listB.add(new B());
        List<List<A>> listOfListA = new ArrayList<List<A>>();
        listOfListA.add(listA);
        //listOfListA.add(listB);
        System.out.printf("listOfListA : %s", listOfListA);
    }
}
