package rmugattarov.basics.y2018m10;

public class IntMinMax {
    public static void main(String[] args) {
        String maxIntString = Integer.toBinaryString(Integer.MAX_VALUE);
        String minIntString = Integer.toBinaryString(Integer.MIN_VALUE);
        String negOne = Integer.toBinaryString(-1);
        System.out.println(maxIntString);
        System.out.println(minIntString);
        System.out.println(negOne);
    }
}
