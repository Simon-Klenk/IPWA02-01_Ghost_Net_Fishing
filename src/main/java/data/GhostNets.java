package data;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import objects.GhostNet;
import objects.RecoveringPerson;
import objects.ReportingPerson;
import objects.Status;

/**
 * Bean Annotation.
 */
@Named
@ApplicationScoped
public class GhostNets implements Serializable {

  private static final long serialVersionUID = 1L;
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
  private String recoveryRegistered;
  private String saved;
  EntityManager em;

  public GhostNets() {
    this.setRecoveryRegistered(Status.RECOVERY_REGISTERED);
    this.setSaved(Status.SAVED);
  }

  /**
   * generiert aus den Eingabefelder der Webseite ein neues Geisternetz und eine
   * neue Meldende Person.
   *
   */
  public void createNewGhostNet(Double latitude, Double longitude, Double size, String status,
      String name, String firstName, String phoneNumber) {
    ReportingPerson reportingPerson = new ReportingPerson(name, firstName, phoneNumber);
    GhostNet ghostNet = new GhostNet(latitude, longitude, size, status, reportingPerson);
    reportingPerson.getGhostNet().add(ghostNet);

    try {
      em = emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(reportingPerson);
      em.persist(ghostNet);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
    } finally {
      em.close();
    }
  }

  /**
   * Gibt eine Liste aller GhostNet aus der Datenbank zurück.
   *
   * @return Liste aller GhostNet
   *
   */
  @SuppressWarnings("unchecked")
  public List<GhostNet> getGhostNets() {
    em = emf.createEntityManager();
    Query q = em.createQuery("select a from GhostNet a");
    List<GhostNet> ghostNets = q.getResultList();
    return ghostNets;
  }

  /**
   * updatet den Status des GhostNet in der Datenbank.
   *
   */
  public void updateStatusRecoveryRegistered(GhostNet ghostNet, String name, String firstName,
      String phoneNumber) {
    RecoveringPerson recoveringPerson = new RecoveringPerson(name, firstName, phoneNumber);
    ghostNet.setStatus(Status.RECOVERY_REGISTERED);
    ghostNet.setRecoveringPerson(recoveringPerson);

    try {
      em = emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(recoveringPerson);
      em.merge(ghostNet);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
    } finally {
      em.close();
    }

    recoveringPerson.getGhostNet().add(ghostNet);
    try {
      em = emf.createEntityManager();
      em.getTransaction().begin();
      em.merge(recoveringPerson);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
    } finally {
      em.close();
    }
  }

  /**
   * updatet den Status des GhostNet in der Datenbank.
   *
   */
  public void updateStatusSaved(GhostNet ghostNet) {
    ghostNet.setStatus(Status.SAVED);

    try {
      em = emf.createEntityManager();
      em.getTransaction().begin();
      em.merge(ghostNet);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
    } finally {
      em.close();
    }
  }

  public String getSaved() {
    return saved;
  }

  public void setSaved(String saved) {
    this.saved = saved;
  }

  public String getRecoveryRegistered() {
    return recoveryRegistered;
  }

  public void setRecoveryRegistered(String recoveryRegistered) {
    this.recoveryRegistered = recoveryRegistered;
  }

}