package coffee;

public class GroundCoffe extends CoffeeTypes {
    public GroundCoffe(String name, double weight, double price, double volume) {
        super(name, weight, price, volume);
    }

    @Override
    public String getType() {
        return "Мелена кава";
    }
}
