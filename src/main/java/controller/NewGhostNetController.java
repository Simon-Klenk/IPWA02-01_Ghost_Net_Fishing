package controller;
import java.io.Serializable;
import data.GhostNets;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import objects.Status;

@Named
@ViewScoped
public class NewGhostNetController implements Serializable {

	private static final long serialVersionUID = 1L;
	private double latitude;
	private double longitude;
	private double size;
	private String name;
	private String firstName;
	private int phoneNumber;	
	@Inject
	GhostNets ghostNets;
	
	
	public String createNewGhostNet() {
		ghostNets.createNewGhostNet(latitude, longitude, size, Status.REPORTED, name, firstName, phoneNumber);
		return Pages.INDEX;
	}
	
	public String cancel() {
		return Pages.INDEX;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
