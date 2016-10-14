package rmugattarov.init_blocks;

/**
 * Created by rmugattarov on 14.10.2016.
 */
public class InitBlockVsConstr {
    private static class SubClass extends InitBlockVsConstr {
        {
            System.out.println("SubClass Block");
        }
        public SubClass() {
            System.out.println("SubClass Constr");
        }
    }

    {
        System.out.println("Block");
    }

    public InitBlockVsConstr() {
        System.out.println("Constr");
    }

    public static void main(String[] args) {
        new SubClass();
    }
}
