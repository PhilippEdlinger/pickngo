package models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class FoodItem extends Product{
    public Boolean isVegan;
    public Boolean isVegetarian;
    public Boolean isDishOfTheDay;

    public FoodItem() {
    }

    public FoodItem(String name, Double price, String imagePath, String allergies, Integer preparationTime, List<OrderItem> orderItems, CategoryET categoryET, Boolean isVegan, Boolean isVegetarian, Boolean isDishOfTheDay) {
        super(name, price, imagePath, allergies, preparationTime, orderItems, categoryET);
        this.isVegan = isVegan;
        this.isVegetarian = isVegetarian;
        this.isDishOfTheDay = isDishOfTheDay;
    }
}
