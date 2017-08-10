package patterns.in.use.task8;

import sun.security.provider.PolicySpiFile;

/**
 * Created by eugene on 10.08.17.
 */
public class PizzaApp {
    public static void main(String[] args) {
        Pizza pizza = new PizzaBuilder()
                .buildDough(new PizzaElements(30,"standard"))
                .buildSause(new PizzaElements(40,"ketchup"))
                .buildTopping(new PizzaElements(33,"cheese"))
                .build();
        System.out.println(pizza);
    }
}

class PizzaElements {
    private int price;
    private String name;

    public PizzaElements(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PizzaElements{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Pizza {
    private PizzaElements dough;
    private PizzaElements sauce;
    private PizzaElements topping;
    private int price;

    public void setDough(PizzaElements dough) {
        this.dough = dough;
    }

    public void setSauce(PizzaElements sauce) {
        this.sauce = sauce;
    }

    public void setTopping(PizzaElements topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough=" + dough +
                ", sauce=" + sauce +
                ", topping=" + topping +
                ", price=" + price +
                '}';
    }
}

class PizzaBuilder {
    public static final double EXTRA_CHARGE = 0.4;
    private PizzaElements dough = new PizzaElements(0, "");
    private PizzaElements sauce = new PizzaElements(0, "");
    private PizzaElements topping = new PizzaElements(0, "");
    private int price;

    PizzaBuilder buildDough(PizzaElements dough) {
        this.dough = dough;
        return this;
    }
    PizzaBuilder buildSause(PizzaElements sauce){
        this.sauce = sauce;
        return this;
    }
    PizzaBuilder buildTopping(PizzaElements topping){
        this.topping = topping;
        return this;
    }
    Pizza build(){
        Pizza pizza = new Pizza();
        pizza.setDough(dough);
        pizza.setSauce(sauce);
        pizza.setTopping(topping);
        price =(int)((dough.getPrice()+sauce.getPrice()+ topping.getPrice())*(1+EXTRA_CHARGE));
        return pizza;
    }
}