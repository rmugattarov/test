package rmugattarov.algorithms;

public class SliceWithOverhead {
    public static void main(String[] args) {
        System.out.println(sliceCount(15, 1, 10));
        System.out.println(sliceCount(5, 1, 2));
        System.out.println(sliceCount(10, 5, 6));
        System.out.println(sliceCount(9, 1, 10));
        System.out.println(sliceCount(0, 1, 10));
    }

    private static int sliceCount(int val, int overhead, int maxSize) {
        int payloadPerSegment = maxSize - overhead;
        int quot = val / payloadPerSegment;
        if (val != quot * payloadPerSegment) {
            return quot + 1;
        } else {
            return quot;
        }
    }
}
