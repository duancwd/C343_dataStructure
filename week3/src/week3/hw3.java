package week3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hw3 {
	 public static Scanner s ;
	  public static ArrayList<String> sourselist;
	  public static  String inputstring ;
	  public static  String temp;
	  public static Hashtable<String, String> DNAtalble;
	  public static File f; 
	  public static  String DNA;
	
	public static void main(String [] args)throws Exception{
		
	 s = new Scanner(System.in);
	
	String str = s.next();
		sourselist = new  ArrayList<String>();
		DNAtalble = new Hashtable<String, String>();
		
		f=new File("F:/codon.txt"); 
		InputStreamReader read = new InputStreamReader(new FileInputStream(f),"GBK");   
		ArrayList<String> readList = new ArrayList<String>();   
		BufferedReader reader=new BufferedReader(read);  
		while((temp=reader.readLine())!=null &&!"".equals(temp)){   
			readList.add(temp);  
		}   
		readList.remove(0);
//System.out.println(readList);
		for(int i=0; i< readList.size();i++){
			inputstring = readList.get(i);
			inputstring  = inputstring.replaceAll("[^A-Za-z0-9*]", " ");
			StringTokenizer a = new  StringTokenizer(inputstring);
			
			while(a.hasMoreTokens()){
				String b = a.nextToken();
				if (b.length()== 1){
				   
					
					//System.out.print(" b= "+b);
					while(a.hasMoreTokens()){
						DNAtalble.put(a.nextToken(), b);
						
					}
				}
				//sourselist.add(a.nextToken());
			}
		}

	//System.out.println(sourselist)	;
	//System.out.println(DNAtalble);
	//0-3 3-5	

	//System.out.println(str);
		//System.out.println(str.length());
		
		for(int i= 0; i+3<=str.length(); i+=3){
			DNA= str.substring(i, i+3);
			//System.out.println(DNA);
			System.out.print(DNAtalble.get(DNA));
			}
		
	}
}
