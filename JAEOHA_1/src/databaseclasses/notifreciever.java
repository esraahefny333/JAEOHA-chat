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
public class notifreciever {
    
    private Integer notifId;
    private Integer recieverId;

    public notifreciever() {
    }

    
    
    
    public notifreciever(Integer notifId, Integer recieverId) {
        this.notifId = notifId;
        this.recieverId = recieverId;
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
     * @return the recieverId
     */
    public Integer getRecieverId() {
        return recieverId;
    }

    /**
     * @param recieverId the recieverId to set
     */
    public void setRecieverId(Integer recieverId) {
        this.recieverId = recieverId;
    }

  
}