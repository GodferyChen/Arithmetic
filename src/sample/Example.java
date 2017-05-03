package sample;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by chen on 2017/2/25.
 */
public class Example {

    String str = new String("good");
    char[] ch = {'a','b','c'};

    public void change(String str,char[] ch){
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
//        sample.sample.Example ex = new sample.sample.Example();
//        ex.change(ex.str,ex.ch);
//        System.out.print(ex.str+" and ");


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("sample.sample.Example.run");
            }
        },1000*20);
        System.out.println("sample.sample.Example.main");
    }

}
