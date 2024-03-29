
/*********


http://www.saxproject.org/

SAX is the Simple API for XML, originally a Java-only API. 
SAX was the first widely adopted API for XML in Java, and is a �de facto� standard. 
The current version is SAX 2.0.1, and there are versions for several programming language environments other than Java. 



The following URL from Oracle is the JAVA documentation for the API

https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html


*********/

import org.xml.sax.InputSource;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;
import  java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
////////////////////////////////////////////////////////////

/**************

SAX parser use callback function  to notify client object of the XML document structure. 
You should extend DefaultHandler and override the method when parsin the XML document

***************/

////////////////////////////////////////////////////////////

public class SaxParser4BestDealXMLdataStore1 extends DefaultHandler{
	Tv tv;
	SoundSystem sound;
	Phone phone;
	Laptop laptop;
	VoiceAssistant voice;
	FitnessWatch fitness;
	SmartWatch smart;
	Headphones headphone;
	WirelessPlan wireless;
	Accessory accessory;
	
	static HashMap<String, Tv> tvs;
	static HashMap<String, SoundSystem> sounds;
	static HashMap<String, Phone> phones;
	static HashMap<String, Laptop> laptops;
	static HashMap<String, VoiceAssistant> voices;
	static HashMap<String, FitnessWatch> fitnesses;
	static HashMap<String, SmartWatch> smarts;
	static HashMap<String, Headphones> headphones;
	static HashMap<String, WirelessPlan> wirelesses;
	static HashMap<String, Accessory> accessories;
	
	String tvXmlFileName;
	HashMap<String, String> accessoryHashMap;
	String elementValueRead;
	String currentElement="";
	
	public SaxParser4BestDealXMLdataStore1() {
		
	}
	
	public SaxParser4BestDealXMLdataStore1(String tvXmlFileName) {
		this.tvXmlFileName = tvXmlFileName;
		tvs = new HashMap<String, Tv>();
		sounds = new HashMap<String, SoundSystem>();
		phones = new HashMap<String, Phone>();
		laptops = new HashMap<String, Laptop>();
		voices = new HashMap<String, VoiceAssistant>();
		fitnesses = new HashMap<String, FitnessWatch>();
		smarts = new HashMap<String, SmartWatch>();
		headphones = new HashMap<String, Headphones>();
		wirelesses = new HashMap<String, WirelessPlan>();
		accessories = new HashMap<String, Accessory>();
		parseDocument();
	}
	

    private void parseDocument() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(tvXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }

////////////////////////////////////////////////////////////

/*************

There are a number of methods to override in SAX handler  when parsing your XML document :

    Group 1. startDocument() and endDocument() :  Methods that are called at the start and end of an XML document. 
    Group 2. startElement() and endElement() :  Methods that are called  at the start and end of a document element.  
    Group 3. characters() : Method that is called with the text content in between the start and end tags of an XML document element.


There are few other methods that you could use for notification for different purposes, check the API at the following URL:

https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html

***************/

////////////////////////////////////////////////////////////

    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("tv")) {
        	currentElement = "tv";
            tv = new Tv();
            tv.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("sound")) {
        	currentElement = "sound";
        	sound = new SoundSystem();
        	sound.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("phone")) {
        	currentElement = "phone";
        	phone = new Phone();
        	phone.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("laptop")) {
        	currentElement = "laptop";
        	laptop = new Laptop();
        	laptop.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("voice")) {
        	currentElement = "voice";
        	voice = new VoiceAssistant();
        	voice.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("fitness")) {
        	currentElement = "fitness";
        	fitness = new FitnessWatch();
        	fitness.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("smart")) {
        	currentElement = "smart";
        	smart = new SmartWatch();
        	smart.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("headphone")) {
        	currentElement = "headphone";
        	headphone = new Headphones();
        	headphone.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("wireless")) {
        	currentElement = "wireless";
        	wireless = new WirelessPlan();
        	wireless.setId(attributes.getValue("id"));
        }
        if (elementName.equalsIgnoreCase("accessory")) {
        	currentElement = "accessory";
        	accessory = new Accessory();
        	accessory.setId(attributes.getValue("id"));
        }
        if (elementName.equals("accessory") &&  !currentElement.equals("tv"))
      	{
      			currentElement = "accessory";
      			accessory = new Accessory();
      			accessory.setId(attributes.getValue("id"));
      	}
       /* if (elementName.equals("accessory") &&  !currentElement.equals("laptop"))
      	{
      			currentElement = "accessory";
      			accessory = new Accessory();
      			accessory.setId(attributes.getValue("id"));
      	}*/
    }


    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {
 
        if (element.equals("tv")) 
        {
            tvs.put(tv.getId(),tv);
            return;
        }
        if(element.equals("sound")) 
        {
        	sounds.put(sound.getId(), sound);
        	return;
        }
        if(element.equals("phone")) 
        {
        	phones.put(phone.getId(), phone);
        	return;
        }
        if(element.equals("laptop")) 
        {
        	laptops.put(laptop.getId(), laptop);
        	return;
        }
        if(element.equals("voice")) 
        {
        	voices.put(voice.getId(), voice);
        	return;
        }
        if(element.equals("fitness")) 
        {
        	fitnesses.put(fitness.getId(), fitness);
        	return;
        }
        if(element.equals("smart")) 
        {
        	smarts.put(smart.getId(), smart);
        	return;
        }
        if(element.equals("headphone")) 
        {
        	headphones.put(headphone.getId(), headphone);
        	return;
        }
        if(element.equals("wireless")) 
        {
        	wirelesses.put(wireless.getId(), wireless);
        	return;
        }
        if (element.equals("accessory") && currentElement.equals("accessory")) {
			accessories.put(accessory.getId(),accessory);       
			return; 
        }
		if (element.equals("accessory") && currentElement.equals("tv")) 
		{
			accessoryHashMap.put(elementValueRead,elementValueRead);
		}
		if (element.equals("accessory") && currentElement.equals("laptop")) 
		{
			accessoryHashMap.put(elementValueRead,elementValueRead);
		}
      	if (element.equalsIgnoreCase("accessories") && currentElement.equals("tv")) {
			tv.setAccessories(accessoryHashMap);
			accessoryHashMap=new HashMap<String,String>();
			return;
		}
		/*if (element.equalsIgnoreCase("accessories") && currentElement.equals("laptop")) {
			laptop.setAccessories(accessoryHashMap);
			accessoryHashMap=new HashMap<String,String>();
			return;
		}*/

		if(element.equalsIgnoreCase("image")) {
			if(currentElement.equals("tv")) 
			{
				tv.setImage(elementValueRead);
			}
			if(currentElement.equals("sound"))
			{
				sound.setImage(elementValueRead);
			}
			if(currentElement.equals("phone")) 
			{
				phone.setImage(elementValueRead);
			}
			if(currentElement.equals("laptop")) 
			{
				laptop.setImage(elementValueRead);
			}
			if(currentElement.equals("voice")) 
			{
				voice.setImage(elementValueRead);
			}
			if(currentElement.equals("fitness")) 
			{
				fitness.setImage(elementValueRead);
			}
			if(currentElement.equals("smart")) 
			{
				smart.setImage(elementValueRead);
			}
			if(currentElement.equals("headphone")) 
			{
				headphone.setImage(elementValueRead);
			}
			if(currentElement.equals("wireless")) 
			{
				wireless.setImage(elementValueRead);
			}
			if(currentElement.equals("accessory")) 
			{
				accessory.setImage(elementValueRead);
			}
				return;		
		}
		if (element.equalsIgnoreCase("discount")) {
            if(currentElement.equals("tv")) 
            {
				tv.setDiscount(Double.parseDouble(elementValueRead));
            }	
        	if(currentElement.equals("sound"))
        	{	
				sound.setDiscount(Double.parseDouble(elementValueRead));
        	}	
            if(currentElement.equals("phone"))
            {	
				phone.setDiscount(Double.parseDouble(elementValueRead));
            }	
            if(currentElement.equals("laptop"))
            {	
				laptop.setDiscount(Double.parseDouble(elementValueRead));
            }
            if(currentElement.equals("voice"))
            {	
				voice.setDiscount(Double.parseDouble(elementValueRead));
            }
            if(currentElement.equals("fitness"))
            {	
				fitness.setDiscount(Double.parseDouble(elementValueRead));
            }
            if(currentElement.equals("smart"))
            {	
				smart.setDiscount(Double.parseDouble(elementValueRead));
            }
            if(currentElement.equals("headphone"))
            {	
				headphone.setDiscount(Double.parseDouble(elementValueRead));
            }
            if(currentElement.equals("wireless"))
            {	
				wireless.setDiscount(Double.parseDouble(elementValueRead));
            }
            if(currentElement.equals("accessory"))
            {	
				accessory.setDiscount(Double.parseDouble(elementValueRead));          
            }
				return;
	    }

		if (element.equalsIgnoreCase("condition")) {
            if(currentElement.equals("tv"))
            {
				tv.setCondition(elementValueRead);
            }
            if(currentElement.equals("sound"))
            {
				sound.setCondition(elementValueRead);
            }
            if(currentElement.equals("phone"))
            {
				phone.setCondition(elementValueRead);
            }
            if(currentElement.equals("laptop"))
            {
				laptop.setCondition(elementValueRead);
            }
            if(currentElement.equals("voice"))
            {
				voice.setCondition(elementValueRead);
            }
            if(currentElement.equals("fitness"))
            {
				fitness.setCondition(elementValueRead);
            }
            if(currentElement.equals("smart"))
            {
				smart.setCondition(elementValueRead);
            }
            if(currentElement.equals("headphone"))
            {
				headphone.setCondition(elementValueRead);
            }
            if(currentElement.equals("wireless"))
            {
				wireless.setCondition(elementValueRead);
            }
            if(currentElement.equals("acessory"))
            {
				accessory.setCondition(elementValueRead);
            }
			return;  
		}
		if (element.equalsIgnoreCase("manufacturer")) {
            if(currentElement.equals("tv"))
            {
				tv.setRetailer(elementValueRead);
            } 
            if(currentElement.equals("sound"))
            {
				sound.setRetailer(elementValueRead);
            }  
            if(currentElement.equals("phone"))
            {
				phone.setRetailer(elementValueRead);
            }  
            if(currentElement.equals("laptop"))
            {
				laptop.setRetailer(elementValueRead);
            } 
            if(currentElement.equals("voice"))
            {
				voice.setRetailer(elementValueRead);
            } 
            if(currentElement.equals("fitness"))
            {
				fitness.setRetailer(elementValueRead);
            } 
            if(currentElement.equals("smart"))
            {
				smart.setRetailer(elementValueRead);
            } 
            if(currentElement.equals("headphone"))
            {
				headphone.setRetailer(elementValueRead);
            } 
            if(currentElement.equals("wireless"))
            {
				wireless.setRetailer(elementValueRead);
            } 
            if(currentElement.equals("accessory"))
            {
				accessory.setRetailer(elementValueRead);
            } 
			return;
		}
		if (element.equalsIgnoreCase("name")) {
            if(currentElement.equals("tv"))
            {
				tv.setName(elementValueRead);
            } 
            if(currentElement.equals("sound"))
            {
				sound.setName(elementValueRead);
            } 
            if(currentElement.equals("phone"))
            {
				phone.setName(elementValueRead);
            } 
            if(currentElement.equals("laptop"))
            {
				laptop.setName(elementValueRead);
            }
            if(currentElement.equals("voice"))
            {
				voice.setName(elementValueRead);
            } 
            if(currentElement.equals("fitness"))
            {
				fitness.setName(elementValueRead);
            } 
            if(currentElement.equals("smart"))
            {
				smart.setName(elementValueRead);
            } 
            if(currentElement.equals("headphone"))
            {
				headphone.setName(elementValueRead);
            } 
            if(currentElement.equals("wireless"))
            {
				wireless.setName(elementValueRead);
            } 
            if(currentElement.equals("accessory"))
            {
				accessory.setName(elementValueRead);
            } 
			return;
	    }
		if(element.equalsIgnoreCase("price")){
			if(currentElement.equals("tv"))
			{
				tv.setPrice(Double.parseDouble(elementValueRead));
			}  
			if(currentElement.equals("sound"))
			{
				sound.setPrice(Double.parseDouble(elementValueRead));
			} 
			if(currentElement.equals("phone"))
			{
				phone.setPrice(Double.parseDouble(elementValueRead));
			} 
			if(currentElement.equals("laptop"))
			{
				laptop.setPrice(Double.parseDouble(elementValueRead));
			} 
			if(currentElement.equals("voice"))
			{
				voice.setPrice(Double.parseDouble(elementValueRead));
			} 
			if(currentElement.equals("fitness"))
			{
				fitness.setPrice(Double.parseDouble(elementValueRead));
			} 
			if(currentElement.equals("smart"))
			{
				smart.setPrice(Double.parseDouble(elementValueRead));
			}
			if(currentElement.equals("headphone"))
			{
				headphone.setPrice(Double.parseDouble(elementValueRead));
			}
			if(currentElement.equals("wireless"))
			{
				wireless.setPrice(Double.parseDouble(elementValueRead));
			}
			if(currentElement.equals("accessory"))
			{
				accessory.setPrice(Double.parseDouble(elementValueRead));
			}
			return;
        }

    }

    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }
	
  //call the constructor to parse the xml and get product details
   public static void addHashmap() {
  		String TOMCAT_HOME = System.getProperty("catalina.home");	
  		new SaxParser4BestDealXMLdataStore1(TOMCAT_HOME+"\\webapps\\app\\ProductCatalog.xml");
      } 

}
