package com.v.views.ordersbag;

import com.v.views.MyUI;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import java.text.NumberFormat;
import java.util.Locale;

public class BagPopup {
    public BagPopup() {
        this.body = new VerticalLayout(); // VERY IMPORTANT
        this.checkout = new Button("Check Out");
    }
    
    public void setLeftPanel(String img) {
        lp = new Panel();
        ThemeResource resource = new ThemeResource(img); // add image
        Image i = new Image("", resource);
        i.setSizeFull();
        lp.setContent(i);
        lp.setSizeFull();
        lp.addStyleName("leftpanel");
    }
    
    public Panel getLeftPanel() {
        return lp;
    }
    
    public void setRightPanel(String prod, int quan, double initPrice, String spec, String rrid) {
        rp = new Panel();
        
        VerticalLayout v = new VerticalLayout();
        HorizontalLayout h = new HorizontalLayout();
        Label product = new Label(prod); // add product
        product.setCaption("Product");
        
        ComboBox<Integer> qty = new ComboBox("Qty");
        qty.setItems(1, 2, 3, 4, 5);
        qty.setValue(quan); // add quantity
        qty.setEmptySelectionAllowed(false);
        
        Label priceLabel = new Label(fmt.format(quan * initPrice)); // add initial price
        priceLabel.setCaption("Price");
        h.addComponents(product, qty, priceLabel);
        h.setExpandRatio(product, 1);
        h.setExpandRatio(qty, 2);
        h.setExpandRatio(priceLabel, 1);
        h.setSizeFull();
        
        totalValue = BagView.price; // get initial total price
        
        qty.addValueChangeListener(e -> {
            totalValue = (e.getValue() - e.getOldValue()) * initPrice + totalValue;
            priceLabel.setValue(fmt.format(e.getValue() * initPrice)); // set price of a product
            totalPriceLabel.setValue("<b>Total: " + fmt.format(totalValue) + "</b>"); // set total price
            
            // update database
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
        remove.setId(rrid);
        
        remove.addClickListener(e -> {
            totalValue = totalValue - qty.getValue() * initPrice;
            totalPriceLabel.setValue("<b>Total: " + fmt.format(totalValue) + "</b>"); // update total price
            
            body.removeComponent(v.getParent().getParent()); // remove a record
            if (body.getComponentCount() == 0) setEmpty();
            
            // update database
            
            MyUI.vservice.deleteById(remove.getId());
    
        });
        
        remove.setStyleName(ValoTheme.BUTTON_DANGER);
        
        v.addComponents(h, b, l, remove);
        v.setComponentAlignment(remove, Alignment.MIDDLE_RIGHT);
        v.setSizeFull();
        
        rp.setContent(v);
        rp.setSizeFull();
    }
    
    public Panel getRightPanel() {
        return rp;
    }
    
    public void setRecord(Panel lp, Panel rp) {
        record = new HorizontalLayout();
        record.addComponents(lp, rp);
        record.setExpandRatio(lp, 1);
        record.setExpandRatio(rp, 3);
        record.setSizeFull();
    }
    
    public HorizontalLayout getRecord() {
        return record;
    }
    
    public void setBody(HorizontalLayout record) {
        body.addComponent(record);  // add more records
    }
    
    public VerticalLayout getBody() {
        return body;
    }
    
    public void setFooter() {
        footer = new AbsoluteLayout();
        
        String initTotalPrice = fmt.format(BagView.price);
        totalPriceLabel = new Label("<b>Total: " + initTotalPrice + "</b>", ContentMode.HTML); // set initial total price
        checkout.setStyleName(ValoTheme.BUTTON_PRIMARY);
        
        checkout.addClickListener(e -> {
            // checkout
            MyUI.navi.navigateTo("order");
            
        });
        
        footer.addComponent(new Label("<b>Enjoy your life!</b>", ContentMode.HTML), "bottom: 15px; left: 30px");
        footer.addComponent(totalPriceLabel, "bottom: 15px; right: 180px");
        footer.addComponent(checkout, "bottom: 10px; right: 30px");
        footer.setSizeFull();
    }
    
    public AbsoluteLayout getFooter() {
        return footer;
    }
    
    public void setEmpty() {
        Label empty = new Label("<h2>Your Bag is Empty</h2>", ContentMode.HTML);
        body.addComponent(empty);
        body.setSizeFull();
        body.setComponentAlignment(empty, Alignment.MIDDLE_CENTER);
        checkout.setEnabled(false);
    }
    
    private Panel lp, rp;
    private Label totalPriceLabel;
    private Button checkout;
    
    private HorizontalLayout record;
    private VerticalLayout body;
    private AbsoluteLayout footer;
    
    private double totalValue;
    
    private NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
}