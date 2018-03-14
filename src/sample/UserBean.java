package sample;

/**
 * Created by chen on 2017/5/3.
 */
public class UserBean {

    private String userName;
    private long userId;
    static String copyright = "";

    static {
        System.out.println("UserBean.static initializer");
        copyright = "初始化 copyright";
    }

    public UserBean(){

    }

    public UserBean(String userName,long userId){
        this.userName = userName;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public static void staticMethod(String devName){
        System.out.printf("Hi %s,I am a static method",devName);
    }

    public void publicMethod(){
        System.out.println("I am a public method");
    }

    private void privateMethod(){
        System.out.println("I am a private method");
    }
}
