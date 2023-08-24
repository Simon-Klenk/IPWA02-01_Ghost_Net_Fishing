package objects;

import javax.persistence.Entity;

/**
 * Bean Annotation.
 */
@Entity
public class RecoveringPerson extends Person {

  public RecoveringPerson() {

  }

  public RecoveringPerson(String name, String firstName, String phoneNumber) {
    super(name, firstName, phoneNumber);
  }

}