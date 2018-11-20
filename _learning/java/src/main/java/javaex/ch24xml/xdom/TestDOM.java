package javaex.ch24xml.xdom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class TestDOM {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document document = parser.parse("zooinventory.xml");
        Element inventory = document.getDocumentElement();
        NodeList animals = inventory.getElementsByTagName("Animal");

        System.out.println("Animals = ");
        for (int i = 0; i < animals.getLength(); i++) {
            String name = DOMUtil.getSimpleElementText(
                    (Element) animals.item(i), "Name");
            String species = DOMUtil.getSimpleElementText(
                    (Element) animals.item(i), "Species");
            System.out.println("  " + name + " (" + species + ")");
        }

        Element foodRecipe = DOMUtil.getFirstElement(
                (Element) animals.item(1), "FoodRecipe");
        String name = DOMUtil.getSimpleElementText(foodRecipe, "Name");
        System.out.println("Recipe = " + name);
        NodeList ingredients = foodRecipe.getElementsByTagName("Ingredient");
        for (int i = 0; i < ingredients.getLength(); i++)
            System.out.println("  " + DOMUtil.getSimpleElementText(
                    (Element) ingredients.item(i)));
    }
}

