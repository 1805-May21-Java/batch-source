package com.revature.threads;

public class TestRunnable implements Runnable {

    Count chocula;
    StringBuilder sbl;
    StringBuffer sbf;

    @Override
    public void run() {
       // for(int i = 0; i<5000; i++){
        //    chocula.increment();
        //}
        for(int i = 0; i<25; i++){
            this.sbl.append("~");
            this.sbf.append("~");
        }
    }

    public TestRunnable(){
        super();
    }

    public TestRunnable(Count c){
        super();
        this.chocula = c;
    }
    public TestRunnable(StringBuilder sbl, StringBuffer sbf){
        this.sbf = sbf;
        this.sbl = sbl;
    }
}
