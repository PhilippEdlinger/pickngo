package workload;

import models.DrinkItem;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DrinkItemRepo extends Repository<DrinkItem, Long> {
}
