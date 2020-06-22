/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shop.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "order_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderData.findAll", query = "SELECT o FROM OrderData o")
    , @NamedQuery(name = "OrderData.findById", query = "SELECT o FROM OrderData o WHERE o.id = :id")
    , @NamedQuery(name = "OrderData.findByOrderDate", query = "SELECT o FROM OrderData o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "OrderData.findByPayMethod", query = "SELECT o FROM OrderData o WHERE o.payMethod = :payMethod")
    , @NamedQuery(name = "OrderData.findByDeliveryMethod", query = "SELECT o FROM OrderData o WHERE o.deliveryMethod = :deliveryMethod")})
public class OrderData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Column(name = "pay_method")
    private String payMethod;
    @Column(name = "delivery_method")
    private String deliveryMethod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderData")
    private Collection<UserOrder> userOrderCollection;
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToOne
    private UserData idUser;

    public OrderData() {
    }

    public OrderData(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @XmlTransient
    public Collection<UserOrder> getUserOrderCollection() {
        return userOrderCollection;
    }

    public void setUserOrderCollection(Collection<UserOrder> userOrderCollection) {
        this.userOrderCollection = userOrderCollection;
    }

    public UserData getIdUser() {
        return idUser;
    }

    public void setIdUser(UserData idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof OrderData)) {
            return false;
        }
        OrderData other = (OrderData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.shop.Entity.OrderData[ id=" + id + " ]";
    }
    
}
