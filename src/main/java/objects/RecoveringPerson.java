package objects;

import javax.persistence.Entity;

@Entity
public class RecoveringPerson extends Person {
	
	public RecoveringPerson() {
		
	}

	public RecoveringPerson(String name, String lastName, int phoneNumber) {
		super(name, lastName, phoneNumber);
	}

}