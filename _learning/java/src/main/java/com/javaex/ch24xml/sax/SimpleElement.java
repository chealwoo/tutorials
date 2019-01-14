package com.javaex.ch24xml.sax;

public class SimpleElement {
    StringBuffer text = new StringBuffer();

    public void addText(String s) {
        text.append(s);
    }

    public String getText() {
        return text.toString();
    }

    public void setAttributeValue(String name, String value) {
        System.out.println("name: " + name + "value: " + value);
//		throw new Error( getClass()+": No attributes allowed");
    }
}
