package workload;

import models.KlimaBox;
import models.Menu;
import models.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;


@ApplicationScoped
public class KlimaboxService extends Repository<KlimaBox, Long> {

    public KlimaBox getKlimaBoxById(Long id) {
        return findById(id);
    }

    public KlimaBox updateKlimabox(Long id, Integer quantity) {
        KlimaBox box = getKlimaBoxById(id);
        box.setQuantity(quantity);
        return updateET(box);
    }
}