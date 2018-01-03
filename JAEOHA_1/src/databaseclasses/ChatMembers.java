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
public class ChatMembers {
    
  private Integer chatId;
  private String  memberId;

    public ChatMembers() {
     }

    public ChatMembers(Integer chatId, String memberId)
    {
        this.chatId = chatId;
        this.memberId = memberId;
     }
  
    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }    
}