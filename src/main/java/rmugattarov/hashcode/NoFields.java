package rmugattarov.hashcode;

/**
 * Created by rmugattarov on 13.09.2016.
 */
public class NoFields {
    private int hashCode;

    public NoFields() {
        this.hashCode = this.getClass().getName().hashCode();
    }

    public int getHashCode() {
        return hashCode;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new NoFields().getHashCode());
        }
    }
}
