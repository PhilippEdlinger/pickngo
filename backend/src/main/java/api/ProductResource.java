package api;

import io.smallrye.mutiny.Uni;
import models.DrinkItem;
import models.FoodItem;
import models.KlimaBox;
import workload.DrinkItemRepo;
import workload.FoodItemRepo;
import workload.KlimaboxService;
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
    @Inject
    KlimaboxService klimaboxService;

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
    @Path("search/{w}")
    public Response searchProduct(@PathParam("w") String searchWord) {
        return Response.ok(productService.search(searchWord)).build();
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

    @PUT
    @Path("klimaBox/update/{id}")
    public Response updateKlimabox(@PathParam("id") Long id, Integer quantity) {
        return Response.ok(klimaboxService.updateKlimabox(id, quantity)).build();
    }

    @GET
    @Path("klimaBox/{id}")
    public Response getKlimaboxById(@PathParam("id") Long id) {
        return Response.ok(klimaboxService.getKlimaBoxById(id)).build();
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
