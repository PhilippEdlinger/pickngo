package models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class DrinkItem extends Product {
    public Double volume;
    public Boolean warm;

    public DrinkItem() {
    }

    public DrinkItem(String name, Double price, String description, String imagePath, String allergies, Integer preparationTime, List<OrderItem> orderItems, CategoryET categoryET, List<Menu> menus, List<Tag> tags, Double volume, Boolean warm) {
        super(name, price, description, imagePath, allergies, preparationTime, orderItems, categoryET, menus, tags);
        this.volume = volume;
        this.warm = warm;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Boolean getWarm() {
        return warm;
    }

    public void setWarm(Boolean warm) {
        this.warm = warm;
    }
}
