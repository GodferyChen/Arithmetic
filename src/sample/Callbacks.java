package sample;

/**
 * Created by chen on 2017/2/4.
 */
public class Callbacks {

    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        caller1.go();
        caller1.go();
        caller2.go();
        caller2.go();
    }

}

interface Incrementable{
    void increement();
}

class Callee1 implements Incrementable{
    private int i = 0;

    @Override
    public void increement() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement{
    public void increment(){
        System.out.println("Other operation");
    }
    static void f(MyIncrement mi){
        mi.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;
    public void increment(){
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements Incrementable{

        @Override
        public void increement() {
            Callee2.this.increment();
        }
    }
    Incrementable getCallbackReference(){
        return new Closure();
    }
}

class Caller{
    private Incrementable callbackReference;
    Caller(Incrementable cbh){
        callbackReference = cbh;
    }
    void go(){
        callbackReference.increement();
    }
}
