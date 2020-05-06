package Foobar;

public class AlloyWheeledVehicle extends AbstractVehicleOption {
	private static int price = 250;
	private Vehicle v;
	public AlloyWheeledVehicle(Vehicle v) {
		super(v.getEngine(), v.getColour()); //���� ���� v�� ������ �÷��� �Ѱ���
		this.v=v; // this Vehicle v ��ü�� ���޵� v�� �־���
	}
	@Override
	public int getPrice() { //���޹��� v�� ���ݰ� �ش� �ɼ��� ������ ���� �������ش�
		return this.v.getPrice()+price;
	}
}
