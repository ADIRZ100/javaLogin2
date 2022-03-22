/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PROJECTLOGIN;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "ClientManager")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientManager.findAll", query = "SELECT c FROM ClientManager c"),
    @NamedQuery(name = "ClientManager.findByUserID", query = "SELECT c FROM ClientManager c WHERE c.userID = :userID"),
    @NamedQuery(name = "ClientManager.findByUsername", query = "SELECT c FROM ClientManager c WHERE c.username = :username"),
    @NamedQuery(name = "ClientManager.findByPasswordUser", query = "SELECT c FROM ClientManager c WHERE c.passwordUser = :passwordUser"),
    @NamedQuery(name = "ClientManager.findByPhoneNumber", query = "SELECT c FROM ClientManager c WHERE c.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "ClientManager.findByGmail", query = "SELECT c FROM ClientManager c WHERE c.gmail = :gmail"),
    @NamedQuery(name = "ClientManager.findByHowMuchSubUsers", query = "SELECT c FROM ClientManager c WHERE c.howMuchSubUsers = :howMuchSubUsers")})
public class ClientManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userID")
    private Integer userID;
    @Column(name = "username")
    private String username;
    @Column(name = "passwordUser")
    private String passwordUser;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "Gmail")
    private String gmail;
    @Column(name = "howMuchSub_Users")
    private Integer howMuchSubUsers;

    public ClientManager() {
    }

    public ClientManager(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Integer getHowMuchSubUsers() {
        return howMuchSubUsers;
    }

    public void setHowMuchSubUsers(Integer howMuchSubUsers) {
        this.howMuchSubUsers = howMuchSubUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientManager)) {
            return false;
        }
        ClientManager other = (ClientManager) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.PROJECTLOGIN.ClientManager[ userID=" + userID + " ]";
    }
    
}
