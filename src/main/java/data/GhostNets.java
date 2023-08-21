package data;

import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
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

@Named
@ApplicationScoped
public class GhostNets implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit");
	private String recoveryGegistered;
	private String saved;
	EntityManager em;
  	
	public GhostNets() {
		this.setRecoveryGegistered(Status.RECOVERY_REGISTERED);
		this.setSaved(Status.SAVED);
	}
	
	public void createNewGhostNet(double latitude, double longitude, double size, String status, String name, String firstName, int phoneNumber) {
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
	
    @SuppressWarnings("unchecked")
	public List<GhostNet> getGhostNets() {
    	em = emf.createEntityManager();
    	Query q = em.createQuery("select a from GhostNet a");
		List<GhostNet> ghostNets = q.getResultList();
        return ghostNets;
    }
    
    public void updateStatusRecoveryRegistered(GhostNet ghostNet, String name, String firstName, int phoneNumber) {
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

	public String getRecoveryGegistered() {
		return recoveryGegistered;
	}

	public void setRecoveryGegistered(String recoveryGegistered) {
		this.recoveryGegistered = recoveryGegistered;
	}

	public String getSaved() {
		return saved;
	}

	public void setSaved(String saved) {
		this.saved = saved;
	}
    
}