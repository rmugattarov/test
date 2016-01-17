package rmugattarov.mockito;

/**
 * Created by rmugattarov on 17.01.2016.
 */
public class DummyClass {
    private DummyInterface dummyService;

    public String returnString() {
        System.out.println("DummyClass.returnString() called!");
        return dummyService.returnString();
    }
}
