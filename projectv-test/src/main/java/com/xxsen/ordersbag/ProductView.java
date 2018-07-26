package com.xxsen.ordersbag;

import com.vaadin.navigator.View;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class ProductView extends VerticalLayout implements View {
    public ProductView() {
        init();
    }
    
    private void init() {
        Panel p = new Panel();
        p.setWidth("70%");
        p.setHeight("90%");
        
        AbsoluteLayout a = new AbsoluteLayout();
        
        Label price = new Label("$1,599.00");
        Button b = new Button("Add to Bag");
        b.setStyleName(ValoTheme.BUTTON_PRIMARY);
        
        a.addComponent(mainPanel(), "left: 20px; top: 20px; right: 20px; bottom: 100px");
        a.addComponent(price, "right: 20px; bottom: 70px");
        a.addComponent(b, "right: 20px; bottom: 20px");
        
        p.setContent(a);
        
        setSizeFull();
        addComponent(p);
        setComponentAlignment(p, Alignment.MIDDLE_CENTER);
    }
    
    public Panel mainPanel() {
        Panel p = new Panel();
        
        HorizontalLayout h = new HorizontalLayout();
        
        Panel lp = leftPanel(), rp = rightPanel();
        
        h.addComponents(lp, rp);
        h.setExpandRatio(lp, 1);
        h.setExpandRatio(rp, 2);
        h.setSizeFull();
        
        p.setContent(h);
        p.setSizeFull();
        return p;
    }
    
    public Panel leftPanel() {
        Panel p = new Panel();
        String s = "<b>Specifications</b>:<br>"
                + "<lu><li>1.4GHz dual-core 7th-generation Intel Core i7 processor, Turbo Boost up to 3.6GHz</li>"
                + "<li>16GB 1866MHz LPDDR3 memory</li>"
                + "<li>512GB SSD storage</li>"
                + "<li>Intel HD Graphics 615</li>"
                + "<li>Backlit Keyboard - US English</li></lu>";
        
        VerticalLayout v = new VerticalLayout();
        
        ThemeResource resource = new ThemeResource("macbook.jpeg");
        Image i = new Image("", resource);
        i.setSizeFull();
        
        Label name = new Label("<b>MacBook</b>", ContentMode.HTML);
        Label spec = new Label(s, ContentMode.HTML);
        spec.setSizeFull();
        
        v.addComponents(i, name, spec);
        v.setExpandRatio(i, 1);
        v.setComponentAlignment(name, Alignment.MIDDLE_CENTER);
        v.setExpandRatio(spec, 1);
        v.setSizeFull();
        
        p.setContent(v);
        p.setSizeFull();
        return p;
    }
    
    public Panel rightPanel() {
        Panel p = new Panel();
        
        VerticalLayout v = new VerticalLayout();
        
        
        ListSelect<String> processor = new ListSelect<>("Processor");
        processor.setItems("A", "B");
        processor.setSizeFull();
        processor.setHeight("80%");
        
        ListSelect<String> memory = new ListSelect<>("Memory");
        memory.setItems("A", "B");
        memory.setSizeFull();
        
        NativeSelect<String> keyboard = new NativeSelect<>("Keyboard Language");
        keyboard.setItems("Backlit Keyboard - US English", "Backlit Keyboard - Russian", "Backlit Keyboard - Japanese");
        
        v.addComponents(processor, memory, keyboard);
        v.setExpandRatio(processor, 2);
        v.setExpandRatio(memory, 2);
        v.setExpandRatio(keyboard, 1);
        
        v.setSizeFull();
        
        p.setContent(v);
        p.setSizeFull();
        return p;
    }
}
