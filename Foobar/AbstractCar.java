package Foobar;


public abstract class AbstractCar extends AbstractVehicle { 
	public AbstractCar(Engine engine) { //매개변수가 engine만 있을때 수행되는 생성자
		super(engine);
		
	}
	public AbstractCar(Engine engine, Vehicle.Colour colour) { // colour가 추가된 생성자
		super(engine, colour);
	
	}
}
