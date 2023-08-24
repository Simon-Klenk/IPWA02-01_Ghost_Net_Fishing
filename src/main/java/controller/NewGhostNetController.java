package controller;

import data.GhostNets;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import objects.Status;

/**
 * Bean Annotation.
 */
@Named
@ViewScoped
public class NewGhostNetController implements Serializable {

  private static final long serialVersionUID = 1L;
  private Double latitude;
  private Double longitude;
  private Double size;
  private String name;
  private String firstName;
  private String phoneNumber;
  @Inject
  GhostNets ghostNets;

  /**
   * generiert aus den Eingabefelder der Webseite ein neues Geisternetz und eine
   * neue Meldende Person.
   *
   * @return Startseite
   */
  public String createNewGhostNet() {
    ghostNets.createNewGhostNet(latitude, longitude, size, Status.REPORTED, name, firstName,
        phoneNumber);
    return Pages.INDEX;
  }

  public String cancel() {
    return Pages.INDEX;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
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

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}
