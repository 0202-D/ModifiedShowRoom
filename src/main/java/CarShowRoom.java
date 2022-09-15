import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Dm.Petrov
 * DATE: 13.09.2022
 */
public class CarShowRoom {
    List<Car> list = new ArrayList<>();
    private int timeToCreateAuto = 3000;
    private int timeToBuy = 2000;
    private int firstCarToSell = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void releaseAuto() {
        lock.lock();
        try {
            Thread.sleep(timeToCreateAuto);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Toyota release auto");
        list.add(new Car());
        condition.signal();
        System.out.println(list.size() + " car in storage");
        lock.unlock();
    }


    public synchronized void buyAuto() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " came to the salon");
        try {
            while (list.isEmpty()) {
                System.out.println("No cars");
                condition.await();
            }

            Thread.sleep(timeToBuy);
            System.out.println(Thread.currentThread().getName() + " buy auto");
            list.remove(firstCarToSell);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}




