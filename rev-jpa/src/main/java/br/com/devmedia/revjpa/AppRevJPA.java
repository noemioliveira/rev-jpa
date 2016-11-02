package br.com.devmedia.revjpa;

import java.util.Arrays;
import java.util.List;

import br.com.devmedia.revjpa.dao.AddressDAO;
import br.com.devmedia.revjpa.dao.DocumentDAO;
import br.com.devmedia.revjpa.dao.PersonDAO;
import br.com.devmedia.revjpa.dao.PhoneDAO;
import br.com.devmedia.revjpa.entity.Address;
import br.com.devmedia.revjpa.entity.Address.TypeAddress;
import br.com.devmedia.revjpa.entity.Document;
import br.com.devmedia.revjpa.entity.Person;
import br.com.devmedia.revjpa.entity.Phone;
import br.com.devmedia.revjpa.entity.Phone.TypePhones;

/**
 * Hello world!
 *
 */

public class AppRevJPA 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        insertPerson();
//        findByIdPerson();
//        findAllPersons();
//        countPersons();
//        findByLastName();
//        findByAge();
//        findFullName();
//        update();
//        delet();
      
//        inserDocument();
//        updateDocument();
//        findPesonByCpf();
        
//        insertPhone();
//        insertPhoneByPerson();
//        updatePhone();
//         upadatePhoneByPerson();
//         deleteOnCasccade();
        
//        insertAddressByPerson();
        
//        insertPesonByAddress();
//        
        findByCity();
    }
    
    private static void findByCity() {
		// TODO Auto-generated method stub
		List<Address> addresses  =  new AddressDAO().findByCity("Curitiba");
		
		for(Address address:addresses){
			System.out.println(address.toString());
		}
	} 

	private static void insertPesonByAddress() {
	 
    	Person person1 = new PersonDAO().findById(15l);
    	Person person2 = new PersonDAO().findById(14l);
    	
    	Address ad1 = new Address();
		ad1.setCity("Curitiba");
		ad1.setStreet("Rua Joao Negrao");
		ad1.setType(TypeAddress.COMERCIAL);
		ad1.setPersons(Arrays.asList(person1,person2));
		
		AddressDAO dao = new AddressDAO();
		dao.save(ad1);
		
		System.out.println(new AddressDAO().findById(ad1.getId()));
		
	}

	private static void insertAddressByPerson() {
		Address ad1 = new Address();
		ad1.setCity("Curitiba");
		ad1.setStreet("Rua Cadido Lopes");
		ad1.setType(TypeAddress.RESIDENCIAL);
		
		Address ad2 = new Address();
		ad2.setCity("Sao Jose dos Pinhais");
		ad2.setStreet("Rua da PAZ");
		ad2.setType(TypeAddress.COMERCIAL);
		
		Person person = new Person();
		person.setFirstName("Fabio");
		person.setLastName("dos  Santos Nakamura");
		person.setAge(47);
		person.setDocument(new Document("598.365.789-98",5992458));
		person.addPhone(new Phone(TypePhones.RESISDENCIA, "3568-9825"));
		person.addPhone(new Phone(TypePhones.CELULAR, "9333-9825"));
		
		person.setAddress(Arrays.asList(ad1,ad2));
		
		new PersonDAO().save(person);
		System.out.println(new PersonDAO().findById(person.getId()));
		
	}

	private static void deleteOnCasccade() {
    	//Cascade All  deleta, atualiza e cadastra  em cascata todos as objetos do relacionamento
//		new PersonDAO().delete(10l);
//    	new PhoneDAO().delete(5l);
    		
//    	cascade Merge e Persist  atualiza todos
//    	new PhoneDAO().delete(7l);
    	
    	PhoneDAO dao = new PhoneDAO();
    	Phone phone = dao.findById(7l);
    	System.out.println(phone.toString());
    	
    	phone.getPerson().delPhone(phone);
    	dao.delete(phone);
		
	}

	private static void upadatePhoneByPerson() {
    	Person  person = new PersonDAO().findById(13l);
    	
    	for(Phone phone: person.getPhones()){
    		System.out.println("1 Phone"+phone.toString());
    		
    		if(TypePhones.COMERCIAL == phone.getType()){
    			phone.setType(TypePhones.RESISDENCIA);
    		}
    	}
    	
    	new PersonDAO().update(person);
    	for(Phone phone: person.getPhones()){
    		System.out.println("2 Phone"+phone.toString());
    	}
	}

	private static void updatePhone() {
		// TODO Auto-generated method stub
		Person  person = new PersonDAO().findById(3l);
		PhoneDAO  dao = new PhoneDAO();
		Phone phone =  dao.findById(4l);
//	    Phone ph = new PhoneDAO().findById(3l);	
		
		phone.setPerson(person);
		dao.update(phone);
		
		dao.findById(phone.getId());
		System.out.println(phone.toString());
	}

	private static void insertPhoneByPerson() {
		// TODO Auto-generated method stub
    	
    	Phone phone1 = new Phone( TypePhones.CELULAR,"99589-5131");
    	Phone phone2 = new Phone( TypePhones.COMERCIAL,"3015-2777");
    	Person p1 = new Person();
		p1.setFirstName("Leandro");
		p1.setLastName(" Braz Cubass");
		p1.setAge(37);
        p1.setDocument(new Document("333.011.222-21",92494653));
        
//        phone1.setPerson(p1);
//        phone2.setPerson(p1);
//        p1.setPhones(Arrays.asList(phone1,phone2));
        p1.addPhone(phone1);
        p1.addPhone(phone2);
        
        new PersonDAO().save(p1);
		
	}

	private static void insertPhone() {
		Person p1 = new Person();
		p1.setFirstName("Guilherme");
		p1.setLastName("Neves");
		p1.setAge(32);
        p1.setDocument(new Document("505.890.500-21",87754587));
		
        Phone phone = new Phone( TypePhones.CELULAR,"9132-2277");
        phone.setPerson(p1);
        
        PhoneDAO dao = new PhoneDAO();
        dao.save(phone);
        
        phone = dao.findById(phone.getId());
        
        System.out.println(phone.toString());
        	
	}

	private static void findPesonByCpf() {
		// TODO Auto-generated method stub
		Person p = new PersonDAO().findByCpf("123.456.789-10");
		System.out.println(p.toString());
	}

	private static void updateDocument() {
		// TODO Auto-generated method stub
    	//Polimorfismo
		Document doc = new DocumentDAO().findById(1l);
		System.out.println(doc.toString());
		
		doc.setCpf("123.456.789-10");
		
		new DocumentDAO().update(doc);
		
		System.out.println(doc.toString());
		
	}

	private static void inserDocument() {
		// TODO Auto-generated method stub
         
    	Person p1 = new Person();
    	p1.setFirstName("Aline");
    	p1.setLastName("Santos");
    	p1.setAge(21);
    	p1.setDocument(new Document("525.265.999-99", 95958952));
    	
    	new PersonDAO().save(p1);
    	
    	System.out.println(p1.toString());  
    	
    	
		
	}

	private static void delet() {
		// TODO Auto-generated method stub
//		Person p1 = new PersonDAO().findById(8l);
//		System.out.println(p1.toString());
    	new PersonDAO().delete(10l);
		
	}

	private static void update() {
		
    	Person p1 =  new PersonDAO().findById(7l);
    	System.out.println(p1.toString());
    	
    	p1.setAge(40);
    	
    	new PersonDAO().update(p1);
    	
    	Person p2 =  new PersonDAO().findById(7l);
    	
    	System.out.println(p2.toString());
		
	}

	private static void findFullName() {
		// TODO Auto-generated method stub
		Person person = new PersonDAO().findFullName("Julia Eduarda", "Sobanski");
		
			System.out.println(person.toString());
		
	}

	private static void findByAge() {
		// TODO Auto-generated method stub
		List<Person> persons = new PersonDAO().findByAgeBetween(1, 30);
		for(Person person : persons){
			System.out.println(person.toString());
		}
	}

	private static void findByLastName() {
		// TODO Auto-generated method stub
		List<Person> persons = new PersonDAO().finByLastName("Oliveira");
		
		for(Person p :persons){
			System.out.println(""+ persons.toString() );
		}
	}

	private static void countPersons() {
		// TODO Auto-generated method stub
		Long  total = new PersonDAO().count(); 
		System.out.println("Total de Pessoas: "+ total);
	}

	private static void findAllPersons() {
		// TODO Auto-generated method stub
		List<Person> listaPersons = new PersonDAO().findAll();
		
		for(Person p : listaPersons){
			System.out.println(p.toString());
		}
	}

	private static void findByIdPerson() {
		// TODO Auto-generated method stub
    	//Polimorfismo
    	Person p1 = new PersonDAO().findById(2l);
    	Person p2 = new PersonDAO().findById(1l);
    	
        System.out.println(p1.toString());
        System.out.println(p2.toString());
		
	}

	public static void insertPerson(){
    	Person p1 = new Person();
    	
    	p1.setFirstName("Fernando");
    	p1.setLastName("Fernades");
    	p1.setAge(43);
    	new PersonDAO().save(p1);
    	System.out.println(p1.toString());
    	
    	Person p2 = new Person();
    	p2.setFirstName("Carlos Atonio");
    	p2.setLastName("da Silva");
    	p2.setAge(57);
    	new PersonDAO().save(p2);
    	System.out.println(p2.toString());
//    	
    	Person p3 = new Person();
    	p3.setFirstName("Nivea Maria");
    	p3.setLastName("de Oliveira Manuel");
    	p3.setAge(39);
    	new PersonDAO().save(p3);
    	System.out.println(p3.toString());
    	
    	Person p4 = new Person();
    	p4.setFirstName("Eluama");
    	p4.setLastName("Venancio Mello");
    	p4.setAge(55);
    	new PersonDAO().save(p4);
    	System.out.println(p4.toString());
    }
}
