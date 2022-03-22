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
@Table(name = "SUB_Client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SUBClient.findAll", query = "SELECT s FROM SUBClient s"),
    @NamedQuery(name = "SUBClient.findByUserIDMamagerParent", query = "SELECT s FROM SUBClient s WHERE s.userIDMamagerParent = :userIDMamagerParent"),
    @NamedQuery(name = "SUBClient.findByUserID", query = "SELECT s FROM SUBClient s WHERE s.userID = :userID"),
    @NamedQuery(name = "SUBClient.findByFirstName", query = "SELECT s FROM SUBClient s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "SUBClient.findByLastName", query = "SELECT s FROM SUBClient s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "SUBClient.findByPhoneNumber", query = "SELECT s FROM SUBClient s WHERE s.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "SUBClient.findByGmail", query = "SELECT s FROM SUBClient s WHERE s.gmail = :gmail"),
    @NamedQuery(name = "SUBClient.findByCarNumber", query = "SELECT s FROM SUBClient s WHERE s.carNumber = :carNumber"),
    @NamedQuery(name = "SUBClient.findBySeniority", query = "SELECT s FROM SUBClient s WHERE s.seniority = :seniority")})
public class SUBClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "userIDMamager_Parent")
    private Integer userIDMamagerParent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userID")
    private Integer userID;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "gmail")
    private String gmail;
    @Column(name = "carNumber")
    private String carNumber;
    @Column(name = "Seniority")
    private Integer seniority;

    public SUBClient() {
    }

    public SUBClient(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserIDMamagerParent() {
        return userIDMamagerParent;
    }

    public void setUserIDMamagerParent(Integer userIDMamagerParent) {
        this.userIDMamagerParent = userIDMamagerParent;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
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
        if (!(object instanceof SUBClient)) {
            return false;
        }
        SUBClient other = (SUBClient) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.PROJECTLOGIN.SUBClient[ userID=" + userID + " ]";
    }
    
}
