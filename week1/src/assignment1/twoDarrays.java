package assignment1;

import java.util.ArrayList;

public interface twoDarrays {
	
	/**
	 * private int x;
	 * private int y;
	 * private int[][] list;
	 */



	/*a function that returns the number of rows
	 * @return a list include all of the number of rows
	 */
	public ArrayList row(int row);

	/*	ArrayList a = new ArrayList();
		for(int column=0;  column< y; column++){
			a.add(list[row][column]);
		}
		return a;
	*/

	
	
	/*
	 * a function that returns the number of columns
	 * @return a list include all of the number of columns
	 */
	public ArrayList column(int column);
		
		/*ArrayList b = new ArrayList();
		for(int row=0;  row< x; row++){
			b.add(list[row][column]);
		}
		return b;*/
	
/*
 * @Return the number of integers currently in the list
 */
	public ArrayList allnumber( );
		/*ArrayList c = new ArrayList();
		for(int row=0;  row< x; row++){
			for(int column=0;  column< y; column++){
				c.add(list[row][column]);
			}
			
		}
		return c;
	*/
	/*
	 *@return true  if the 2D list have number z,
	 */
	public boolean checknumberZ(int z );	
	
/*
 * Insert a new integer at a particular position in the list(ex:row=2,column=3)
 */
	public void Insert(int x2, int y2, int num);
		
		//list[x2-1][y2-1]=num;
		
		
	
	
	


}
