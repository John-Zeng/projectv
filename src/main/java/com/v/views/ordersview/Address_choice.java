package com.v.views.ordersview;

import java.util.ArrayList;
import java.util.List;

import com.v.bean.Address;
import com.v.views.MyUI;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class Address_choice {
	public Address_choice() {}
	
	private static String num;
	
	public Panel addressPanel(){
		Panel p = new Panel();
		p.setSizeFull();
		
		VerticalLayout v = new VerticalLayout();
        HorizontalLayout plus =new HorizontalLayout();
        
        newaddress.setHideOnMouseOut(false);
        Button addreb =new Button();
        addreb.setIcon(VaadinIcons.PLUS_CIRCLE);  
        addreb.addClickListener(e->{
        	newaddress.setPopupVisible(true);
        });
        
        Label addl = new Label("<b>Add new address</b>",ContentMode.HTML);
        plus.addComponents(addreb,addl);
       // plus.setStyleName("infopanel");
        //orderv.addComponent(plus);
        
        List<String> numlist = new ArrayList();
        List<String> stringlist =new ArrayList();
        
        if(MyUI.user != null) {
            List<Address> addrList = MyUI.vservice.getAllAddrss(MyUI.user.getUsername());
            if(addrList != null) {
                for(Address addrItem: addrList) {
                    String name = addrItem.getName();
                    String phone = addrItem.getPhone();
                    String address = addrItem.getAddr();
                    String num = addrItem.getAddrId();
                    numlist.add(num);
                    stringlist.add(pop.infoHtml(name, phone, address));   
                }
            }
        }
        
        
        RadioButtonGroup<String> inforadio = new RadioButtonGroup<>("",stringlist);
        inforadio.setCaptionAsHtml(true);
        inforadio.setHtmlContentAllowed(true);
        inforadio.setSizeFull();
        
        
      
       //数据库读取（收件信息）
       //final int ind=0;
    /*    for(int i=0;i<3;i++) {
        	String name = new String("lct");
        	String phone = "12563488565";
        	String address = "my address";
        	String num = "235645";
        	numlist.add(num);
        	stringlist.add(pop.infoHtml(name, phone, address));      	
        }*/
       
       
        
//        stringlist.add(pop.infoHtml("a", "b", "c"));
//        numlist.add("z");
//        stringlist.add(pop.infoHtml("c", "b", "c"));
//        numlist.add("num");
//        stringlist.add(pop.infoHtml("a", "f", "c"));
//        numlist.add("n");
        
        
       
//        int	number = stringlist.size();
        if(stringlist.size() != 0) {
            inforadio.setItemCaptionGenerator(item->item);
            inforadio.setSelectedItem(stringlist.get(0));
            num=numlist.get(0);
            inforadio.addValueChangeListener(e->{
                int id = stringlist.indexOf(e.getValue());      
                num = numlist.get(id);
                //System.out.println(num + ", " + id);
                //System.out.println(e.getValue());
            });
        }
    
        v.addComponents(plus,inforadio,newaddress);
        v.setComponentAlignment(newaddress, Alignment.TOP_CENTER);
        v.setSizeFull();
        v.setStyleName("infopanel");
        p.setStyleName("infopanel");
        p.setContent(v);
  
		return p;
	}

	
	public String getNumber() {

		return num;
	}
	
	Place_orderUnit pop = new Place_orderUnit();
	PopupView newaddress = new PopupView(null,pop.add_address());
}
