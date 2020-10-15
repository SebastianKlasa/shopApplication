/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shop.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sebas
 */
@Entity
@Table(name = "user_order")
@XmlRootElement
public class UserOrder implements Serializable {

    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected UserOrderPK userOrderPK;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Column(name = "count")
    private Integer count;
    @JoinColumn(name = "id_book", nullable=false)
    @ManyToOne(optional = false)
    private Book book;
    @JoinColumn(name = "id_order", nullable=false)
    @ManyToOne(optional = false)
    @JsonIgnore
    private OrderData orderData;

    public UserOrder() {
    }

//    public UserOrder(UserOrderPK userOrderPK) {
//        this.userOrderPK = userOrderPK;
//    }

//    public UserOrder(int id, int idBook, int idOrder) {
//        this.userOrderPK = new UserOrderPK(id, idBook, idOrder);
//    }
    
    public UserOrder(Book book, Integer count){
        this.book = book;
        this.count = count;
    }

//    public UserOrderPK getUserOrderPK() {
//        return userOrderPK;
//    }
//
//    public void setUserOrderPK(UserOrderPK userOrderPK) {
//        this.userOrderPK = userOrderPK;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        hash += (id);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserOrder)) {
            return false;
        }
        UserOrder other = (UserOrder) object;
        if (this.id!=other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.shop.Entity.UserOrder[ id=" + id + " ]";
    }
    
}
