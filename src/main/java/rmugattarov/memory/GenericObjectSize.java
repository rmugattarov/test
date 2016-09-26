package rmugattarov.memory;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * Created by rmugattarov on 26.09.2016.
 */
public class GenericObjectSize {
    private String s;

    public GenericObjectSize() {
    }

    public GenericObjectSize(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        System.out.printf("null : %d\r\n", ObjectSizeCalculator.getObjectSize(null));
        System.out.printf("empty obj : %d\r\n", ObjectSizeCalculator.getObjectSize(new GenericObjectSize()));
        System.out.printf("explicit null field : %d\r\n", ObjectSizeCalculator.getObjectSize(new GenericObjectSize(null)));
        System.out.printf("empty string field: %d\r\n", ObjectSizeCalculator.getObjectSize(new GenericObjectSize("")));
        System.out.printf("one char string field: %d\r\n", ObjectSizeCalculator.getObjectSize(new GenericObjectSize("a")));
    }
}
