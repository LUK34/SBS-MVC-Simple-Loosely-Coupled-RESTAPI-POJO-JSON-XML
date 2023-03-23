package kw.kng.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kw.kng.app.binders.Student;

@RestController
public class StudentRestController 
{
	/* POSTMAN -> GET method
	 	http:localhost:8080/home
	 */	
	@GetMapping(
			value="/home",
			produces= {"application/xml","application/json"}
	)
	public Student getStudentData()
	{
		Student s= new Student();
		s.setName("admin");
		s.setEmail("admin@gmail.com");
		s.setGender("Male");
		return s;
	}

	@PostMapping(
				value="/home",
				consumes= {"application/xml","application/json"},
				produces= {"text/plain"}
	)
	public ResponseEntity<String> addStudentDetails(@RequestBody Student student)
	{
		System.out.println(student);
		return new ResponseEntity<>("Customer Saved", HttpStatus.CREATED);
	}
}

/* ----------------------------------------- READ ME --------------------------------------------------------
  Run as SpringBootApplication
  
1. GET XML data
1.1 Select option as "GET" in POSTMAN
1.2 Type URL: localhost:8080/home
1.3 Select Headers
1.4 Key->Accept, Value->application/xml
1.5 Press "Send"

OUTPUT:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<student>
    <email>admin@gmail.com</email>
    <gender>Male</gender>
    <name>admin</name>
</student>


2. GET JSON
2.1 Select option as "GET" in POSTMAN
2.2 Type URL: localhost:8080/home
2.3 Select Headers
2.4 Key->Accept, Value->application/json
2.5 Press "Send"
OUTPUT:
{
    "email": "admin@gmail.com",
    "name": "admin",
    "gender": "Male"
}

3. POST XML
3.1 Select option as "POST" in POSTMAN
3.2 Type URL: localhost:8080/home
3.3 Select Headers
3.4 Key->Content-Type, Value->application/xml
3.5 Select Body and paste the below code, select XML as dropdown option
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<student>
    <email>admin@gmail.com</email>
    <gender>Male</gender>
    <name>admin</name>
</student>
3.6 Press "Send"

OUTPUT:
Student(email=admin@gmail.com, name=admin, gender=Male)

4. POST XML
4.1 Select option as "POST" in POSTMAN
4.2 Type URL: localhost:8080/home
4.3 Select Headers
4.4 Key->Content-Type, Value->application/json
4.5 Select Body and paste the below code, select JSON as dropdown option
{
    "email": "admin@gmail.com",
    "name": "admin",
    "gender": "Male"
}
4.6 Press "Send"

OUTPUT:
Student(email=admin@gmail.com, name=admin, gender=Male)
 */






