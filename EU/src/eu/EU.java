
package eu;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EU {
 static List<String> adat = null;
 static List<LocalDate> datum = new ArrayList<>();
 static String[] darabok;
 static EuClass eu = new EuClass();
 static String fileSorai;
 static Map<String,LocalDate> adatok = new HashMap<>();
    
    public static void main(String[] args) {
        
        System.out.println("2.Feladat");
        
        
        upload(feltolt("eucsatlakozas.txt"));
        
        
        
        System.out.println("3.Feladat");

        
        System.out.println("EU tagállamainak száma: " + adatok.size());
        
        
        
        System.out.println("4.Feladat");
        
        
        int osszeg = 0;
         for (LocalDate value : adatok.values()) {
             if (value.getYear() == 2007) {
                 osszeg++;
             }
        }
         System.out.println("2007-ben " + osszeg + " ország csatlakozott");
         
         
         
         
         System.out.println("5.Feladat");

         
         System.out.println("Magyarország csatlakozásának dátuma: " + adatok.get("Magyarország"));
         
         
         
         
         System.out.println("6.Feladat");
         
         
         boolean majus = false;
         for (LocalDate value : adatok.values()) {
            if(value.getMonth() == Month.MAY){
                majus = true;
            }
        }
         if (majus) {
             System.out.println("Májusban volt csatlakozás");
        }
         else{
             System.out.println("Nem volt Májusban csatlakozás");
         }
        
         
         
         
         System.out.println("7.Feladat");
         
        
         for (LocalDate value : adatok.values()) {
            datum.add(value);
        }
         Collections.sort(datum);
         
         LocalDate a = datum.get(datum.size()-1);
         
        for (Map.Entry<String, LocalDate> actualPosition : adatok.entrySet()) {
            if (actualPosition.getValue().equals(a)) {
                System.out.println("Legutoljára csatlakozott ország: " + actualPosition.getKey());
            }
        }
        
        
        System.out.println("8.Feladat");
        
        
        Map<Integer,Integer> statisztika = new HashMap<>();
        
        int ev;
        for (LocalDate value : adatok.values()) {
            ev = value.getYear();
            if (!statisztika.containsKey(ev)) {
                statisztika.put(ev, 0);
            }
             int csatlakozottOrszagokSzamaAzEvben = statisztika.get(ev);
             statisztika.put(ev, csatlakozottOrszagokSzamaAzEvben + 1);
        }
        
        System.out.println("Statisztika");
        for (Map.Entry<Integer, Integer> entry : statisztika.entrySet()) {
             System.out.format("%d - %d ország\n", entry.getKey(), entry.getValue());
        }

      
    }
    
    
    
        public static List<String> feltolt(String uri){
        try {
            adat = Files.readAllLines(Paths.get(uri),Charset.defaultCharset());
        } catch (IOException ex) {
            System.out.println("Hiba: " + ex.getMessage());
        }
     return adat;
    }
    
    public static Map<String, String> upload(List<String> adat){
        boolean kihagy = false;
        for (String sor : adat) {
            
            if(!kihagy){
                kihagy = true;
                continue;
            }
            fileSorai= sor.replace(".","-");
            darabok = fileSorai.split(";");
            eu.setOrszag(darabok[0]);
            eu.setCsatlakozas(LocalDate.parse(darabok[1]));
            adatok.put(eu.getOrszag(),eu.getCsatlakozas());
        }
     return null;   
    }
}
