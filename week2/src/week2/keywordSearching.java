package week2;
/*
 * 
 * @author chaoduan
 * 
 */

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;




public class keywordSearching {
	public static File f; 
	public static int ch; 
	public static String checkInput;
	public static int count;
	public static  String inputstring ;
	public static ArrayList<String> sourselist;
	public static  String temp;
	public static int w=0;
	
	public static void main(String [] args)throws Exception{ 
		sourselist = new  ArrayList<String>();
		
		f=new File("F:/tweet-candy-Jan20.txt"); 
		InputStreamReader read = new InputStreamReader(new FileInputStream(f),"GBK");   
		ArrayList<String> readList = new ArrayList<String>();   
		BufferedReader reader=new BufferedReader(read);    


		while((temp=reader.readLine())!=null &&!"".equals(temp)){   
			readList.add(temp);  
		}   

		for(int i=0; i< readList.size();i++){
			inputstring = readList.get(i);
			inputstring  = inputstring.replaceAll("[^A-Za-z0-9]", " ");
			StringTokenizer a = new  StringTokenizer(inputstring);
			while(a.hasMoreTokens()){
				sourselist.add(a.nextToken());
			}
		}
		OutputStream fos=new FileOutputStream("c:\\output.txt", false);   
	 
		for( int i = 0; i< sourselist.size(); i++){
			count =1;
			for(int j=i+1;j <sourselist.size(); j++){
				if(sourselist.get(i).equalsIgnoreCase(sourselist.get(j))){
					count = count+1;
					sourselist.remove(j);
				}
			}
			
			w=w+1;
			
			String str = "["+w+"] "+sourselist.get(i)+" "+count;
			     str+="\r\n";
			     str+="\r";
			     str+="\n";
			byte b[] = str.getBytes() ;
			fos.write(b) ;
		
			
			System.out.println( "["+w+"] "+sourselist.get(i)+" = "+count );
		}
		fos.close() ;
	}
}



