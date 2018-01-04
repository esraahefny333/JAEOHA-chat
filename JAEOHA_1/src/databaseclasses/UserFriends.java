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
public class UserFriends {
    private Integer userId;
    private Integer friendId;

    public UserFriends() {
    }

    public UserFriends(Integer userId, Integer friendId) {
        this.userId = userId;
        this.friendId = friendId;
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the friendId
     */
    public Integer getFriendId() {
        return friendId;
    }

    /**
     * @param friendId the friendId to set
     */
    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }
    
    
}
