package cn.jn.MacUI;

import java.io.File;


import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
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
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.icons.*;


public class Mainview extends VerticalLayout implements View {

	public Mainview() {
        final Panel tg = new Panel();
        final Panel pics0 = new Panel();
        final Panel pics1 = new Panel();
        final Label label =new Label("Welcome to MacApple.");
        final Label mbl = new Label("MacBook");
        final Label mbal = new Label("MacBook Air");
        final Label mbpl = new Label("MacBook Pro");
        final Label iml = new Label("iMac");
        final Label impl = new Label("iMac Pro");
        final Label mpl = new Label("Mac Pro");
        final Label mml = new Label("Mac mini");
        final Button b1 = new Button("Sign up");
        final Button b2 = new Button("Login");
        final Button b3 = new Button("Cart");
        final Button b4 = new Button("Order");
        final HorizontalLayout bt = new HorizontalLayout();
        final HorizontalLayout navi = new HorizontalLayout();
        final HorizontalLayout pm1 = new HorizontalLayout();
        final HorizontalLayout pm2 = new HorizontalLayout();
        final HorizontalLayout pm3 = new HorizontalLayout();
        final HorizontalLayout pm4 = new HorizontalLayout();
        final HorizontalLayout bot1 = new HorizontalLayout();
        final HorizontalLayout payop = new HorizontalLayout();
        final HorizontalLayout payop1 = new HorizontalLayout();
        final HorizontalLayout follus = new HorizontalLayout();
        final HorizontalLayout ctus = new HorizontalLayout();
        final Panel lab = new Panel();
        final Panel btt = new Panel();
        final Button picc1 = new Button();
        final Button picc2 = new Button();
        final Button picc3 = new Button();
        final Button picc4 = new Button();
        final Button picc5 = new Button();
        final Button picc6 = new Button();
        final Button picc7 = new Button();
        final Panel macapple = new Panel();
        final Panel aboutus = new Panel();
        final Panel payment = new Panel();
        final Panel contact = new Panel();
        final Panel address = new Panel();
        final Panel follow = new Panel();
        final Panel l1 = new Panel();
        
        final VerticalLayout ma = new VerticalLayout();
        final VerticalLayout ab = new VerticalLayout();
        final VerticalLayout pa = new VerticalLayout();
        final VerticalLayout co = new VerticalLayout();
        final VerticalLayout ad = new VerticalLayout();
        final VerticalLayout fo = new VerticalLayout();
        
        final Label macapp = new Label("Macapple");
        final Label about = new Label("About Us");
        final Button ourteam = new Button("Our Team");
        final Button outstore = new Button("Our Store");
        final Label pay = new Label("Payment Options");
        final Label cont = new Label("Contact");
        final Label add = new Label("Address");
        final Label fol = new Label("Follow us");
        final Button ma1 = new Button("Macbook");
        final Button ma2 = new Button("Macbook Air");
        final Button ma3 = new Button("Macbook Pro");
        final Button ma4 = new Button("iMac");
        final Button ma5 = new Button("iMac Pro");
        final Button ma6 = new Button("Mac Pro");
        final Button ma7 = new Button("Mac mini");
        final Button tfbt = new Button("Macapple@163.com");
        final Button adds = new Button("Jinan University Panyu Campus");
        
        setWidth("1920px");
        setHeightUndefined();
        navi.setSizeUndefined();
        pics0.setSizeUndefined();
        pics1.setSizeUndefined();
        l1.setSizeUndefined();
        
        picc1.setSizeUndefined();
        picc2.setSizeUndefined();
        picc3.setSizeUndefined();
        picc4.setSizeUndefined();
        picc5.setSizeUndefined();
        picc6.setSizeUndefined();
        picc7.setSizeUndefined();
        
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
        
        bt.addComponents(b1,b2,b3,b4);
        
       // AbsoluteLayout tags = new AbsoluteLayout();
        lab.setSizeUndefined();
        tg.setSizeUndefined();
        btt.setSizeUndefined();
        navi.setSizeFull();
        navi.addComponents(lab,tg,btt);
        navi.setExpandRatio(lab, 1);
        navi.setExpandRatio(tg, 2);
        navi.setExpandRatio(btt, 1);
        navi.setComponentAlignment(lab,Alignment.MIDDLE_CENTER);
        navi.setComponentAlignment(tg, Alignment.TOP_CENTER);
        navi.setComponentAlignment(btt, Alignment.MIDDLE_CENTER);
        pm1.setSizeFull();
        pm1.addComponents(picc1,picc2);
        pm1.setExpandRatio(picc1, 1);
        pm1.setExpandRatio(picc2, 1);
        pm1.setComponentAlignment(picc1, Alignment.MIDDLE_CENTER);
        pm1.setComponentAlignment(picc2, Alignment.MIDDLE_CENTER);
        pm2.setSizeFull();
        pm2.addComponents(picc3,picc4);
        pm2.setExpandRatio(picc3, 1);
        pm2.setExpandRatio(picc4, 1);
        pm2.setComponentAlignment(picc3, Alignment.MIDDLE_CENTER);
        pm2.setComponentAlignment(picc4, Alignment.MIDDLE_CENTER);
        pm3.setSizeFull();
        pm3.addComponents(picc5,picc6);
        pm3.setExpandRatio(picc5, 1);
        pm3.setExpandRatio(picc6, 1);
        pm3.setComponentAlignment(picc5, Alignment.MIDDLE_CENTER);
        pm3.setComponentAlignment(picc6, Alignment.MIDDLE_CENTER);
        pm4.setSizeFull();
        pm4.addComponent(picc7);
        pm4.setComponentAlignment(picc7, Alignment.MIDDLE_CENTER);
        bot1.setSizeFull();
        bot1.addComponents(macapple,aboutus,payment,contact,address,follow);
        bot1.setComponentAlignment(macapple, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(aboutus, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(payment, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(contact, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(address, Alignment.TOP_CENTER);
        bot1.setComponentAlignment(follow, Alignment.TOP_CENTER);
        
        
      
        addComponent(navi);
        //addComponent(label);
        //addComponent(bt);
        addComponent(pics0);
        addComponent(pics1);
        addComponent(pm1);
        addComponent(pm2);
        addComponent(pm3);
        addComponent(pm4);
        addComponent(bot1);
        
        ThemeResource r1 = new ThemeResource("macbook.svg");
        ThemeResource r2 = new ThemeResource("macbookair.svg");
        ThemeResource r3 = new ThemeResource("macbookpro.svg");
        ThemeResource r4 = new ThemeResource("macmini.svg");
        ThemeResource r5 = new ThemeResource("imac.svg");
        ThemeResource r6 = new ThemeResource("imacPro.svg");
        ThemeResource r7 = new ThemeResource("macpro.svg");
        ThemeResource r8 = new ThemeResource("apple.png");
        ThemeResource r9 = new ThemeResource("stuff.jpg");
        ThemeResource r10 = new ThemeResource("mac0.jpg");
        ThemeResource m1 = new ThemeResource("macbook.jpg");
        ThemeResource m2 = new ThemeResource("macbookair.jpg");
        ThemeResource m3 = new ThemeResource("macbookpro.jpg");
        ThemeResource m4 = new ThemeResource("macmini.jpg");
        ThemeResource m5 = new ThemeResource("imac.jpg");
        ThemeResource m6 = new ThemeResource("imacpro.jpg");
        ThemeResource m7 = new ThemeResource("macpro.jpg");
        ThemeResource pa1 = new ThemeResource("visa.png");
        ThemeResource pa2 = new ThemeResource("wechatpay.png");
        ThemeResource pa3 = new ThemeResource("masterp.png");
        ThemeResource pa4 = new ThemeResource("unionp.png");        
        
        
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

               
        Image pic1 = new Image("",r9);
        Image pic2 = new Image("",r10);
        
        Image pmacbook = new Image("",m1);
        Image pmacbookair = new Image("",m2);
        Image pmacbookpro = new Image("",m3);
        Image pmacmini = new Image("",m4);
        Image pimac = new Image("",m5);
        Image pimacpro = new Image("",m6);
        Image pmacpro = new Image("",m7);
        
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
        
        
        pic1.setSizeUndefined();
        pic2.setSizeUndefined();
        
        tg.setWidthUndefined();
        ma.addComponents(macapp,ma1,ma2,ma3,ma4,ma5,ma6,ma7);
        ab.addComponents(about,ourteam,outstore);
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
        
        
        tg.setStyleName("panel_sty");
        lab.setStyleName("panel_sty");
        btt.setStyleName("panel_sty");
        pics0.setStyleName("panel_sty");
        pics1.setStyleName("panel_sty");
        pm1.addStyleName("picbut");
        pm1.addStyleName("btsp");
        pm1.addStyleName("btspp");
        pm1.addStyleName("bticon");
        pm2.addStyleName("picbut");
        pm2.addStyleName("btsp");
        pm2.addStyleName("btspp");
        pm2.addStyleName("bticon");
        pm3.addStyleName("picbut");
        pm3.addStyleName("btsp");
        pm3.addStyleName("btspp");
        pm3.addStyleName("bticon");
        pm4.addStyleName("picbut");
        pm4.addStyleName("btsp");
        pm4.addStyleName("btspp");
        pm4.addStyleName("btminiicon");
        macapple.setStyleName("panel_sty");
        aboutus.setStyleName("panel_sty");
        payment.setStyleName("panel_sty");
        contact.setStyleName("panel_sty");
        address.setStyleName("panel_sty");
        follow.setStyleName("panel_sty");
        setStyleName("panel_sty");
        tg0.addStyleName("btsp");
        tg0.addStyleName("btspp");
        tg0.addStyleName("labsty");
        bt.setStyleName("btsty");
        ab.setStyleName("btsty");
        ma.setStyleName("btsty");
        ad.setStyleName("btsty");
        co.setStyleName("btsty");
        adds.setStyleName("btsty");
        tg.addStyleName("capsty");
        tg.addStyleName("panelwid");
        tg.addStyleName("space");
        tg.addStyleName("logosty");
        lab.setStyleName("taglabel");
        bot1.setStyleName("botlabel");
        lab.setContent(label);
        btt.setContent(bt);
        pics0.setContent(pic1);
        pics1.setContent(pic2);
        picc1.setIcon(m1);
        picc2.setIcon(m2);
        picc3.setIcon(m3);
        picc4.setIcon(m5);
        picc5.setIcon(m6);
        picc6.setIcon(m7);
        picc7.setIcon(m4);
        tg.setContent(tg0);
       // setContent(tags);



        
        
    }

}
