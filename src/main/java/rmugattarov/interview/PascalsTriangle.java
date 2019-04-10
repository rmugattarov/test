package rmugattarov.interview;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        outputPascalsTriangle(5);
    }

    private static void outputPascalsTriangle(int rows) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        while(rows-- > 0) {
            System.out.println(row);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int i = 1; i < row.size(); i++) {
                newRow.add(row.get(i - 1) + row.get(i));
            }
            row = newRow;
            row.add(1);
        }
    }
}
