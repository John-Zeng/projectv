package com.v.views.ordersview;


import java.awt.Dialog;

import com.v.bean.Address;
import com.v.views.MyUI;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
public class Place_orderUnit {
	
public Place_orderUnit() {}

public Panel add_address(){
	Panel panel = new Panel("<center><b>Add new address</b></center>");
	panel.setWidth("430px");
    FormLayout form = new FormLayout();
    HorizontalLayout hor = new HorizontalLayout();
    

	TextField receiver = new TextField("Receiver name:");
	TextField phone = new TextField("Telephone: ");
	TextField address =  new TextField("Address:");
	TextField postcode = new TextField("Postcode:");
			
	Button clean = new Button("Clean");
	clean.addClickListener(e->{
		receiver.setValue("");
		phone.setValue("");
		address.setValue("");
		postcode.setValue("");
	});
	
	Button con=new Button("Save address");	
	con.addClickListener(e->{
		if(receiver.getValue()!="") {
			if(phone.getValue()!="") {
				if(address.getValue()!="") {
					if(postcode.getValue()!="") {
						String name = receiver.getValue();
						String tele = phone.getValue();
						String addr = address.getValue();
						String post = postcode.getValue();	
						//数据库操作(添加收件信息)
						Address newAddr = new Address();
						newAddr.setAddr(addr);
						newAddr.setPhone(tele);
						newAddr.setName(name);
						newAddr.setUsername(MyUI.user.getUsername());
						newAddr.setPostcode(post);
						newAddr.setAddrId(MyUI.vservice.genSalt());
						MyUI.vservice.insertAddr(newAddr);
						Page.getCurrent().reload();
					}else {
						Notification.show("Please input the postcode!");
					}																					
				}else {
						Notification.show("Please input the address!");
					}
			}else {
				Notification.show("Please input the telephone number!");
			}				
		}else {
				Notification.show("Please input the receiver name!");
			}
								
	});
	
	hor.addComponents(clean,con);
	
	form.addComponents(receiver,phone,address,postcode,hor);
	
	panel.setContent(form);
	panel.setStyleName("poppanel");
	return panel;
}



public Layout delivery() {
	VerticalLayout verlay = new VerticalLayout();
	HorizontalLayout hor1 = new HorizontalLayout();
	hor1.setSizeFull();
	HorizontalLayout hor2 = new HorizontalLayout();
	hor2.setSizeFull();
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	Panel p4 = new Panel();
	Panel p5 = new Panel();
	
	Label l1 =new Label("<b>When will I get my items?</b><br>"+
						"The 'Delivers' timeframe is an estimate of when<br>"+
						"your items will be delivered to your shipping<br>"+
						"address. This includes warehouse processing, <br>"+
						"or'Ship' timeframe, plus carrier delivery times.<br><br>"+
						"We’ll provide more information about dispatch<br>"+
						"options and delivery dates during the checkout<br>"+
						"process. ",ContentMode.HTML);
	
	Label l2 = new Label("<b>When will I receive text notifications?</b><br>" + 
						"In addition to email notifications, we will <br>"+
						"also send you text messages when your items  <br>"+
						"have shipped. Texts are sent between 8.00-21.00 <br>" + 
						"local time.To stop receiving text notifications,<br>"+
						"call an Apple Representative at 1800-1651-0525.",ContentMode.HTML);
	Label l3 = new Label("<b>How do I track my shipment?</b><br>" + 
						"As each item ships from our warehouse, <br>"+
						"we’ll send you a Shipment Notification <br>"+
						"email. Visit online Order Status to view<br>"+
						"the most up-to-date status of your order.",ContentMode.HTML);
	
	Label l4 = new Label("<b>When will I receive text notifications?</b><br>" + 
					"In addition to email notifications,<br>"+
					" we will also send you text messages<br>"+
					" when your items have shipped. Texts<br>"+
					" are sent between 8.00-21.00 local time.<br>" + 			 
					"To stop receiving text notifications, call<br>"+
					" an Apple Representative at 1800-1651-0525.",ContentMode.HTML );
		
	
	p1.setContent(l1);
	p2.setContent(l2);
	p3.setContent(l3);
	p4.setContent(l4);

	hor1.addComponents(p1,p2);
	hor1.setExpandRatio(p1, 1);
	hor1.setExpandRatio(p2, 1);
	hor1.setComponentAlignment(p1, Alignment.TOP_CENTER);
	hor1.setComponentAlignment(p2, Alignment.TOP_CENTER);
	
	hor2.addComponents(p3,p4);
	hor2.setExpandRatio(p3, 1);
	hor2.setExpandRatio(p4, 1);
	hor2.setComponentAlignment(p3, Alignment.TOP_CENTER);
	hor2.setComponentAlignment(p4, Alignment.TOP_CENTER);

	verlay.addComponents(hor1,hor2);
	verlay.setStyleName("infopanel");

	return verlay;
}

	public Layout pro_address() {
		
		VerticalLayout ver = new VerticalLayout();
		HorizontalLayout hor1 = new HorizontalLayout();
		hor1.setSizeFull();
		HorizontalLayout hor2 = new HorizontalLayout();
		
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		
		Label l1 = new Label("<b>Can I ship to multiple addresses?</b><br>" + 
				"Yes. Just select “Ship items to multiple addresses”<br>"+
				" next to Delivery Options, then enter an address for<br>"+
				" each item on your order. <br>" + 
				"When the item ships from our warehouse, we will email<br>"+
				" both you and the recipient with tracking information.<br>"+
				" You can also track your order using online Order Status. ",ContentMode.HTML);
		
		Label l2 = new Label("<b>How do I track my shipment?</b><br>" + 
					"Visit online Order Status to view the most<br>"+
					"up-to-date status of your order. If you ordered<br>"+
					"multiple items and have chosen to receive separate<br>"+
					"shipments, there will be no additional shipping charges.",ContentMode.HTML);
		
		
		Label l3 = new Label("<b>What if I will not be available to receive my shipment?</b><br>" + 
								"Most of our shipments contain valuable items, so our<br>"+
								"carriers are required to obtain a signature upon delivery.<br>" + 				
								"If you are unable to sign for delivery, the carrier will<br>"+
								"leave a calling card and we will notify you by email. You can<br>"+
								" then contact the carrier directly to schedule a new delivery <br>"+
								"appointment or alternatively amend your delivery address.",ContentMode.HTML);
		
		p1.setContent(l1);
		p2.setContent(l2);
		p3.setContent(l3);
		
		hor1.addComponents(p1,p2);
		hor1.setExpandRatio(p1, 1);
		hor1.setExpandRatio(p2, 1);
		hor1.setComponentAlignment(p1, Alignment.TOP_CENTER);
		hor1.setComponentAlignment(p2, Alignment.TOP_CENTER);
		
		hor2.addComponent(p3);
		hor2.setComponentAlignment(p3, Alignment.TOP_CENTER);
		ver.addComponents(hor1,hor2);
		ver.setStyleName("infopanel");
		
		return ver;
	}
	
	public Layout payment() {
		
		VerticalLayout ver=new VerticalLayout();
		HorizontalLayout hor1 = new HorizontalLayout();
		hor1.setSizeFull();
		HorizontalLayout hor2 = new HorizontalLayout();
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		
		Label l1 = new Label("<b>What payment methods can I use?</b><br>" + 
							"You can use a variety of payment options,<br>"+
							" including credit cards, debit cards and Apple <br>"+
							"Store Gift Cards for all shipment options.<br>" + 
							"Just call an Apple Representative at 1800-1651-0525<br>"+
							" for more information. ",ContentMode.HTML);
		
		
		Label l2 = new Label("<b>When will my credit card be charged?</b><br>" + 
							"When you place your order, Apple requests authorisation <br>"+
							"to charge the order amount from your credit card company.<br>"+
							"If you order more than one item,there may be multiple<br>"+				
							"authorisations based on item availability.Once we receive<br>" + 
							"approval, Apple reserves the amount on your card until the<br>"+
							"item(s) are available to ship. Your card will be charged <br>"+			
							"when your order is dispatched. If you order more than one item, <br>"+
							"there may be more multiple charges as items ship separately  <br>"+		
							"as they become available.",ContentMode.HTML);
		
		Label l3 =new Label("<b>When will I receive my invoice?</b><br>" + 
							"Your invoice(s) will be created when your order<br>"+
							" is shipped, not at the time of order. At that <br>"+
							"time your official Apple Invoice will be sent <br>"+
							"to the email address you provide when placing your<br>"+
							"order. If you order more than one item, there may<br>"+
							"be multiple invoices as items ship separately as<br>"+
							" they become available.<br>" + 
							"Multiple invoices cannot be changed to a single invoice.",ContentMode.HTML);
		
		p1.setContent(l1);
		p2.setContent(l2);
		p3.setContent(l3);
		
		hor1.addComponents(p1,p2);
		hor1.setExpandRatio(p1, 1);
		hor1.setExpandRatio(p2, 1);
		hor1.setComponentAlignment(p1, Alignment.TOP_CENTER);
		hor1.setComponentAlignment(p2, Alignment.TOP_CENTER);
		hor2.addComponent(p3);
		hor2.setComponentAlignment(p3, Alignment.TOP_CENTER);
		ver.addComponents(hor1,hor2);
		ver.setStyleName("infopanel");		
		return ver;
	}
	
	public String infoHtml(String name, String phone,String address) {
		StringBuilder s = new StringBuilder("<b>Receiver:</b>"+name
		+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
		+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
		+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
		+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
		+"<b>Telephone:</b>"+phone+"<br>"
		+"<b>Shipping Address:</b>"+address);	
		return s.toString();
	}
	
	public String desHtml(String name,String price) {
		StringBuilder s =new StringBuilder("&nbsp&nbsp&nbsp&nbsp&nbsp"
        					+"<b>"+name+"</b>"
        					+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
        					+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
        					+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
        					+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
        					+price+" x &nbsp1 "+"<br>"	
        					+"&nbsp&nbsp&nbsp&nbsp&nbsp"
        					+"<b>Free Shipping:&nbsp$0</b>");
		return s.toString();
		
	}
	
}



