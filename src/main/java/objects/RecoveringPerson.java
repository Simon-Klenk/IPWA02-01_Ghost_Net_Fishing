package objects;

import javax.persistence.Entity;

@Entity
public class RecoveringPerson extends Person {
	
	public RecoveringPerson() {
		
	}

	public RecoveringPerson(String name, String lastName, String phoneNumber) {
		super(name, lastName, phoneNumber);
	}

}