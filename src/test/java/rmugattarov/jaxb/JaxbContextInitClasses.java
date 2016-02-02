package rmugattarov.jaxb;

import org.junit.Test;
import rmugattarov.jaxb.jaxb_classes.A;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

/**
 * Created by rmugattarov on 02.02.2016.
 */
public class JaxbContextInitClasses {
    @Test
    public void test() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(A.class);
        A a = (A) jaxbContext.createUnmarshaller().unmarshal(new StringReader("<a><b><string>Bazinga!</string></b></a>"));
        System.out.println(a.getB().getString());
    }
}
