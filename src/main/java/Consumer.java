import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dm.Petrov
 * DATE: 14.09.2022
 */
public class Consumer extends Thread {
    CarShowRoom carShowRoom;
    public Consumer(CarShowRoom carShowRoom) {
        this.carShowRoom = carShowRoom;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            carShowRoom.buyAuto();
        }

    }
}
