package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	
	public AddPlace addPlacePayload(String Name,String Language,String Address) {
		 AddPlace p=new AddPlace();	
			p.setAccuracy(50);
			p.setAddress(Address);
			p.setLanguage(Language);
			p.setName(Name);
			p.setPhone_number("1234567");
			p.setWebsite("SID@gmail");
			List<String> myList =new ArrayList<String>();
			myList.add("shoe park");
			myList.add("shop");
			p.setTypes(myList);
			Location l= new Location();	
			l.setLat(12.123455);
			l.setLng(-12.12345);
			p.setLocation(l);
			return p;
		
	}
	public  String DeleteAPi(String placeid) {
		return "{\r\n"
				+ "\r\n"
				+ "    \"place_id\":\""+placeid+"\"\r\n"
				+ "}";
	}

}
