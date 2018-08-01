package com.v.views.mainview;

import java.util.List;

import com.v.bean.Consumer;
import com.v.views.MyUI;
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
    public LoSi() {
    }

    public Layout signup() {
        VerticalLayout vlayout = new VerticalLayout();
        FormLayout form = new FormLayout();
        form.setSizeUndefined();
        HorizontalLayout hlayout = new HorizontalLayout(); /* Button */

        Label signupLabel = new Label("<b>Sign Up</b>", ContentMode.HTML);
        TextField email = new TextField("Email");
        TextField tel = new TextField("Phone");
        TextField username = new TextField("Username");
        username.setPlaceholder("Username");
        PasswordField password = new PasswordField("New password");
        password.setPlaceholder("New password");
        RadioButtonGroup<String> gender = new RadioButtonGroup<>("Gender");
        gender.setItems("Female", "Male");
        gender.addStyleName("horizontal");
        gender.setRequiredIndicatorVisible(true);
        Button create = new Button("Create");
        create.setStyleName(ValoTheme.BUTTON_PRIMARY);

        create.addClickListener(e -> {
            // Update database
            String un = username.getValue();
            Consumer user = MyUI.vservice.getUserByName(un);
            if(user == null) {
                Consumer nc = new Consumer();
                String salt = MyUI.vservice.genSalt();
                nc.setPassword(password.getValue());
                nc.setSalt(salt);
                String hashPwd = MyUI.vservice.hashPwd(nc);
                nc.setPassword(hashPwd);
                nc.setUsername(username.getValue());
                nc.setEmail(email.getValue());
                nc.setTelephone(tel.getValue());
                if (gender.getValue().equals("Male")) {
                    nc.setGender((byte) 1);
                } else {
                    nc.setGender((byte) 0);
                }
                System.out.println(MyUI.vservice.insertUser(nc));
                Page.getCurrent().reload();
            }else {
                Notification.show("User exsits");
            }
           
        });

        Button drop = new Button("Drop");
        hlayout.addComponents(create, drop);

        form.addComponents(username, password, email, tel, gender, hlayout);

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
        TextField username = new TextField("Username");
        username.setIcon(VaadinIcons.USER);
        PasswordField password = new PasswordField("Password");
        password.setIcon(VaadinIcons.PASSWORD);
        Button confirm = new Button("Confirm");
        confirm.setStyleName(ValoTheme.BUTTON_PRIMARY);
        Button forgot = new Button("Forgot");
        Link link = new Link("Need some help?", new ExternalResource("https://www.apple.com"));

        confirm.addClickListener(e -> {
            String un = username.getValue();
            if(un.equals("admin")) {
                MyUI.navi.navigateTo("admin");
            }else {
                Consumer user = MyUI.vservice.getUserByName(un);
                if(user == null) {
                    Notification.show("User Not Exist", Notification.Type.WARNING_MESSAGE);
                }else {
                    String salt = user.getSalt();
                    Consumer nc = new Consumer();
                    String pwd = password.getValue();
                    nc.setUsername(un);
                    nc.setPassword(pwd);
                    nc.setSalt(salt);
                    String hashpwd = MyUI.vservice.hashPwd(nc);
                    if(hashpwd.equals(user.getPassword())) {
                        MyUI.user = user;
                        MyUI.navi.navigateTo("userview");
                        Page.getCurrent().reload();
                    }else {
                        Notification.show("Password Invalid", Notification.Type.WARNING_MESSAGE);
                    }
                }
            }
            
        });

        forgot.addClickListener(e -> {
            new Notification("Tips:",
                    "<ul><li>Contact "
                            + "<a href='mailto:i@miss.you' style='text-decoration:none; color:#0069cc;'>me</a>"
                            + " ASAP</li><li>Create another account</li></ul>",
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