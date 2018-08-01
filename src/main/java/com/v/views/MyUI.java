package com.v.views;
import javax.servlet.annotation.WebServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.v.bean.Consumer;
import com.v.service.VService;
import com.v.views.admin.AdminView;
import com.v.views.mainview.Mainview;
import com.v.views.mainview.Userview;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.v.views.ordersbag.ProductView;
import com.v.views.ordersbag.ProductViewAfterlog;
import com.v.views.ordersview.Place_orderView;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class MyUI extends UI {

    public static Navigator navi;
    public static ApplicationContext ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    public static VService vservice = (VService)ac.getBean("vservice");
    public static Consumer user = null;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        getPage().setTitle("Mac Store");
        final VerticalLayout layout = new VerticalLayout();   
        navi = new Navigator(this, this);
        navi.addView("admin", new AdminView());
        navi.addView("product", new ProductView());
        navi.addView("userview", new Userview());
        navi.addView("productafin", new ProductViewAfterlog());
        navi.addView("order", new Place_orderView());
        navi.addView("", new Mainview());
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}