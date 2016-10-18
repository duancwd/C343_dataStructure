package week12;

/**

 * 

 */

/**

 * @author ChaoDuan

 *

 */




/*

 * 

 * @author chaoduan

 * 

 */


import java.io.BufferedReader;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public class Gossipgraph  {
        public static File f; 
        public static int ch; 
        public static String checkInput;
        public static int count;
        public static  String inputstring ;
        public static ArrayList<String> sourselist;
        public static  String temp;
        public static int w=0;
        public static int vertices=0;
            
        private int[] fReachedFrom;          
        private double[] fUptimeSnapshot;          
        private double[] fUptimeReached;         
        private boolean[] fCloudNodes; 
        private Vector<String> tweets;	
        private Vector<String> words;	
        private Vector<Integer> counts;
        private void readFile(String inputFile) throws FileNotFoundException {		
       		
        	InputStream in = new FileInputStream(inputFile);		
        
        	Scanner scan = new Scanner(in);		
        			
        	while(scan.hasNext()) {			
        				
        			}		
        		
        	scan.close();	}
        	
        
        
        public void extractWords() {	
        	words = new Vector<String> (100, 20);		
        	counts = new Vector<Integer> (100, 20);		
        	for(int i = 0; i < tweets.size(); i ++) {			
        		String atweet = tweets.elementAt(i);			
        		String reg = "\\w+";			
        		Pattern p = Pattern.compile(reg);			
        		Matcher m = p.matcher(atweet);			
        		while(m.find()) {				
        			String aword = m.group(0);				
        			if(words.contains(aword)) {					
        				int idx = words.indexOf(aword);					
        				counts.setElementAt(counts.elementAt(idx) + 1, idx);				
        				}				
        			else {					
        				words.add(aword);					
        				counts.add(1);			
        				}			
        			}		
        		}	
        	}
        
        
        public static void main(String [] args)throws Exception{ 
                sourselist = new  ArrayList<String>();

                

                f=new File("C:/Users/chaoduan/Desktop/google.txt"); 
                InputStreamReader read = new InputStreamReader(new FileInputStream(f),"GBK");   
                ArrayList<String> readList = new ArrayList<String>();   
                BufferedReader reader=new BufferedReader(read);    



                while((temp=reader.readLine())!=null &&!"".equals(temp)){   
                        readList.add(temp);  
                }   

System.out.println(readList);

                for(int i=0; i< readList.size();i++){
                        inputstring = readList.get(i);
                        inputstring  = inputstring.replaceAll("[^A-Za-z0-9]", " ");
                        StringTokenizer a = new  StringTokenizer(inputstring);
                        while(a.hasMoreTokens()){
                                sourselist.add(a.nextToken());

                        }

                }

                OutputStream fos=new FileOutputStream("C:/Users/chaoduan/Desktop/output.txt", false);   


                for( int i = 0; i< sourselist.size(); i++){
                        count =1;
                        for(int j=i+1;j <sourselist.size(); j++){
                                if(sourselist.get(i).equalsIgnoreCase(sourselist.get(j))){
                                        count = count+1;
                                      //  sourselist.remove(j);
                                        vertices = w/2;
                                }
                               

                        }

                        

                        w=w+1;

                        

                        String str = "["+w+"] "+sourselist.get(i)+" "+count;
                             str+="\r\n";
                             str+="\r";
                             str+="\n";
                        byte b[] = str.getBytes() ;
                        fos.write(b) ;
                       
                       
                

                        

                        System.out.println( "["+w+"] "+sourselist.get(i));
                }
                String strl = "vertices= "+vertices;
                byte c[]=strl.getBytes();
                fos.write(c) ;
                fos.close() ;
                System.out.println("vertices= "+vertices );
        }

}

