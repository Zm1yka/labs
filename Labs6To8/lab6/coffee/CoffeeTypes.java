package coffee;

public abstract class CoffeeTypes {
    protected String name;
    protected double weight;  
    protected double price;   
    protected double volume; // Volume of the coffee product

    public CoffeeTypes(String name, double weight, double price, double volume) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.volume = volume; // Initialize volume
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
    
    public double getVolume() {
        return volume; // Getter for volume
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%s: Назва: %s, Вага: %.2f г, Ціна: %.2f грн, Об'єм: %.2f л",
                getType(), name, weight, price, volume);
    }
}
