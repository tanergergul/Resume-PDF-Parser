/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tanergergul
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class ResumePDFParser {

    public static void main(final String[] args) throws IOException, TikaException, SAXException {

        String dosyayolu = "/home/dawnsoldier/NetBeansProjects/JavaApplication1/src/javaapplication1/profile4.pdf";
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(new File(dosyayolu));
        ParseContext pcontext = new ParseContext();

        //PDF parser kullanarak dokuman parse ediliyor...
        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(inputstream, handler, metadata, pcontext);


        String kaynak = handler.toString();

        // okunan icerik diziye aktarılıyor
        String[] kaynaklar = kaynak.split("\n");
        // satır satır konsola yazdırılıyor
        /*
        for (int i = 0; i < kaynaklar.length; i++) {
            //System.out.println(i + " - " + kaynaklar[i] );
            
        }
        */

        ArrayList<String> iletisim = new ArrayList<>();
        ArrayList<String> yetenekler = new ArrayList<>();
        ArrayList<String> diller = new ArrayList<>();
        ArrayList<String> sertifikalar = new ArrayList<>();
        ArrayList<String> oduller = new ArrayList<>();
        ArrayList<String> deneyimler = new ArrayList<>();
        ArrayList<String> egitimler = new ArrayList<>();
        ArrayList<String> kisisel = new ArrayList<>();
        
      // iletişim bilgileri çekiliyor      
     for (int i = 0; i < kaynaklar.length; i++) {
           if(kaynaklar[i].contains("İletişim")){
               for (int j = i+1; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty()){
                   iletisim.add(kaynaklar[j]);
                   }
                   
                   if(!kaynaklar[j-1].contains("İletişim") && kaynaklar[j].isEmpty() ){
                       break;
                   }
               }
           }
           
           
       }
     
     // yeteneklerler çekiliyor
     
     for (int i = 0; i < kaynaklar.length; i++) {
           
           if(kaynaklar[i].contains("Yetenekler")){
               for (int j = i+1; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty()){
                   yetenekler.add(kaynaklar[j]);
                   }
                   
                   if(!kaynaklar[j-1].contains("Yetenekler") && kaynaklar[j].isEmpty() ){
                       break;
                   }
               }
           }
           
       }
     
     // diller çekiliyor
     
     for (int i = 0; i < kaynaklar.length; i++) {
           
           if(kaynaklar[i].contains("Languages")){
               for (int j = i+1; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty()){
                   diller.add(kaynaklar[j]);
                   }
                   
                   if(!kaynaklar[j-1].contains("Languages") && kaynaklar[j].isEmpty() ){
                       break;
                   }
               }
           }
           
       }
     
     
          // sertifikalar çekiliyor
     
     for (int i = 0; i < kaynaklar.length; i++) {
           
           if(kaynaklar[i].contains("Certifications")){
               for (int j = i+1; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty()){
                   sertifikalar.add(kaynaklar[j]);
                   }
                   
                   if(!kaynaklar[j-1].contains("Certifications") && kaynaklar[j].isEmpty() ){
                       break;
                   }
               }
           }
           
       }
     
     
          // ödüller çekiliyor
     
     for (int i = 0; i < kaynaklar.length; i++) {
           
           if(kaynaklar[i].contains("Awards")){
               for (int j = i+1; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty()){
                   oduller.add(kaynaklar[j]);
                   }
                   
                   if(!kaynaklar[j-1].contains("Awards") && kaynaklar[j].isEmpty() ){
                       break;
                   }
               }
           }
           
       }
     
          // deneyimler çekiliyor
     
     for (int i = 0; i < kaynaklar.length; i++) {
           
           if(kaynaklar[i].contains("Deneyim")){
               for (int j = i+1; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty()){
                   deneyimler.add(kaynaklar[j]);
                   }
                   if(kaynaklar[j+1].length()> 50){
                       j = j+2;
                   }
                   
                   if(kaynaklar[j+1].contains("Eğitim") && kaynaklar[j].isEmpty() ){
                       break;
                   }
               }
           }
           
       }
     
          // egitimler çekiliyor
     
     for (int i = 0; i < kaynaklar.length; i++) {
           
           if(kaynaklar[i].contains("Eğitim")){
               for (int j = i+1; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty() && !kaynaklar[j].contains("  Page") && !kaynaklar[j].contains("http") && !kaynaklar[j].contains("   ")){
                   egitimler.add(kaynaklar[j]);
                   }
                   
                  /* if(kaynaklar[j+1].contains("Page") && kaynaklar[j].isEmpty() ){
                       
                   }*/
               }
           }
           
       }
     
          // isim - meslek - sehir  cekiliyor
     
     for (int i = 0; i < kaynaklar.length; i++) {
           
           if(kaynaklar[i].contains("Özet")){
               for (int j = i-4; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty()){
                   kisisel.add(kaynaklar[j]);
                   }
                   
                   if(kaynaklar[j].isEmpty() ){
                       break;
                   }
               }
           }
           if(kisisel.isEmpty() && kaynaklar[i].contains("Deneyim")){
               for (int j = i-4; j < kaynaklar.length; j++) {
                   
                   if(!kaynaklar[j].isEmpty()){
                   kisisel.add(kaynaklar[j]);
                   }
                   
                   if(kaynaklar[j].isEmpty() ){
                       break;
                   }
               }
           }
           
       }
     

         
         
        System.out.println(iletisim);
        System.out.println(yetenekler);
        System.out.println(diller);
        System.out.println(sertifikalar);
        System.out.println(oduller);
        System.out.println(deneyimler);
        System.out.println(egitimler);
        System.out.println(kisisel);
        
        
        System.out.println("\n\n************************************************** ");
        System.out.println("\nKişisel Bilgiler \n----------------------------------\n");
        for (int i = 0; i < kisisel.size(); i++) {
            System.out.println(kisisel.get(i));
        }
        System.out.println("\nYetenekler \n----------------------------------\n");
        for (int i = 0; i < yetenekler.size(); i++) {
            System.out.println(yetenekler.get(i));
        }
        if(sertifikalar.size()>0)
        System.out.println("\nSertifikalar \n----------------------------------\n");
        for (int i = 0; i < sertifikalar.size(); i++) {
            System.out.println(sertifikalar.get(i));
        }
        if(diller.size()>0)
        System.out.println("\nDiller \n----------------------------------\n");
        for (int i = 0; i < diller.size(); i++) {
            System.out.println(diller.get(i));
        }
        if(oduller.size()>0)
        System.out.println("\nÖdüller \n----------------------------------\n");
        for (int i = 0; i < oduller.size(); i++) {
            System.out.println(oduller.get(i));
        }
        System.out.println("\nEğitim \n----------------------------------\n");
        for (int i = 0; i < egitimler.size(); i++) {
            System.out.println(egitimler.get(i));
            if(egitimler.get(i).contains("-")){
                System.out.println("");
            }
        }
        System.out.println("\nDeneyim \n----------------------------------\n");
        for (int i = 0; i < deneyimler.size(); i++) {
            System.out.println(deneyimler.get(i));
            if(deneyimler.get(i).contains("-") && deneyimler.get(i).matches(".*\\d+.*")){
                System.out.println("");
            }
        }
        System.out.println("\nİletişim Bilgileri \n----------------------------------\n");
        for (int i = 0; i < iletisim.size(); i++) {
            System.out.println(iletisim.get(i));
        }
        System.out.println("\n************************************************** ");
          
      // metadata içeriği konsola yazdırılıyor
      /*
      System.out.println("PDF Metadata:");
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) {
         System.out.println(name+ " : " + metadata.get(name));
      }
         */
    }
}
