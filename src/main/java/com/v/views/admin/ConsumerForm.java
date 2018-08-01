package com.v.views.admin;

import com.v.bean.Consumer;
import com.v.views.MyUI;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ConsumerForm extends VerticalLayout {
    private TextField email = new TextField("Email");
    private TextField telephone = new TextField("Telephone");
    private Button confirm = new Button("Confirm");
    private Button delete = new Button("delete");
    
    private AdminView adminView;
    private Binder<Consumer> binder = new Binder<>(Consumer.class);
    private Consumer csnm;
    
    public ConsumerForm(AdminView adminView) {
        
        this.adminView = adminView;
        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(confirm,delete);
        addComponents( email, telephone,buttons);

        confirm.setStyleName(ValoTheme.BUTTON_PRIMARY);
        confirm.setClickShortcut(KeyCode.ENTER);
        
        binder.bindInstanceFields(this);
    }
    
    private void delete() {
        MyUI.vservice.deleteConsumerByName(csnm.getUsername());
        setVisible(false);
        adminView.setCsnmList();
    }

    private void confirm() {
        if(csnm != null) {
            MyUI.vservice.updateConsumerByUsername(csnm);
            setVisible(false);
            adminView.setCsnmList();
        }
    }

    public void setCsnm(Consumer csnm) {
        this.csnm = csnm;
        binder.setBean(csnm);
        
        delete.setVisible(csnm.getUsername() != null);
        setVisible(true);
        
        confirm.addClickListener(e->{
            if(csnm.getUsername()!=null)  confirm();
         });
        delete.addClickListener(e->delete());
    }
}
