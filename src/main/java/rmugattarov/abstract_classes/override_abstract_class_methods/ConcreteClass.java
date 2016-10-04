package rmugattarov.abstract_classes.override_abstract_class_methods;

/**
 * Created by rmugattarov on 04.10.2016.
 */
public class ConcreteClass extends AbstractClass {
    @Override
    public void printSmth() {
        System.out.println("ConcreteClass");
    }

    public static void main(String[] args) {
        new ConcreteClass().printSmth();
    }
}
