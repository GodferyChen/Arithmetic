package sample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by chen on 2017/4/30.
 */
public class Hello {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("sample.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("=================本类属性=================");
        //取得本类的全部属性
        Field[] field = demo.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            //权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            //属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv+" "+type.getName()+" "+field[i].getName()+";");
        }
        System.out.println("================实现的接口或者父类的属性=================");
        //取得实现的接口或者父类的属性
        Field[] field1 = demo.getFields();
        for (int i = 0; i < field1.length; i++) {
            //权限修饰符
            int mo = field1[i].getModifiers();
            String priv = Modifier.toString(mo);
            //属性类型
            Class<?> type = field1[i].getType();
            System.out.println(priv+" "+type.getName()+" "+field1[i].getName()+";");
        }
    }

}

