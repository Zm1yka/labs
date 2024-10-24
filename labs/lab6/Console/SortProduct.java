package Console;

import Truck.CoffeeTruck;

public class SortProduct implements Command {
    private CoffeeTruck coffeeTruck;

    public SortProduct(CoffeeTruck coffeeTruck) {
        this.coffeeTruck = coffeeTruck;
    }

    @Override
    public void execute() {
        System.out.println("Сортування продуктів за співвідношенням ціни до ваги...");
        coffeeTruck.sortByPriceToWeightRatio();
        coffeeTruck.showAllProducts(); // Now this will display formatted product info
    }
}
