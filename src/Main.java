public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //打印从运行程序的系统中获取的所以“属性”
        System.getProperties().list(System.out);
        //用户名
        System.out.println(System.getProperty("user.name"));
        //库的路径
        System.out.println(System.getProperty("java.library.path"));
    }
}
