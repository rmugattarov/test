package rmugattarov.bad_interview;

import java.io.FileNotFoundException;
import java.io.IOException;

interface I1 {
    void copy() throws IOException, IllegalArgumentException;
}
interface I2 {
    void copy() throws FileNotFoundException, InterruptedException;
}

public class No13 implements I1, I2 {

    @Override
    public void copy() {

    }
}
