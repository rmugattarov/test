package rmugattarov.endianness;

/**
 * Created by rmugattarov on 29.05.2017.
 */
public class TestEndiannes {
    public static void main(String[] args) {
        int x = 0xA1B2C3D4;
        System.out.println(x);
        int[] littleEndian = {0xD4, 0xC3, 0xB2, 0xA1};
        int y = 0;
        for (int i = 0; i < littleEndian.length; i++) {
            y += littleEndian[i] * (int) Math.pow(256, i);
        }
        System.out.println(y);
        System.out.println(x == y);
        y = 0;
        for (int i = littleEndian.length - 1; i >= 0; i--) {
            y += littleEndian[i] * (int) Math.pow(256, i);
        }
        System.out.println(y);
        System.out.println(x == y);
    }
}
