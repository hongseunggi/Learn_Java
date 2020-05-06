package Foobar;

public class MetallicPaintedVehicle extends AbstractVehicleOption{
	private static int price = 750;
	private Vehicle v;
	public MetallicPaintedVehicle(Vehicle v) {
		super(v.getEngine(), v.getColour());//���� ���� v�� ������ �÷��� �Ѱ���
		this.v=v; // this Vehicle v ��ü�� ���޵� v�� �־���
	}
	@Override
	public int getPrice() {//���޹��� v�� ���ݰ� �ش� �ɼ��� ������ ���� �������ش�
		return this.v.getPrice()+price;
	}
}
