package rmugattarov.jaxb.jaxb_classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rmugattarov on 02.02.2016.
 */
@XmlRootElement(name = "a")
public class A {
    @XmlElement
    protected B b;

    public B getB() {
        return b;
    }
}
