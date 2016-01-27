package rmugattarov.jaxb;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.io.StringReader;
import java.util.List;

/**
 * Created by rmugattarov on 27.01.2016.
 */
public class NoElementWrapperTest {
    @XmlRootElement(name = "rootElement")
    private static class TestJaxb implements Serializable {
        @XmlElement(name = "element")
        private List<String> elementList;

        @Override
        public String toString() {
            return " TestJaxb {elementList : " + elementList + "} ";
        }
    }

    String xml =
            "<rootElement>" +
                    "<elementList>" +
                    "<element>1234</element>" +
                    "<element>qwer</element>" +
                    "</elementList>" +
                    "</rootElement>";

    @Test
    public void test_no_element_wrapper() {
        JAXBContext jaxbContext;
        TestJaxb testJaxb = null;
        try {
            jaxbContext = JAXBContext.newInstance(TestJaxb.class);
            testJaxb = (TestJaxb) jaxbContext.createUnmarshaller().unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println(testJaxb);
    }
}
