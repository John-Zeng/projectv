package com.v.views.mainview;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ourteam {
    public ourteam() {}
    
    public Layout Ourteam() {
        VerticalLayout vlayout = new VerticalLayout();
        HorizontalLayout p1 = new HorizontalLayout();
        HorizontalLayout p2 = new HorizontalLayout();
        HorizontalLayout p3 = new HorizontalLayout();
        HorizontalLayout p4 = new HorizontalLayout();
        HorizontalLayout p5 = new HorizontalLayout();
        
        FormLayout form = new FormLayout();
        form.setSizeUndefined();      
        
        Label ourteamLabel = new Label("<h3>Our Team</h3>", ContentMode.HTML);
        Label p1n = new Label("Chuting Lu");
        Label p1e = new Label("13250743936@qq.com");
        Label p2n = new Label("Yijian Zeng");
        Label p2e = new Label("zengyj19960@gamil.com");
        Label p3n = new Label("Wenjie Liang");
        Label p3e = new Label("lewintt@icloud.com");
        Label p4n = new Label("Zhijian Chen");
        Label p4e = new Label("13928998713@163.com");
        Label p5n = new Label("Pengcheng Ma");
        Label p5e = new Label("503783192@qq.com");
        p1.addComponents(p1n,p1e);
        p2.addComponents(p2n,p2e);
        p3.addComponents(p3n,p3e);
        p4.addComponents(p4n,p4e);
        p5.addComponents(p5n,p5e);
 
        form.addComponents(p1,p2,p3,p4,p5);
        
        vlayout.addComponents(ourteamLabel, form);
        vlayout.setComponentAlignment(ourteamLabel, Alignment.TOP_CENTER);
        vlayout.setSizeUndefined();
        return vlayout;
    }
    
    public Layout Ourstore() {
    	VerticalLayout qr = new VerticalLayout();
    	Label qrc = new Label();
    	ThemeResource qrcode = new ThemeResource("img/qrcode.png");  
    	qrc.setIcon(qrcode);
    	qr.addComponent(qrc);
    	return qr;
    }
    
}