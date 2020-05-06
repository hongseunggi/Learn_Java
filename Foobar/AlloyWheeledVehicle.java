package Foobar;

public class AlloyWheeledVehicle extends AbstractVehicleOption {
	private static int price = 250;
	private Vehicle v;
	public AlloyWheeledVehicle(Vehicle v) {
		super(v.getEngine(), v.getColour()); //전달 받은 v의 엔진과 컬러를 넘겨줌
		this.v=v; // this Vehicle v 객체에 전달된 v를 넣어줌
	}
	@Override
	public int getPrice() { //전달받은 v의 가격과 해당 옵션의 가격을 더해 리턴해준다
		return this.v.getPrice()+price;
	}
}
