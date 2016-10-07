package rmugattarov.reflection;

import java.lang.reflect.Field;

/**
 * Created by rmugattarov on 07.10.2016.
 */
public class SetField {
    private String s = "Bazinga!";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        SetField setField = new SetField();
        Field declaredField = SetField.class.getDeclaredField("s");
        declaredField.setAccessible(true);
        System.out.println(declaredField.get(setField));
        declaredField.set(setField, null);
        System.out.println(declaredField.get(setField));
    }
}
