package structural.delegate;

/**
 * Created by eugene on 07.08.17.
 */
public class Delegate {
    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setDrawable(new Triangle());
        painter.paint();
        painter.setDrawable(new Square());
        painter.paint();
        painter.setDrawable(new Circle());
        painter.paint();
    }
}

interface Drawable {
    void draw();
}

class Triangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Triangle.draw");
    }
}

class Square implements Drawable {
    @Override
    public void draw() {
        System.out.println("Square.draw");
    }
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Circle.draw");
    }
}

class Painter {
    Drawable drawable;

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void paint() {
        drawable.draw();
    }
}