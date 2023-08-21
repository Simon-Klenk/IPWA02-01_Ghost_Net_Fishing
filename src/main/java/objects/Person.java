package objects;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public abstract class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String firstName;
	private int phoneNumber;
	@OneToMany (targetEntity = GhostNet.class, cascade = CascadeType.ALL)
	private List<GhostNet> ghostNet = new ArrayList<>();
	

	public Person() {
		
	}
	
	public Person(String name, String firstName, int phoneNumber) {
		this.setName(name);
		this.setFirstName(firstName);
		this.setPhoneNumber(phoneNumber);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public List<GhostNet> getGhostNet() {
		return ghostNet;
	}

	public void setGhostNet(List<GhostNet> ghostNet) {
		this.ghostNet = ghostNet;
	}
}
