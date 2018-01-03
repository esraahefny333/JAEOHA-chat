/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseclasses;

import javafx.scene.image.Image;
/**
 *
 * @author omnia
 */
public class Users {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String country;
    private String gender;
    private Image photo;
    private String password;
    private String status;
    private Integer active;
    
    public Users()
    { 
    }
    public Users(Integer id,String firstName,String lastName,String email,String phone,
    String country,String gender,Image photo,String password,String status,Integer active)         
    {
      this.id=id;
      this.firstName=firstName;
      this.lastName=lastName;
      this.email=email;
      this.phone=phone;
      this.country=country;
      this.gender=gender;
      this.photo=photo;
      this.password=password;
      this.status=status;
      this.active=active;
    }
    public Users(String first_name,String last_name,String email,String phone,
    String country,String gender,Image photo,String password,String status,Integer active)         
    {
      this.firstName=firstName;
      this.lastName=lastName;
      this.email=email;
      this.phone=phone;
      this.country=country;
      this.gender=gender;
      this.photo=photo;
      this.password=password;
      this.status=status;
      this.active=active;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}