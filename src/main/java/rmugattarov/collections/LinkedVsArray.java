package rmugattarov.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rmugattarov on 15.08.2016.
 */
public class LinkedVsArray {
    public static void main(String[] args) {
        Date date1 = new Date();
        List<Long> arrayList = new ArrayList<>();
        for (long i = 0; i < 10000000L; i++) {
            arrayList.add(i);
        }
        for (Long number : arrayList) {
            number += number;
        }
        Date date2 = new Date();
        System.out.printf("ArrayList : %d ms\r\n", (date2.getTime() - date1.getTime()));

        Date date3 = new Date();
        List<Long> linkedList = new LinkedList<>();
        for (long i = 0; i < 10000000L; i++) {
            linkedList.add(i);
        }
        for (Long number : linkedList) {
            number += number;
        }
        Date date4 = new Date();
        System.out.printf("LinkedList : %d ms\r\n", (date4.getTime() - date3.getTime()));
    }
}
