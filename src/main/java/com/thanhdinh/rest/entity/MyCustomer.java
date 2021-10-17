package com.thanhdinh.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity//anh xa bang trong CSDL
@Table(name = "mycustomer")
@XmlRootElement(name="customers")
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // very imp
public class MyCustomer {

	@Id //key chinh
	//@GeneratedValue //tu dong tang
	@Column
	//su dung khi ten colum trong DB khac voi colum trong class nay
	private long id;

	@Column
	private String name;

	@Column
	private int age;

	@Column
	private int phone;
	
	@Column
	private int code;

	@Column
	private String email;
	
	@Column
	private String gender;

	@Column
	private String city;

	// setters and getters
	//truyen va lay du lieu
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	// constructor with fields
	//ham tao co tham so
	public MyCustomer(long id, String name, String gender ,int age, String city,String email , int phone,int code) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.code = code;

	}

	// constructor without fields
	// ham tao khong tham so
	public MyCustomer() {
		super();
	}
//	@Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + (int) (id ^ (id >>> 32));
//        return result;
//    }
// 
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        MyCustomer other = (MyCustomer) obj;
//        if (id != other.id)
//            return false;
//        return true;
//    }
 
	 @Override
	    public String toString() {
	        return "Customer [id=" + id + ", name=" + name + ", gender=" + gender+ ", age=" + age + ", city=" + city+", email=" + email+", phone=" + phone+", code=" + code+"]";
	    }

}
