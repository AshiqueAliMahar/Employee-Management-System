package Beans;


public class EmployeeBean {
	
	private int empId;
	private String name;
	private String email;
	private String phone;
	byte [] pic;
	public EmployeeBean(int empId, String name, String email, String phone,byte [] pic) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.pic=pic;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	
	
}
