package pwj_zadanie01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PWJ_Zadanie01 {

   
    public static void main(String[] args) throws FileNotFoundException {
       Scanner input = new Scanner(System.in);
       
       
       System.out.print("Podaj liczbe z zakresu 1-100: ");
       int n = input.nextInt();
       if((n < 1) || (n > 100)){
           System.out.print("Blad. Niepoprawny zakres!!!");
       }else{
           int licznik=0;   //liczba imion żeńskich
           String imie,nazwisko;
           
           File plik = new File("imiona.txt");
           File plik2 = new File("nazwiska.txt");
           Scanner in = new Scanner(plik);
           Scanner in2 = new Scanner(plik2);
           
           String[] imie_k = new String[20];
           String[] nazwisko_k = new String[20];
               
           for(int i=0; i<20; i++){
               imie=in.nextLine();
               if(imie.endsWith("a") && !imie.equals("Jarema")){
                   imie_k[licznik]=imie;
                   //System.out.println(imie_k[licznik]);
                  licznik++;
               }
           }
            for(int i=0; i<20; i++){
                nazwisko=in2.nextLine();
                String[] parts = nazwisko.split(" ");
                nazwisko_k[i]=parts[1];
                //System.out.println(nazwisko_k[i]);
            
            }
            in.close();
            in2.close();
            
            PrintWriter zapis = new PrintWriter("szpieg.txt");
            for(int i =0; i<n; i++){
            //pesel
            Random r = new Random();
            
            int max = 991231;
            int min = 220101;
           
            Integer pesel_r;
            pesel_r = r.nextInt((max - min) + 1) + min;
            //System.out.println(pesel_r);
            String pesel = pesel_r.toString()+"12345";
            //System.out.println(PESEL);
            
            int imie_r = r.nextInt(licznik);
            //System.out.println(imie_r);
            int nazwisko_r = r.nextInt(20);
            //System.out.println(nazwisko_r);
            System.out.println(imie_k[imie_r] +" "+ nazwisko_k[nazwisko_r] + " " + pesel);
            
            
            zapis.println(imie_k[imie_r] +" "+ nazwisko_k[nazwisko_r] + " " + pesel);
            
            }
            zapis.close();
            
            
            
       }
    }
}