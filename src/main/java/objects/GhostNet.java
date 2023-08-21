package objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GhostNet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double latitude;
	private double longitude;
	private double size;
	private String status;
	@ManyToOne
	ReportingPerson reportingPerson;
	@ManyToOne
	RecoveringPerson recoveringPerson;
	
	public GhostNet() {
		
	}
	
	public GhostNet(double latitude, double longitude, double size, String status, ReportingPerson reportingPerson) {
		this.setLatitude(latitude);
		this.setLongitude(longitude);
		this.setSize(size);
		this.setStatus(status);
		this.setReportingPerson(reportingPerson);
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ReportingPerson getReportingPerson() {
		return reportingPerson;
	}

	public void setReportingPerson(ReportingPerson reportingPerson) {
		this.reportingPerson = reportingPerson;
	}

	public RecoveringPerson getRecoveringPerson() {
		return recoveringPerson;
	}

	public void setRecoveringPerson(RecoveringPerson recoveringPerson) {
		this.recoveringPerson = recoveringPerson;
	}

}