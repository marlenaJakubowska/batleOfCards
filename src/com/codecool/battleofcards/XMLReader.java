package com.codecool.battleofcards;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLReader {
    Document document;

    public void readXMLDocument(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        {
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                this.document = builder.parse(filePath);
                this.document.getDocumentElement().normalize();
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void createCardFromXMLData() {
        NodeList gameList = document.getElementsByTagName("Game");

        for (int gameIndex = 0; gameIndex < gameList.getLength(); gameIndex++) {
            Node nodeGame = gameList.item(gameIndex);
            if (nodeGame.getNodeType() == Node.ELEMENT_NODE) {
                Element game = (Element) nodeGame;
                System.out.println("Name: " + game.getAttribute("name"));
            }

        }
    }
}
