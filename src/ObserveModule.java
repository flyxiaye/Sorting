//观察者模式
//改进版 委托 未完成
import java.util.LinkedList;
import java.util.List;

public class ObserveModule {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();

        s.attach(new ConcreteObserver(s, "X"));
        s.attach(new ConcreteObserver(s, "Y"));
        s.attach(new ConcreteObserver(s, "Z"));

        s.setSubjectState("ABC");
        s.notify_observer();
    }
}


abstract class Subject {
    private List<Observer> observers = new LinkedList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notify_observer() {
        for (Observer o : observers) {
            o.update();
        }
    }
}

interface Observer {
    void update();
}

class ConcreteSubject extends Subject {
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String value) {
        subjectState = value;
    }
}

class ConcreteObserver implements Observer {

    private String name;
    private String observerState;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    @Override
    public void update() {
        observerState = subject.getSubjectState();
        System.out.printf("观察者%s的新状态是%s\n", name, observerState);
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }
}