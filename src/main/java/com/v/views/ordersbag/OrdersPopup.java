package com.v.views.ordersbag;

import com.v.bean.Orders;
import com.v.bean.Record;
import com.v.views.MyUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.renderers.HtmlRenderer;
import java.util.ArrayList;
import java.util.List;

public class OrdersPopup {
    public OrdersPopup() {
    }

    public Layout ordersview() {
        Label header = new Label("Orders");
        Panel body = body();
        VerticalLayout v = new VerticalLayout();
        v.addComponents(header, body);
        v.setExpandRatio(header, 1);
        v.setExpandRatio(body, 10);
        v.setComponentAlignment(header, Alignment.MIDDLE_CENTER);
        v.setComponentAlignment(body, Alignment.TOP_CENTER);

        v.setWidth("800");
        v.setHeight("500");
        return v;
    }

    public Panel body() {
        Panel p = new Panel();
        Grid<Order> gg = new Grid<>(Order.class);
        List<Order> orders = new ArrayList<>();
       
       if(MyUI.user != null) {
           List<Orders> list = MyUI.vservice.getUserOrders(MyUI.user.getUsername());
          
           for (Orders od : list) {
               List<Record> records = od.getRecords();
               String orderId = od.getoId();
               for(Record rec: records) {
                   Order o = new Order();
                   o.setSeller("MacStore");
                   o.setId(orderId);
                   o.setItem(rec.getPd());
                   o.setDate(od.getOdTime());
                   orders.add(o);
               }
           }
       }
        
        
//        Order a = new Order(), b = new Order();
//        a.setSeller("Apple");
//        a.setId("CPRP159810914");
//        a.setItem("MacBook");
//        a.setDate("2018-07-24");
//        b.setSeller("Apple");
//        b.setId("87C948190F0AD");
//        b.setItem("iMac");
//        b.setDate("2015-09-12");
       
//        orders.add(a);
//        orders.add(b);
        gg.setItems(orders);

        gg.setColumns("seller", "item", "id", "date");
        p.setStyleName("gridx");
        gg.setSizeFull();
        p.setContent(gg);
        return p;
    }
}
