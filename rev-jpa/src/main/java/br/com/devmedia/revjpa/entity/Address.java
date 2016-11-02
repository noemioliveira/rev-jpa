package br.com.devmedia.revjpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="ADDRESSES")
public class Address implements Serializable{

	public enum TypeAddress{
		COMERCIAL, RESIDENCIAL;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ID_ADDRESS")
	private Long id;
	@Column(name="CITY" , nullable = false)
	private String city;
	@Column(name="STREET" , nullable = false)
	private String  street;
	@Enumerated(EnumType.STRING)
	@Column(name="TYPE_ADDRESS", nullable = false )
	private TypeAddress type;
	//por padrao a JPA coloca FetchType.lAZY quando o rekacinamento  termina com  MANY
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PERSONS_ADDRESS",joinColumns = @JoinColumn(name="ID_ADDRESS"),
	                                 inverseJoinColumns = @JoinColumn(name ="ID_PERSON"))
	private List<Person> persons;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public TypeAddress getType() {
		return type;
	}
	public void setType(TypeAddress type) {
		this.type = type;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((persons == null) ? 0 : persons.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (persons == null) {
			if (other.persons != null)
				return false;
		} else if (!persons.equals(other.persons))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", street=" + street
				+ ", type=" + type + "]";
	}
	

}
