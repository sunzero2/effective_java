package builder;

public class Main {
    public static void main(String[] args) {
        BuilderPattern builderPattern = new BuilderPattern.Builder(240, 8).build();
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addToping(Pizza.Topping.SAUSAGE).build();
        Calzone calzone = new Calzone.Builder().addToping(Pizza.Topping.HAM).sauceInside().build();
    }
}
