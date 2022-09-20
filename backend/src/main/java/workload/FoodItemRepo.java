package workload;

import models.FoodItem;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FoodItemRepo extends Repository<FoodItem, Long> {
}
