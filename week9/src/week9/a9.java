package week9;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;



public class a9 {
	private Vector<String> tweet;
	private Vector<String>  words;
	private Vector<Integer> count;
	
	public HashMap<String,ArrayList<Integer>> hashmap;
	
	
	public a9(){
		tweet = null;
		words = null;
		hashmap = new HashMap<String, ArrayList<Integer>>();
		
	}
	
	public a9(String inputFile){
		this();
		tweet = new Vector<String>(100,20);
		try{
			readFile(inputFile);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
	}
	public void readFile(String inputFile) throws FileNotFoundException{
		InputStream  in  = new FileInputStream(inputFile);
		
		Scanner scan = new Scanner(in);
		int lines = 1;
		while(scan.hasNext()){
			for (String s: scan.nextLine().split(" ")){
				ArrayList<Integer> temp = hashmap.get(s);
				if(temp == null){
					ArrayList<Integer> a  = new ArrayList<Integer>();
					a.add(lines);
					hashmap.put(s, a);
				}
				else if(temp!=null&&temp.get(temp.size()-1)!=lines){
					temp.add(lines);
					hashmap.put(s, temp);
					
				}
				
			}lines++;
		}scan.close();
		
	}
	
	public void display(){
		for(int i = 0; i< words.size();i++)
		System.out.println(words.elementAt(i)+" "+count.elementAt(i));
	}
	public void save2File(String outputFile){
		try{
			File file = new File(outputFile);
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			for(int i=0; i<words.size();i++)
				output.write(words.elementAt(i)+" "+count.elementAt(i)+"\n");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
 public static void main(String[] args){
	 a9 tweets = new a9("F:/docu.txt");
	 System.out.println("test 'in':"+tweets.hashmap.get("in").toString());
	 System.out.print("Please type a word(ex: data):");
	 Scanner s = new Scanner(System.in);
	 
	  String str = s.next();
	 System.out.println(str+":"+tweets.hashmap.get(str).toString());
	 
	 
 }
}
