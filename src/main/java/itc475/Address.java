package itc475;


public class Address {
	
	
	private String street;
    private String city;
    private String state;
    private String zipCode;

    
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getters and Setters
    //Street
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    //City
    public String getCity() {
    	return city;
    }
    
    public void setCity(String city) {
    	this.city = city;
    }
    
    //State
    public String getState() {
    	return state;
    }
    
    public void setState(String state) {
    	this.state = state;
    }
    
    //ZipCode 
    public String getZip() {
    	return zipCode;
    }
    
    public void setZip(String zipCode) {
    	this.zipCode = zipCode;
    }
    
    @Override 
    public String toString() {
    	
    	StringBuilder addressBuild = new StringBuilder();
    	addressBuild.append(street).append(", ")
    	.append(city).append(", ")
    	.append(state).append(", ")
    	.append(zipCode);
    	
    	return addressBuild.toString();
    }
    
}
