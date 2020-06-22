/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shop.Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "user_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserOrder.findAll", query = "SELECT u FROM UserOrder u")
    , @NamedQuery(name = "UserOrder.findById", query = "SELECT u FROM UserOrder u WHERE u.userOrderPK.id = :id")
    , @NamedQuery(name = "UserOrder.findByIdBook", query = "SELECT u FROM UserOrder u WHERE u.userOrderPK.idBook = :idBook")
    , @NamedQuery(name = "UserOrder.findByIdOrder", query = "SELECT u FROM UserOrder u WHERE u.userOrderPK.idOrder = :idOrder")
    , @NamedQuery(name = "UserOrder.findByCount", query = "SELECT u FROM UserOrder u WHERE u.count = :count")})
public class UserOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserOrderPK userOrderPK;
    @Column(name = "count")
    private Integer count;
    @JoinColumn(name = "id_book", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;
    @JoinColumn(name = "id_order", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OrderData orderData;

    public UserOrder() {
    }

    public UserOrder(UserOrderPK userOrderPK) {
        this.userOrderPK = userOrderPK;
    }

    public UserOrder(int id, int idBook, int idOrder) {
        this.userOrderPK = new UserOrderPK(id, idBook, idOrder);
    }

    public UserOrderPK getUserOrderPK() {
        return userOrderPK;
    }

    public void setUserOrderPK(UserOrderPK userOrderPK) {
        this.userOrderPK = userOrderPK;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public void setOrderData(OrderData orderData) {
        this.orderData = orderData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userOrderPK != null ? userOrderPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserOrder)) {
            return false;
        }
        UserOrder other = (UserOrder) object;
        if ((this.userOrderPK == null && other.userOrderPK != null) || (this.userOrderPK != null && !this.userOrderPK.equals(other.userOrderPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.shop.Entity.UserOrder[ userOrderPK=" + userOrderPK + " ]";
    }
    
}
