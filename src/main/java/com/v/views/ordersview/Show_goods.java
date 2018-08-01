package com.v.views.ordersview;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


import com.v.bean.Item;
import com.v.bean.Orders;
import com.v.bean.RecordWithBLOBs;
import com.v.views.MyUI;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.v.views.ordersbag.OrdersPopup;

public class Show_goods {
    private OrdersPopup o = new OrdersPopup();
    PopupView op = new PopupView(null, o.ordersview());
    static double sum = 0; 
    public Show_goods() {
    }

    public Panel goodPanel() {
        Panel p = new Panel();
        VerticalLayout infover = new VerticalLayout();
        p.setContent(infover);
        HorizontalLayout infohor2 = new HorizontalLayout();

        // 数据库操作（获取欲下单商品信息）
//        for (int i = 0; i < 3; i++) {
//            HorizontalLayout infohor1 = new HorizontalLayout();
//            Panel img = new Panel();
//            ThemeResource imgpath = new ThemeResource("img/imac_pro_01_large.jpg");
//            Image imgc = new Image(null, imgpath);
//            imgc.setWidth("100px");
//            imgc.setHeight("100px");
//            img.setContent(imgc);
//            String name = "iPhone15";
//            String price = "$55223";
//            String count = "6";
//            Label la = new Label(pop.desHtml(name, price, count), ContentMode.HTML);
//
//            infohor1.addComponents(img, la);
//            infover.addComponent(infohor1);
//        }
        sum = 0;
        if(MyUI.user != null) {
            List<RecordWithBLOBs> recordsList = MyUI.vservice.getInBag(MyUI.user.getUsername());
            for(RecordWithBLOBs rec: recordsList) {
                HorizontalLayout infohor1 = new HorizontalLayout();
                Panel img = new Panel();
                String image = MyUI.vservice.getByName(rec.getPd()).getImage();
                ThemeResource imgpath = new ThemeResource("img/" + image);
                Image imgc = new Image(null, imgpath);
                imgc.setWidth("100px");
                imgc.setHeight("100px");
                img.setContent(imgc);
                String name = rec.getPd();
                double pp = rec.getPrice();
                String price ="$"+ pp;
                sum += pp;
                //String count = "6s";
                Label la = new Label(pop.desHtml(name, price), ContentMode.HTML);

                infohor1.addComponents(img, la);
                infover.addComponent(infohor1);
            }
            
        }
        
        Button orderb1 = new Button("Confirm");
        orderb1.setStyleName(ValoTheme.BUTTON_PRIMARY);
        orderb1.addClickListener(e -> {
            // 页面跳转到订单
            if(choice.getNumber() == null) {
                Notification.show("Select an Address");
            }else {
                Orders newOrder = new Orders();
                
                newOrder.setTotal(sum);
                newOrder.setUsername(MyUI.user.getUsername());
                newOrder.setAddrId(choice.getNumber());
                Date date = new Date();
                newOrder.setOdTime(date);
                
                String orderId = MyUI.vservice.genSalt();
                newOrder.setoId(orderId);
                
                MyUI.vservice.insertOrders(newOrder);
                List<RecordWithBLOBs> listRecord = MyUI.vservice.getInBag(MyUI.user.getUsername());
                for(RecordWithBLOBs record : listRecord) {
                    Item item = new Item();
                    item.setoId(orderId);
                    item.setQuantity(1);
                    item.setrId(record.getrId());
                    MyUI.vservice.insertItem(item);
                }
                MyUI.vservice.deleteBag(MyUI.user.getUsername());
                
                // 数据库操作(删除购物车，添加订单)
                Notification.show("Buy Success! Thank you!", Notification.Type.WARNING_MESSAGE);
                //生成订单，清空购物车数据库
                
               
                MyUI.navi.navigateTo("userview");
                Page.getCurrent().reload();
                System.out.println(choice.getNumber());
                
            }
            
        });
        Button orderb2 = new Button("Cancel");
        orderb2.setStyleName(ValoTheme.BUTTON_DANGER);

        orderb2.addClickListener(e -> {
            // 页面跳转到首页
            // 数据库操作（删除订单预存表）
            MyUI.navi.navigateTo("userview");
        });
        Label total = new Label("<b>Order Total: </b>" +fmt.format(sum), ContentMode.HTML);
        HorizontalLayout hor = new HorizontalLayout();
        hor.addComponents(orderb1, orderb2, op);
        // hor.setStyleName("but");
        infohor2.setSizeFull();
        infohor2.addComponents(hor, total);
        infohor2.setExpandRatio(hor, 1);
        infohor2.setExpandRatio(total, 1);
        infohor2.setComponentAlignment(hor, Alignment.TOP_LEFT);
        infohor2.setComponentAlignment(total, Alignment.TOP_CENTER);

        infover.addComponent(infohor2);
        p.setSizeFull();
        return p;
    }
    NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
    Place_orderUnit pop = new Place_orderUnit();
    Address_choice choice = new Address_choice();
}
