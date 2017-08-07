package structural.decorator;

/**
 * Created by eugene on 07.08.17.
 */
public class Decorator {
    public static void main(String[] args) {
        PrinterInterface printerInterface = new QuotesDecorator
                (new LeftBracketDecorator(new RightBracketDecorator( new Printer("Hello"))));
        printerInterface.print();
    }
}
interface PrinterInterface{
    void print();
}
class Printer implements PrinterInterface{
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}
abstract class AbstractDecorator implements PrinterInterface{
    PrinterInterface component;

    public AbstractDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
    }
}

class QuotesDecorator extends AbstractDecorator{

    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}
class LeftBracketDecorator extends AbstractDecorator{

    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}
class RightBracketDecorator extends AbstractDecorator{

    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}
