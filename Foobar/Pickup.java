package Foobar;

public class Pickup extends AbstractVan { //AbstractVan�� ��ӹ޴� Pickup Ŭ����
	public Pickup(Engine engine) { //engine�� ���޵Ǿ��� �� ȣ��Ǵ� ������
		super(engine);
	}
	public Pickup(Engine engine, Vehicle.Colour colour) { //engine�� colour���� ���޵ɶ� ȣ��Ǵ� ������
		super(engine, colour);
	}
	@Override
	public int getPrice() { // ���� ����
		return 9000;
	}
}
