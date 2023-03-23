package kw.kng.app.binders;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class Student 
{
	private String email;
	private String name;
	private String gender;
	
}
