package rmugattarov.bad_interview;

public class No2 {
    public static void main(String[] args) {
        String string = "Hello";
        StringBuilder builder = new StringBuilder("Hello!");
        StringBuilder builder2 = new StringBuilder("Hello!");

//        System.out.println(string == builder); Error:(9, 35) java: incomparable types: java.lang.String and java.lang.StringBuilder
        System.out.println(string.equals(builder));
        System.out.println(builder.equals(builder2));
    }
}
