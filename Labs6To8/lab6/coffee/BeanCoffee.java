package coffee;

public class BeanCoffee extends CoffeeTypes {
    public BeanCoffee(String name, double weight, double price, double volume) {
        super(name, weight, price, volume); // Pass volume to the constructor
    }

    @Override
    public String getType() {
        return "Зернова кава";
    }
}
