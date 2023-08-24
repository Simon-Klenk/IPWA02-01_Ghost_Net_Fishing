package controller;

import data.GhostNets;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import objects.GhostNet;

/**
 * Bean Annotation.
 */
@Named
@ViewScoped
public class TableGhostNetsController implements Serializable {

  private static final long serialVersionUID = 1L;
  @Inject
  GhostNets ghostNets;
  @Inject
  RecoveringPersonController recoveringPersonController;

  public void recoveryRegistered(GhostNet ghostNet) {
    ghostNets.updateStatusRecoveryRegistered(ghostNet, recoveringPersonController.getName(),
        recoveringPersonController.getFirstName(), recoveringPersonController.getPhoneNumber());
  }

  public void saved(GhostNet ghostNet) {
    ghostNets.updateStatusSaved(ghostNet);
  }

  public String getStatus(GhostNet ghostNet) {
    return ghostNet.getStatus();
  }

}
