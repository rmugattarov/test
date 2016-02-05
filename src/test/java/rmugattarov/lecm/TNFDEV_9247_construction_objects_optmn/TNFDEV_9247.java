package rmugattarov.lecm.TNFDEV_9247_construction_objects_optmn;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rmugattarov on 05.02.2016.
 */
public class TNFDEV_9247 {
    public static final String RECORD_OPEN_TAG = "<RECORD>";
    public static final String RECORD_CLOSE_TAG = "RECORD>";
    public static final Pattern fieldPattern = Pattern.compile("<\\s*FIELD\\s+NAME=\\s*\"(\\w+)\"\\s*>(.*)<\\s*/\\s*FIELD\\s*>");

    @Test
    public void test() throws IOException {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("tn.fntst.ru", "cpe_bootstrap@tn.fntst.ru", "o9p0[-]=");
        try (InputStreamReader inputStream = new InputStreamReader(new BufferedInputStream(new SmbFileInputStream(new SmbFile("smb://172.28.24.185/tstxml/KatStroy.XML", auth))), "UTF-8")) {
            int c;
            StringBuilder sb = new StringBuilder();
            while ((c = inputStream.read()) != -1) {
                sb.append((char) c);
                if (sb.toString().startsWith(RECORD_OPEN_TAG)) {
                    sb.setLength(0);
                } else if (sb.toString().endsWith(RECORD_CLOSE_TAG)) {
                    Matcher matcher = fieldPattern.matcher(sb);
                    while (matcher.find()) {
                        System.out.printf("%s = %s\n", matcher.group(1), matcher.group(2));
                    }
                    sb.setLength(0);
                }
            }
        }
    }
}
