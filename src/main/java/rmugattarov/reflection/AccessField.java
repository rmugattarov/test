package rmugattarov.reflection;

import java.lang.reflect.Field;

/**
 * Created by rmugattarov on 26.09.2016.
 */
public class AccessField {
    private String s = "Bazinga!";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        AccessField accessField = new AccessField();
        Field declaredField = AccessField.class.getDeclaredField("s");
        System.out.println(declaredField.get(accessField));
    }
}
