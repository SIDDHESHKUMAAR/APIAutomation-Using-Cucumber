package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	static RequestSpecification req;
public RequestSpecification RequestSpecifications() throws IOException  {
	if(req==null) {
	PrintStream Stream=new PrintStream(new FileOutputStream("logging.text"));	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	 req=new RequestSpecBuilder().setBaseUri(GetProperties("baseUri")).addQueryParam("key","qaclick123")
			 .addFilter(RequestLoggingFilter.logRequestTo(Stream)).addFilter(ResponseLoggingFilter.logResponseTo(Stream))
			 .setContentType(ContentType.JSON).build();
	 
		
	return req;}
	return req;
}
public static String GetProperties(String Key) throws IOException {
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\ssasikumar\\eclipse-workspace\\NG_API_CUCUMBER_FRAMEWORK\\src\\test\\java\\resources\\Properties.properties");
	prop.load(fis);
	
	return prop.getProperty(Key);
}
public static String getJSONPath(Response res,String Key) {
	String responsed=res.asString();
	JsonPath js=new JsonPath(responsed);
	js.get(Key);
	return js.get(Key).toString();
}
}
	