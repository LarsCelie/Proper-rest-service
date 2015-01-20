package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InvalidPropertiesFormatException;

import javax.xml.bind.annotation.XmlRootElement;

import Controller.Generator;

@XmlRootElement
public class Template {
	private String name;
	private String code;
	
	public Template(){}
	
	public Template(String name) {
		this.name = name;
		try {
			generateCode();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	public void generateCode() throws InvalidPropertiesFormatException, IOException, SQLException{
		code = new Generator().generate(name);
	}
}