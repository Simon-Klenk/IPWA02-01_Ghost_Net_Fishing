package objects;

import javax.persistence.Entity;

@Entity
public class ReportingPerson extends Person {
	
	public ReportingPerson() {
		
	}

	public ReportingPerson(String name, String firstName, int phoneNumber) {
		super(name, firstName, phoneNumber);
	}

}