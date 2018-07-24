package com.xxsen.myvaa;

import com.vaadin.navigator.View;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class StartView extends HorizontalLayout implements View {
    public StartView() {
        init();
    }
    
    private void init() {
        Panel pl = leftPanel(), pr = rightPanel();
        addComponents(pl, pr);
        setExpandRatio(pl, 1);
        setExpandRatio(pr, 1);
        setComponentAlignment(pl, Alignment.MIDDLE_CENTER);
        setComponentAlignment(pr, Alignment.MIDDLE_CENTER);
        setStyleName("startview");
        setSizeFull();
    }
    
    public Panel leftPanel() {
        Panel p = new Panel();
        HorizontalLayout v = new HorizontalLayout();
        v.addComponents(spop, lpop);
        p.setContent(v);
        p.setStyleName("leftpanel");
        p.setWidth("0");
        p.setHeight("0");
        return p;
    }
    
    public Panel rightPanel() {
        Panel p = new Panel();
        VerticalLayout v = new VerticalLayout();
        
        Label l = new Label("<h3>See what's happening in<br>"
                + "the world right now</h3>"
                + "<br>"
                + "<h4>Join us today.</h4>", ContentMode.HTML);
        
        spop.setHideOnMouseOut(false);
        Button signup = new Button("Sign Up");
        signup.setStyleName(ValoTheme.BUTTON_PRIMARY);
        signup.addClickListener(e -> {
            spop.setPopupVisible(true);
        });
        
        lpop.setHideOnMouseOut(false);
        Button login = new Button("Log In");
        login.addClickListener(e -> {
            lpop.setPopupVisible(true);
        });
        
        v.addComponents(l, signup, login);
        
        
        p.setContent(v);
        p.setStyleName("rightpanel");
        p.setSizeUndefined();
        return p;
    }
    
    private LoSi lsview = new LoSi();
    PopupView spop = new PopupView(null, lsview.signup());
    PopupView lpop = new PopupView(null, lsview.login());
}
