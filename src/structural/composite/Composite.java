package structural.composite;

import java.util.ArrayList;

/**
 * Created by eugene on 08.08.17.
 */
public class Composite {
    public static void main(String[] args) {
        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape circle3 = new Circle();

        Shape rectangle1 = new Rectangle();
        Shape rectangle2 = new Rectangle();
        Shape rectangle3 = new Rectangle();

        Shape triangle1 = new Triangle();
        Shape triangle2 = new Triangle();
        Shape triangle3 = new Triangle();

        Compositor compositor = new Compositor();
        Compositor compositor1 = new Compositor();
        Compositor compositor2 = new Compositor();

        compositor1.addComponent(circle1);
        compositor1.addComponent(triangle1);
        compositor1.addComponent(rectangle1);

        compositor2.addComponent(circle2);
        compositor2.addComponent(rectangle2);
        compositor2.addComponent(triangle2);

        compositor.addComponent(compositor1);
        compositor.addComponent(compositor2);
        compositor.addComponent(circle3);
        compositor.addComponent(rectangle3);
        compositor.addComponent(triangle3);

        compositor.draw();

    }
}
interface Shape{
    void draw();
}
class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Triangle.draw");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle.draw");
    }
}
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle.draw");
    }
}
class Compositor implements Shape{
    private ArrayList<Shape> components = new ArrayList<>();
    public void addComponent(Shape component){
        components.add(component);
    }
    public void removeComponent(Shape component){
        components.remove(component);
    }
    @Override
    public void draw() {
        for (Shape component:
             components) {
            component.draw();
        }
    }
}