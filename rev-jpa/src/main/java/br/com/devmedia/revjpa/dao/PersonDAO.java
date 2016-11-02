package br.com.devmedia.revjpa.dao;

import java.util.List;

import br.com.devmedia.revjpa.entity.Person;

public class PersonDAO  extends GenericDAO<Person>{

	public PersonDAO(){
		super(Person.class);
	}
	
	public List<Person> finByLastName(String  lastaName){
		
		String jpql= "from Person p where p.lastName Like ?";
		return find(jpql, lastaName);
	}
	
	public List<Person> findByAgeBetween(int min, int max){
		String jpql ="from Person p where p.age between ? and ? ";
		
		return find(jpql,min,max);
	}
	
	public Person findFullName(String firstName, String LastName){
		String jpql= "from Person p where p.firstName like? and p.lastName Like ?  ";
		return findOne(jpql, firstName ,LastName);
	}
	
	public Person findByCpf(String cpf){
		
		String jpql ="  select p from Person p, Document d where d.cpf like ? "
				+ "and p.document.id = d.id";
		return  findOne(jpql, cpf);
	}
}
