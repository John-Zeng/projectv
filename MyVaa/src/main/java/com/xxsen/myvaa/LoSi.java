package com.xxsen.myvaa;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.ContentMode;
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

public class LoSi {
    public LoSi() {}
    
    public Layout signup() {
        VerticalLayout vlayout = new VerticalLayout();
        FormLayout form = new FormLayout();
        form.setSizeUndefined();
        HorizontalLayout hlayout = new HorizontalLayout(); /* Button */
        
        Label signupLabel = new Label("<b>Sign Up</b>", ContentMode.HTML);
        TextField firstName = new TextField("First name");
        TextField lastName = new TextField("Last name");
        TextField mobileemail = new TextField();
        mobileemail.setPlaceholder("Mobile number or email");
        PasswordField password = new PasswordField();
        password.setPlaceholder("New password");
        DateField date = new DateField("Birthday");
        date.setDateFormat("yyyy-MM-dd");
        date.setPlaceholder("yyyy-mm-dd");
        RadioButtonGroup<String> gender = new RadioButtonGroup<>("Gender");
        gender.setItems("Female", "Male");
        gender.addStyleName("horizontal");
        
        Button create = new Button("Create");
        create.setStyleName(ValoTheme.BUTTON_PRIMARY);
        Button drop = new Button("Drop");
        hlayout.addComponents(create, drop);
        
        form.addComponents(firstName, lastName, mobileemail, password, date, gender, hlayout);
        
        vlayout.addComponents(signupLabel, form);
        vlayout.setStyleName("signupview");
        vlayout.setSizeUndefined();
        return vlayout;
    }
    
    public Layout login() {
        VerticalLayout vlayout = new VerticalLayout();
        HorizontalLayout hlayouttext = new HorizontalLayout();
        HorizontalLayout hlayoutbutton = new HorizontalLayout(); /* Button */
        
        Label loginLabel = new Label("<b>Log In</b>", ContentMode.HTML);
        TextField username = new TextField("Email or Phone");
        username.setIcon(VaadinIcons.USER);
        PasswordField password = new PasswordField("Password");
        password.setIcon(VaadinIcons.PASSWORD);
        Button confirm = new Button("Confirm");
        confirm.setStyleName(ValoTheme.BUTTON_PRIMARY);
        Button forgot = new Button("Forgot");
        Link link = new Link("Need some help?", new ExternalResource("https://www.apple.com"));
        
        confirm.addClickListener(e -> {
            if (username.getValue().equals("x")) {
                if (password.getValue().equals("x")) {
                    MyUI.navi.navigateTo("main");
                } else Notification.show("Password Invalid", Notification.Type.WARNING_MESSAGE);
            } else {
                Notification.show("User Not Exist", Notification.Type.WARNING_MESSAGE);
            }
        });
        
        forgot.addClickListener(e -> {
            new Notification("Tips:", "<ul><li>Contact " +
                    "<a href='mailto:i@miss.you' style='text-decoration:none; color:#0069cc;'>me</a>" +
                    " ASAP</li><li>Create another account</li></ul>",
                    Notification.Type.TRAY_NOTIFICATION, true).show(Page.getCurrent());
        });
        
        hlayouttext.addComponents(username, password);
        hlayoutbutton.addComponents(confirm, forgot);
        vlayout.addComponents(loginLabel, hlayouttext, hlayoutbutton, link);
        vlayout.setStyleName("loginview");
        vlayout.setSizeUndefined();
        return vlayout;
    }
}
