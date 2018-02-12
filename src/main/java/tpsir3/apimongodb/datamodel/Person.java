package tpsir3.apimongodb.datamodel;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public class Person {
	@Id
	private ObjectId id;
	private String name;
	private List<Address> adresses = new ArrayList<Address>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAdresses() {
		return adresses;
	}

	public void setAdress(Address address) {
		adresses.add(address);
	}
}
