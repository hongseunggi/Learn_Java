import java.util.Observable;
import java.util.Observer;
class SpeedoMeTer extends Observable{
	int currentSpeed;
	public void setCurrentSpeed(int speed) {
		this.currentSpeed = speed;
		setChanged();
		notifyObservers();
	}
	public int getCurrentSpeed() {
		return currentSpeed;
	}
}
class SpeedMoNitor implements Observer{
	private int speed;
	public static final int SPEED_TO_ALERT =70;
	public void update(Observable obs, Object obj) {
		if(obs instanceof SpeedoMeTer) {
			SpeedoMeTer speedo = (SpeedoMeTer) obs;
			this.speed = speedo.getCurrentSpeed();
			if(this.speed>SPEED_TO_ALERT) {
				System.out.println("**ALERT**Driving too fast!!("+speedo.getCurrentSpeed()+")");
			}
			else{
				System.out.println("__nice and steady__("+speedo.getCurrentSpeed()+")");
			}
		}
		
	}
}

public class FoobarMotor {
	public static void main(String []args) {
		SpeedMoNitor monitor = new SpeedMoNitor();
		SpeedoMeTer speedo = new SpeedoMeTer();
		speedo.addObserver(monitor);
		speedo.setCurrentSpeed(50);
	    speedo.setCurrentSpeed(70);
		speedo.setCurrentSpeed(40);
		speedo.setCurrentSpeed(100);
		speedo.setCurrentSpeed(69);

	}
}
