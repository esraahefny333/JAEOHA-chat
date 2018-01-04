/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseclasses;

/**
 *
 * @author abanoub samy
 */
public class notifications {
    
    private int notifId;
    private String notifText;

    public notifications(int notifId, String notifText) {
        this.notifId = notifId;
        this.notifText = notifText;
    }

    /**
     * @return the notifId
     */
    public int getNotifId() {
        return notifId;
    }

    /**
     * @param notifId the notifId to set
     */
    public void setNotifId(int notifId) {
        this.notifId = notifId;
    }

    /**
     * @return the notifText
     */
    public String getNotifText() {
        return notifText;
    }

    /**
     * @param notifText the notifText to set
     */
    public void setNotifText(String notifText) {
        this.notifText = notifText;
    }
    
    
    
}
