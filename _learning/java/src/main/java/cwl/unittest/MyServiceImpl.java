package cwl.unittest;

public class MyServiceImpl implements MyService{

    public static void publicDo(int a, String st) {
        System.out.println(st);
    }

    private void privateDo(int a, String st) {
        System.out.println("private" + st);
    }

    private boolean privateGetTrue(String st) {
        System.out.println("private" + st);
        return null != st ? true : false;
    }

    @Override
    public int getInt(int aInt) {
        return 0;
    }

    @Override
    public void doSomething() {

    }
}
