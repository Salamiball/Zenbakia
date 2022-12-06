package com.example.zenbakia;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Verschluesseln {
	
	private int KEY = Key();
	private String new_text = "";
	private String liste =  " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\nÄÖÜäöü"; //Leerzeichen muss am Anfang der Liste stehen
	private ArrayList zahlen = new ArrayList();


	public String alg1(String text) {
		int Valgo;
		for(int i = 0; i < liste.length(); i++) {
			Valgo = (i + 400000 * 2 + (48* i) - (i * i + (98 * i))) + KEY; //Erstellen der Zahlen mit (KEY) am Ende
			
			zahlen.add(Valgo);
				
		}
		String k1 = Integer.toString(KEY);
		String k2 = k1.substring(2,4);
		k1=(k1.substring(0,2));
	
		for(int i = 0; i < text.length(); i++) {
			char a = text.charAt(i); 
			int b = liste.indexOf(a);
			new_text += zahlen.get(b);
		}
		
		if(new_text == "") {
			return "Error 404 Text nicht gefunden";
		} else {
			
			new_text = alg2(new_text); //alg2 mit Text aus alg 1 ausgefuert und zu new_text gemacht und ausgegeben
			new_text = k1 + new_text + k2;
			return alg3(new_text);
		}
			
	}
	
	public Integer Key() {	//Erstellt einen Random Schluessel
		Random r1 = new Random();
		int key = 1000 + r1.nextInt(8999);
		return key;
	}
	
	
	public String alg2(String text) {		//vertauscht einzelne Zeichen des Textes
		
		String temp="";
		String temp2="";

		    for(int i=0; i<text.length();i++) {
		        temp=text.substring(i,i+1);
		        
		        if(temp.charAt(0) =='8') {
		            temp2 += "5";

		        }else if(temp.charAt(0)=='4') {
		            temp2 += "6";

		        }else if(temp.charAt(0)=='6') {
		            temp2+="4";

		        }else if(temp.charAt(0)=='5') {
		            temp2 += "8";
		            }else {
		                temp2=temp2+text.substring(i,i+1);
		            }
		    }
		    
		return temp2;
	}
	public String alg3(String text) {
		ArrayList ls = new ArrayList();
		String temp = "";
		int bonus = 0;
		
		for(int i=0; i < text.length();i++) {
			char a = text.charAt(i);
			temp += a;
			
			if(temp.length() == 3) { //fuegt alle 3 Zeichen einen Eintrag aus 3 Zeichen der Arraylist hinzu
				ls.add(temp);
				temp = "";
			}
			else if((i == text.length() - 1) && (temp != "")) { //fuegt im Letzten Schleifen durchgang die uepringen Zeichen hinzu
				ls.add(temp);								//nur fuer den Fall, dass sich die gesammt Zahl nicht durch 3 teilen leasst.
				bonus = temp.length();
			}
		}
		
		ArrayList neu = new ArrayList();
		
		int valgo3 = ls.size();
		int count =1;
		
		for(int i=0; i < valgo3; i++) {
			
			if(count == 1) {
				neu.add(ls.get(ls.size()- 1)); 
				ls.remove(ls.size()-1);
				
			} if(count==2) {
				neu.add(ls.get(0));	
				ls.remove(0);
				count=0;
			}
			count+=1;
			
		}
		
		
		String new_text = "";				//setzt die Arraylist in Ganzzahl um
		for(int i=0;i<neu.size();i++) {
			new_text += neu.get(i);
		}
		new_text += String.valueOf(bonus); //bonus notwendig zum entschlusseln
		
		return new_text;
	}
	
}
