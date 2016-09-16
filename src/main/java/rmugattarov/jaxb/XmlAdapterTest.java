package rmugattarov.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.StringReader;

/**
 * Created by rmugattarov on 16.09.2016.
 */
public class XmlAdapterTest {
    public static class Unmappable {
        private final String s;

        public Unmappable(String s) {
            this.s = s;
        }

        @Override
        public String toString() {
            return " Unmappable {s : " + s + "} ";
        }

        public String getS() {
            return s;
        }
    }


    public static class Mappable {
        @XmlValue
        private String s;

        public Mappable() {
        }

        public Mappable(String s) {
            this.s = s;
        }

        public String getS() {
            return s;
        }
    }

    public static class UnmappableAdapter extends XmlAdapter<Mappable, Unmappable> {

        @Override
        public Unmappable unmarshal(Mappable v) throws Exception {
            return new Unmappable(v.getS());
        }

        @Override
        public Mappable marshal(Unmappable v) throws Exception {
            return new Mappable(v.getS());
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class RootClass {
        @XmlJavaTypeAdapter(UnmappableAdapter.class)
        private Unmappable unmappable;

        @Override
        public String toString() {
            return " RootClass {unmappable : " + unmappable + "} ";
        }
    }

    public static void main(String[] args) throws JAXBException {
        System.out.println(JAXBContext.newInstance(RootClass.class, Unmappable.class).createUnmarshaller().unmarshal(new StringReader("<rootClass><unmappable>Bazinga!</unmappable></rootClass>")));
    }
}
