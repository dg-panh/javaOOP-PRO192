/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class OrderItem implements Comparable<OrderItem>{
    Order order;
    Item item;
    private int quantity;
    private int index;

    public OrderItem(Order order, Item item) {
        this.order = order;
        this.item = item;
        quantity = order.getTotalOfQuantity();
        index = 0;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    
    
    @Override
    public int compareTo(OrderItem o) {
        return order.getId().compareToIgnoreCase(o.getOrder().getId()); 
    }
}
