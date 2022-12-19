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

    public KlimaBox updateKlimabox(Long id) {
        KlimaBox box = getKlimaBoxById(id);
        if (box.getQuantity() > 0) {
            box.setQuantity(box.getQuantity() - 1);
            box = updateET(box);
        }

        return box;
    }
}