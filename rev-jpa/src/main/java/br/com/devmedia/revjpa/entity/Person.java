package br.com.devmedia.revjpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(
		name ="persons", indexes = {@Index(columnList ="FIRST_NAME, LAST_NAME", name= "IDx_PersoName",
		unique= true)})
//@Table(name ="persons", uniqueConstraints ={@UniqueConstraint(columnNames ="fist_name, last_name", name="ID_nomeInterio_sem repetir")})
public class Person  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSON")
	private Long id;
	
	@Column(name = "FIRST_NAME", nullable = false, length = 30)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = false, length = 60)
	private String lastName;
	
	@Column(name = "AGE", nullable = false)
	private Integer age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DOCUMENT_ID")
	private Document document;
	
	@OneToMany(mappedBy= "person", cascade =CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Phone> phones;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch =FetchType.EAGER)
	@JoinTable(
			name="PERSONS_ADDRESS",
			joinColumns = @JoinColumn(name="ID_PERSON"),
            inverseJoinColumns = @JoinColumn(name ="ID_ADDRESS"))
	private List<Address> address;
	
	public void addPhone(Phone phone){
		if(phones  == null){
			phones = new ArrayList<Phone>();
		}
		phone.setPerson(this);
		phones.add(phone);
	}
	
	public void delPhone(Phone phone){
		if(phones != null){
			phones.remove(phone);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}	

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result
				+ ((document == null) ? 0 : document.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phones == null) ? 0 : phones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (document == null) {
			if (other.document != null)
				return false;
		} else if (!document.equals(other.document))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phones == null) {
			if (other.phones != null)
				return false;
		} else if (!phones.equals(other.phones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + "]";
	}



}
