package rmugattarov.hashcode;

import java.util.HashSet;
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
        System.out.println("s set to : " + s);
    }

    @Override
    public int hashCode() {
        int hash = s == null ? 1 : s.hashCode();
        System.out.println("hashCode called. value : " + hash);
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
        System.out.println("equals called. result " + result);
        return result;
    }

    public static void main(String[] args) {
        Set<MutableHash> set = new HashSet<>();
        MutableHash o1 = new MutableHash();
        set.add(o1);
        System.out.println("set size : " + set.size());
        set.add(o1);
        System.out.println("set size : " + set.size());
        o1.setS("123");
        set.add(o1);
        System.out.println("set size : " + set.size());
        int i = 0;
        for (MutableHash mutableHash : set) {
            System.out.printf("set element %d : %s\r\n", ++i, mutableHash.getS());
        }
    }
}
