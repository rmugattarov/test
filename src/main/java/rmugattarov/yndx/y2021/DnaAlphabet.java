package rmugattarov.yndx.y2021;

public class DnaAlphabet {
    public static void main(String[] args) {
        String a = "BALZKUWISPHXCQTNMGJVFRDOEY";
//        String a = "ABDEFJRKOTNWZIPHULXCYQGSVM";
//        String a = "TABYZNQHGKOUXCPIJFLDREVWSM";
        gen(a);
    }

    private static void gen(String a) {
        String prev = a.substring(0, 1);
        System.out.println("1) " + prev);
        for (int i = 1; i < 5; i++) {
            String segment = prev + a.charAt(i) + prev;
            System.out.println(i + 1 + ") " + segment);
            prev = segment;
        }
    }

}
