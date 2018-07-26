package com.xxsen.ordersbag;

import com.vaadin.navigator.View;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PopupView;

public class StartView extends AbsoluteLayout implements View {
    public StartView() {
        init();
    }
    
    private void init() {
        HorizontalLayout h = new HorizontalLayout();
        BagView bagView = new BagView();
        
        PopupView op = new PopupView(null, o.ordersview());
        PopupView bp = new PopupView(null, bagView);
        op.setHideOnMouseOut(false);
        bp.setHideOnMouseOut(false);

        Button ordersBut = new Button("Orders");
        Button bagBut = new Button("Bag");
        Button prodBut = new Button("Product");
        
        ordersBut.addClickListener(e -> {
            op.setPopupVisible(true);
        });
        
        bagBut.addClickListener(e -> {
            bp.setPopupVisible(true);
        });
        
        prodBut.addClickListener(e -> {
            MyUI.navi.navigateTo("product");
        });
        
        op.setSizeFull();
        bp.setSizeFull();
        
        addComponent(op, "left: 50%; right: 50%; top: 50%; bottom: 50%;");
        addComponent(bp, "left: 50%; right: 50%; top: 50%; bottom: 50%;");
        h.addComponents(ordersBut, bagBut, prodBut);
        addComponent(h);
    }
    
    private OrdersPopup o = new OrdersPopup();
}
