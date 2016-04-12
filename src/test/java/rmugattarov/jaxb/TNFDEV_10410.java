package rmugattarov.jaxb;

import org.junit.Test;
import rmugattarov.jaxb.jaxb_classes.KatStroyXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.*;

/**
 * Created by rmugattarov on 12.04.2016.
 */
public class TNFDEV_10410 {
    @Test
    public void test() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(KatStroyXml.class);
//        KatStroyXml katStroyXml = (KatStroyXml) jaxbContext.createUnmarshaller().unmarshal(new FileReader(KatStroyXml.PATH));
//        KatStroyXml katStroyXml = (KatStroyXml) jaxbContext.createUnmarshaller().unmarshal(new BufferedInputStream(new FileInputStream(KatStroyXml.PATH)));
        KatStroyXml katStroyXml = (KatStroyXml) jaxbContext.createUnmarshaller().unmarshal(new InputStreamReader(new FileInputStream(new File(KatStroyXml.PATH))));

        System.out.println(katStroyXml);
    }
}
