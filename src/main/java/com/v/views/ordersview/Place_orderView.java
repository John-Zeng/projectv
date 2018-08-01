package com.v.views.ordersview;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.v.views.mainview.navibot;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.sass.internal.selector.Selector;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Place_orderView  extends VerticalLayout implements View {
	String width = "1920px";
	private navibot navbot = new navibot();
	public Place_orderView () { 
		       
      
        //收件地址及商品信息
        HorizontalLayout addresshor = new HorizontalLayout();
        Panel addressp = new Panel();
        VerticalLayout orderv = new VerticalLayout();                                              
        orderv.addComponents(choice.addressPanel(),good.goodPanel());
     
    
        addressp.setWidth("1000px");
        addressp.setContent(orderv);
        addressp.setStyleName("infopanel");
        addresshor.setWidth(width);
        addresshor.setHeightUndefined();
        addresshor.addComponents(addressp);
        addresshor.setComponentAlignment(addressp,Alignment.TOP_CENTER);
        
     
        //常见问题
        HorizontalLayout problemhor = new HorizontalLayout();
        Panel problempanel = new Panel("<b>FAQ</b>");    
        TabSheet   sample = new TabSheet();
        sample.setWidth("1000px");
        sample.setHeight(100.0f, Unit.PERCENTAGE);
        sample.addStyleName(ValoTheme.TABSHEET_FRAMED);
        sample.addStyleName(ValoTheme.TABSHEET_PADDED_TABBAR);
       

        sample.addTab(pop.delivery(), "Delivery Options");
        sample.addTab(pop.pro_address(),"Shipping Address");
        sample.addTab(pop.payment(),"Payment");
        
      
        problempanel.setContent(sample);
        problempanel.setWidth("1000px");
        
        problemhor.setStyleName("infopanel");
        problemhor.setWidth(width);
        problemhor.setHeightUndefined();
        problemhor.addComponents(problempanel);
        problemhor.setComponentAlignment(problempanel, Alignment.TOP_CENTER);        
      
        setSizeUndefined();
        addComponents(navbot.naviguser(),addresshor,problemhor,navbot.botafin());
   
	}
	
      Place_orderUnit pop = new Place_orderUnit();
    /*  PopupView delivery = new PopupView(null,pop.delivery());
      PopupView addresspop = new PopupView(null,pop.pro_address());
      PopupView paymentpop =new PopupView(null,pop.payment());*/
     
      Show_goods good =new Show_goods();
      Address_choice choice = new Address_choice();
    }
