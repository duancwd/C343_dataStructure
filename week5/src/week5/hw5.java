package week5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.StringTokenizer;





public class hw5 {
  private  static double inputX;
  private static double inputY;
  private  static double X;
  private  static double Y;
  public static File f; 
	public static int ch; 
	public static String checkInput;
	public static int count;
	public static  String inputstring ;
	public static ArrayList<String> sourselist;
	public static  String temp;
	public static int w=0;
	public static ArrayList<String> sourselist2;

  private static ArrayList<Line> linelist;
  private  static double Key=0;
  private  static double E;
  private static BinNode<Double, Double> BinNode;
  public static ArrayList<Double> maplist;
	
	public static void main(String [] args) throws IOException{
		linelist = new ArrayList<Line>();
		
		Key = 0;
sourselist = new  ArrayList<String>();
		
		f=new File("F:/map.txt"); 
		InputStreamReader read = new InputStreamReader(new FileInputStream(f),"GBK");   
		ArrayList<String> readList = new ArrayList<String>();   
		BufferedReader reader=new BufferedReader(read);    

	
		while((temp=reader.readLine())!=null &&!"".equals(temp)){   
			readList.add(temp);  
		}   
		//System.out.print("list =="+readList);

		for(int i=0; i< readList.size();i++){
			inputstring = readList.get(i);
			inputstring  = inputstring.replaceAll("[^A-Za-z0-9.]", " ");
			StringTokenizer a = new  StringTokenizer(inputstring);
			//System.out.println(i+"  "+a.countTokens());
			if(a.countTokens()== 4){
				while(a.hasMoreTokens()){
					sourselist.add(a.nextToken());
				}
			}
			
				
				
			}
			
	//	System.out.print("list =="+sourselist);
		
		for(int i=0; i+4<= sourselist.size(); i=i+4){
	// System.out.println((Double.parseDouble(sourselist.get(i))));
	// System.out.println((Double.parseDouble(sourselist.get(i+1))));
	// System.out.println((Double.parseDouble(sourselist.get(i+2))));
	// System.out.println((Double.parseDouble(sourselist.get(i+3))));
				linelist.add(new Line(Double.parseDouble(sourselist.get(i)),Double.parseDouble(sourselist.get(i+1)),Double.parseDouble(sourselist.get(i+2)),Double.parseDouble(sourselist.get(i+3))));
			
		}
		
 for(int i = 0; i< linelist.size(); i++){
	if(linelist.get(i).cross(linelist.get(i+1))==0){
		
		BinNode = new BinNode(Key=i,"nothing");
		BinNode.setLeft(BinNode);
	if(linelist.get(i).cross(linelist.get(i+1))==-1){
		
		BinNode = new BinNode(Key=i,"nothing");
	}
		
	}
 }
		
		
	 
        
	}
}
