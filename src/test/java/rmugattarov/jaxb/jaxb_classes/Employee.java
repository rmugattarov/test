package rmugattarov.jaxb.jaxb_classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by rmugattarov on 03.03.2016.
 */
@XmlRootElement(name = "employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = -9106581905078767082L;

    @XmlElement
    protected String firstName;
    @XmlElement
    protected String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected  Employee() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
