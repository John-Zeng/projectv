package cn.jn.MacUI;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.View;
import com.vaadin.server.FileResource;
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
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class Userview extends VerticalLayout implements View {

	public Userview() {
        final Panel tag = new Panel();
        final Panel pics0 = new Panel();
        final Panel pics1 = new Panel();
        final HorizontalLayout logo = new HorizontalLayout();
        final Label label =new Label("Welcome to MacApple.");
        final Button b1 = new Button("Name");
        final Button b2 = new Button("Logout");
        final Button b3 = new Button("Cart");
        final Button b4 = new Button("Order");
        final HorizontalLayout bt = new HorizontalLayout();
        final HorizontalLayout navi = new HorizontalLayout();
        final Panel lab = new Panel();
        final Panel btt = new Panel();
        
        setSizeUndefined();
        navi.setHeightUndefined();
        navi.setWidthUndefined();
        pics0.setSizeUndefined();
        pics1.setSizeUndefined();

        bt.addComponents(b1,b2,b3,b4);
        
       // AbsoluteLayout tags = new AbsoluteLayout();
        lab.setSizeUndefined();
        tag.setSizeUndefined();
        btt.setSizeUndefined();
        navi.setSizeFull();
        navi.addComponents(lab,tag,btt);
        navi.setExpandRatio(lab, 1);
        navi.setExpandRatio(tag, 2);
        navi.setExpandRatio(btt, 1);
        navi.setComponentAlignment(lab,Alignment.TOP_CENTER);
        navi.setComponentAlignment(tag, Alignment.TOP_CENTER);
        navi.setComponentAlignment(btt, Alignment.TOP_CENTER);
      
        addComponent(navi);
        //addComponent(label);
        //addComponent(bt);
        addComponent(pics0);
        addComponent(pics1);
               
        String basepath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        FileResource r1 = new FileResource(new File(basepath + "/WEB-INF/classes/macbook.svg"));
        FileResource r2 = new FileResource(new File(basepath + "/WEB-INF/classes/macbookair.svg"));
        FileResource r3 = new FileResource(new File(basepath + "/WEB-INF/classes/macbookpro.svg"));
        FileResource r4 = new FileResource(new File(basepath + "/WEB-INF/classes/macmini.svg"));
        FileResource r5 = new FileResource(new File(basepath + "/WEB-INF/classes/imac.svg"));
        FileResource r6 = new FileResource(new File(basepath + "/WEB-INF/classes/imacPro.svg"));
        FileResource r7 = new FileResource(new File(basepath + "/WEB-INF/classes/macpro.svg"));
        FileResource r8 = new FileResource(new File(basepath + "/WEB-INF/classes/apple.png"));
        FileResource r9 = new FileResource(new File(basepath + "/WEB-INF/classes/stuff.jpg"));
        FileResource r10 = new FileResource(new File(basepath + "/WEB-INF/classes/mac0.jpg"));
        
        Button ap = new Button();
        ap.setIcon(r8);
             
        Image macbook = new Image("Macbook",r1);       
        Image macbookair = new Image("Macbookair",r2);
        Image macbookpro = new Image("MacbookPro",r3);
        Image macmini = new Image("Macmini",r4);
        Image imac = new Image("iMac",r5);
        Image imacPro = new Image("iMacPro",r6);
        Image macpro = new Image("MacPro",r7);
        Image apple = new Image("",r8); 
        Image pic1 = new Image("",r9);
        Image pic2 = new Image("",r10);
        
        pic1.setSizeUndefined();
        pic2.setSizeUndefined();
        
        tag.setWidthUndefined();
        logo.addComponents(ap,macbook,macbookair,macbookpro,imac,imacPro,macpro,macmini);
        tag.setStyleName("panel_sty");
        lab.setStyleName("panel_sty");
        btt.setStyleName("panel_sty");
        pics0.setStyleName("panel_sty");
        pics1.setStyleName("panel_sty");
        setStyleName("panel_sty");
        bt.setStyleName("btsty");
        logo.setStyleName("btsty");
        tag.addStyleName("capsty");
        tag.addStyleName("panelwid");
        tag.addStyleName("space");
        tag.setContent(logo);
        lab.setContent(label);
        btt.setContent(bt);
        pics0.setContent(pic1);
        pics1.setContent(pic2);
       // setContent(tags);

        

        
        
    }

}
