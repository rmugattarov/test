package rmugattarov.jaxb;

import org.junit.Test;
import rmugattarov.jaxb.jaxb_classes.IntInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

/**
 * Created by rmugattarov on 02.06.2016.
 */
public class TestIntInteger {
    @Test
    public void test() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(IntInteger.class);
        IntInteger intInteger = (IntInteger) jaxbContext.createUnmarshaller().unmarshal(new StringReader("<intInteger><primInt>3</primInt><obInt>123</obInt></intInteger>"));
        System.out.println(intInteger.getPrimtInt());
        System.out.println(intInteger.getObInt());
    }
}
