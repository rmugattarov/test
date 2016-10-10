package rmugattarov.reflection;

import java.lang.reflect.Field;

/**
 * Created by rmugattarov on 07.10.2016.
 */
public class SetField {
    private String s = "Bazinga!";

    @Override
    public String toString() {
        return " SetField { s : " + s + "} ";
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        SetField o1 = new SetField();
        SetField o2 = new SetField();
        Field declaredField = SetField.class.getDeclaredField("s");
        declaredField.setAccessible(true);
        System.out.println(declaredField.get(o1));
        declaredField.set(o1, null);
        declaredField.set(o2, null);
        System.out.println(o1 + " "  + o1.hashCode());
        System.out.println(o2 + " "  + o2.hashCode());
    }
}
