package PluralSightJava8;

public class RunnableLambda {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable(){
        
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Hello World from thread [" +
                    Thread.currentThread().getName() + 
                    "]");
                }
            }
        };
        //Replacing Runnable Object through Lambda Expression
            Runnable runnableLambda = () -> {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Hello World from thread using lambda [" +
                    Thread.currentThread().getName() + 
                    "]");
                }
            };
        Thread t = new Thread(runnableLambda);
        t.start();
        t.join();
    }

}