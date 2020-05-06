package Foobar;

public class LeatherSeatedVehicle extends AbstractVehicleOption {
	private static int price = 1200;
	private Vehicle v;
	public LeatherSeatedVehicle(Vehicle v) {
		super(v.getEngine(), v.getColour());//���� ���� v�� ������ �÷��� �Ѱ���
		this.v=v; // this Vehicle v ��ü�� ���޵� v�� �־���
	}
	@Override
	public int getPrice() {//���޹��� v�� ���ݰ� �ش� �ɼ��� ������ ���� �������ش�
		return this.v.getPrice()+price;
	}
}
