public class MultiThreadDemos {

    public static void main(String[] args) {

        MainThread mainThread = new MainThread();



        MyThread thread1 = new MyThread("Thread 1", Thread.MAX_PRIORITY);

        MyThread thread2 = new MyThread("Thread 2", Thread.NORM_PRIORITY);

        MyThread thread3 = new MyThread("Thread 3", Thread.MIN_PRIORITY);



        mainThread.start();



        thread1.start();

        thread2.start();

        thread3.start();

        try {

            thread1.join();

            thread2.join();

            thread3.join();

        } catch (InterruptedException e) {

            System.out.println("Interrupted while waiting for threads to finish.");

        }



        System.out.println("Thread 1: " + thread1.getCount());

        System.out.println("Thread 2: " + thread2.getCount());

        System.out.println("Thread 3: " + thread3.getCount());

    }

}



class MainThread extends Thread {

    public void run() {

        System.out.println("Main thread started.");

        try {

            Thread.sleep(5000); 

        } catch (InterruptedException e) {

            System.out.println("Main thread interrupted.");

        }

        System.out.println("Main thread finished.");

    }

}



class MyThread extends Thread {

    private String name;

    private int priority;

    private int count;



    public MyThread(String name, int priority) {

        this.name = name;

        this.priority = priority;

    }



    public void run() {

        System.out.println(name + " started.");

        for (int i = 1; i <= 10; i++) {

            System.out.println(name + ": " + i);

            count++;

            try {

                Thread.sleep(1000); 

            } catch (InterruptedException e) {

                System.out.println(name + " interrupted.");

            }

        }

        System.out.println(name + " finished.");

    }



    public int getCount() {

        return count;

    }

}

