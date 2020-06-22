/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shop.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "user_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserData.findAll", query = "SELECT u FROM UserData u")
    , @NamedQuery(name = "UserData.findById", query = "SELECT u FROM UserData u WHERE u.id = :id")
    , @NamedQuery(name = "UserData.findByEmail", query = "SELECT u FROM UserData u WHERE u.email = :email")
    , @NamedQuery(name = "UserData.findByFirstName", query = "SELECT u FROM UserData u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "UserData.findByLastName", query = "SELECT u FROM UserData u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "UserData.findByCity", query = "SELECT u FROM UserData u WHERE u.city = :city")
    , @NamedQuery(name = "UserData.findByPostalCode", query = "SELECT u FROM UserData u WHERE u.postalCode = :postalCode")
    , @NamedQuery(name = "UserData.findByStreet", query = "SELECT u FROM UserData u WHERE u.street = :street")
    , @NamedQuery(name = "UserData.findByHomeNumber", query = "SELECT u FROM UserData u WHERE u.homeNumber = :homeNumber")})
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "city")
    private String city;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "street")
    private String street;
    @Column(name = "home_number")
    private String homeNumber;
    @OneToMany(mappedBy = "idUser")
    private Collection<OrderData> orderDataCollection;
    @OneToMany(mappedBy = "idUser")
    private Collection<Book> bookCollection;

    public UserData() {
    }

    public UserData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    @XmlTransient
    public Collection<OrderData> getOrderDataCollection() {
        return orderDataCollection;
    }

    public void setOrderDataCollection(Collection<OrderData> orderDataCollection) {
        this.orderDataCollection = orderDataCollection;
    }

    @XmlTransient
    public Collection<Book> getBookCollection() {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection) {
        this.bookCollection = bookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserData)) {
            return false;
        }
        UserData other = (UserData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.shop.Entity.UserData[ id=" + id + " ]";
    }
    
}
