package rmugattarov.jaxb.jaxb_classes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.List;

/**
 * Created by rmugattarov on 12.04.2016.
 */
@XmlRootElement(name = "TABLE")
public class KatStroyXml {
    public final static String PATH = "C:\\Users\\rmugattarov\\Desktop\\KatStroyTest.xml";

    @XmlElement(name = "RECORD")
    private List<Record> records;

    @Override
    public String toString() {
        return " KatStroyXml {records : " + records + "} ";
    }

    public static class Record {
        @XmlElement(name = "FIELD")
        private List<Field> fields;

        @Override
        public String toString() {
            return " Record {fields : " + fields + "} ";
        }

        public static class Field {
            @XmlAttribute(name = "NAME")
            private String name;
            @XmlValue
            private String value;

            @Override
            public String toString() {
                return " Field {name : " + name + ",\nvalue : " + value + "\n} ";
            }

            public String getName() {
                return name;
            }

            public String getValue() {
                return value;
            }
        }
    }
}
