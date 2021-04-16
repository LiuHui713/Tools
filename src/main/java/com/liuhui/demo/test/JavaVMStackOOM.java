package com.liuhui.demo.test;

//栈内存溢出 OutOfMemory
//VM Args：-Xss2M
public class JavaVMStackOOM {
    private void dontstop(){
        while (true){

        }
    }

    public void stackLeakByThread() {
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontstop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
