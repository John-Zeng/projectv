package com.xxsen.ordersbag;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.text.NumberFormat;

public class BagUtils {
    public BagUtils(BagView bagView) {
        this.bagView = bagView;
    }
    
    public Panel leftPanel(String img) {
        Panel p = new Panel();
        ThemeResource resource = new ThemeResource(img); // add image
        Image i = new Image("", resource);
        i.setSizeFull();
        p.setContent(i);
        p.setSizeFull();
        p.addStyleName("leftpanel");
        return p;
    }

    public Panel rightPanel(String prod, int quan, float initPrice, String spec) {
        Panel p = new Panel();
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        VerticalLayout v = new VerticalLayout();
        HorizontalLayout h = new HorizontalLayout();
        Label product = new Label(prod); // add product
        product.setCaption("Product");

        ComboBox<Integer> qty = new ComboBox("Qty");
        qty.setItems(1, 2, 3, 4, 5);
        qty.setValue(quan); // add quantity
        qty.setEmptySelectionAllowed(false);

        Label price = new Label(quan * initPrice + ""); // add initial price
        price.setCaption("Price");
        h.addComponents(product, qty, price);
        h.setExpandRatio(product, 1);
        h.setExpandRatio(qty, 2);
        h.setExpandRatio(price, 1);
        h.setSizeFull();

        t = BagView.price;
        qty.addValueChangeListener(e -> {
            oldValue = Float.parseFloat(price.getValue());
            newValue = qty.getValue() * initPrice;
            t = t - oldValue + newValue;
            price.setValue(qty.getValue() * initPrice + ""); // set price
            BagView.tprice.setValue("<b>Total: " + fmt.format(t) + "</b>"); // set total price
        });

        Button b = new Button("Show product details");
        b.setStyleName(ValoTheme.BUTTON_LINK);
        b.setIcon(VaadinIcons.ANGLE_DOWN);

        Label l = new Label(spec, ContentMode.HTML); // add specification
        l.addStyleName("spec");
        l.setSizeFull();
        l.setVisible(false);

        b.addClickListener(e -> {
            if (l.isVisible()) {
                b.setCaption("Show product details");
                b.setIcon(VaadinIcons.ANGLE_DOWN);
                l.setVisible(false);
            } else {
                b.setCaption("Hide product details");
                b.setIcon(VaadinIcons.ANGLE_UP);
                l.setVisible(true);
            }
        });

        Button remove = new Button("Remove");

        remove.addClickListener(e -> {
            // remove a record
            
            ((Layout) p.getParent()).removeAllComponents();
        });

        remove.setStyleName(ValoTheme.BUTTON_DANGER);

        v.addComponents(h, b, l, remove);
        v.setComponentAlignment(remove, Alignment.MIDDLE_RIGHT);
        v.setSizeFull();

        p.setContent(v);
        p.setSizeFull();

        return p;
    }

    public void setRecord(String img, String prod, int quan, float initPrice, String spec) {
        record = new HorizontalLayout();
        Panel lp = leftPanel(img);
        Panel rp = rightPanel(prod, quan, initPrice, spec);
        record.addComponents(lp, rp);
        record.setExpandRatio(lp, 1);
        record.setExpandRatio(rp, 3);
        record.setSizeFull();
    }

    public HorizontalLayout getRecord() {
        return record;
    }
    
    public void setBagView(BagView bagView) {
        this.bagView = bagView;
    }
    
    public BagView getBagView() {
        return bagView;
    }
    
   
    
    private BagView bagView;
    private HorizontalLayout record;
    private float oldValue, newValue, t;
}