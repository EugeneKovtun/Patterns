package behavioral.visitor;

/**
 * Created by eugene on 08.08.17.
 */
public class VisitorApp {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();
        Visitor visitor = new HooliganVisitor();
        body.accept(visitor);
        engine.accept(visitor);
    }
}

interface Visitor {
    void visit(EngineElement engineElement);

    void visit(BodyElement bodyElement);
}

interface Element {
    void accept(Visitor visitor);
}

class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BodyElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {
    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("Start engine");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Knock at the body");
    }
}

class MechanicVisitor implements Visitor {
    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("Check engine");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Check body");
    }
}