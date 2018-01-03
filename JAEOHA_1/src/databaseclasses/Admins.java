/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseclasses;

/**
 *
 * @author omnia
 */
public class Admins {
    
   private Integer adminId;
   private String fname;
   private String lname;
   private String email;
   private String password;

   public Admins()
   {}
   public Admins(Integer adminId,String fname,String lname,String email,String passsword)
   {
      this.adminId=adminId;
      this.fname=fname;
      this.lname=lname;
      this.email=email;
      this.password=passsword;
   }
   
   public Admins(String fname,String lname,String email,String passsword)
   {
      this.fname=fname;
      this.lname=lname;
      this.email=email;
      this.password=passsword;
   }
   
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}