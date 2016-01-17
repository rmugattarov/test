package rmugattarov.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by rmugattarov on 17.01.2016.
 */
public class MockitoTest {
    private DummyInterface dummyObject;

    public MockitoTest() {
        dummyObject = Mockito.mock(DummyInterface.class);
        Mockito.when(dummyObject.returnString())
                .thenReturn("Hello, I am mocked!");
    }

    @Test
    public void test_mocked_object() {
        String answer = dummyObject.returnString();
        System.out.printf("Mocked dummy service returned : %s", answer);
        Assert.assertEquals("Hello, I am mocked!", answer);
    }
}
