package com.xxsen.ordersbag;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class BagView extends VerticalLayout {
    public BagView() {
        init();
    }

    private void init() {
        VerticalLayout items = new VerticalLayout();

        price = 0;

        for (int i = 0; i < 2; i++) {
            bag = l.get(i);
            price += (bag.getQuan() * bag.getInitPrice());
            bp.setRecord(bag.getImg(), bag.getProd(), bag.getQuan(), bag.getInitPrice(), bag.getSpec());
            items.addComponent(bp.getRecord()); // add more records
        }

        items.addStyleName("scrollv");

        AbsoluteLayout a = new AbsoluteLayout();
        tprice = new Label("<b>Total: " + NumberFormat.getCurrencyInstance().format(price) + "</b>", ContentMode.HTML); // set
        Button checkout = new Button("Check Out");
        checkout.setStyleName(ValoTheme.BUTTON_PRIMARY);

        checkout.addClickListener(e -> {
            // checkout
        });

        a.addComponent(new Label("<b>Enjoy your life!</b>", ContentMode.HTML), "bottom: 15px; left: 30px");
        a.addComponent(tprice, "bottom: 15px; right: 180px");
        a.addComponent(checkout, "bottom: 10px; right: 30px");
        a.setSizeFull();

        addComponents(items, a);
        setExpandRatio(items, 4);
        setExpandRatio(a, 1);
        setWidth("800");
        setHeight("500");
    }

    public List<Bag> datagen() {
        String i = "<b>Specifications</b>:<br>"
                + "<lu><li>1.4GHz dual-core 7th-generation Intel Core i7 processor, Turbo Boost up to 3.6GHz</li>"
                + "<li>16GB 1866MHz LPDDR3 memory</li>" + "<li>512GB SSD storage</li>"
                + "<li>Intel HD Graphics 615</li>" + "<li>Backlit Keyboard - US English</li></lu>";
        String j = "<b>Specifications</b>:<br>"
                + "<lu><li>2.2GHz dual-core Intel Core i7 processor, Turbo Boost up to 3.2GHz</li>"
                + "<li>8GB 1600MHz LPDDR3 memory</li>" + "<li>512GB SSD storage</li>"
                + "<li>Intel HD Graphics 6000</li>" + "<li>Backlit Keyboard - US English</li></lu>";
        List<Bag> l = new ArrayList();
        Bag a = new Bag(), b = new Bag();
        a.setImg("macbook.jpeg");
        a.setInitPrice(1949.00f);
        a.setProd("MacBook");
        a.setQuan(2);
        a.setSpec(i);
        b.setImg("macbookair.jpeg");
        b.setInitPrice(1549.00f);
        b.setProd("MacBook Air");
        b.setQuan(1);
        b.setSpec(j);

        l.add(a);
        l.add(b);

        return l;
    }

    private Bag bag;
    private List<Bag> l = datagen();
    private BagUtils bp = new BagUtils(this);
    public static Label tprice;
    public static float price;
}
