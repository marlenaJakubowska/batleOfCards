//package com.codecool.battleofcards;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.IOException;
//import java.util.HashMap;
//
//public class XMLReader {
//    Document document;
//
//    public void readXMLDocument(String filePath) {
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//        {
//            try {
//                DocumentBuilder builder = factory.newDocumentBuilder();
//                this.document = builder.parse(filePath);
//                this.document.getDocumentElement().normalize();
//            } catch (ParserConfigurationException | SAXException | IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public void createCardsInDeckFromXMLData(Deck deck) {
//        NodeList gameList = document.getElementsByTagName("Game");
//
//        for (int gameIndex = 0; gameIndex < gameList.getLength(); gameIndex++) {
//            Node nodeGame = gameList.item(gameIndex);
//            if (nodeGame.getNodeType() == Node.ELEMENT_NODE) {
//                Element game = (Element) nodeGame;
//                String gameName = game.getAttribute("name");
//
//                NodeList attributeTagList = game.getChildNodes();
//                for (int attributeTagIndex = 0; attributeTagIndex<attributeTagList.getLength(); attributeTagIndex++){
//                    Node attributeTagNode = attributeTagList.item(attributeTagIndex);
//                    if(attributeTagNode.getNodeType()==Node.ELEMENT_NODE){
//                        Element attributeTag = (Element) attributeTagNode;
//                        NodeList dataList = attributeTag.getChildNodes();
//
//                        HashMap<String, Float> cardStats = new HashMap<>();
//                        for (int dataIndex = 0; dataIndex<dataList.getLength(); dataIndex++){
//                            Node nodeData = dataList.item(dataIndex);
//                            if (nodeData.getNodeType()==Node.ELEMENT_NODE){
//                                Element data = (Element) nodeData;
//                                cardStats.put(data.getAttribute("type"), Float.parseFloat(data.getTextContent()));
//                            }
//                        }
//                        Card card = new Card(gameName, cardStats);
//                        deck.addCard(card);
//                    }
//                }
//            }
//        }
//    }
//}
