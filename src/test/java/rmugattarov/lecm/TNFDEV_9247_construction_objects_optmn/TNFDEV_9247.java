package rmugattarov.lecm.TNFDEV_9247_construction_objects_optmn;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Created by rmugattarov on 05.02.2016.
 */
public class TNFDEV_9247 {
    @Test
    public void test() throws IOException {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("tn.fntst.ru", "cpe_bootstrap@tn.fntst.ru", "o9p0[-]=");
        BufferedInputStream inputStream = new BufferedInputStream(new SmbFileInputStream(new SmbFile("smb://172.28.24.185/tstxml/KatStroy.XML", auth)));
        int c;
        while ((c = inputStream.read()) != -1) {
            System.out.print((char) c);
        }
    }
}
