package sample;

import java.lang.reflect.*;

/**
 * Created by chen on 2017/5/3.
 */
public class Reflection {

    public static void main(String[] args) {
        //获取class
        Class userBeanClass = null;
        try {
            userBeanClass = Class.forName("sample.UserBean");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        Class userBeanClass = UserBean.class;

        //打印成员变量
        Field [] fields = userBeanClass.getDeclaredFields();
        for (Field field : fields) {
            String fieldString = "";
            fieldString += Modifier.toString(field.getModifiers()) + " ";//'private'
            fieldString += field.getType().getSimpleName()+" ";//'String'
            fieldString += field.getName()+";";//'userName'
//            System.out.println(fieldString);
        }

        //打印成员方法
        Method[] methods = userBeanClass.getDeclaredMethods();
        for (Method method : methods) {
            String methodString = Modifier.toString(method.getModifiers()) + " ";//private static
            methodString += method.getReturnType().getSimpleName()+" ";//void
            methodString += method.getName()+"(";//staticMethod
            Class [] params = method.getParameterTypes();
            for (int i=0;i < params.length;i++) {
                methodString += params[i].getSimpleName() + " arg"+i;//String
            }
            methodString +=")";

//            System.out.println(methodString);
        }

        //打印构造方法
        Constructor [] constructors = userBeanClass.getConstructors();
        for (Constructor constructor : constructors) {
            String conString = Modifier.toString(constructor.getModifiers()) + " ";//private
            conString += constructor.getName() +"(";
            Class[] params = constructor.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                conString += params[i].getSimpleName()+" arg"+i;
                if(i < params.length -1){
                    conString +=",";
                }
            }
            conString += ")";
//            System.out.println(conString);
        }

        //执行方法
        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers())){//如果是static方法
                try {
                    method.invoke(null,"raki");//直接调用，并传入需要的参数devName
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else {
                Class[] params = {String.class,long.class};
                try {
                    //获取参数格式为String,long的构造函数
                    Constructor constructor = userBeanClass.getDeclaredConstructor(params);
                    //利用构造函数进行实例化，得到Object
                    Object userBean = constructor.newInstance();
                    if(Modifier.isPrivate(method.getModifiers())){
                        //如果是 private 的方法，需要获取调用权限
                        method.setAccessible(true);
                    }

                    //调用 method ，无须参数
                    method.invoke(userBean);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
