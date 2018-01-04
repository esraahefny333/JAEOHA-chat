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
public class UserFriendRequests {
    private Integer reieverId;
    private Integer senderId;

    public UserFriendRequests() {
    }

    public UserFriendRequests(Integer reieverId, Integer senderId) {
        this.reieverId = reieverId;
        this.senderId = senderId;
    }

    /**
     * @return the reieverId
     */
    public Integer getReieverId() {
        return reieverId;
    }

    /**
     * @param reieverId the reieverId to set
     */
    public void setReieverId(Integer reieverId) {
        this.reieverId = reieverId;
    }

    /**
     * @return the senderId
     */
    public Integer getSenderId() {
        return senderId;
    }

    /**
     * @param senderId the senderId to set
     */
    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }
    
    
}
