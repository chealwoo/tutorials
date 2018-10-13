package java.ch24.sax;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestModelBuilder 
{
	public static void main( String [] args ) throws Exception
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		XMLReader parser = saxParser.getXMLReader();
		SAXModelBuilder mb = new SAXModelBuilder();
		parser.setContentHandler( mb );

		parser.parse( new InputSource("zooinventory.xml") );
		Inventory inventory = (Inventory)mb.getModel();
		System.out.println("Animals = "+inventory.getAnimals());
		Animal cocoa = (Animal)(inventory.getAnimals().get(1));
		FoodRecipe recipe = cocoa.getFoodRecipe();
		System.out.println( "Recipe = "+recipe );
	}
}

