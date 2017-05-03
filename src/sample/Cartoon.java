package sample;

/**
 * Created by chen on 2017/4/7.
 */
public class Cartoon extends Art{

    private int k = printInit("Cartoon.k initialized");

    public Cartoon(){
        System.out.println("k = "+k+",j = "+j);
    }

    private static int x2 = printInit("static Cartoon.x2 initialized");

    public static void main(String[] args) {
        Cartoon d = new Cartoon();
        System.out.println(Math.round(-10.5));
    }

}

class Art{
    private int i = 9;
    protected int j;

    Art(){
        System.out.println("i = "+ i +",j = "+j);
        j = 39;
    }
    private static int x1 = printInit("static Art.x1 initialized");

    static int printInit(String s){
        System.out.println(s);
        return 47;
    }
}
