package Foobar;

public class Coupe extends AbstractCar { //AbstractCar�� ��ӹ޴� Coupe Ŭ����
	public Coupe(Engine engine) { //engine�� ���޵Ǿ��� �� ȣ��Ǵ� ������
		super(engine);
	}
	public Coupe(Engine engine, Vehicle.Colour colour) { //engine�� colour���� ���޵ɶ� ȣ��Ǵ� ������
		super(engine, colour);
	}
	@Override
	public int getPrice() { //Coupe ���� ����
		return 7000;
	}
}
