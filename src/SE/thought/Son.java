package SE.thought;

/**
 * @author gmydl
 * @title: Son
 * @projectName DataStructure
 * @description: TODO
 * @date 2022/7/5 11:48
 */
public class Son extends Father{

    private String name ;

    private int age;

    public Son() {
        super.introduction();
    }

    public Son(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduction() {
        System.out.println("大家好！我是"         + age + "号" + name + ".");
    }

    public static void main(String[] args) {
        Son son1 = new Son();


        Son son2 = new Son("1", 1);
        son2.introduction();
    }
}
