package rmugattarov.bonch;

import java.util.zip.Adler32;

public class ChecksumAdler {
    public static void main(String[] args) {
        Adler32 adler32 = new Adler32();
        adler32.update("int i;".getBytes());
        System.out.println(adler32.getValue());
    }
}
