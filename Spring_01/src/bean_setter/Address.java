package bean_setter;

public class Address {
	private String city;
	private String tel;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", tel=" + tel + "]";
	}
	
} 
