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

    public FoodItem(String name, Double price, String imagePath, String allergies, Integer preparationTime, List<OrderItem> orderItems, CategoryET categoryET, List<Menu> menus, List<Tag> tags, Boolean isVegan, Boolean isVegetarian, Boolean isDishOfTheDay) {
        super(name, price, imagePath, allergies, preparationTime, orderItems, categoryET, menus, tags);
        this.isVegan = isVegan;
        this.isVegetarian = isVegetarian;
        this.isDishOfTheDay = isDishOfTheDay;
    }

    public Boolean getVegan() {
        return isVegan;
    }

    public void setVegan(Boolean vegan) {
        isVegan = vegan;
    }

    public Boolean getVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public Boolean getDishOfTheDay() {
        return isDishOfTheDay;
    }

    public void setDishOfTheDay(Boolean dishOfTheDay) {
        isDishOfTheDay = dishOfTheDay;
    }
}
