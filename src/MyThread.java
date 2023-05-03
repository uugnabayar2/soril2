public class MyThread extends Thread {

    public void run() {

        System.out.println("MyThread урсаж эхэллээ.");

        for (int i = 1; i <= 5; i++) {

            System.out.println("MyThread: " + i);

            try {

                Thread.sleep(1000); 

            } catch (InterruptedException e) {

                System.out.println("MyThread interrupted.");

            }

        }

        System.out.println("MyThread дууслаа.");

    }



    public static void main(String[] args) {

        MyThread thread = new MyThread(); 

        thread.start(); 

        System.out.println("Main thread дууслаа.");

    }

}

