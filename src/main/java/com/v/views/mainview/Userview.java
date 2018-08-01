package com.v.views.mainview;

import java.io.File;

import com.v.views.MyUI;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Link;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.v.views.ordersbag.ProductView;
import com.vaadin.icons.*;


public class Userview extends VerticalLayout implements View {
	
	private LoSi lsview = new LoSi();
    PopupView spop = new PopupView(null, lsview.signup());
    PopupView lpop = new PopupView(null, lsview.login());
    private ourteam ot = new ourteam();
    PopupView ote = new PopupView(null, ot.Ourteam());
    PopupView ost = new PopupView(null, ot.Ourstore());
    private navibot navbot = new navibot();
    
    public Userview() {
    	init();
    }

	private void init() {
        final Panel pics0 = new Panel();
        final Panel pics1 = new Panel();
        final HorizontalLayout pm1 = new HorizontalLayout();
        final HorizontalLayout pm2 = new HorizontalLayout();
       

        setSizeUndefined();
        pics0.setSizeUndefined();
        pics1.setSizeUndefined();
        
     
        Link picc1 = new Link(null,new ExternalResource("https://www.apple.com/macbook/"));
        Link picc2 = new Link(null,new ExternalResource("https://www.apple.com/macbook-air/"));
        Link picc3 = new Link(null,new ExternalResource("https://www.apple.com/macbook-pro/"));
        Link picc4 = new Link(null,new ExternalResource("https://www.apple.com/mac-pro/"));
        
        picc1.setIcon(new ThemeResource("img/macbook.gif"));
        picc2.setIcon(new ThemeResource("img/macbookair.gif"));
        picc3.setIcon(new ThemeResource("img/macbookpro.gif"));
        picc4.setIcon(new ThemeResource("img/macpro.gif"));
        
        pm1.setSizeFull();
        pm1.addComponents(picc1,picc2);
        pm1.setExpandRatio(picc1, 1);
        pm1.setExpandRatio(picc2, 1);
        pm1.setComponentAlignment(picc1, Alignment.BOTTOM_RIGHT);
        pm1.setComponentAlignment(picc2, Alignment.BOTTOM_LEFT);
        pm2.setSizeFull();
        pm2.addComponents(picc3,picc4);
        pm2.setExpandRatio(picc3, 1);
        pm2.setExpandRatio(picc4, 1);
        pm2.setComponentAlignment(picc3, Alignment.TOP_RIGHT);
        pm2.setComponentAlignment(picc4, Alignment.TOP_LEFT);
        
        addComponent(navbot.naviguser());
        addComponent(pics0);
        addComponent(pics1);
        addComponent(pm1);
        addComponent(pm2);
        addComponent(navbot.botafin());
        
        ThemeResource r9 = new ThemeResource("img/stuff.jpg");
        ThemeResource r10 = new ThemeResource("img/mac0.jpg");
                
               
        Image pic1 = new Image("",r9);
        Image pic2 = new Image("",r10);
        
        pic1.setSizeUndefined();
        pic2.setSizeUndefined();
        

        pics0.addStyleName("panel_sty");
        pics1.addStyleName("panel_sty");
        pics0.addStyleName("nobor");
        pics1.addStyleName("nobor");
        pm1.addStyleName("nobor");
        pm2.addStyleName("nobor");
        pm1.addStyleName("picbut");
        pm1.addStyleName("btsp");
        pm1.addStyleName("btspp");
        pm1.addStyleName("bticon");
        pm2.addStyleName("picbut");
        pm2.addStyleName("btsp");
        pm2.addStyleName("btspp");
        pm2.addStyleName("bticon");
        setStyleName("panel_sty");
        pics0.setContent(pic1);
        pics1.setContent(pic2);
       // setContent(tags);



        
        
    }

}
