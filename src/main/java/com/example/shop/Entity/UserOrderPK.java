/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shop.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author sebas
 */
@Embeddable
public class UserOrderPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "id_book")
    private int idBook;
    @Basic(optional = false)
    @Column(name = "id_order")
    private int idOrder;

    public UserOrderPK() {
    }

    public UserOrderPK(int id, int idBook, int idOrder) {
        this.id = id;
        this.idBook = idBook;
        this.idOrder = idOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) idBook;
        hash += (int) idOrder;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserOrderPK)) {
            return false;
        }
        UserOrderPK other = (UserOrderPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idBook != other.idBook) {
            return false;
        }
        if (this.idOrder != other.idOrder) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.shop.Entity.UserOrderPK[ id=" + id + ", idBook=" + idBook + ", idOrder=" + idOrder + " ]";
    }
    
}
