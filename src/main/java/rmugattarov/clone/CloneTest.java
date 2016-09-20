package rmugattarov.clone;

/**
 * Created by rmugattarov on 20.09.2016.
 */
public class CloneTest {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneTest o1 = new CloneTest();
        CloneTest o2 = (CloneTest) o1.clone();
    }
}
