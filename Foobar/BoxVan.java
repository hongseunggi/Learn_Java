package Foobar;

public class BoxVan extends AbstractVan { //AbstractVan�� ��ӹ޴� boxvan Ŭ����
	public BoxVan(Engine engine) { //engine�� ���޵Ǿ��� �� ȣ��Ǵ� ������
		super(engine);
	}
	public BoxVan(Engine engine, Vehicle.Colour colour) { //engine�� colour���� ���޵ɶ� ȣ��Ǵ� ������
		super(engine, colour);
	}
	@Override
	public int getPrice() { //boxvan�� ������ ���� ���ش� 
		return 10000;
	}
}
