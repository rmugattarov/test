package rmugattarov.jaxb.jaxb_classes;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by rmugattarov on 02.02.2016.
 */
public class B {
    @XmlElement
    protected String string;

    public String getString() {
        return string;
    }
}
