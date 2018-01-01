//package rmugattarov.memory;
//
//import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//
///**
// * Created by rmugattarov on 19.09.2016.
// */
//public class ArrayLvsLinkedL {
//    public static void main(String[] args) {
//        ArrayList<String> arrayList = new ArrayList<>();
//        LinkedList<String> linkedList = new LinkedList<>();
//
//        System.out.printf("Empty ArrayList : %d\r\n", ObjectSizeCalculator.getObjectSize(arrayList));
//        System.out.printf("Empty LinkedList : %d\r\n", ObjectSizeCalculator.getObjectSize(linkedList));
//
//        int elementCount = 10_000_000;
//        for (int i = 0; i < elementCount; i++) {
//            arrayList.add(null);
//            linkedList.add(null);
//        }
//
//        System.out.printf("ArrayList : %d KB per element\r\n", ObjectSizeCalculator.getObjectSize(arrayList) / elementCount);
//        System.out.printf("LinkedList : %d KB per element\r\n", ObjectSizeCalculator.getObjectSize(linkedList) / elementCount);
//    }
//}
