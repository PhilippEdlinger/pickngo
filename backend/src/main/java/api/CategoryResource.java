package api;

import models.Category;
import workload.CategoryRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {


    @Inject
    CategoryRepository categoryRepository;

    @GET
    public Response getCategories() {
        return Response.accepted(categoryRepository.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getCategoryById(@PathParam("id") Long categoryId){
        return Response
                .accepted(categoryRepository.findById(categoryId))
                .build();
}

    @PUT
    public Response createCategory(Category category){
        return Response
                .accepted(categoryRepository.updateET(category))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCategoryById(@PathParam("id") Long categoryId ){
        return Response.accepted(categoryRepository.deleteById(categoryId)).build();
    }


}
