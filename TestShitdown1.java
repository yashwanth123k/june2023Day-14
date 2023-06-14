class MyThread extends Thread{
public void run(){
System.out.println("shut down hook task completed...");
}
}
class TestShitdown1{
public static void main(String args[])throws Exception{
Runtime r=Runtime.getRuntime();
r.addShutdownHook(new MyThread());
System.out.println("New main sleeping,..");
try{
Thread.sleep(3000);}
catch(Exception e){}
}
}
