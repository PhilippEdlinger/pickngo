package models;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class DrinkItem extends Product {
    public Double volume;
    public Boolean warm;

    public DrinkItem() {
    }

    public DrinkItem(String name, Double price, String imagePath, String allergies, Integer preparationTime, List<OrderItem> orderItems, CategoryET categoryET, Double volume, Boolean warm) {
        super(name, price, imagePath, allergies, preparationTime, orderItems, categoryET);
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
