import java.lang.Thread;

public class MultiThreadingDemo extends Thread{
private int threadNumber;

    public MultiThreadingDemo(int threadNumber) {
        this.threadNumber=threadNumber;
    }

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("Thread is working :"+i+"  from thread  "+ threadNumber);
        }
        try{
            Thread.sleep(1_000);
        }catch(InterruptedException e){
        }
    }
}
