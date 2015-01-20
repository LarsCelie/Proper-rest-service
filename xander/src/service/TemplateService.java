package service;

import java.util.Collection;

import model.Template;

public class TemplateService {
	public Template getTemplate(String businessRule) {
		Template template = new Template(businessRule); //TemplateDao.instance.getModel().get(businessRule);
	    //if(template==null)
	      //throw new RuntimeException("Get: Template with " + businessRule +  " not found");
	    return template;
	}
	
	public Collection<Template> getTemplates() {
		return null;
	}

	public Template execute(Template template) {
		// TODO Auto-generated method stub
		return null;
	}

}
