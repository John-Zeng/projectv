package com.v.views.admin;

import java.util.ArrayList;
import java.util.List;

import com.v.bean.Consumer;
import com.v.bean.Customer;
import com.v.bean.Product;
import com.v.bean.RecordIns;
import com.v.service.CustomerService;

import com.v.views.MyUI;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class AdminView extends HorizontalLayout implements View {

    private Panel rp = new Panel();
    private CssLayout options = new CssLayout();
    private VerticalLayout storeFront = new VerticalLayout();
    private VerticalLayout consumers = new VerticalLayout();

    private TextField filtering = new TextField();
    private TextField consumerFiltering = new TextField();

    private Grid<Product> proGrid = new Grid<>(Product.class);
    private Grid<Consumer> consumerGrid = new Grid<>(Consumer.class);

    private List<Product> productsList = MyUI.vservice.getAllProduct();
    private List<Consumer> consumerList = MyUI.vservice.getAllConsumer();

    public AdminView() {
        init();
    }

    private void init() {

        addStyleName("adminView");
        setHeight("100%");

        setLeftPanel();
        setRightPanel();
        setRpContent(storeFront);
        addComponent(options);
        addComponent(rp);

    }

    private void setRightPanel() {
        setStoreFrontLayout();
        setConsumerLayout();
        rp.addStyleName("secondInCss");
    }

    private void setConsumerLayout() {
        HorizontalLayout toolBar = new HorizontalLayout();
        HorizontalLayout gridContainer = new HorizontalLayout();

        ConsumerForm csnmForm = new ConsumerForm(this);

        consumerFiltering.setWidth("300px");
        consumerFiltering.addStyleNames("bottom-line", ValoTheme.TEXTFIELD_INLINE_ICON);
        consumerFiltering.setIcon(VaadinIcons.SEARCH);
        consumerFiltering.setPlaceholder("Search");
        consumerFiltering.addValueChangeListener(e -> {
            updateConsumerList();
        });

        toolBar.addComponents(consumerFiltering);
        
        consumerGrid.setSizeFull();
        consumerGrid.setSizeFull();
        consumerGrid.setColumns("username", "telephone", "salt","password","email", "gender");
        consumerGrid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() == null) {
                csnmForm.setVisible(false);
            } else {
                csnmForm.setCsnm(event.getValue());
            }
        });

        gridContainer.addComponents(consumerGrid, csnmForm);
        gridContainer.setExpandRatio(consumerGrid, 1);
        gridContainer.setSizeFull();
        
        consumers.setSizeFull();
        consumers.addComponents(toolBar, gridContainer);
        
        csnmForm.setVisible(false);
        
        updateConsumerList();
    }

    private void setStoreFrontLayout() {
        HorizontalLayout toolBar = new HorizontalLayout();
        HorizontalLayout mainContent = new HorizontalLayout();
        ProForm proForm = new ProForm(this);
        Button addNewBtn = new Button();

        filtering.setWidth("300px");
        filtering.addStyleNames("bottom-line", ValoTheme.TEXTFIELD_INLINE_ICON);
        filtering.setIcon(VaadinIcons.SEARCH);
        filtering.setPlaceholder("Search");
        filtering.addValueChangeListener(e -> {
            updateList();
        });

        addNewBtn.addStyleName("addNewBtn");
        addNewBtn.setCaption("Add New");
        addNewBtn.setIcon(VaadinIcons.PLUS_CIRCLE);
        addNewBtn.addStyleNames(ValoTheme.BUTTON_PRIMARY);
        addNewBtn.addClickListener(e -> {
            consumerGrid.asSingleSelect().clear();
            proForm.setPro(new Product());
        });

        toolBar.addComponents(filtering, addNewBtn);

        mainContent.addComponents(proGrid, proForm);
        mainContent.setExpandRatio(proGrid, 1);
        mainContent.setSizeFull();

        proGrid.setSizeFull();
        proGrid.setColumns("name", "image", "price", "moreDesc");
        proGrid.asSingleSelect().addValueChangeListener(e -> {
            if (e.getValue() == null)
                proForm.setVisible(false);
            else
                proForm.setPro(e.getValue());
        });
        
        storeFront.setSizeFull();
        storeFront.addComponents(toolBar, mainContent);

        proForm.setVisible(false);
        updateList();

    }

    public void updateList() {
        List<Product> pdtsList = productsList;
        String filter = filtering.getValue();
        if (!(filter.equals("") && filter == null)) {
            pdtsList = new ArrayList<>();
            for (Product pro : productsList) {
                if (pro.toString().toLowerCase().contains(filter.toLowerCase())) {
                    pdtsList.add(pro);
                }
            }
            proGrid.setItems(pdtsList);
        }
    }

    public void setProList() {
        productsList = MyUI.vservice.getAllProduct();
        updateList();
    }

    public void updateConsumerList() {
        String filter = consumerFiltering.getValue();
        List<Consumer> conList = consumerList;
        if (!(filter.equals("") && filter == null)){
            conList = new ArrayList<>();
            for (Consumer cons : consumerList) {
                if(cons.toString().toLowerCase().contains(filter.toLowerCase()))
                    conList.add(cons);
            }
        } 
        consumerGrid.setItems(conList);
    }

    public void setCsnmList() {
        consumerList = MyUI.vservice.getAllConsumer();
        updateConsumerList();
    }

    private void setRpContent(VerticalLayout content) {
        rp.setContent(content);
        content.setWidth("1000px");
        rp.addStyleName("myPanel");
    }

    private void setLeftPanel() {
        Label vLabel = new Label("Seller");
        Button stfBtn = new Button();
        Button productsBtn = new Button();
        Button logoutBtn = new Button("Logout");

        vLabel.addStyleNames(ValoTheme.LABEL_H3, ValoTheme.TEXTAREA_ALIGN_CENTER);
        vLabel.setWidth("180px");
        vLabel.setHeight("50px");

        stfBtn.setCaption("StoreFront");
        stfBtn.setIcon(VaadinIcons.CART_O);
        stfBtn.addClickListener(e -> {
            setRpContent(storeFront);
        });

        productsBtn.setCaption("Consumers");
        productsBtn.setIcon(VaadinIcons.GIFT);
        productsBtn.addClickListener(e -> {
            setRpContent(consumers);
        });

        logoutBtn.setCaption("Logout");
        logoutBtn.setIcon(VaadinIcons.OUT);
        logoutBtn.addClickListener(e -> {
            MyUI.navi.navigateTo("");
        });

        options.setWidth("200px");
        options.addComponents(vLabel, stfBtn, productsBtn, logoutBtn);
        options.addStyleName("optionsPanel");
    }

}
