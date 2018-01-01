//package rmugattarov.memory;
//
//import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
//
///**
// * Created by rmugattarov on 26.09.2016.
// */
//public class LazyInitMem {
//    private String s;
//
//    public String getS() {
//        if (s == null) {
//            s = "";
//        }
//        return s;
//    }
//
//    public static void main(String[] args) {
//        LazyInitMem obj = new LazyInitMem();
//        System.out.printf("empty obj : %d\r\n", ObjectSizeCalculator.getObjectSize(obj));
//        obj.getS();
//        System.out.printf("s init-d obj : %d\r\n", ObjectSizeCalculator.getObjectSize(obj));
//
//    }
//}
