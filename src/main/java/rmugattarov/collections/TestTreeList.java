package rmugattarov.collections;

import org.apache.commons.collections4.list.TreeList;

/**
 * Created by rmugattarov on 16.06.2016.
 */
public class TestTreeList {
    public static void main(String[] args) {
        TreeList<String> treeList = new TreeList<>();
        treeList.add("Z");
        treeList.add("Y");
        treeList.add("X");
        treeList.add("A");
        treeList.add("A");
        treeList.add("A");
        treeList.add("B");
        treeList.add("C");
        treeList.add("D");
        System.out.println(treeList);
    }
}
