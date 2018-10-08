package rmugattarov.basics.y2018m10;

public class OverrideStatic {
    protected static final int m() {return 0;}
    private static class A extends OverrideStatic {
        protected static final int m(int i){return 0;}
    }
}
