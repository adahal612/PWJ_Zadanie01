package pwj_zadanie01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class PWJ_Zadanie01 {
    public static void main(String[] args) throws FileNotFoundException {
       Scanner input = new Scanner(System.in);
       System.out.println("Program losowo generuje N danych osobowych kobiet:");
       System.out.println("Imie, nazwisko, pesel");
       System.out.println("Autor: Mateusz Jankie 96563");
       System.out.print("Podaj liczbe z zakresu 1-100: ");
       
       int n = input.nextInt();
       
       if((n < 1) || (n > 100)){
           System.out.println("Blad. Niepoprawny zakres!!!");
       }else{
           int licznik=0;   
           String imie,nazwisko;
           
           File plik = new File("imiona.txt");
           File plik2 = new File("nazwiska.txt");
           Scanner in2;
           String[] imie_k;
           String[] nazwisko_k;
           
           try (Scanner in = new Scanner(plik)) {
               in2 = new Scanner(plik2);
               imie_k = new String[20];
               nazwisko_k = new String[20];
               for(int i=0; i<20; i++){
                   imie=in.nextLine();
                   if(imie.endsWith("a") && !imie.equals("Jarema")){
                       imie_k[licznik]=imie;
                       licznik++;
                   }
               }   for(int i=0; i<20; i++){
                   nazwisko=in2.nextLine();
                   String[] parts = nazwisko.split(" ");
                   nazwisko_k[i]=parts[1];
               }
           }
            in2.close();
            System.out.println("Wylosowane dane osobowe:");
            
           try (PrintWriter zapis = new PrintWriter("szpieg.txt")) {
               for(int i =0; i<n; i++){
                   Random r = new Random();
                   
                   BigInteger max2 = new BigInteger("99123112345");
                   BigInteger min2 = new BigInteger("22010112345");
                   BigInteger zak = max2.subtract(min2);
                   
                   long zak2 = zak.longValue();
                   long min = min2.longValue();
                   long max = max2.longValue();

                   Long pesel_r;
                   pesel_r =(long) (Math.random()* ((max - min) + 1) + min );
                   String pesel = pesel_r.toString();                   
                   int imie_r = r.nextInt(licznik);
                   int nazwisko_r = r.nextInt(20);
                   
                   System.out.println((i+1) + " " + imie_k[imie_r] +" "+ nazwisko_k[nazwisko_r] + " " + pesel);
                   zapis.println(imie_k[imie_r] +" "+ nazwisko_k[nazwisko_r] + " " + pesel);               
               }
           }
           System.out.println("Dane zostaly zapisane do pliku: szpieg.txt");
       }
    }
}