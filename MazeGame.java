import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class MazeGame
{
	int l=0;
	int row=0;
	int matrix[][];int size=0;
	ArrayList<Integer> maze;
	BufferedReader reader=null;
	ArrayList<Integer> travArray;
	//Creating a maze by reading the values from the file and putting it into a 2D array
	public void create()
	{
		 String line=null;
	   maze=new ArrayList<Integer>();
  	    try
        {
  	       reader=new BufferedReader(new FileReader("CreateMaze.txt"));
  		     line=reader.readLine();
  		     while(line!=null)
  		         {	
             		 row++;
            	   String[] splitData=line.split(" ");
  		     			 line=reader.readLine();
  		     			 for(int i=0;i<splitData.length;i++)
  		    			 {
  			   					maze.add(Integer.parseInt(splitData[i]));
  		     			 }
  	      		}
         }
       catch(Exception e)
         {
        	e.printStackTrace();
         }
        
     
       		 int count=(maze.size())/5;
        		matrix = new int[row][5];
  		
        			for(int i=0;i<row;i++)
        				{
           				for(int j=0;j<5;j++)
           					{
            					 if(l<maze.size())
             					{
              							 matrix[i][j]=maze.get(l);
               						 l++;
             					}
             					else
             					{  
             	 						 break;
             					}
          					 }
       				}
        
       			 for(int i=0;i<row;i++)
        				{
          				 for(int j=0;j<5;j++)
          					 {
            						 System.out.print(matrix[i][j]+" ");
             
           					 }
          							 System.out.println(" ");
        				}
        }
  	//traversing through the created maze by the directions in the given file and 
  	//displaying the current position after each traversal and writing the output onto a file
  	public void traversal() throws Exception
  	{
			int roomno;
  	  String line=null;
			PrintWriter fout=null;
		
        try
        {
			
		 			  fout=new PrintWriter(new FileWriter("finalReport.txt"));
  	     		reader=new BufferedReader(new FileReader("TraverseMaze.txt"));
  		  		line=reader.readLine();
  		      while(line!=null)
  		  				{
							     ArrayList<Integer> y=new ArrayList<Integer>();
  		     			   String[] splitData=line.split(" ");
  		              for(int i=0;i<splitData.length;i++)
  		         			{
  			    					 y.add(Integer.parseInt(splitData[i]));
  		     				   }
  		    					roomno=y.get(0);
								    int size=y.size();
								    for(int i=1;i<size;i++)
										{
											 int dir=y.get(i);
											 int room=matrix[roomno-1][dir+1];
											 if(room>0)
												{
													roomno=room;
												}
				
										}
										System.out.println("Destination room:"+roomno);
										fout.println(roomno+"\n");
										line=reader.readLine();
			
					
  	       			}
  	     
  	}
			catch(Exception e)
			{
			System.out.println(e);
			}
			fout.close();
	}
}
