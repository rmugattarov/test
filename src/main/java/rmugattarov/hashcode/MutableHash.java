package rmugattarov.hashcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by rmugattarov on 15.09.2016.
 */
public class MutableHash {
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
        System.out.printf("s set to : %s\r\n", s);
    }

    @Override
    public int hashCode() {
        int hash = s == null ? 1 : s.hashCode();
        System.out.printf("hashCode called. value : %d\r\n", hash);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        boolean result;
        if (o == null) {
            result = false;
        } else if (o == this) {
            result = true;
        } else if (getClass() != o.getClass()) {
            result = false;
        } else {
            MutableHash that = (MutableHash) o;
            result = this.s.equals(that.s);
        }
        System.out.printf("equals called. result : %s\r\n", result);
        return result;
    }

    public static void main(String[] args) {
        Set<MutableHash> set = new HashSet<>();
        MutableHash o1 = new MutableHash();
        set.add(o1);
        System.out.printf("set size : %d\r\n", set.size());
        set.add(o1);
        System.out.printf("set size : %d\r\n", set.size());
        o1.setS("123");
        set.add(o1);
        System.out.printf("set size : %d\r\n", set.size());
        int i = 0;
        for (MutableHash mutableHash : set) {
            System.out.printf("set element %d : %s\r\n", ++i, mutableHash.getS());
        }
        Iterator<MutableHash> iterator = set.iterator();
        i= 0;
        while (iterator.hasNext()) {
            MutableHash next = iterator.next();
            System.out.printf("set element %d : %s\r\n", ++i, next.getS());
        }
    }
}
