/**
 * @author Dm.Petrov
 * DATE: 14.09.2022
 */
public class Producer extends Thread {
    private CarShowRoom carShowRoom;

    public Producer(CarShowRoom carShowRoom) {
        this.carShowRoom = carShowRoom;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            carShowRoom.releaseAuto();
        }
    }
}
