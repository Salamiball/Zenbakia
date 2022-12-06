package com.example.zenbakia;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Entschluesseln {
	
	private int KEY;	
	
	private String new_text = "";
	private String liste =  " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\nÄÖÜäöü"; //Leerzeichen muss am Anfang der Liste stehen
	
	private ArrayList<Integer> zahlen = new ArrayList();
	private ArrayList<String> back = new ArrayList(); 
	
	public String alg1(String text) {
		
		


		if(text == "") {
			return "Error 404 Text nicht gefunden";
		} else {
		try {
		text = alg3(text);	
		
		int lange=text.length();
		KEY = getKey(text, lange);
		text = text.substring(2,lange-2);
		
		if(text == "") {
			return "Ungeultiger Text";
		} else {
		
		
		text = alg2(text);				//Algo2 wird Entschluesselt
		
		int Valgo;
		String c = "";
		for(int i = 0; i < liste.length(); i++) {
			Valgo = (i + 400000 * 2 + (48* i) - (i * i + (98 * i))) + KEY; //Erstellen der Zahlen mit (KEY)
			
			zahlen.add(Valgo);
		}
		

		
		for(int i=0; i<text.length(); i+=6) {
	        c=text.substring(i,(i+6));
	        	back.add(c);
	        }
		 
		for(int i = 0; i < back.size(); i++) {
			String d = back.get(i);
			int d1 = Integer.parseInt(d);
			int dd = zahlen.indexOf(d1);
			char ddd = liste.charAt(dd);
			
			new_text += ddd;
		}

		return new_text;
		
		}
		} catch (Exception e) {
			return "Ungueltiger Code";
		}
		
	}
	}
	
	private String alg2(String text) { //setzt die vertauschten Zeichen wieder zuruck
		
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
	public String alg3(String text2) {
		
		ArrayList ls2 = new ArrayList();
		String temp2 = "";
		int getbonus = Integer.parseInt(text2.substring(text2.length()-1)); //holt den Bonus als Int Wert
		text2.replace(text2.substring(text2.length()-1), "");	//loescht den Bonus aus text
		
		int counter = 0;
		for(int i=0; i < text2.length();i++) {
			char a = text2.charAt(i);
			temp2 += a;

			if((temp2.length() == getbonus) && (i < getbonus) && (getbonus != 0)) { //fuer den Fall, dass die Zahl nicht durch 3 teilbar ist wird dafuer gesorgt, dass der Text wieder
				ls2.add(temp2);							  //in das richtige Format kommt. Bsp. f�r Fehler: aus 92372 wird [923,72] wird [72,923] wird 72923
				temp2 = "";								  //	  	          Problem beim entschluesseln: aus 72923 wird [729,23] wird [23,729] wird 23729
														  //								  92372 != 23729 deshalb bonus Variable sehr Wichtig
			}
			
			else if(temp2.length() == 3) { //fuegt alle 3 Zeichen einen Eintrag aus 3 Zeichen der Arraylist hinzu
				ls2.add(temp2);
				
				temp2 = "";
			}
			
		}
		
		ArrayList neu2 = new ArrayList();	///Entschluesseln
		
		int valgo32 = ls2.size();
		int count2 =1;
		for(int i=0; i < valgo32; i++) {
			
			if(i < valgo32 / 2) {
				neu2.add(ls2.get(i+1));
				ls2.remove(i+1);
			} else {
				neu2.add(ls2.get(ls2.size()- 1));
				ls2.remove(ls2.size()-1);
			}
			
			
		}
		String new_text2 = "";				//setzt die Arraylist in Ganzzahl um
		for(int i=0;i<neu2.size();i++) {
			new_text2 += neu2.get(i);
		}
		
		return new_text2;
	}
	
	private Integer getKey(String text, int lange) {	//holt sich den Schluessel aus text
		
		String k1=text.substring(0,2);
		String k2=text.substring(lange-2,lange);
		
		int Key = Integer.parseInt(k1 + k2);
		
		return Key;
	}
	
}