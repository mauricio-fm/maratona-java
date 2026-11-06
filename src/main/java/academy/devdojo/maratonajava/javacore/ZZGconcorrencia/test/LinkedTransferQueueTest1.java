package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// A LinkedTransferQueue junta as funcionalidade dessas tres ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue
public class LinkedTransferQueueTest1 {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Object> tq = new LinkedBlockingQueue<>();
        System.out.println(tq.add("mauricio")); // add elements, if no and throwing an IllegalStateException
        System.out.println(tq.offer("mauricio")); // try add elements, returning true upon success and false
        System.out.println(tq.offer("mauricio", 10 , TimeUnit.SECONDS)); // wait if necessary up to the specified
        // wait time for space to become available
        tq.put("devdojo"); // wait if necessary for space to become available.
        System.out.println(tq.remainingCapacity()); // capacity of LinkedBlockingQueue
    }
}
