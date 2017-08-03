/**
 * Created by eugene on 03.08.17.
 */
public class Prototype {
    public static void main(String[] args) {
        HumanFactory factory = new HumanFactory(new Human(19,"Tor"));
        Human h1 = factory.makeCopy();
        System.out.println(h1);
    }
}

interface Copyable {
    Object copy();
}

class Human implements Copyable {
    private int age;
    private String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        return new Human(age, name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumanFactory {
    Human human;

    public HumanFactory(Human human) {
        this.human = human;
    }

    public void setPrototype(Human human) {
        this.human = human;
    }

    public Human makeCopy() {
        return (Human) human.copy();
    }
}