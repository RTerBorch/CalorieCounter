package com.CalorieCounter.CalorieCounter;


import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MappingXMLTest {

    @Test
    void testXMLMapping() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("C:\\Users\\robin\\OneDrive\\ProgramUtveckling\\JavaProjects\\CalorieCounter\\src\\test\\LivsmedelDatasetXML.xml");
            document.getDocumentElement().normalize();

            NodeList livsmedelList = document.getElementsByTagName("Livsmedel");

            for (int i = 0; i < livsmedelList.getLength() - 1; i++) {
                Node livsmedel = livsmedelList.item(i);

                if (livsmedel.getNodeType() == Node.ELEMENT_NODE) {
                    Element livsmedelElement = (Element) livsmedel;

                    // Example assertion
                    assertEquals("Nöt talg", livsmedelElement.getElementsByTagName("Namn").item(0).getTextContent());
                    System.out.println(livsmedelElement.getElementsByTagName("Namn").item(0).getTextContent());

                    NodeList naringsvardenList = livsmedelElement.getElementsByTagName("Naringsvarde");

                    for (int j = 0; j < naringsvardenList.getLength(); j++) {
                        Node naringsvarde = naringsvardenList.item(j);

                        if (naringsvarde.getNodeType() == Node.ELEMENT_NODE) {
                            Element naringsvardeElement = (Element) naringsvarde;

                            // Another example assertion
                            if ("Mfet".equals(naringsvardeElement.getElementsByTagName("Forkortning").item(0).getTextContent())) {
                                assertEquals("35,8", naringsvardeElement.getElementsByTagName("Varde").item(0).getTextContent());
                            }
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void testXMLMapping2() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("C:\\Users\\robin\\OneDrive\\ProgramUtveckling\\JavaProjects\\CalorieCounter\\src\\test\\20230613.xml");
            document.getDocumentElement().normalize();

            NodeList livsmedelList = document.getElementsByTagName("Livsmedel");


            Node livsmedel = livsmedelList.item(0);

            if (livsmedel.getNodeType() == Node.ELEMENT_NODE) {
                Element livsmedelElement = (Element) livsmedel;

                // Example assertion
                assertEquals("Nöt talg", livsmedelElement.getElementsByTagName("Namn").item(0).getTextContent());
                System.out.println(livsmedelElement.getElementsByTagName("Namn").item(0).getTextContent());

                NodeList naringsvardenList = livsmedelElement.getElementsByTagName("Naringsvarde");

                for (int j = 0; j < naringsvardenList.getLength(); j++) {
                    Node naringsvarde = naringsvardenList.item(j);

                    if (naringsvarde.getNodeType() == Node.ELEMENT_NODE) {
                        Element naringsvardeElement = (Element) naringsvarde;

                        // Another example assertion
                        if ("Mfet".equals(naringsvardeElement.getElementsByTagName("Forkortning").item(0).getTextContent())) {
                            assertEquals("35,8", naringsvardeElement.getElementsByTagName("Varde").item(0).getTextContent());
                        }
                    }
                }
            }


        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testXMLMapping3() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("C:\\Users\\robin\\OneDrive\\ProgramUtveckling\\JavaProjects\\CalorieCounter\\src\\test\\LivsmedelDatasetXML.xml");
            document.getDocumentElement().normalize();

            NodeList livsmedelList = document.getElementsByTagName("Livsmedel");


            Node livsmedel = livsmedelList.item(0);
            System.out.println(livsmedel.getFirstChild());
            System.out.println("DWADWAPKDPAWKDPWAOPD");

            if (livsmedel.getNodeType() == Node.ELEMENT_NODE) {
                Element livsmedelElement = (Element) livsmedel;

                System.out.println(livsmedelElement.getElementsByTagName("Namn").item(0).getTextContent());
                System.out.println(livsmedelElement.getElementsByTagName("ViktGram").item(0).getTextContent());
                System.out.println(livsmedelElement.getElementsByTagName("Huvudgrupp").item(0).getTextContent());
                System.out.println(livsmedelElement.getElementsByTagName("Naringsvarden").item(0).getTextContent());
            }


        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void testarDetta() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("C:\\Users\\robin\\OneDrive\\ProgramUtveckling\\JavaProjects\\CalorieCounter\\src\\test\\längreTestlista.XML"));
            document.getDocumentElement().normalize();
            //http://www7.slv.se/apilivsmedel/LivsmedelService.svc/Livsmedel/Naringsvarde/20230613
            NodeList livsmedelList = document.getElementsByTagName("Livsmedel");

            for (int i = 0; i < livsmedelList.getLength(); i++) {
                Node livsmedel = livsmedelList.item(i);

                if (livsmedel.getNodeType() == Node.ELEMENT_NODE) {
                    Element livsmedelElement = (Element) livsmedel;

                    System.out.println("Namn: " + livsmedelElement.getElementsByTagName("Namn").item(0).getTextContent());
                    System.out.println("Vikt i gram: " + livsmedelElement.getElementsByTagName("ViktGram").item(0).getTextContent());
                    System.out.println("Huvudgrupp: " + livsmedelElement.getElementsByTagName("Huvudgrupp").item(0).getTextContent());

                    NodeList naringsvardenList = livsmedelElement.getElementsByTagName("Naringsvarde");
                    for (int k = 0; k < naringsvardenList.getLength(); k++) {
                    //    System.out.println();
                     //   System.out.println("Product nr: " + (k + 1));
                        Node naringsvardeNode = naringsvardenList.item(k);


                        if (naringsvardeNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element naringsvardeElement = (Element) naringsvardeNode;
                            String naringsvardeNamn = naringsvardeElement.getElementsByTagName("Namn").item(0).getTextContent();
                            String varde = naringsvardeElement.getElementsByTagName("Varde").item(0).getTextContent();
                            String enhet = naringsvardeElement.getElementsByTagName("Enhet").item(0).getTextContent();

                         //    System.out.println("Debug: Current Näringsvärde name is " + naringsvardeNamn);

                            switch (naringsvardeNamn) {
                                case "Energi (kcal)":

                                    System.out.println(naringsvardeNamn + ": " + varde + " " + enhet);
                                    break;
                                case "Fett":

                                    System.out.println(naringsvardeNamn + ": " + varde + " " + enhet);
                                    break;
                                case "Protein":

                                    System.out.println(naringsvardeNamn + ": " + varde + " " + enhet);
                                    break;
                                case "Kolhydrater":
                                    System.out.println(naringsvardeNamn + ": " + varde + " " + enhet);
                                    break;

                            }



                        }
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

}





