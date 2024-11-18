package Truck;

import coffee.CoffeeTypes;
import logging.LogManager;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class CoffeeTruck {
    private List<CoffeeTypes> products;
    private double currentVolume;
    private double maxVolume;
    private static final Logger logger = LogManager.getLogger();

    public CoffeeTruck() {
        this.products = new ArrayList<>();
        this.currentVolume = 0;
        this.maxVolume = 1000;
        logger.info("Створено новий CoffeeTruck з максимальним об'ємом " + maxVolume);
    }

    public void addProduct(CoffeeTypes product) {
        double productVolume = product.getVolume();
        if (canLoad(productVolume)) {
            products.add(product);
            currentVolume += productVolume;
            logger.info("Продукт додано: " + product);
        } else {
            String errorMessage = "Неможливо додати продукт: обсяг перевищує обмеження.";
            logger.warning(errorMessage);
            System.out.println(errorMessage);
        }
    }

    public boolean canLoad(double productVolume) {
        return (currentVolume + productVolume) <= maxVolume;
    }

    public void sortByPriceToWeightRatio() {
        products.sort((coffee1, coffee2) -> 
            Double.compare(coffee1.getPrice() / coffee1.getWeight(), coffee2.getPrice() / coffee2.getWeight())
        );
        logger.info("Продукти відсортовано за співвідношенням ціни до ваги.");
    }

    public void showAllProducts() {
        if (products.isEmpty()) {
            logger.info("Спроба показати всі продукти: Фургон порожній.");
            System.out.println("Фургон порожній.");
        } else {
            System.out.println("Продукти в фургоні:");
            for (CoffeeTypes product : products) {
                System.out.println(product);
                logger.fine("Відображення продукту: " + product);
            }
        }
    }
    
    public List<CoffeeTypes> getProducts() {
        return products;
    }

    public void clearProducts() {
        products.clear();
        logger.info("Всі продукти видалено з фургона.");
    }
}
