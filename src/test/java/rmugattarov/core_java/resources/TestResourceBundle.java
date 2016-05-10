package rmugattarov.core_java.resources;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by rmugattarov on 10.05.2016.
 */
public class TestResourceBundle {
    @Test
    public void test() {
        ResourceBundle bundle = ResourceBundle.getBundle("123", new Locale("ru"));
    }
}
