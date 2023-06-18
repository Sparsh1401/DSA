public class MultiThreading {
    public MultiThreading(int i) {

    }
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            MultiThreadingDemo myThing = new MultiThreadingDemo(i);
            myThing.start();
        }
    }
}
