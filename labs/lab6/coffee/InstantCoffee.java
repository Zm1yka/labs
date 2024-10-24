package coffee;

public class InstantCoffee extends CoffeeTypes {
    public InstantCoffee(String name, double weight, double price, double volume) {
        super(name, weight, price, volume);
    }

    @Override
    public String getType() {
        return "Розчинна кава";
    }
}
