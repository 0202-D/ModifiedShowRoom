import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dm.Petrov
 * DATE: 14.09.2022
 */
public class Main {
    public static void main(String[] args) {
        CarShowRoom carShowRoom = new CarShowRoom();
        Lock lock = new ReentrantLock();
        Thread producer = new Producer(carShowRoom);
        for (int i = 1; i <= 10; i++) {
            new Thread(()->new Consumer(carShowRoom,lock).buy(),"Customer "+i).start();
        }
        producer.start();




    }
}
