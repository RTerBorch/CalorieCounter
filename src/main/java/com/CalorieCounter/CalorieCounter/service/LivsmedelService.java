package com.CalorieCounter.CalorieCounter.service;

import com.CalorieCounter.CalorieCounter.model.Livsmedel;
import com.CalorieCounter.CalorieCounter.model.Naringsvarde;
import com.CalorieCounter.CalorieCounter.repository.LivsmedelRepository;


import org.springframework.stereotype.Service;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivsmedelService {

    private final LivsmedelRepository livsmedelRepository;


    private static final HashSet<String> INTRESSANT_NARINGSVARDE = new HashSet<>();
    // Intressanta värden
    static {
        INTRESSANT_NARINGSVARDE.add("Energi (kcal)");
        INTRESSANT_NARINGSVARDE.add("Fett");
        INTRESSANT_NARINGSVARDE.add("Protein");
        INTRESSANT_NARINGSVARDE.add("Kolhydrater");
    }


    public LivsmedelService(LivsmedelRepository livsmedelRepository) {
        this.livsmedelRepository = livsmedelRepository;
    }

    public void UpdateDB(boolean isTest) {

        Long livsmedelID;
        String livsmedelNamn;
        int livsmedelGram;

        Document document;
        // databas från dagens datum uppdatera senare tester som kollar ifall värdet är annorlunda
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateString = today.format(formatter);


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();


            //TODO Ta detta till en config fil sedan istället.
            if (isTest) {
                document = builder.parse(new File("C:\\Users\\robin\\OneDrive\\ProgramUtveckling\\JavaProjects\\CalorieCounter\\src\\test\\längreTestlista.XML"));
            } else {
                document = builder.parse("http://www7.slv.se/apilivsmedel/LivsmedelService.svc/Livsmedel/Naringsvarde/20230613");
            }
            document.getDocumentElement().normalize();
//"http://www7.slv.se/apilivsmedel/LivsmedelService.svc/Livsmedel/Naringsvarde/" + dateString
            // Makes a list of all livsmedel from api-document
            NodeList livsmedelList = document.getElementsByTagName("Livsmedel");

            // For every livsmedel (if it is an element)
            for (int i = 1; i < livsmedelList.getLength(); i++) {
                Node livsmedelNode = livsmedelList.item(i);


                if (livsmedelNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element livsmedelElement = (Element) livsmedelNode;


                    List<Naringsvarde> naringsvardenList = new ArrayList<>();
                    // Livsmedel element

                    livsmedelID = Long.parseLong(livsmedelElement.getElementsByTagName("Nummer").item(0).getTextContent());
                    livsmedelNamn = livsmedelElement.getElementsByTagName("Namn").item(0).getTextContent();
                    livsmedelGram = Integer.parseInt(livsmedelElement.getElementsByTagName("ViktGram").item(0).getTextContent());
                    Livsmedel nyttLivsmedel = new Livsmedel(livsmedelID,livsmedelNamn,livsmedelGram,naringsvardenList);

                    // Näringsvärden
                    NodeList NaringsvardenNodeList = livsmedelElement.getElementsByTagName("Naringsvarde");

                    // För varje näringsämne
                    for (int k = 0; k < NaringsvardenNodeList.getLength(); k++) {
                        Node naringsvardeNode = NaringsvardenNodeList.item(k);

                        if (naringsvardeNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element naringsvardeElement = (Element) naringsvardeNode;

                            String naringsvardeNamn = naringsvardeElement.getElementsByTagName("Namn").item(0).getTextContent();


                            if (INTRESSANT_NARINGSVARDE.contains(naringsvardeNamn)) {

                                // Formaterar för att lättare passa i DOUBLE
                                String stringVarde = naringsvardeElement.getElementsByTagName("Varde").item(0).getTextContent();
                                stringVarde = stringVarde.replace(",", ".");
                                Double varde = Double.parseDouble(stringVarde);

                                // Fungerar ej, autoGenererar istället id.
                              //  Long id = Long.parseLong(naringsvardeElement.getElementsByTagName("Nummer").item(0).getTextContent());
                                String namn = naringsvardeElement.getElementsByTagName("Namn").item(0).getTextContent();
                                String enhet = naringsvardeElement.getElementsByTagName("Enhet").item(0).getTextContent();

                               Naringsvarde naringsvarde = new Naringsvarde(namn, varde, enhet, nyttLivsmedel);
                              nyttLivsmedel.getNaringsvarden().add(naringsvarde);
                            }

                        }
                    }
                  livsmedelRepository.save(nyttLivsmedel);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }


    // Search LivsmedelDB with relevant returns. String search -> Exact match > Start with > Contains
    public List<Livsmedel> searchLivsmedel(String search) {
        String lowerSearch = search.toLowerCase();

        return livsmedelRepository.findAll().stream()
                .filter(livsmedel -> livsmedel.getNamn().toLowerCase().contains(lowerSearch))
                .sorted(Comparator.comparing((Livsmedel livsmedel) -> !livsmedel.getNamn().equalsIgnoreCase(search))
                        .thenComparing(livsmedel -> !livsmedel.getNamn().toLowerCase().startsWith(lowerSearch))
                        .thenComparing(Livsmedel::getNamn))
                .collect(Collectors.toList());
    }



    /*

    public List<Livsmedel> searchLivsmedel(String search){
      return  livsmedelRepository.findAll().stream().toList().stream().filter(livsmedel -> livsmedel.getNamn().contains(search.toLowerCase())).toList();
    }

     */

    public List<Livsmedel> allLivsMedel(){
        return livsmedelRepository.findAll().stream().toList();
    }




}
