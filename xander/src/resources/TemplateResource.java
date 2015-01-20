package resources;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import model.Template;
import service.TemplateService;
import dao.TemplateDao;


public class TemplateResource {
  @Context
  UriInfo uriInfo;
  @Context
  Request request;
  String businessRule;
  TemplateService templateService = new TemplateService();

  public TemplateResource(UriInfo uriInfo, Request request, String rule) {
    this.uriInfo = uriInfo;
    this.request = request;
    this.businessRule = rule;
  }
  
  //Application integration     
  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Template getTemplate() {
    Template template = TemplateDao.instance.getModel().get(businessRule);
    if(template==null)
      throw new RuntimeException("Get: Template with " + businessRule +  " not found");
    return template;
  }
  
  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Template getTemplateHTML() {
    Template template = TemplateDao.instance.getModel().get(businessRule);
    if(template==null)
      throw new RuntimeException("Get: Template with " + businessRule +  " not found");
    return template;
  }
  

  // Defines that the next path parameter after todos is
  // treated as a parameter and passed to the TodoResources
  // Allows to type http://localhost:8080/de.vogella.jersey.todo/rest/todos/1
  // 1 will be treaded as parameter todo and passed to TodoResource
  @Path("{template}")
  @GET
  public Template getTemplate(@PathParam("template") String id) {
	  return templateService.getTemplate(id);
  }
  
  @PUT
  public Template executeTemplate(Template template) {
	  return templateService.execute(template);
  }
}