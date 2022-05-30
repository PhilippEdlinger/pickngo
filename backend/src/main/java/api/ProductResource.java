package api;

import models.DrinkItem;
import models.FoodItem;
import models.Product;
import workload.DrinkItemRepo;
import workload.FoodItemRepo;
import workload.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {


    @Inject
    private ProductRepository productRepository;
    @Inject
    private FoodItemRepo foodItemRepo;
    @Inject
    private DrinkItemRepo drinkItemRepo;

    @GET
    public Response getProducts() {
        return Response.ok(productRepository.findAll().list()).build();
    }

    @GET
    @Path("{id}")
    public Response getProductById(@PathParam("id") Long productId) {
        return Response
                .ok(productRepository.findById(productId))
                .build();
    }

    @POST
    @Path("foodItem")
    public Response persistFoodItem(FoodItem foodItem) {
        foodItemRepo.persistET(foodItem);
        return Response.ok().build();
    }

    @POST
    @Path("drinkItem")
    public Response persistDrinkItem(DrinkItem drinkItem) {
        drinkItemRepo.persistET(drinkItem);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProductById(@PathParam("id") Long productId ){
        return Response.ok(productRepository.deleteById(productId)).build();
    }
}
