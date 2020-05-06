package asdfasds;
import java.util.ArrayList;

interface Subject{
	public void addObserver(Observer o);
	public void deleteObserver(Observer o);
	public void notifyObservers();
}
interface Observer{
	public void update(int speed);

}
class Speedometer implements Subject{
	int currentSpeed;
	private ArrayList<Observer> observers;
	public Speedometer() {
		observers = new ArrayList<Observer>();
	}
	public void setCurrentSpeed(int speed) {
		this.currentSpeed = speed;
		notifyObservers();
	}
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	@Override
	public void notifyObservers(){
		for(int i=0; i<observers.size(); i++){
            Observer observer = (Observer)observers.get(i);
            observer.update(this.currentSpeed);
        }

    }
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}
	@Override
	public void deleteObserver(Observer o) {
		 int i = observers.indexOf(o);                
	        if(i>=0){
	            observers.remove(i);
	        }
	}
	
}


class SpeedMonitor implements Observer{
	private int speed;
	public static final int SPEED_TO_ALERT =70;
	
	@Override
	public void update(int speed) {
		this.speed = speed;
		if(this.speed>SPEED_TO_ALERT) {
				System.out.println("**ALERT**Driving too fast!!("+this.speed+")");
		}
		else{
				System.out.println("__nice and steady__("+this.speed+")");
		}
		
	}
}
public class myObserverFoobarMotor {
	public static void main(String []args) {
		SpeedMonitor monitor = new SpeedMonitor();
		Speedometer speedo = new Speedometer();
		speedo.addObserver(monitor);
		speedo.setCurrentSpeed(50);
		speedo.setCurrentSpeed(70);
		speedo.setCurrentSpeed(40);
		speedo.setCurrentSpeed(100);
		speedo.setCurrentSpeed(69);
    }

}
