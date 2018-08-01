package com.v.views.admin;

import com.v.bean.Product;
import com.v.views.MyUI;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ProForm extends VerticalLayout {
    private TextField name = new TextField("name");
    private TextField image = new TextField("image");
    private TextArea moreDesc = new TextArea("moreDesc");
    private Button save = new Button("save");
    private Button delete = new Button("delete");

    private AdminView adminView;
    private Product pro;
    private Binder<Product> binder = new Binder<>(Product.class);

    public ProForm(AdminView adminView) {
        this.adminView = adminView;
        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        addComponents(name, image, moreDesc, buttons);

        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(KeyCode.ENTER);

        binder.bindInstanceFields(this);

    }

    public void setPro(Product pro) {
        this.pro = pro;
        binder.setBean(pro);

        delete.setVisible(pro != null);
        setVisible(true);
        save.addClickListener(e -> {
            if (pro != null)
                save();
        });
        delete.addClickListener(e -> delete());
    }

    private void delete() {
        MyUI.vservice.deleteProductByName(pro.getName());
        adminView.setProList();
        setVisible(false);
    }

    private void save() {
        System.out.println(pro);
        if (pro.getId() != null) {
            if (!pro.getName().equals(""))
                MyUI.vservice.updateProductById(pro);
        } else if(pro.getName() != null){
            Product pdc = MyUI.vservice.getProductByName(pro.getName());
            if (pdc == null && !pro.getName().equals("")) {
                pro.setPrice(1599);
                MyUI.vservice.insertProduct(pro);
            } 
        }

        adminView.setProList();
        setVisible(false);
    }
}
