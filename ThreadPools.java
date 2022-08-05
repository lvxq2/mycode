package test1;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPools {

    public ThreadPools(int threadCount) {
      
    }

    public void execute(Runnable runnable) {
     
    }

    public static void main(String[] args) {
        ThreadPools pools = new ThreadPools(10);

        for (int i = 0; i < 10000; i++) {
            final int index = i;
            pools.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("index : " + index);
                }
            });

        }
    }

}
