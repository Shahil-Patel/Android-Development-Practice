import java.io.*;
import java.util.ArrayList;
public class FileNumsReader
{
  static ArrayList<Integer> a=new ArrayList<>();

  public static void main(String[] args)throws Exception
  {

	  File file = new File("C:\\Users\\10014725\\Desktop\\Threads\\nums.txt");
	  BufferedReader br = new BufferedReader(new FileReader(file));
  	  Thread t1=new Thread("Thread 1:"){
  			public void run(){
	      		String st;
				try{
					while ((st = br.readLine()) != null){
						System.out.print(st+" ");
						a.add(Integer.parseInt(st));
					}
				}catch(Exception e){}
  			}
		};
		t1.start();
		try{
			t1.join();
		}catch(Exception e){};

        int sum=0;
		for(int x=0;x<a.size();x++){
			sum+=a.get(x);
		}
		System.out.println("\n"+sum);
	}
}