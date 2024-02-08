/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laba7;
import java.io.*;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
public class Laba7 {
  
    static void zad2(){
       int[] arr = new int [4]; 
       Random r = new Random(); 
       for (int i=0; i<arr.length; i++) arr[i]=r.nextInt(10); 
      
       try (FileOutputStream fos = new FileOutputStream(("f1.dat"),false)){
         for (int i=0; i<arr.length; i++) fos.write(arr[i]);   
       }
       catch (IOException e){
         System.out.print(e.toString());
       }
    }
   
          static void zad3(){
          try (FileInputStream fis = new FileInputStream ("f1.dat")){
              int i; int count = 0; 
              while ((i = fis.read())!=-1) if (i>3) {    
                  count++; System.out.println(i);
              }
           System.out.println("количество равно - "+count);   
          }     
          
          catch (IOException e){
              System.out.println(e.toString());
          }
       }
        
        static void zad4(){
            String s = "Somebody text On english, I dont know, what i should write, but 65 67 ";
            
            try (FileOutputStream fos = new FileOutputStream(("f2.txt"),false) ){
                fos.write(s.getBytes());
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
            
            try (FileInputStream fis = new FileInputStream("f2.txt");
                  FileOutputStream fos = new FileOutputStream(("f3.txt"),false)){
               
               StringBuilder st = new StringBuilder(); 
               int i;
               while ((i=fis.read())!=-1) st.append((char)i); 
               String text = st.toString(); 
              
               Pattern p = Pattern.compile("\\s[a-z]+"); 
               Matcher m = p.matcher(text); 
               
               String match; 
               while (m.find()){
                   match = text.substring(m.start(), m.end()); 
                   fos.write(match.getBytes());
               }
               
               p = Pattern.compile("\\d+"); 
               m = p.matcher(text);
                while (m.find()){
                   match = text.substring(m.start(), m.end()); 
                   fos.write(match.getBytes());
               }
               
                p = Pattern.compile("[A-Z][a-z]*"); 
               m = p.matcher(text);
                while (m.find()){
                   match = text.substring(m.start(), m.end()); 
                   fos.write(match.getBytes());
               }   
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
        }
        
        static void zad5(){
         String list = "картошка, капуста, помидоры, огурцы#20 15 180 110 ";
         String prices = list.substring(list.indexOf("#")+1,list.length());
         list = list.substring(0, list.indexOf("#"));
         String[] food = list.split(",");
         String[] p= prices.split(" ");
        
         int[] price = new int[p.length]; 
         for (int i=0; i<price.length;i++) price[i]=Integer.parseInt(p[i]);
         int [] demoPrice = new int[p.length];
         for (int i=0; i<price.length;i++) demoPrice [i]=price[i]; 
         
         Arrays.sort(price);
         int index=0; 
         for(int i=0;i<price.length;i++){
          for (int j=0;j<demoPrice.length;j++) if (price[i]==demoPrice[j]) index = j; 
          System.out.println(food[index]+" - "+price[i]);
         }
         
        }
         
        static void zad6(){
            try (FileInputStream fis = new FileInputStream("sentence.txt");
                  FileOutputStream fos = new FileOutputStream(("sentence2.txt"),false)){
               StringBuilder st = new StringBuilder(); 
               int i;
               while ((i=fis.read())!=-1) st.append((char)i); 
               String text = st.toString(); 
                int index = text.indexOf("Masha");
              st.replace(index, index+5, "Nastya");
               text=st.toString(); 
               
               fos.write(text.getBytes());
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
        }
        
        static void zad7(){
            try (FileOutputStream fos = new FileOutputStream(("statistic.txt"),false)){
              String s = "A text file is given, statistics are calculated on it-the number ";
              byte[] data=s.getBytes();
              fos.write(data);
            }catch (IOException e){
                System.out.println(e.toString());
            }
            
            try(FileInputStream fis = new FileInputStream("statistic.txt")){
              StringBuilder st = new StringBuilder(); 
               int i;
               while ((i=fis.read())!=-1) st.append((char)i); 
               String text = st.toString(); 
               System.out.println("кол-во знаков-"+text.length());
               Pattern p = Pattern.compile("\\s"); 
               Matcher m = p.matcher(text);
               int count = 0;
               while(m.find()) count++; //посчитали кол-во пробелов
               System.out.println("кол-во знаков без пробелов"+(text.length()-count));
               
               p=Pattern.compile("[A-z]+");
               m = p.matcher(text);
               count = 0;
               while(m.find()) count++;  
               System.out.println("кол-во слов "+count); 
               
               p=Pattern.compile("\\.");
               m = p.matcher(text);
               count = 0;
               while(m.find()) count++;  
               System.out.println("кол-во предложений "+count); 
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
        }
        
      
        
        public static void zad8(){
          try(FileInputStream fis = new FileInputStream("C:\\Users\\gumil\\Downloads\\usnumbers.txt")){
              StringBuilder st = new StringBuilder(); 
               int i;
               while ((i=fis.read())!=-1) st.append((char)i); 
               String text = st.toString(); 
               String[] strs = text.split("\\n");
               double[] num = new double[strs.length];
               for(i = 0;i < strs.length;i++) num[i]=Double.parseDouble(strs[i]); 
               double max=0; double sum=0; int count=0;  double min =num[0];
               for(i = 0;i < num.length;i++){
                 if (num[i]>max) max = num[i];
                 if (num[i]<min) min = num[i];
                 sum += num[i]; count++;   
               }
               double mid = sum/count; 
               System.out.println(min+" " + max +" " + mid); 
  

          }
           catch (IOException e){
                System.out.println(e.toString());
            }
        }
    
    
    
    public static void main(String[] args) {
    zad8();     
    //zad3();
    //zad6();
    }
}