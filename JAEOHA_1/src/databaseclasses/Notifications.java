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
public class Notifications {
    
    private Integer notifId;
    private String notifText;

    public Notifications() {
    }

    
    
    
    
    public Notifications(Integer notifId, String notifText) {
        this.notifId = notifId;
        this.notifText = notifText;
    }

    /**
     * @return the notifId
     */
    public Integer getNotifId() {
        return notifId;
    }

    /**
     * @param notifId the notifId to set
     */
    public void setNotifId(Integer notifId) {
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