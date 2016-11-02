package br.com.devmedia.revjpa.dao;

import java.util.List;

import br.com.devmedia.revjpa.entity.Address;

public class AddressDAO extends GenericDAO<Address> {

	public AddressDAO() {
		super(Address.class);
		// TODO Auto-generated constructor stub
	}

	public List<Address> findByCity(String cidade){
		String jpql = "from Address  a  where a.city like ?";
		return find(jpql, cidade);
	}
}
