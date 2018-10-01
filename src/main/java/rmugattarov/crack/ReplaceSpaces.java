package rmugattarov.crack;

public class ReplaceSpaces {
    public static void main(String[] args) {
        String s;
        s= "12 56 7 8 ";
        System.out.println(s);
        System.out.println(replace(s));
    }

    private static String replace(String s) {
        return s.replaceAll("[ ]", "%20");
    }
}
