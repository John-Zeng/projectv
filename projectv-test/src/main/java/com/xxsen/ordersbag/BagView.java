package com.xxsen.ordersbag;

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
        List<Bag> l = datagen();
        
        Panel lp, rp;
        HorizontalLayout record;
        VerticalLayout body;
        AbsoluteLayout footer;
        
        for (Bag i : l) {
            price += (i.getQuan() * i.getInitPrice());
            bp.setLeftPanel(i.getImg());
            lp = bp.getLeftPanel();
            bp.setRightPanel(i.getProd(), i.getQuan(), i.getInitPrice(), i.getSpec());
            rp = bp.getRightPanel();

            bp.setRecord(lp, rp);
            record = bp.getRecord();

            bp.setBody(record);
        }
        
        body = bp.getBody();
        body.addStyleName("scrollv");
        
        bp.setFooter();
        footer = bp.getFooter();
        
        addComponents(body, footer);
        setExpandRatio(body, 4);
        setExpandRatio(footer, 1);
        setWidth("800");
        setHeight("500");
    }
    
    public List<Bag> datagen() {
        String i = "<b>Specifications</b>:<br>"
                + "<lu><li>1.4GHz dual-core 7th-generation Intel Core i7 processor, Turbo Boost up to 3.6GHz</li>"
                + "<li>16GB 1866MHz LPDDR3 memory</li>"
                + "<li>512GB SSD storage</li>"
                + "<li>Intel HD Graphics 615</li>"
                + "<li>Backlit Keyboard - US English</li></lu>";
        String j = "<b>Specifications</b>:<br>"
                + "<lu><li>2.2GHz dual-core Intel Core i7 processor, Turbo Boost up to 3.2GHz</li>"
                + "<li>8GB 1600MHz LPDDR3 memory</li>"
                + "<li>512GB SSD storage</li>"
                + "<li>Intel HD Graphics 6000</li>"
                + "<li>Backlit Keyboard - US English</li></lu>";
        List<Bag> l = new ArrayList();
        Bag a = new Bag(), b = new Bag();
        a.setImg("macbook.jpeg"); a.setInitPrice(1949f); a.setProd("MacBook"); a.setQuan(2); a.setSpec(i);
        b.setImg("macbookair.jpeg"); b.setInitPrice(1549f); b.setProd("MacBook Air"); b.setQuan(1); b.setSpec(j);
        
        l.add(a);
        l.add(b);
        
        return l;
    }
    
    private BagPopup bp = new BagPopup();
    public static float price = 0;
}
