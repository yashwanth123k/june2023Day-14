import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class WorkerThread implements Runnable{
private String message;
public WorkerThread(String s){
this.message=s;}
public void run(){
System.out.println(Thread.currentThread().getName()+"(Start)message="+message);
processmessage();
System.out.println(Thread.currentThread().getName()+"(End)");}
private void processmessage(){
try{
Thread.sleep(2000);}
catch(InterruptedException e){
e.printStackTrace();}
}
}
class TestThreadPool{
public static void main(String args[]){
ExecutorService executor=Executors.newFixedThreadPool(5);
for(int i=0;i<10;i++){
Runnable Worker=new WorkerThread(""+i);
executor.execute(Worker);
}
executor.shutdown();
while(!executor.isTerminated()){}
System.out.println("Finished all threads");
}
}
