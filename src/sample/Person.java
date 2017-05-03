package sample;

/**
 * Created by chen on 2017/4/30.
 */
public class Person implements China{

    private String name;
    private int age;

    public Person(){

    }

    public Person(String name){
        this.name = name;
    }

    public Person(int age){
        this.age = age;
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void sayChina() {
        System.out.println("hello,China");
    }

    @Override
    public void sayHello(String name, int age) {
        System.out.println(name+" "+age);
    }
}

interface China{

    static final String name="Raki";
    static int age =26;
    void sayChina();
    void sayHello(String name,int age);

}
