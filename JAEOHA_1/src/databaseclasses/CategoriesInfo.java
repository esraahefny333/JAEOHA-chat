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
public class CategoriesInfo {
    
  private Integer groubId;
  private String  groubName;

  public CategoriesInfo()
  {}
  
  public CategoriesInfo(Integer groubId,String groubName)
  {
    this.groubId=groubId;
    this.groubName=groubName;
  }
  
  public CategoriesInfo(String groubName)
  {
    this.groubName=groubName;
  }
  
    public Integer getGroubId() {
        return groubId;
    }

    public void setGroubId(Integer groubId) {
        this.groubId = groubId;
    }

    public String getGroubName() {
        return groubName;
    }

    public void setGroubName(String groubName) {
        this.groubName = groubName;
    }
}