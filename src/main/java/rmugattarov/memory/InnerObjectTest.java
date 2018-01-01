//package rmugattarov.memory;
//
//import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
//
///**
// * Created by rmugattarov on 26.09.2016.
// */
//public class InnerObjectTest {
//    public InnerObjectTest innerObjectTest;
//
//    public static void main(String[] args) {
//        InnerObjectTest obj = new InnerObjectTest();
//        System.out.printf("null inner : %d\r\n", ObjectSizeCalculator.getObjectSize(obj));
//        obj.innerObjectTest = new InnerObjectTest();
//        System.out.printf("1 inner : %d\r\n", ObjectSizeCalculator.getObjectSize(obj));
//        obj.innerObjectTest.innerObjectTest = new InnerObjectTest();
//        System.out.printf("2 inner : %d\r\n", ObjectSizeCalculator.getObjectSize(obj));
//        obj.innerObjectTest = null;
//        System.out.printf("null inner : %d\r\n", ObjectSizeCalculator.getObjectSize(obj));
//    }
//}
