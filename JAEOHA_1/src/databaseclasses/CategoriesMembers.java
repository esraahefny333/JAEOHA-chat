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
public class CategoriesMembers {
    
  private Integer groubId;
  private String memberId;

  public CategoriesMembers()
  {}
  
  public CategoriesMembers(Integer groubId,String memberId)
  {
     this.groubId=groubId;
     this.memberId=memberId;
  }
  
  public CategoriesMembers(String memberId)
  {
     this.memberId=memberId;
  }
  
    public Integer getGroubId() {
        return groubId;
    }

    public void setGroubId(Integer groubId) {
        this.groubId = groubId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }    
}