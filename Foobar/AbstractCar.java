package Foobar;


public abstract class AbstractCar extends AbstractVehicle { 
	public AbstractCar(Engine engine) { //�Ű������� engine�� ������ ����Ǵ� ������
		super(engine);
		
	}
	public AbstractCar(Engine engine, Vehicle.Colour colour) { // colour�� �߰��� ������
		super(engine, colour);
	
	}
}
