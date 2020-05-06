package Foobar;

public class SatNavVehicle extends AbstractVehicleOption {
	private static int price = 1500;
	private Vehicle v;
	public SatNavVehicle(Vehicle v) {
		super(v.getEngine(), v.getColour());//���� ���� v�� ������ �÷��� �Ѱ���
		this.v=v; // this Vehicle v ��ü�� ���޵� v�� �־���
	}
	@Override
	public int getPrice() {//���޹��� v�� ���ݰ� �ش� �ɼ��� ������ ���� �������ش�
		return this.v.getPrice()+price;
	}
}
