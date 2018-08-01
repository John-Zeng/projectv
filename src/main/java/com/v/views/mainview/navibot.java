package com.v.views.mainview;

import com.v.views.MyUI;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.v.views.ordersbag.BagPopup;
import com.v.views.ordersbag.BagView;
import com.v.views.ordersbag.OrdersPopup;
import com.v.views.ordersbag.ProductView;
import com.v.views.ordersbag.ProductViewAfterlog;


public class navibot {
	
	private LoSi lsview = new LoSi();
    PopupView spop = new PopupView(null, lsview.signup());
    PopupView lpop = new PopupView(null, lsview.login());
    private ourteam ot = new ourteam();
    PopupView ote = new PopupView(null, ot.Ourteam());
    PopupView ost = new PopupView(null, ot.Ourstore());
    
    PopupView bag = new PopupView(null, new BagView());
    private OrdersPopup o = new OrdersPopup();
    PopupView op = new PopupView(null, o.ordersview());
    
	public navibot() {}
	
	
	public Layout navig() {
		
		Panel tg = new Panel();
		Label label =new Label("Welcome to MacStore.");
        Label mbl = new Label("MacBook");
        Label mbal = new Label("MacBook Air");
        Label mbpl = new Label("MacBook Pro");
        Label iml = new Label("iMac");
        Label impl = new Label("iMac Pro");
        Label mpl = new Label("Mac Pro");
        Label mml = new Label("Mac mini");
        Button b1 = new Button("Sign up");
        Button b2 = new Button("Log in");
        HorizontalLayout bt = new HorizontalLayout();
        HorizontalLayout navi = new HorizontalLayout();
        Panel lab = new Panel();
        Panel btt = new Panel();
        
        spop.setHideOnMouseOut(false);
        b1.addClickListener(e -> {
            spop.setPopupVisible(true);
        });
        lpop.setHideOnMouseOut(false);
        b2.addClickListener(e -> {
            lpop.setPopupVisible(true);
        });
        
        navi.setSizeUndefined();
        bt.addComponents(b1,b2);
        lab.setSizeUndefined();
        tg.setSizeUndefined();
        btt.setSizeUndefined();
        navi.setSizeUndefined();
        navi.setWidth("100%");
           
        navi.addComponents(lab,tg,btt);
        navi.setExpandRatio(lab, 1);
        navi.setExpandRatio(tg, 2);
        navi.setExpandRatio(btt, 1);
        navi.setComponentAlignment(lab,Alignment.MIDDLE_CENTER);
        navi.setComponentAlignment(tg, Alignment.TOP_CENTER);
        navi.setComponentAlignment(btt, Alignment.MIDDLE_CENTER);
        navi.addComponents(spop,lpop);
        navi.setComponentAlignment(spop,Alignment.BOTTOM_CENTER);
        navi.setComponentAlignment(lpop,Alignment.BOTTOM_CENTER);
        
        ThemeResource r1 = new ThemeResource("img/macbook.svg");
        ThemeResource r2 = new ThemeResource("img/macbookair.svg");
        ThemeResource r3 = new ThemeResource("img/macbookpro.svg");
        ThemeResource r4 = new ThemeResource("img/macmini.svg");
        ThemeResource r5 = new ThemeResource("img/imac.svg");
        ThemeResource r6 = new ThemeResource("img/imacPro.svg");
        ThemeResource r7 = new ThemeResource("img/macpro.svg");
        ThemeResource r8 = new ThemeResource("img/apple.png");
        
        Button ap = new Button();
        ap.setIcon(r8);
        Button mb = new Button();
        mb.setIcon(r1, "Macbook");
        Button mba = new Button();
        mba.setIcon(r2, "Macbook Air");
        Button mbp = new Button();
        mbp.setIcon(r3, "Macbook Pro");
        Button mm = new Button();
        mm.setIcon(r4, "Mac mini");
        Button im = new Button();
        im.setIcon(r5, "iMac");
        Button imp = new Button();
        imp.setIcon(r6, "iMac Pro");
        Button mp = new Button();
        mp.setIcon(r7, "Mac Pro");
        
        ap.addClickListener(e -> {
        	MyUI.navi.navigateTo("");
        });
        mb.addClickListener(e -> {
        	ProductView.setName("MacBook");
        	MyUI.navi.navigateTo("product");
        });
        mba.addClickListener(e -> {
        	ProductView.setName("MacBook Air");
        	MyUI.navi.navigateTo("product");
        });
        mbp.addClickListener(e -> {
        	ProductView.setName("MacBook Pro");
        	MyUI.navi.navigateTo("product");
        });
        im.addClickListener(e -> {
        	ProductView.setName("iMac");
        	MyUI.navi.navigateTo("product");
        });
        imp.addClickListener(e -> {
        	ProductView.setName("iMac Pro");
        	MyUI.navi.navigateTo("product");
        });
        mm.addClickListener(e -> {
            ProductView.setName("Mac mini");
            MyUI.navi.navigateTo("product");
        });
        mp.addClickListener(e -> {
            ProductView.setName("Mac Pro");
            MyUI.navi.navigateTo("product");
        });
        
        VerticalLayout tg1 = new VerticalLayout();
        tg1.addComponents(mb,mbl);
        VerticalLayout tg2 = new VerticalLayout();
        tg2.addComponents(mba,mbal);
        VerticalLayout tg3 = new VerticalLayout();
        tg3.addComponents(mbp,mbpl);
        VerticalLayout tg4 = new VerticalLayout();
        tg4.addComponents(im,iml);
        VerticalLayout tg5 = new VerticalLayout();
        tg5.addComponents(imp,impl);
        VerticalLayout tg6 = new VerticalLayout();
        tg6.addComponents(mp,mpl);
        VerticalLayout tg7 = new VerticalLayout();
        tg7.addComponents(mm,mml);
        VerticalLayout tg8 = new VerticalLayout();
        tg8.addComponent(ap);
        HorizontalLayout tg0 = new HorizontalLayout();
        tg0.addComponents(tg8,tg1,tg2,tg3,tg4,tg5,tg6,tg7);
        
        tg.setWidthUndefined();
        tg.addStyleName("panel_sty");
        lab.addStyleName("panel_sty");
        btt.addStyleName("panel_sty");
        navi.addStyleName("nobor");
        navi.addStyleName("panel_sty");
        tg0.addStyleName("btsp");
        tg0.addStyleName("btspp");
        tg0.addStyleName("labsty");
        bt.setStyleName("btsty");
        tg.addStyleName("capsty");
        tg.addStyleName("panelwid");
        tg.addStyleName("space");
        tg.addStyleName("logosty");
        lab.setStyleName("taglabel");
        lab.setContent(label);
        btt.setContent(bt);
        tg.setContent(tg0);
        
        return navi;
	}
	
	public Layout naviguser() {
		
		Panel tg = new Panel();
		Label label =new Label("Welcome to MacStore.");
        Label mbl = new Label("MacBook");
        Label mbal = new Label("MacBook Air");
        Label mbpl = new Label("MacBook Pro");
        Label iml = new Label("iMac");
        Label impl = new Label("iMac Pro");
        Label mpl = new Label("Mac Pro");
        Label mml = new Label("Mac mini");
        
        Button b2 = new Button("Log out");
        Button b3 = new Button("Bag");
        Button b4 = new Button("Order");
        HorizontalLayout bt = new HorizontalLayout();
        HorizontalLayout navi = new HorizontalLayout();
        Panel lab = new Panel();
        Panel btt = new Panel();
        
        /*b1.addClickListener(e -> {
            spop.setPopupVisible(true);
        });*/
        b2.addClickListener(e -> {
            MyUI.user = null;
        	MyUI.navi.navigateTo("");
        });
        op.setHideOnMouseOut(false);
        bag.setHideOnMouseOut(false);
        b3.addClickListener(e->{
            BagView.datagen();
        	bag.setPopupVisible(true);
        });
        b4.addClickListener(e->{
        	op.setPopupVisible(true);
        });
        
        
        navi.setSizeUndefined();
        bt.addComponents(uBtn,b2,b3,b4);
        lab.setSizeUndefined();
        tg.setSizeUndefined();
        btt.setSizeUndefined();
        navi.setSizeUndefined();
        navi.setWidth("100%");
           
        navi.addComponents(lab,tg,btt);
        navi.setExpandRatio(lab, 1);
        navi.setExpandRatio(tg, 2);
        navi.setExpandRatio(btt, 1);
        navi.setComponentAlignment(lab,Alignment.MIDDLE_CENTER);
        navi.setComponentAlignment(tg, Alignment.TOP_CENTER);
        navi.setComponentAlignment(btt, Alignment.MIDDLE_CENTER);
        navi.addComponents(bag,op);
        
        ThemeResource r1 = new ThemeResource("img/macbook.svg");
        ThemeResource r2 = new ThemeResource("img/macbookair.svg");
        ThemeResource r3 = new ThemeResource("img/macbookpro.svg");
        ThemeResource r4 = new ThemeResource("img/macmini.svg");
        ThemeResource r5 = new ThemeResource("img/imac.svg");
        ThemeResource r6 = new ThemeResource("img/imacPro.svg");
        ThemeResource r7 = new ThemeResource("img/macpro.svg");
        ThemeResource r8 = new ThemeResource("img/apple.png");
        
        Button ap = new Button();
        ap.setIcon(r8);
        Button mb = new Button();
        mb.setIcon(r1, "Macbook");
        Button mba = new Button();
        mba.setIcon(r2, "Macbook Air");
        Button mbp = new Button();
        mbp.setIcon(r3, "Macbook Pro");
        Button mm = new Button();
        mm.setIcon(r4, "Mac mini");
        Button im = new Button();
        im.setIcon(r5, "iMac");
        Button imp = new Button();
        imp.setIcon(r6, "iMac Pro");
        Button mp = new Button();
        mp.setIcon(r7, "Mac Pro");
        
        ap.addClickListener(e -> {
        	MyUI.navi.navigateTo("userview");
        });
        mb.addClickListener(e -> {
        	ProductViewAfterlog.setName("MacBook");
        	MyUI.navi.navigateTo("productafin");
        });
        mba.addClickListener(e -> {
        	ProductViewAfterlog.setName("MacBook Air");
        	MyUI.navi.navigateTo("productafin");
        });
        mbp.addClickListener(e -> {
        	ProductViewAfterlog.setName("MacBook Pro");
        	MyUI.navi.navigateTo("productafin");
        });
        im.addClickListener(e -> {
        	ProductViewAfterlog.setName("iMac");
        	MyUI.navi.navigateTo("productafin");
        });
        imp.addClickListener(e -> {
        	ProductViewAfterlog.setName("iMac Pro");
        	MyUI.navi.navigateTo("productafin");
        });
        mm.addClickListener(e -> {
            ProductViewAfterlog.setName("Mac mini");
            MyUI.navi.navigateTo("productafin");
        });
        mp.addClickListener(e -> {
            ProductViewAfterlog.setName("Mac Pro");
            MyUI.navi.navigateTo("productafin");
        });
        
        VerticalLayout tg1 = new VerticalLayout();
        tg1.addComponents(mb,mbl);
        VerticalLayout tg2 = new VerticalLayout();
        tg2.addComponents(mba,mbal);
        VerticalLayout tg3 = new VerticalLayout();
        tg3.addComponents(mbp,mbpl);
        VerticalLayout tg4 = new VerticalLayout();
        tg4.addComponents(im,iml);
        VerticalLayout tg5 = new VerticalLayout();
        tg5.addComponents(imp,impl);
        VerticalLayout tg6 = new VerticalLayout();
        tg6.addComponents(mp,mpl);
        VerticalLayout tg7 = new VerticalLayout();
        tg7.addComponents(mm,mml);
        VerticalLayout tg8 = new VerticalLayout();
        tg8.addComponent(ap);
        HorizontalLayout tg0 = new HorizontalLayout();
        tg0.addComponents(tg8,tg1,tg2,tg3,tg4,tg5,tg6,tg7);
        
        tg.setWidthUndefined();
        tg.addStyleName("panel_sty");
        lab.addStyleName("panel_sty");
        btt.addStyleName("panel_sty");
        navi.addStyleName("nobor");
        navi.addStyleName("panel_sty");
        tg0.addStyleName("btsp");
        tg0.addStyleName("btspp");
        tg0.addStyleName("labsty");
        bt.setStyleName("btsty");
        tg.addStyleName("capsty");
        tg.addStyleName("panelwid");
        tg.addStyleName("space");
        tg.addStyleName("logosty");
        lab.setStyleName("taglabel");
        lab.setContent(label);
        btt.setContent(bt);
        tg.setContent(tg0);
        
        return navi;
	}
	
	
	public Layout bot() {
		HorizontalLayout bot1 = new HorizontalLayout();
        HorizontalLayout payop = new HorizontalLayout();
        HorizontalLayout payop1 = new HorizontalLayout();
        HorizontalLayout follus = new HorizontalLayout();
        HorizontalLayout ctus = new HorizontalLayout();
        Panel macapple = new Panel();
        Panel aboutus = new Panel();
        Panel payment = new Panel();
        Panel contact = new Panel();
        Panel address = new Panel();
        Panel follow = new Panel();
        VerticalLayout ma = new VerticalLayout();
        VerticalLayout ab = new VerticalLayout();
        VerticalLayout pa = new VerticalLayout();
        VerticalLayout co = new VerticalLayout();
        VerticalLayout ad = new VerticalLayout();
        VerticalLayout fo = new VerticalLayout();
        Label macapp = new Label("MacStore");
        Label about = new Label("About Us");
        Button ourteam = new Button("Our Team");
        Button outstore = new Button("Our Store");
        Label pay = new Label("Payment Options");
        Label cont = new Label("Contact");
        Label add = new Label("Address");
        Label fol = new Label("Follow us");
        Button ma1 = new Button("MacBook");
        Button ma2 = new Button("MacBook Air");
        Button ma3 = new Button("MacBook Pro");
        Button ma4 = new Button("iMac");
        Button ma5 = new Button("iMac Pro");
        Button ma6 = new Button("Mac Pro");
        Button ma7 = new Button("Mac mini");
        Button tfbt = new Button("Macapple@163.com");
        Button adds = new Button("Jinan University Panyu Campus");
        
        bot1.setSizeUndefined();
        macapple.setSizeUndefined();
        aboutus.setSizeUndefined();
        payment.setSizeUndefined();
        contact.setSizeUndefined();
        address.setSizeUndefined();
        follow.setSizeUndefined();
        payop.setSizeUndefined();
        payop1.setSizeUndefined();
        follus.setSizeUndefined();
        ma.setSizeUndefined();
        ab.setSizeUndefined();
        pa.setSizeUndefined();
        co.setSizeUndefined();
        ad.setSizeUndefined();
        fo.setSizeUndefined();
        
        ote.setHideOnMouseOut(false);
        ourteam.addClickListener(e -> {
            ote.setPopupVisible(true);
        });
        ost.setHideOnMouseOut(false);
        outstore.addClickListener(e -> {
            ost.setPopupVisible(true);
        });
        ma1.addClickListener(e -> {
        	ProductView.setName("MacBook");
        	MyUI.navi.navigateTo("product");
        });
        ma2.addClickListener(e -> {
        	ProductView.setName("MacBook Air");
        	MyUI.navi.navigateTo("product");
        });
        ma3.addClickListener(e -> {
        	ProductView.setName("MacBook Pro");
        	MyUI.navi.navigateTo("product");
        });
        ma4.addClickListener(e -> {
        	ProductView.setName("iMac");
        	MyUI.navi.navigateTo("product");
        });
        ma5.addClickListener(e -> {
        	ProductView.setName("iMac Pro");
        	MyUI.navi.navigateTo("product");
        });
        ma7.addClickListener(e -> {
            ProductView.setName("Mac mini");
            MyUI.navi.navigateTo("product");
        });
        ma6.addClickListener(e -> {
            ProductView.setName("Mac Pro");
            MyUI.navi.navigateTo("product");
        });
        
        bot1.setSizeFull();
        bot1.addComponents(macapple,aboutus,payment,contact,address,follow);
        bot1.setComponentAlignment(macapple, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(aboutus, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(payment, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(contact, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(address, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(follow, Alignment.TOP_CENTER);
        
        ThemeResource pa1 = new ThemeResource("img/visa.png");
        ThemeResource pa2 = new ThemeResource("img/wechatpay.png");
        ThemeResource pa3 = new ThemeResource("img/masterp.png");
        ThemeResource pa4 = new ThemeResource("img/unionp.png");        
        
        Image pvisa = new Image("",pa1);
        Image pwechat = new Image("",pa2);
        Image pmaster= new Image("",pa3);
        Image punion = new Image("",pa4);
        Label facebook = new Label();
        facebook.setIcon(VaadinIcons.FACEBOOK_SQUARE);
        Label twitter = new Label();
        twitter.setIcon(VaadinIcons.TWITTER);
                   
        
        pvisa.setWidth("107px");
        pvisa.setHeight("48px");
        pmaster.setWidth("107px");
        pmaster.setHeight("48px");
        punion.setWidth("107px");
        punion.setHeight("48px");
        pwechat.setHeight("48px");
        pwechat.setWidth("107px");
        
        ma.addComponents(macapp,ma1,ma2,ma3,ma4,ma5,ma6,ma7);
        ab.addComponents(about,ourteam,outstore,ote,ost);
        payop.addComponents(pvisa,pwechat);
        payop1.addComponents(pmaster,punion);
        pa.addComponents(pay,payop,payop1);
        ctus.addComponents(tfbt);
        co.addComponents(cont,ctus);
        ad.addComponents(add,adds);
        follus.addComponents(facebook,twitter);
        fo.addComponents(fol,follus);
        macapple.setContent(ma);
        aboutus.setContent(ab);
        payment.setContent(pa);
        contact.setContent(co);
        address.setContent(ad);
        follow.setContent(fo);
        
        bot1.addStyleName("nobor");
        follus.addStyleName("folus");
        macapple.addStyleName("panel_sty");
        aboutus.addStyleName("panel_sty");
        payment.addStyleName("panel_sty");
        contact.addStyleName("panel_sty");
        address.addStyleName("panel_sty");
        follow.addStyleName("panel_sty");
        bot1.addStyleName("panel_sty");
        ab.setStyleName("btsty");
        ma.setStyleName("btsty");
        ad.setStyleName("btsty");
        co.setStyleName("btsty");
        adds.setStyleName("btsty");
        bot1.addStyleName("botlabel");
        
        return bot1;
	}	

	public Layout botafin() {
		HorizontalLayout bot1 = new HorizontalLayout();
        HorizontalLayout payop = new HorizontalLayout();
        HorizontalLayout payop1 = new HorizontalLayout();
        HorizontalLayout follus = new HorizontalLayout();
        HorizontalLayout ctus = new HorizontalLayout();
        Panel macapple = new Panel();
        Panel aboutus = new Panel();
        Panel payment = new Panel();
        Panel contact = new Panel();
        Panel address = new Panel();
        Panel follow = new Panel();
        VerticalLayout ma = new VerticalLayout();
        VerticalLayout ab = new VerticalLayout();
        VerticalLayout pa = new VerticalLayout();
        VerticalLayout co = new VerticalLayout();
        VerticalLayout ad = new VerticalLayout();
        VerticalLayout fo = new VerticalLayout();
        Label macapp = new Label("MacStore");
        Label about = new Label("About Us");
        Button ourteam = new Button("Our Team");
        Button outstore = new Button("Our Store");
        Label pay = new Label("Payment Options");
        Label cont = new Label("Contact");
        Label add = new Label("Address");
        Label fol = new Label("Follow us");
        Button ma1 = new Button("MacBook");
        Button ma2 = new Button("MacBook Air");
        Button ma3 = new Button("MacBook Pro");
        Button ma4 = new Button("iMac");
        Button ma5 = new Button("iMac Pro");
        Button ma6 = new Button("Mac Pro");
        Button ma7 = new Button("Mac mini");
        Button tfbt = new Button("Macapple@163.com");
        Button adds = new Button("Jinan University Panyu Campus");
        
        bot1.setSizeUndefined();
        macapple.setSizeUndefined();
        aboutus.setSizeUndefined();
        payment.setSizeUndefined();
        contact.setSizeUndefined();
        address.setSizeUndefined();
        follow.setSizeUndefined();
        payop.setSizeUndefined();
        payop1.setSizeUndefined();
        follus.setSizeUndefined();
        ma.setSizeUndefined();
        ab.setSizeUndefined();
        pa.setSizeUndefined();
        co.setSizeUndefined();
        ad.setSizeUndefined();
        fo.setSizeUndefined();
        
        ote.setHideOnMouseOut(false);
        ourteam.addClickListener(e -> {
            ote.setPopupVisible(true);
        });
        ost.setHideOnMouseOut(false);
        outstore.addClickListener(e -> {
            ost.setPopupVisible(true);
        });
        ma1.addClickListener(e -> {
        	ProductViewAfterlog.setName("MacBook");
        	MyUI.navi.navigateTo("productafin");
        });
        ma2.addClickListener(e -> {
        	ProductViewAfterlog.setName("MacBook Air");
        	MyUI.navi.navigateTo("productafin");
        });
        ma3.addClickListener(e -> {
        	ProductViewAfterlog.setName("MacBook Pro");
        	MyUI.navi.navigateTo("productafin");
        });
        ma4.addClickListener(e -> {
        	ProductViewAfterlog.setName("iMac");
        	MyUI.navi.navigateTo("productafin");
        });
        ma5.addClickListener(e -> {
        	ProductViewAfterlog.setName("iMac Pro");
        	MyUI.navi.navigateTo("productafin");
        });
        ma7.addClickListener(e -> {
            ProductViewAfterlog.setName("Mac mini");
            MyUI.navi.navigateTo("productafin");
        });
        ma6.addClickListener(e -> {
            ProductViewAfterlog.setName("Mac Pro");
            MyUI.navi.navigateTo("productafin");
        });
        
        bot1.setSizeFull();
        bot1.addComponents(macapple,aboutus,payment,contact,address,follow);
        bot1.setComponentAlignment(macapple, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(aboutus, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(payment, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(contact, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(address, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(follow, Alignment.TOP_CENTER);
        
        ThemeResource pa1 = new ThemeResource("img/visa.png");
        ThemeResource pa2 = new ThemeResource("img/wechatpay.png");
        ThemeResource pa3 = new ThemeResource("img/masterp.png");
        ThemeResource pa4 = new ThemeResource("img/unionp.png");        
        
        Image pvisa = new Image("",pa1);
        Image pwechat = new Image("",pa2);
        Image pmaster= new Image("",pa3);
        Image punion = new Image("",pa4);
        Label facebook = new Label();
        facebook.setIcon(VaadinIcons.FACEBOOK_SQUARE);
        Label twitter = new Label();
        twitter.setIcon(VaadinIcons.TWITTER);
                   
        
        pvisa.setWidth("107px");
        pvisa.setHeight("48px");
        pmaster.setWidth("107px");
        pmaster.setHeight("48px");
        punion.setWidth("107px");
        punion.setHeight("48px");
        pwechat.setHeight("48px");
        pwechat.setWidth("107px");
        
        ma.addComponents(macapp,ma1,ma2,ma3,ma4,ma5,ma6,ma7);
        ab.addComponents(about,ourteam,outstore,ote,ost);
        payop.addComponents(pvisa,pwechat);
        payop1.addComponents(pmaster,punion);
        pa.addComponents(pay,payop,payop1);
        ctus.addComponents(tfbt);
        co.addComponents(cont,ctus);
        ad.addComponents(add,adds);
        follus.addComponents(facebook,twitter);
        fo.addComponents(fol,follus);
        macapple.setContent(ma);
        aboutus.setContent(ab);
        payment.setContent(pa);
        contact.setContent(co);
        address.setContent(ad);
        follow.setContent(fo);
        
        bot1.addStyleName("nobor");
        follus.addStyleName("folus");
        macapple.addStyleName("panel_sty");
        aboutus.addStyleName("panel_sty");
        payment.addStyleName("panel_sty");
        contact.addStyleName("panel_sty");
        address.addStyleName("panel_sty");
        follow.addStyleName("panel_sty");
        bot1.addStyleName("panel_sty");
        ab.setStyleName("btsty");
        ma.setStyleName("btsty");
        ad.setStyleName("btsty");
        co.setStyleName("btsty");
        adds.setStyleName("btsty");
        bot1.addStyleName("botlabel");
        
        return bot1;
    }
	Button uBtn = new Button("User");
	public void enter(ViewChangeEvent e) {
	    if(MyUI.user != null) {
	        uBtn.setCaption(MyUI.user.getUsername());
	    }
	   
	}
}
