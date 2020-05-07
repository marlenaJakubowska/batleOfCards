package com.codecool.battleofcards;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CardReader {

    private Document document;
    private final Deck deck;

    public CardReader() {
        this.deck = new Deck();
        readCards();
    }

    public void readXmlDoc(String path) {
        try {
            File file = new File(path);
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            this.document = docBuilder.parse(file);
            this.document.getDocumentElement().normalize();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void readCards() {

        this.readXmlDoc("cards.xml");
        NodeList nodeList = document.getElementsByTagName("Game");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            Element element = (Element) node;
            String name = element.getAttribute("name");
            Card card = new Card(name);
            this.deck.addCard(card);
            addCardStatsToCard(card, element);

        }
    }

    private void addCardStatsToCard(Card card, Element element) {
        Element attributesNode = (Element) element.getElementsByTagName("Attributes").item(0);
        NodeList attr = attributesNode.getElementsByTagName("Attr");
        for (int i = 0; i <attr.getLength(); i++) {
            Element attrElement = (Element) attr.item(i);
            String type = attrElement.getAttribute("type");
            float value = Float.parseFloat(attrElement.getTextContent());
            card.setCardStatByType(type, value);
        }
    }

    public Deck getDeck() {return this.deck;}

}
