package rmugattarov.reflection;

import java.util.Arrays;

/**
 * Created by rmugattarov on 06.04.2017.
 */
public class ProxyArray {
    public static void main(String[] args) {
        Object[] obArr = new Object[10];
        Object proxy = DebugProxy.newInstance(obArr);
        obArr = (Object[]) proxy;
        System.out.println(Arrays.toString(obArr));
    }
}
