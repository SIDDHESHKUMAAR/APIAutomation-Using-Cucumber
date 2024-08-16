package resources;

public enum APIResources {
AddPlaceApi("/maps/api/place/add/json"),
GetPlaceApi("/maps/api/place/get/json"),
DeletePlaceApit("/maps/api/place/delete/json");
	private String resource;
	
	APIResources(String Resources){
		this.resource=Resources;
		
		
	}
	public String getResource() {
		return resource;
		
	}
}
