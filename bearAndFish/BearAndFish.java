package designpattern;
import java.util.Scanner;
abstract class GameObject{
	protected int distance;
	protected int x, y;
	public GameObject(int startX, int startY, int distance) {
		this.x=startX;
		this.y=startY;
		this.distance=distance;
		
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public boolean collide(GameObject p) {
		if(this.x==p.getX()&&this.y==p.getY()) {
			return true;
		}
		else {
			return false;
		}
	}
	public abstract void move();
	public abstract char getShape();
}
class Bear extends GameObject{
	public Bear(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	@Override
	public void move() {
		System.out.print("Input a(left), s(down), d(up), f(right) >> ");
		Scanner scan = new Scanner(System.in);
		String key = scan.next();
		Game.array[x][y] = '-';
		if(key.equals("a")) {  // �Է¿� ���� �̵��Ǵ� �Ÿ�, ������ �����ڸ� �϶� �������� �ʰ�, ��,��,�Ʒ�,�� �������� �ԷµǸ� ������ distance��ŭ �̵��Ѵ�.
			if(y==0) y=0;
			else y = y-distance;
		}
		else if(key.equals("s")) {

			if(x==9) x=9;
			else x = x+distance;
		}
		else if(key.equals("d")) {
			if(x==0) x=0;
			else x = x-distance;
		}
		else if(key.equals("f")) {
			if(y==19) y=19;
			else y = y+distance;
		}
		else System.out.println("error"); // �� �� �Է½�
		Game.array[x][y] = getShape(); // getShape �޼ҵ带 �̿��Ͽ� ����� �Է��Ѵ�.
	}
	@Override
	public char getShape() { //�߻�Ŭ���� �޼ҵ带 �������̵�
		return 'B';
	}
}
class Fish extends GameObject{
	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}
	@Override
	public void move() {
		int randnum = (int)(Math.random()*4);
		Game.array[x][y] = '-';
		if(randnum == 0) { //fish�� �����ϰ� �����̱⶧���� �����޼ҵ带 �̿��Ͽ�  �׹������� �����ϰ� �����̰� �Ѵ�.
			if(y==0) y=0;
			else y=y-distance;
		}
		else if(randnum == 1) {
			if(x==9) x=9;
			else x=x+distance;
		}
		else if(randnum == 2) {
			if(x==0) x=0;
			else x-=distance;
		}
		else if(randnum == 3) {
			if(y==19) y=19;
			else y+=distance;
		}
		else System.out.println("error");
		Game.array[x][y] = getShape(); //�̵��� ��ǥ�� ��� �Է�
	}
	@Override
	public char getShape() { //���������� �������̵带 ����Ͽ� ����
		return 'F';
	}
}
class Game{ // ���� ������ ����Ǵ� Ŭ����
	Scanner scan = new Scanner(System.in);
	Bear bear;
	Fish fish;
	public static char array[][] = new char[10][20]; //10x20 ���� �� ���� array
	public void set() {
		bear = new Bear(0,0,1); //�ʱ� ��ġ�� �̵��Ÿ� ����
		fish = new Fish(5,9,1); //�ʱ� ��ġ�� �̵��Ÿ� ����
		for(int i = 0; i<array.length; i++) { //�ʱ� �������� "-"�� ä���.
			for(int j = 0; j<array[i].length; j++) {
				array[i][j] = '-';
			}
		}
		array[bear.x][bear.y] = bear.getShape(); //bear�� fish�� array�� ��´�
		array[fish.x][fish.y] = fish.getShape();
	}
	public void run() { //���� ���� �޼ҵ�
		int rand;
		set(); //�ʱ� ���� �ҷ���
		while(true) { // ������� ���ѹݺ�
			int count = 0;
			for(int i=0; i<5; i++) {
				for(int k=0; k<array.length; k++) {
					for(int j=0; j<array[k].length; j++) {
						System.out.print(array[k][j]);
					}
					System.out.println();
				} // �������� ǥ����
				bear.move();//bear �̵� ȣ��
				rand = (int)(Math.random()*2);
				if(rand==1) { //rand�޼ҵ带 �̿��Ͽ� 5���� 2�� �����̰� �Ѵ�
					count++;
					if(count<=2) { //rand�� 1�϶� 2ȸ �����̰� ����
						fish.move();
					}
				}
				if(i==3 && count==0) { //4ȸ���� 0�� ����������
					fish.move();
					count++;
				}
				if(i==4 && count==1) { //5ȸ���� 1�� ����������
					fish.move();
					count++;
				}
			    if((bear.collide(fish)) == true) { // ������ ���
					array[bear.x][bear.y] = bear.getShape();
					for(int z=0; z<array.length; z++) {
						for(int y=0; y<array[z].length; y++) {
							System.out.print(array[z][y]);
						}
						System.out.println();
					}
					System.out.println("Bear eat fish");
					return;
				}
			    array[bear.x][bear.y] = bear.getShape(); 
			}
		}
	}
}
public class BearAndFish {
	public static void main(String[] args) {
		System.out.println("Bear Fish game");
		Game game = new Game();
		game.run();
	}
}
