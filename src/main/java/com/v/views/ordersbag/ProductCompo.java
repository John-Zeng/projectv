package com.v.views.ordersbag;

import com.v.bean.Bag;
import com.v.bean.Memory;
import com.v.bean.Processor;
import com.v.bean.Product;
import com.v.bean.RecordWithBLOBs;
import com.v.views.MyUI;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ProductCompo {
    public void setLeftPanel(String img, String prod, String[] spec) {
        lp = new Panel();

        VerticalLayout v = new VerticalLayout();

        ThemeResource resource = new ThemeResource(img); // add image
        Image i = new Image("", resource);
        i.setSizeFull();

        Label prodLabel = new Label("<b>" + prod + "</b>", ContentMode.HTML); // add product
        specLabel = new Label(hfmt.formatSpec(spec), ContentMode.HTML); // add specification
        specLabel.setSizeFull();

        v.addComponents(i, prodLabel, specLabel);
        v.setExpandRatio(i, 1);
        v.setComponentAlignment(prodLabel, Alignment.MIDDLE_CENTER);
        v.setExpandRatio(specLabel, 1);

        lp.setContent(v);
        lp.setSizeFull();
    }

    public Panel getLeftPanel() {
        return lp;
    }

    public void setRightPanel(String[] options, double[] price) {
        rp = new Panel();

        VerticalLayout v = new VerticalLayout();

        String p1 = hfmt.formatOpt(options[0]);
        String p2 = hfmt.formatOpt(options[1]);
        String m1 = hfmt.formatOpt(options[2]);
        String m2 = hfmt.formatOpt(options[3]);

        RadioButtonGroup<String> processor = new RadioButtonGroup<>("<h3>Processor</h3>");
        processor.setCaptionAsHtml(true);
        processor.setHtmlContentAllowed(true);
        processor.setItems(p1, hfmt.addMoney(p2, price[0]));
        processor.setSelectedItem(p1);
        processor.setSizeFull();
        processor.setStyleName("selectx");

        processor.addValueChangeListener(e -> {
            // set total price & price & specification
            if (processor.isSelected(hfmt.addMoney(p1, price[0], 0))) {
                totalPrice = totalPrice - price[0];
                priceLabel.setValue("<b>" + fmt.format(totalPrice) + "</b>");

                processor.setItems(hfmt.removeMoney(p1), hfmt.addMoney(p2, price[0]));

                spec[0] = options[0].replaceAll("<br>", " ");
                setSpec(spec);
            } else if (processor.isSelected(hfmt.addMoney(p2, price[0]))) {
                totalPrice = totalPrice + price[0];

                priceLabel.setValue("<b>" + fmt.format(totalPrice) + "</b>");

                processor.setItems(hfmt.addMoney(p1, price[0], 0), hfmt.removeMoney(p2));
                spec[0] = options[1].replaceAll("<br>", " ");
                setSpec(spec);
            }
        });

        RadioButtonGroup<String> memory = new RadioButtonGroup<>("<h3>Memory</h3>");
        memory.setCaptionAsHtml(true);
        memory.setHtmlContentAllowed(true);
        memory.setItems(m1, hfmt.addMoney(m2, price[1]));
        memory.setSelectedItem(m1);
        memory.setSizeFull();
        memory.setStyleName("selectx");

        memory.addValueChangeListener(e -> {
            // set total price & price & specification
            if (memory.isSelected(hfmt.addMoney(m1, price[1], 0))) {
                totalPrice = totalPrice - price[1];
                priceLabel.setValue("<b>" + fmt.format(totalPrice) + "</b>");

                memory.setItems(hfmt.removeMoney(m1), hfmt.addMoney(m2, price[1]));

                spec[1] = options[2];
                setSpec(spec);
            } else if (memory.isSelected(hfmt.addMoney(m2, price[1]))) {
                totalPrice = totalPrice + price[1];
                priceLabel.setValue("<b>" + fmt.format(totalPrice) + "</b>");

                memory.setItems(hfmt.addMoney(m1, price[1], 0), hfmt.removeMoney(m2));

                spec[1] = options[3];
                setSpec(spec);
            }
        });

        ComboBox<String> keyboard = new ComboBox<>("<h3>Keyboard Language</h3>");
        keyboard.setCaptionAsHtml(true);
        keyboard.setItems("Backlit Keyboard - US English", "Backlit Keyboard - Russian", "Backlit Keyboard - Japanese");
        keyboard.setValue("Backlit Keyboard - US English");
        keyboard.setWidth("270");
        keyboard.setEmptySelectionAllowed(false);

        keyboard.addValueChangeListener(e -> {
            // set specification
            spec[4] = e.getValue();
            setSpec(spec);
        });

        v.addComponents(processor, memory, keyboard);
        v.setExpandRatio(processor, 2);
        v.setExpandRatio(memory, 2);
        v.setExpandRatio(keyboard, 1);

        v.setSizeFull();

        rp.setContent(v);
        rp.setSizeFull();
    }

    public Panel getRightPanel() {
        return rp;
    }

    public void setDetail(Panel lp, Panel rp) {
        detail = new HorizontalLayout();

        detail.addComponents(lp, rp);
        detail.setExpandRatio(lp, 1);
        detail.setExpandRatio(rp, 2);
        detail.setSizeFull();
    }

    public HorizontalLayout getDetail() {
        return detail;
    }

    public void setBody(HorizontalLayout detail, float initPrice) {
        body = new AbsoluteLayout();
        totalPrice = initPrice;
        priceLabel = new Label("<b>" + fmt.format(initPrice) + "</b>", ContentMode.HTML);
        Button addToBag = new Button("Add to Bag");
        addToBag.setStyleName(ValoTheme.BUTTON_PRIMARY);

        addToBag.addClickListener(e -> {
            // update database
            
            if(MyUI.user == null) {
                Notification.show("Please Log in first!", Notification.Type.WARNING_MESSAGE);
            }else {
                RecordWithBLOBs newRecord = new RecordWithBLOBs();
                String rid = MyUI.vservice.genSalt();
                newRecord.setrId(rid);
                newRecord.setPd(prod);
                newRecord.setPrice(totalPrice);
                newRecord.setNote(ProductCompo.spec[0]+"="+ ProductCompo.spec[1]+"="+ ProductCompo.spec[2]+"="+ ProductCompo.spec[3]+"="+ ProductCompo.spec[4]);
                MyUI.vservice.insertRecord(newRecord);
                
                Bag bag = new Bag();
                bag.setrId(rid); 
                bag.setUsername(MyUI.user.getUsername());
                
                MyUI.vservice.insertBag(bag);
                
                Page.getCurrent().reload();
            }
        });

        body.addComponent(detail, "left: 20px; top: 20px; right: 20px; bottom: 100px");
        body.addComponent(priceLabel, "right: 40px; bottom: 65px");
        body.addComponent(addToBag, "right: 20px; bottom: 20px");
    }

    public AbsoluteLayout getBody() {
        return body;
    }

    public void setSpec(String[] spec) {
        specLabel.setValue(hfmt.formatSpec(spec));
    }

    private Panel lp, rp;
    private Label priceLabel, specLabel;

    private HorizontalLayout detail;
    private AbsoluteLayout body;

    private HFormatter hfmt = new HFormatter();
    private NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);

    private double totalPrice;

    // datagen
    public static Product xp = ProductView.product;
    public static String prod = xp.getName();
    public static String img = "img/" + xp.getImage();
    public static float initPrice = xp.getPrice();
    public static String[] ms = xp.getMoreDesc().split("=");

    public static List<Memory> mmry = xp.getMemories();
    public static List<Processor> proc = xp.getProcessors();

    
    public static String[] spec = {
            proc.get(0).getPdesc().replaceAll("#", " "),
            mmry.get(0).getMdesc(),
            ms[2],
            ms[3],
            "Backlit Keyboard - US English" };

    public static String[] options = { proc.get(0).getPdesc().replaceAll("#", "<br>"), proc.get(1).getPdesc().replaceAll("#", "<br>"), mmry.get(0).getMdesc(),
            mmry.get(1).getMdesc() };
    public static double[] price = {proc.get(1).getPlPrice(), mmry.get(1).getPlPrice()};

    // public static String[] spec = {
    // "1.3GHz dual-core 7th-generation Intel Core i5 processor, Turbo Boost up to
    // 3.2GHz",
    // "8GB 1866MHz LPDDR3 memory",
    // "512GB SSD storage",
    // "Intel HD Graphics 615",
    // "Backlit Keyboard - US English"
    // };
    //
    // public static String[] options = {
    // "1.3GHz dual-core 7th-generation<br>Intel Core i5 processor,<br>Turbo Boost
    // up to 3.2GHz",
    // "1.4GHz dual-core 7th-generation<br>Intel Core i7 processor,<br>Turbo Boost
    // up to 3.6GHz",
    // "8GB 1866MHz LPDDR3 memory",
    // "16GB 1866MHz LPDDR3 memory"
    // };
    //
    // public static float[] price = {200f, 150f};
    //
    // public static String prod = "MacBook", img = "macbook.jpg";
    //
    // public static float initPrice = 1599f;
}
