package rmugattarov.enums;

/**
 * Created by rmugattarov on 04.10.2016.
 */
public class NestedEnum {
    private MyNestedEnum enumField;

    public enum MyNestedEnum {
        A, B
    }

    public static void main(String[] args) {
        for (MyNestedEnum myNestedEnum : MyNestedEnum.values()) {
            System.out.println(myNestedEnum);
        }
    }
}
