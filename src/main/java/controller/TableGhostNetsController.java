package controller;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import objects.GhostNet;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import data.GhostNets;

@Named
@ViewScoped
public class TableGhostNetsController implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    GhostNets ghostNets;
    @Inject
    RecoveringPersonController recoveringPersonController;

    
    public void recoveryRegistered(GhostNet ghostNet) {
    	ghostNets.updateStatusRecoveryRegistered(ghostNet, recoveringPersonController.getFirstName(), recoveringPersonController.getFirstName(), recoveringPersonController.getPhoneNumber());
    }
    
    public void saved(GhostNet ghostNet) {
    	ghostNets.updateStatusSaved(ghostNet);
    }    
    
    public String getStatus(GhostNet ghostNet) {
    	return ghostNet.getStatus();
    }

}
