package api;

import models.CategoryET;
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
    @Path("{id}")
    public Response getCategoryById(@PathParam("id") Long categoryId) {
        System.out.println("--------------->" +  categoryRepository.findAll());
        return Response
                .ok(categoryRepository.findById(categoryId))
                .build();
    }

    @GET
    public Response getCategories() {
        System.out.println("--------------->" +  categoryRepository.findAll().list().get(0).name);
        return Response.ok(categoryRepository.findAll().list()).build();
    }


    @PUT
    public Response createCategory(CategoryET categoryET){
        return Response
                .ok(categoryRepository.updateET(categoryET))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteCategoryById(@PathParam("id") Long categoryId ){
        return Response.ok(categoryRepository.deleteById(categoryId)).build();
    }

}
