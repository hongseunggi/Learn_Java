package Foobar;

public class AirConditionedVehicle extends AbstractVehicleOption {
	private static int price = 660;
	private Vehicle v;
	public AirConditionedVehicle(Vehicle v) {
		super(v.getEngine(), v.getColour());//���� ���� v�� ������ �÷��� �Ѱ���
		this.v=v; // this Vehicle v ��ü�� ���޵� v�� �־���
		
	}
	@Override
	public int getPrice() {//���޹��� v�� ���ݰ� �ش� �ɼ��� ������ ���� �������ش�
		return this.v.getPrice()+price;
	}
}
