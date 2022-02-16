package api;

import models.Category;
import models.Product;
import workload.CategoryRepository;
import workload.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {


    @Inject
    ProductRepository productRepository;

    @GET
    public Response getProducts() {
        return Response.accepted(productRepository.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getProductById(@PathParam("id") Long productId){
        if (productId != null){
            return Response
                    .accepted(productRepository.findById(productId))
                    .build();
        }else {
            return Response
                    .accepted(productRepository.findAll())
                    .build();
        }

    }

    @PUT
    public Response createProduct(Product product){
        return Response
                .accepted(productRepository.updateET(product))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProductById(@PathParam("id") Long productId ){
        return Response.accepted(productRepository.deleteById(productId)).build();
    }


}
