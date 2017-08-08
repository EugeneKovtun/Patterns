package behavioral.template.method;

/**
 * Created by eugene on 08.08.17.
 */
public class TemplateMethodApp {
    public static void main(String[] args) {
        C c = new A();
        c.method();
        c = new B();
        c.method();
    }
}

abstract class C {
    void method() {
        System.out.println(1);
        differ1();
        System.out.println(3);
        differ2();
    }

    abstract void differ1();

    abstract void differ2();
}

class A extends C {
    @Override
    void differ1() {
        System.out.println(2);
    }

    @Override
    void differ2() {
        System.out.println(5);
    }
}

class B extends C {
    @Override
    void differ1() {
        System.out.println(4);
    }

    @Override
    void differ2() {
        
    }
}