package Foobar;

public class Saloon extends AbstractCar { // AbstractCar�� ��ӹ޴� Saloon Ŭ����
	public Saloon(Engine engine) { //engine�� ���޵Ǿ��� �� ȣ��Ǵ� ������
		super(engine);
	}
	public Saloon(Engine engine, Vehicle.Colour colour) { //engine�� colour���� ���޵ɶ� ȣ��Ǵ� ������
		super(engine, colour);
	}
	@Override
	public int getPrice() { // ���� ����
		return 6000;
	}
}
