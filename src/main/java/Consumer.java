import java.util.concurrent.locks.Lock;

/**
 * @author Dm.Petrov
 * DATE: 14.09.2022
 */
public class Consumer {
    CarShowRoom carShowRoom;
    Lock lock;
    public Consumer(CarShowRoom carShowRoom,Lock lock) {
        this.carShowRoom = carShowRoom;
        this.lock = lock;
    }

    public void buy() {
            lock.lock();
            carShowRoom.buyAuto();
            lock.unlock();
        }
    }

