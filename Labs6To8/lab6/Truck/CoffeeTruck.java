package Truck;

import coffee.CoffeeTypes;

import java.util.ArrayList;
import java.util.List;

public class CoffeeTruck {
    private List<CoffeeTypes> products;  
    private double currentVolume; 
    private double maxVolume; 

    public CoffeeTruck() {
        this.products = new ArrayList<>();
        this.currentVolume = 0; 
        this.maxVolume = 1000; 
    }

    public void addProduct(CoffeeTypes product) {
        double productVolume = product.getVolume(); 
        if (canLoad(productVolume)) {
            products.add(product);
            currentVolume += productVolume; 
        } else {
            System.out.println("Неможливо додати продукт: обсяг перевищує обмеження.");
        }
    }

    public boolean canLoad(double productVolume) {
        return (currentVolume + productVolume) <= maxVolume;
    }

    public void sortByPriceToWeightRatio() {
        products.sort((coffee1, coffee2) -> 
            Double.compare(coffee1.getPrice() / coffee1.getWeight(), coffee2.getPrice() / coffee2.getWeight())
        );
    }

    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Фургон порожній.");
        } else {
            System.out.println("Продукти в фургоні:");
            for (CoffeeTypes product : products) {
                System.out.println(product); 
            }
        }
    }

    public List<CoffeeTypes> getProducts() {
        return products;
    }

    public void clearProducts() {
        products.clear();
    }
}
