package vo;

public class Person {
	private String name;
	private int age;
	private String phone;
	
	//빈 설정파일로 객체 생성하기 위하여 default 생성자를 public으로 설정 
	public Person() { 
		//객체 생성 시점을 확인하기 위한 코드 
		System.out.println("person 생성");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", phone=" + phone + "]";
	} 
	
	
}
