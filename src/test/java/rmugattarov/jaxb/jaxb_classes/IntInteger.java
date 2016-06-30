package rmugattarov.jaxb.jaxb_classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rmugattarov on 02.06.2016.
 */
@XmlRootElement(name = "intInteger")
public class IntInteger {
    @XmlElement(defaultValue = "1")
    private int primtInt = 2;
    @XmlElement(defaultValue = "321")
    private Integer obInt = 2;

    public int getPrimtInt() {
        return primtInt;
    }

    public Integer getObInt() {
        return obInt;
    }
}
