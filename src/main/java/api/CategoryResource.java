package api;

import workload.CategoryRepository;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("category")
public class CategoryResource {


    @Inject
    CategoryRepository categoryRepository;

}
