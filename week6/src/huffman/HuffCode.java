package huffman;

import java.util.HashMap;

public class HuffCode {
	
	public static void main(String[] args) {
		String letters = "CDEKLMUZ";
		int[] freq = {32, 42, 120, 7, 42, 24, 37, 2};
		System.out.println("letters: " + letters);
		HuffTree huff = new HuffTree(letters, freq);
		//to-do
		huff.myHashtable(huff, letters, freq);
		
		String encode = huff.encode("DEED");
		System.out.println("DEED code: " + encode);
		String decode = huff.decode(encode);
		System.out.println("decoded: " + decode);
	}
	
	
}