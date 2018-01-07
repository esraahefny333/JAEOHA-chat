/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseclasses;

import java.io.Serializable;
import javafx.scene.image.Image;
/**
 *
 * @author omnia
 */
public class User implements Serializable{
    
    private Integer id;
//    private String firstName;
//    private String lastName;
    private String userName;
    private String email;
    private String phone;
    private String country;
    private String gender;
    private Image photo;
    private String password;
    private String status;
    private Integer active;
    
    public User()
    { 
    }

    public User(Integer id, String userName, String email, String phone, String country, String gender, Image photo, String password, String status, Integer active) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.gender = gender;
        this.photo = photo;
        this.password = password;
        this.status = status;
        this.active = active;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the photo
     */
    public Image getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the active
     */
    public Integer getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Integer active) {
        this.active = active;
    }
    
    
    
   


}