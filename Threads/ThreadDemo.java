public class ThreadDemo{
	public static void main(String[] args){
		Thread t1=new Thread("Thread 1:"){
			public void run(){
				for(int x=1;x<11;x++){
					System.out.println(getName()+" "+x);
				}
			}
		};
		Thread t2=new Thread("Thread 2:"){
			public void run(){
				for(int x=1;x<11;x++){
					System.out.println(getName()+" "+x);
				}
			}
		};
		try{
					t1.start();
			t2.join();
			t1.join();

		}catch(Exception e){}
		for(int x=1;x<11;x++){
			System.out.println("Main Thread: "+x);
		}
	}
}