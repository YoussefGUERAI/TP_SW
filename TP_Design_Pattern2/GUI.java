import java.util.*;

interface Observer{
    void update();
}

class Logger implements Observer {
    public void update() {
        System.out.println("Logger is updated to: ");
    }

}
class LabelUpdater implements Observer {
    public void update() {
        System.out.println("Label is updated to:" );
    }
}
class NotificationSender implements Observer {
    public void update() {
        System.out.println("Notification sent to user.");
    }
}
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
class SubmitButton implements Subject {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void click() {
        System.out.println("Submit button clicked.");
        notifyObservers();
    }
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
class VolumeSlider implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void changeVolume() {
        System.out.println("Volume slider changed.");
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

public class GUI {
    public static void main(String[] args) {
        SubmitButton submitButton = new SubmitButton();

        Logger logger = new Logger();
        LabelUpdater labelUpdater = new LabelUpdater();

        submitButton.addObserver(logger);
        submitButton.addObserver(labelUpdater);

        submitButton.click();

        VolumeSlider volumeSlider = new VolumeSlider();
        NotificationSender notificationSender = new NotificationSender();
        volumeSlider.addObserver(notificationSender);
        volumeSlider.addObserver(logger);
        volumeSlider.changeVolume();

    }
}