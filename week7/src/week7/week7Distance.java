package week7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * author: chaoduan
 */
public class week7Distance {
    
    
    
    
    
    public static int minValue(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
        
    }
    
    
    public static int distance(String str1, String str2){
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];
        
        for (int i = 0; i <= str1.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= str2.length(); j++)
            distance[0][j] = j;
 
        for (int i = 1; i <= str1.length(); i++)
            for (int j = 1; j <= str2.length(); j++)
                distance[i][j] = minValue(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1]+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1));
        int result = distance[str1.length()][str2.length()];
 
        return result;    
    }
        
        
        
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        ArrayList<String> words = new ArrayList<String>();
        InputStream in = new  FileInputStream("F:/distancet.txt");
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()){
            String word = scanner.next();
            words.add(word);
        }
        
        
        
        
        int start = 0;
        
        while (start + 1 < words.size()){
            
            int result = week7Distance.distance(words.get(start), words.get(start+1));
            System.out.println(words.get(start));
            System.out.println(words.get(start+1));
            System.out.println(result);
            start++;
            
            
            
        }
         
        
        
        
        
        
        
         
    }
    
}
    

