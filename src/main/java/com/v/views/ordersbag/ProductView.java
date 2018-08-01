package com.v.views.ordersbag;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.v.bean.Memory;
import com.v.bean.Processor;
import com.v.bean.Product;
import com.v.service.VService;
import com.v.views.MyUI;
import com.v.views.mainview.navibot;
import com.vaadin.navigator.View;
import com.vaadin.server.Page;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class ProductView extends Panel implements View {
    public ProductView() {
        init();
    }

    private void init() {
        VerticalLayout v = new VerticalLayout();
        Panel p = new Panel();

        pc.setLeftPanel(ProductCompo.img, ProductCompo.prod, ProductCompo.spec); // image & product & specification
        Panel lp = pc.getLeftPanel();
        pc.setRightPanel(ProductCompo.options, ProductCompo.price); // options & price
        Panel rp = pc.getRightPanel();

        pc.setDetail(lp, rp);
        HorizontalLayout h = pc.getDetail();

        pc.setBody(h, ProductCompo.initPrice); // initial price
        AbsoluteLayout a = pc.getBody();

        p.setWidth("70%");
        p.setHeight("700px");
        p.addStyleName("prod");
        p.setContent(a);
        Panel pp = new Panel();
        v.addStyleName("page");
        v.setSizeFull();
        v.addComponents(navbot.navig(), p, navbot.bot());
        v.setComponentAlignment(p, Alignment.MIDDLE_CENTER);
        pp.setContent(v);
        setContent(pp);
    }

    private ProductCompo pc = new ProductCompo();

    public static Product product = MyUI.vservice.getSpec("iMac");
    private navibot navbot = new navibot();
    public static String name = "";

    public static void setName(String N) {
        if(name != N) {
            name = N;
            product = MyUI.vservice.getSpec(name);
            
            ProductCompo.prod = product.getName();
            ProductCompo.img = "img/" + product.getImage();
            ProductCompo.initPrice = product.getPrice();
            ProductCompo.ms = product.getMoreDesc().split("=");
            
            ProductCompo.proc = product.getProcessors();
            ProductCompo.mmry = product.getMemories();
     
            ProductCompo.spec[0] = ProductCompo.proc.get(0).getPdesc().replaceAll("#", " ");
            ProductCompo.spec[1] = ProductCompo.mmry.get(0).getMdesc();
            ProductCompo.spec[2] = ProductCompo.ms[2];
            ProductCompo.spec[3] = ProductCompo.ms[3];      

            ProductCompo.options[0] = ProductCompo.proc.get(0).getPdesc().replaceAll("#", "<br>");
            ProductCompo.options[1] = ProductCompo.proc.get(1).getPdesc().replaceAll("#", "<br>");
            ProductCompo.options[2] = ProductCompo.mmry.get(0).getMdesc();
            ProductCompo.options[3] = ProductCompo.mmry.get(1).getMdesc();
 
            ProductCompo.price[0] = ProductCompo.proc.get(1).getPlPrice();
            ProductCompo.price[1] = ProductCompo.mmry.get(1).getPlPrice();

            Page.getCurrent().reload();
        }
    }
}
