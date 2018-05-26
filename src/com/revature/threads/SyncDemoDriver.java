package com.revature.threads;

public class SyncDemoDriver {
    public static void main(String[] args){

        Count c = new Count();
        Runnable job = new TestRunnable(c);

        //This is how we tell the threads what they have access to.
        //Thread t1 = new Thread(job);
        //Thread t2 = new Thread(job);

        StringBuilder sbl = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        Runnable job2 = new TestRunnable(sbl, sbf);

        Thread t1 = new Thread(job2);
        Thread t2 = new Thread(job2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("StringBuilder result: "+sbl+"\n");
        System.out.println();
        System.out.println("StringBuffer result: "+sbf+"\n");
        //System.out.println("Count: "+c.count);

    }
}
