package com.example.wk9;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Location {
    private static Location loc = null;
    private ArrayList<Info> data;

    public static Location getInstance() {
        if (loc == null) {
            loc = new Location();
        }
        return loc;
    }

    public Location() {
        data = new ArrayList<Info>();
    }

    public void readXML() throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        String url = "https://www.finnkino.fi/xml/TheatreAreas/";
        Document doc = builder.parse(url);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");
        for (int i = 0; i< nList.getLength(); i++) {
            Node node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String id = element.getElementsByTagName("ID").item(0).getTextContent();
                String name = element.getElementsByTagName("Name").item(0).getTextContent();
                Info info = new Info(id, name);
                data.add(info);
            }
        }
    }

    public ArrayList<String> getLocationNames() {
        ArrayList<String> locations = new ArrayList<String>();
        for (int i = 0; i<data.size(); i++) {
            locations.add(data.get(i).name);

        }
        return locations;
    }
}
