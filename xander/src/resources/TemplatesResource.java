package resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import service.TemplateService;
import model.Template;


// Will map the resource to the URL todos
@Path("/templates")
public class TemplatesResource {

  // Allows to insert contextual objects into the class,
  // e.g. ServletContext, Request, Response, UriInfo
  @Context
  UriInfo uriInfo;
  @Context
  Request request;
  
  TemplateService templateService = new TemplateService();

  // Return the list of todos to the user in the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public List<Template> getTemplatesBrowser() {
    List<Template> template = new ArrayList<Template>();
    template.addAll(TemplateDao.instance.getModel().values());
    return template;
  }

  // Return the list of todos for applications
  @GET
  @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  public List<Template> getTemplates() {
    List<Template> template = new ArrayList<Template>();
    template.addAll(TemplateDao.instance.getModel().values());
    return template;
  }

  // retuns the number of todos
  // Use http://localhost:8080/de.vogella.jersey.todo/rest/todos/count
  // to get the total number of records
  @GET
  @Path("count")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCount() {
    int count = TemplateDao.instance.getModel().size();
    return String.valueOf(count);
  }


} 