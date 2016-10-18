package huffman;

import java.util.Hashtable;

/**For simplicity, the huffman codes are represented in Strings, not bits
 * Yuzhen Ye@School of Informatics and Computing, Indiana University, Bloomington
 */


public class HuffTree<Key, E> {
	private MinHeap<Integer, String> heap; //for building the tree
	private BinNode<Integer, String> root; //for traversal

	//to-do
	private Hashtable< String,Integer> codeTable; //huffman code table
	public HuffTree(String letters, int[] weights) {
		init(letters, weights);
		buildTree();
		//myHashtable  ( huff,letters,  weights);
	}
	private void init(String letters, int[] weights) {
		int maxNum = letters.length();
		//BinNode<Integer, String>[] nodes = (BinNode<Integer, String>[]) new Object[maxNum];
		BinNode<Integer, String>[] nodes = new BinNode[maxNum];
		for(int i = 0; i < maxNum; i ++) {
			nodes[i] = new BinNode<Integer, String>(weights[i], letters.substring(i, i + 1)); 
		}
		heap = new MinHeap<Integer, String>(maxNum, maxNum, nodes);
		heap.display();
	}
	private void buildTree() {
		while(heap.length() > 1) {
			BinNode<Integer, String> node1 = heap.removeMin();
			BinNode<Integer, String> node2 = heap.removeMin();
			BinNode<Integer, String> newnode = new BinNode<Integer, String>(node1.getKey() + node2.getKey(), " ");
			newnode.setLeft(node1);
			newnode.setRight(node2);
			heap.insert(newnode);
			heap.display();
		}
		root = heap.removeMin();
		System.out.println("root of the hufftree: weight " + root.getKey());
	}
	
	public  BinNode<Integer, String> getRoot(){
		return root;
		
	}
	public void setRoot(BinNode<Integer,String> ront){
		this.root = root;
	}
	
	public String tocode(BinNode node,int input, char ch, String code){
		BinNode curNode = node;
		if(curNode.getLeft() != null&& curNode.getRight()!=null){
			String temp = " ";
			temp = tocode(curNode.getLeft(), input, ch, code +"0");
			if(temp != null)
				return temp;
			return tocode(curNode.getRight(), input, ch, code +"1");
			
			
			}else if(curNode.getLeft() == null&& curNode.getRight()!=null){
				
				return tocode(curNode.getRight(), input, ch, code +"1");
			}else if (curNode.getLeft() != null&& curNode.getRight()==null){
				return tocode(curNode.getLeft(), input, ch, code +"0");
			
			}else if(curNode.isLeaf()){
				if((Integer)curNode.getKey() ==input&&Character.toString(ch).equals(curNode.getValue())){
					return code;
				}else {return null;}
			}
		
		
		return null;
	}
	
	public  void myHashtable  (HuffTree huff, String letters, int[] weights){
		this.codeTable = new  Hashtable<String,Integer>();
		int maxNum = letters.length();
		for(int i = 0; i<maxNum; i++){
			char ch = letters.charAt(i);
			String code = huff.tocode(getRoot(), weights[i], ch, "");
			int value = code.length()*weights[i];
			codeTable.put(letters.substring(i, i+1), value);
		}
		
		//BinNode<Integer, String>[] nodes = (BinNode<Integer, String>[]) new Object[maxNum];
		//BinNode<Integer, String>[] nodes = new BinNode[maxNum];
		
	}
	

	public String encode(String letters) {
		String a =" ";
		
		int maxNum = letters.length();
		 int[] weights =new int[letters.length()];
		for(int i = 0; i<maxNum; i++){
			
			 weights[i]=codeTable.get(letters.substring(i, i + 1));
			 System.out.println(letters.substring(i, i + 1)+" = "+ weights[i]);
			 a =a +" " +Integer.toString(weights[i]);
		}
		
		//codeTable.
		// TODO Auto-generated method stub
		//for(int )
		
		return a;
	}
	public String decode(String encode) {
		BinNode curNode = root;
		String output = "";
		int i = 0;
		while(i < encode.length()){
			while(!curNode.isLeaf()){
				if(Character.toString(encode.charAt(i)).equals("1")){
					if(curNode.getRight()!= null)
						curNode = curNode.getRight();
					else
						return null;
						
				}else if (Character.toString(encode.charAt(i)).equals("0")){
					if(curNode.getLeft()!= null)
						curNode = curNode.getLeft();
					else
						return null;
					
				}else
					return null; 
				i++;
			}
			output = output + (String)curNode.getValue();
			curNode = root;
		}
		return null;
	}
	
	
//	public int getwights (String input){
//		int sum = 0;
//		for(int i =0; i<input.length(); i++){
//			sum = sum + codeTable.get(input.substring(i, i+1).getCode();
//			
//		}
	//}
}
