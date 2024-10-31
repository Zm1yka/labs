package Console;

import Truck.CoffeeTruck;

public class SortProductByPriceToWeight implements Command {
    private CoffeeTruck coffeeTruck;

    public SortProductByPriceToWeight(CoffeeTruck coffeeTruck) {
        this.coffeeTruck = coffeeTruck;
    }

    @Override
    public void execute() {
        System.out.println("Сортування продуктів за співвідношенням ціни до ваги...");
        coffeeTruck.sortByPriceToWeightRatio();
        coffeeTruck.showAllProducts(); 
    }
}
