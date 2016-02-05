package rmugattarov.jaxb;

import org.junit.Test;
import rmugattarov.jaxb.jaxb_classes.A;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.io.StringReader;
import java.util.List;

/**
 * Created by rmugattarov on 05.02.2016.
 */
public class TestXmlValue {
    @XmlRootElement(name = "JaxbXmlValue")
    public static class JaxbXmlValue {
        @XmlElement(name = "element")
        private List<Element> elements;

        @Override
        public String toString() {
            return " JaxbXmlValue { elements : " + elements + "} ";
        }
    }

    public static class Element {
        @XmlAttribute
        private String name;
        @XmlValue
        private String value;

        @Override
        public String toString() {
            return " Element {name : " + name + ", value : " + value + "} ";
        }
    }

    @Test
    public void test() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(JaxbXmlValue.class);
        JaxbXmlValue jaxbXmlValue = (JaxbXmlValue) jaxbContext.createUnmarshaller().unmarshal(new StringReader("" +
                "<JaxbXmlValue>" +
                "<element name=\"elementName\">" +
                "VALUE" +
                "</element>" +
                "</JaxbXmlValue>"));
        System.out.println(jaxbXmlValue);
    }
}
