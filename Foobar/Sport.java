package Foobar;

public class Sport extends AbstractCar {
	public Sport(Engine engine) { //engine�� ���޵Ǿ��� �� ȣ��Ǵ� ������
		super(engine);
	}
	public Sport(Engine engine, Vehicle.Colour colour) { //engine�� colour���� ���޵ɶ� ȣ��Ǵ� ������
		super(engine, colour);
	}
	@Override
	public int getPrice() {
		return 8000;
	}
}
