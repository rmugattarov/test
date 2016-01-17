package rmugattarov.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by rmugattarov on 17.01.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class InjectFieldsTest {
    private DummyInterface dummyService;
    @InjectMocks
    private DummyClass dummyObject;

    public InjectFieldsTest() {
        dummyService = Mockito.mock(DummyInterface.class);
        Mockito.when(dummyService.returnString()).thenReturn("Bazinga!");
    }

    @Test
    public void test_mock_injection() {
        String answer = dummyObject.returnString();
        System.out.printf("dummyObject.returnString() : %s", answer);
        Assert.assertEquals("Bazinga!", answer);
    }
}
