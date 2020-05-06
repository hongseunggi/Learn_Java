package Foobar;

public abstract class AbstractVan extends AbstractVehicle {
	public AbstractVan(Engine engine) { //매개변수가 engine만 있을때 수행되는 생성자
		super(engine);
		
	}
	public AbstractVan(Engine engine, Vehicle.Colour colour) { // colour가 추가된 생성자
		super(engine, colour);
	
	}
}
