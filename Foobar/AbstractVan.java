package Foobar;

public abstract class AbstractVan extends AbstractVehicle {
	public AbstractVan(Engine engine) { //�Ű������� engine�� ������ ����Ǵ� ������
		super(engine);
		
	}
	public AbstractVan(Engine engine, Vehicle.Colour colour) { // colour�� �߰��� ������
		super(engine, colour);
	
	}
}
