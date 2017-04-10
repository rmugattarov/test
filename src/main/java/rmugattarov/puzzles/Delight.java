package rmugattarov.puzzles;

/**
 * Created by rmugattarov on 10.04.2017.
 */

class Delight {
    public static void main(String[] args) {
        for (byte b = Byte.MIN_VALUE;
             b < Byte.MAX_VALUE; b++) {
            if (b == 0x90)
                System.out.print("Joy!");
        }
    }
}
