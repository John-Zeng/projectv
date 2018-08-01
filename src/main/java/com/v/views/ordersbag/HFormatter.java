package com.v.views.ordersbag;

import java.text.NumberFormat;
import java.util.Locale;

public class HFormatter {
    public HFormatter() {}
    
    public String formatSpec(String[] spec) {
        StringBuilder s = new StringBuilder("<b>Specifications</b>:<br><ul>");
        
        for (String i : spec) {
            s.append("<li>").append(i).append("</li>");
        }
        
        s.append("</ul>");
        
        return s.toString();
    }
    
    public String formatOpt(String opt) {
        StringBuilder s = new StringBuilder("<div style='margin-left: 20px;"
                + "border: 1px solid #888888; border-radius: 5px;"
                + "padding: 15px;'><div style='display: inline-block;"
                + "width: 70%;'><b>");
        
        s.append(opt).append("</b></div><div style='display: inline-block;"
                + "width: 30%; text-align: right'>");
        
        return s.toString();
    }
    
    public String addMoney(String s, double price, int i) {
        StringBuilder sb = new StringBuilder(s);
        return sb.append("- ").append(fmt.format(price)).append("</div></div>").toString();
    }
    
    public String addMoney(String s, double price) {
        StringBuilder sb = new StringBuilder(s);
        return sb.append("+ ").append(fmt.format(price)).append("</div></div>").toString();
    }
    
    public String removeMoney(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.append("</div></div>").toString();
    }
    
    NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
}
