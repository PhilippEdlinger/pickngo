package api;

import io.smallrye.mutiny.Uni;
import models.DrinkItem;
import models.FoodItem;
import workload.DrinkItemRepo;
import workload.FoodItemRepo;
import workload.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {


    @Inject
    ProductService productService;
    @Inject
    FoodItemRepo foodItemRepo;
    @Inject
    DrinkItemRepo drinkItemRepo;

    @GET
    public Response getProducts() {
        return Response.ok(productService.findAll().list()).build();
    }

    @GET
    @Path("{id}")
    public Response getProductById(@PathParam("id") Long productId) {
        return Response
                .ok(productService.findById(productId))
                .build();
    }

    @GET
    @Path("drinks")
    public Response getDrinks() {
        return Response.ok(drinkItemRepo.findAll().list()).build();
    }

    @GET
    @Path("foods")
    public Response getFoods() {
        return Response.ok(foodItemRepo.findAll().list()).build();
    }

    @GET
    @Path("vorspeise")
    public Response getVorspeise() {
        return Response.ok(productService.getVorspeise()).build();
    }

    @GET
    @Path("hauptspeise")
    public Response getHauptspeise() {
        return Response.ok(productService.getHauptspeise()).build();
    }

    @GET
    @Path("klimaBox")
    public Response getKlimaBox() {
        return Response.ok(productService.getKlimaBox()).build();
    }

    @GET
    @Path("desert")
    public Response getDesert() {
        return Response.ok(productService.getDesert()).build();
    }

    @GET
    @Path("aperitif")
    public Response getAperitif() {
        return Response.ok(productService.getAperitif()).build();
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

    @GET
    @Path("/img/{fileName}")
    @Produces("image/jpeg")
    public Uni<Response> getFile(@PathParam("fileName") String fileName) {
        File nf = new File(this.getClass().getClassLoader().getResource("/imgs/products/" + fileName).getFile());
        Response.ResponseBuilder response = Response.ok((Object) nf);
        response.header("Content-Disposition", "attachment;filename=" + nf);
        Uni<Response> re = Uni.createFrom().item(response.build());
        return re;
    }
}
