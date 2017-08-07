package creational;

/**
 * Created by eugene on 03.08.17.
 */
public class AbstractFactory {
    public static void main(String[] args) {
        DeviseFactory deviseFactory = getDeviseFactoryByCountryCode("EN");
        Mouse mouse = deviseFactory.getMouse();
        mouse.doubleClick();
    }

    private static DeviseFactory getDeviseFactoryByCountryCode(String code) {
        switch (code) {
            case "EN":
                return new EnDeviseFactory();
            case "RU":
                return new RuDeviseFactory();
            default:
                throw new IllegalArgumentException("Code" + code + "not found");
        }

    }
}

interface Mouse {
    void click();

    void doubleClick();

    void scroll();
}
interface Keyboard {
    void print();

    void println();
}
interface TouchPad {
    void track(int deltaX, int deltaY);
}

interface DeviseFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    TouchPad getTouchPad();
}

class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("creational.RuMouse.click");
    }

    @Override
    public void doubleClick() {
        System.out.println("creational.RuMouse.doubleClick");
    }

    @Override
    public void scroll() {
        System.out.println("creational.RuMouse.scroll");
    }
}
class RuKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("creational.RuKeyboard.print");
    }

    @Override
    public void println() {
        System.out.println("creational.RuKeyboard.println");
    }
}
class RuTouchPad implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        System.out.println("deltaX = [" + deltaX + "], deltaY = [" + deltaY + "]");
    }
}

class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("creational.EnMouse.click");
    }

    @Override
    public void doubleClick() {
        System.out.println("creational.EnMouse.doubleClick");
    }

    @Override
    public void scroll() {
        System.out.println("creational.EnMouse.scroll");
    }
}
class EnKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("creational.EnKeyboard.print");
    }

    @Override
    public void println() {
        System.out.println("creational.EnKeyboard.println");
    }
}
class EnTouchPad implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        System.out.println("deltaX = [" + deltaX + "], deltaY = [" + deltaY + "]");
    }
}

class RuDeviseFactory implements DeviseFactory {
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}
class EnDeviseFactory implements DeviseFactory {
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}