/**
 * @author Dm.Petrov
 * DATE: 14.09.2022
 */
public class Main {
    public static void main(String[] args) {
        CarShowRoom carShowRoom = new CarShowRoom();
        Thread consumer = new Consumer(carShowRoom);
        consumer.setName("Consumer1");
        Thread consumer2 = new Consumer(carShowRoom);
        consumer2.setName("Consumer2");
        Thread producer = new Producer(carShowRoom);
        consumer.start();
        consumer2.start();
        producer.start();

    }
}
