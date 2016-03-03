package rmugattarov.jaxb;

import org.junit.Test;
import rmugattarov.jaxb.jaxb_classes.Employee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by rmugattarov on 03.03.2016.
 */
public class Marshall {
    @Test
    public void test() throws JAXBException, FileNotFoundException {
        Marshaller marshaller = JAXBContext.newInstance(Employee.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new Employee("Robert", "Mugattarov"), new FileOutputStream("D:/DUMP/employee.xml"));
    }
}
