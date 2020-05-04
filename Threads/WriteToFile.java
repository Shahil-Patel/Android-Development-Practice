import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;
public class WriteToFile{
	public static void main(String [] args){
			Thread t1 = new Thread("Thread 1"){
				public void run(){
					try{
						PrintWriter writer = new PrintWriter("hundred.txt", "UTF-8");
						for (int x = 1; x <=100; x++){
							writer.println(x+"");
						}
						writer.close();
					}catch(Exception e){}
				}//run method
			}; //t1

			Thread t2 = new Thread("Thread 2"){
				public void run(){
					try{
						PrintWriter writerone = new PrintWriter("alphabet.txt", "UTF-8");
						for (int x = 97; x <=122; x++){
							writerone.println(Character.toString ((char)x));
						}
						writerone.close();
					}catch(Exception e){}
				}//run method
			}; //t2

		t1.start();
		t2.start();
		try{
			t1.join();
			t2.join();
		}catch(Exception e){}

		for (int i = 1; i <= 10; i++){
			System.out.println("Main Thread "+i);
		}//for loop

		}//main

}//class


