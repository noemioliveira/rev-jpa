package br.com.devmedia.revjpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="PHONES")
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum TypePhones{
		RESISDENCIA, CELULAR, COMERCIAL;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PHONE")
	private Long id;
	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE_PHONE", nullable =false)
	private TypePhones type;
	@Column(name="NUBER",  nullable = false)
	private String nuber;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="PESON_ID")
	private Person person;
	
	public Phone(){
		super();
	}
	
	public Phone(TypePhones type, String nuber) {
		this.type = type;
		this.nuber = nuber;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypePhones getType() {
		return type;
	}
	public void setType(TypePhones type) {
		this.type = type;
	}
	public String getNuber() {
		return nuber;
	}
	public void setNuber(String nuber) {
		this.nuber = nuber;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nuber == null) ? 0 : nuber.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		Phone other = (Phone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nuber == null) {
			if (other.nuber != null)
				return false;
		} else if (!nuber.equals(other.nuber))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Phone [id=" + id + ", type=" + type + ", nuber=" + nuber
				+ ", person=" + person + "]";
	}
}
