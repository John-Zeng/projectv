package com.v.views.ordersbag;

import com.v.bean.Product;
import com.v.bean.Record;
import com.v.bean.RecordWithBLOBs;
import com.v.views.MyUI;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import java.util.ArrayList;
import java.util.List;

public class BagView extends VerticalLayout {
    public BagView() {
        init();
    }
    
    private void init() {
        List<Obag> l = datagen();
        
        Panel lp, rp;
        HorizontalLayout record;
        VerticalLayout body;
        AbsoluteLayout footer;
        
        price = 0;
        if (!l.isEmpty()) {
            for (Obag i : l) {
                price += (i.getQuan() * i.getInitPrice());
                bp.setLeftPanel(i.getImg());
                lp = bp.getLeftPanel();
                bp.setRightPanel(i.getProd(), i.getQuan(), i.getInitPrice(), i.getSpec(), i.getR_id());
                rp = bp.getRightPanel();

                bp.setRecord(lp, rp);
                record = bp.getRecord();

                bp.setBody(record);
            }
        } else {
            bp.setEmpty();
        }
        
        body = bp.getBody();
        body.addStyleName("scrollv");
        
        bp.setFooter();
        footer = bp.getFooter();
        
        addStyleName("bag");
        addComponents(body, footer);
        setExpandRatio(body, 4);
        setExpandRatio(footer, 1);
        setWidth("800");
        setHeight("500");
    }
    
    public static List<Obag> datagen() {
        List<Obag> l = new ArrayList();
        if(MyUI.user != null) {
            
            List<RecordWithBLOBs> recordInBag = MyUI.vservice.getInBag(MyUI.user.getUsername());
            for(RecordWithBLOBs record:recordInBag) {
                String[] x = record.getNote().split("=");
                String i = hfmt.formatSpec(x);
                Obag obag = new Obag();
                Product p = MyUI.vservice.getByName(record.getPd());
                obag.setImg("img/" + p.getImage());
                obag.setInitPrice(record.getPrice());
                obag.setProd(p.getName());
                obag.setQuan(1);
                obag.setSpec(i);
                obag.setR_id(record.getrId());
                l.add(obag);
                
            }
            
        }
        return l;
        
//        
//        String[] x = {
//            "1.4GHz dual-core 7th-generation Intel Core i7 processor, Turbo Boost up to 3.6GHz",
//            "16GB 1866MHz LPDDR3 memory",
//            "512GB SSD storage",
//            "Intel HD Graphics 615",
//            "Backlit Keyboard - US English"
//        };
//        
//        
//        String i = hfmt.formatSpec(x);
//        String j = "<b>Specifications</b>:<br>"
//                + "<ul><li>2.2GHz dual-core Intel Core i7 processor, Turbo Boost up to 3.2GHz</li>"
//                + "<li>8GB 1600MHz LPDDR3 memory</li>"
//                + "<li>512GB SSD storage</li>"
//                + "<li>Intel HD Graphics 6000</li>"
//                + "<li>Backlit Keyboard - US English</li></ul>";
//        
//        Obag a = new Obag(), b = new Obag();
//        a.setImg("img/macbook.jpg"); a.setInitPrice(1949f); a.setProd("MacBook"); a.setQuan(2); a.setSpec(i);
//        b.setImg("img/macbookair.jpg"); b.setInitPrice(1549f); b.setProd("MacBook Air"); b.setQuan(1); b.setSpec(j);
//        
//        l.add(a);
//        l.add(b);
//        
       
    }
    
    private BagPopup bp = new BagPopup();
    private static HFormatter hfmt = new HFormatter();
    public static float price;
}
