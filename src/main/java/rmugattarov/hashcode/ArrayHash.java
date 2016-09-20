package rmugattarov.hashcode;

/**
 * Created by rmugattarov on 20.09.2016.
 */
public class ArrayHash {
    public static void main(String[] args) {
        String[] arr1 = new String[2];
        System.out.println(arr1.hashCode());
        arr1[0] = "123";
        System.out.println(arr1.hashCode());
        arr1[1] = "234";
        System.out.println(arr1.hashCode());
    }
}
