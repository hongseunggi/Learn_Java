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
		if(key.equals("a")) {  // 입력에 따라 이동되는 거리, 격자의 가장자리 일때 움직이지 않고, 왼,위,아래,오 움직임이 입력되면 설정된 distance만큼 이동한다.
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
		else System.out.println("error"); // 잘 못 입력시
		Game.array[x][y] = getShape(); // getShape 메소드를 이용하여 모양을 입력한다.
	}
	@Override
	public char getShape() { //추상클래스 메소드를 오버라이드
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
		if(randnum == 0) { //fish는 랜덤하게 움직이기때문에 랜덤메소드를 이용하여  네방향으로 랜덤하게 움직이게 한다.
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
		Game.array[x][y] = getShape(); //이동한 좌표에 모양 입력
	}
	@Override
	public char getShape() { //마찬가지로 오버라이드를 사용하여 선언
		return 'F';
	}
}
class Game{ // 실제 게임이 진행되는 클래스
	Scanner scan = new Scanner(System.in);
	Bear bear;
	Fish fish;
	public static char array[][] = new char[10][20]; //10x20 격자 를 담을 array
	public void set() {
		bear = new Bear(0,0,1); //초기 위치와 이동거리 지정
		fish = new Fish(5,9,1); //초기 위치와 이동거리 지정
		for(int i = 0; i<array.length; i++) { //초기 격자판을 "-"로 채운다.
			for(int j = 0; j<array[i].length; j++) {
				array[i][j] = '-';
			}
		}
		array[bear.x][bear.y] = bear.getShape(); //bear와 fish를 array에 담는다
		array[fish.x][fish.y] = fish.getShape();
	}
	public void run() { //게임 실행 메소드
		int rand;
		set(); //초기 설정 불러옴
		while(true) { // 정답까지 무한반복
			int count = 0;
			for(int i=0; i<5; i++) {
				for(int k=0; k<array.length; k++) {
					for(int j=0; j<array[k].length; j++) {
						System.out.print(array[k][j]);
					}
					System.out.println();
				} // 격자판을 표시함
				bear.move();//bear 이동 호출
				rand = (int)(Math.random()*2);
				if(rand==1) { //rand메소드를 이용하여 5번중 2번 움직이게 한다
					count++;
					if(count<=2) { //rand가 1일때 2회 움직이게 설정
						fish.move();
					}
				}
				if(i==3 && count==0) { //4회까지 0번 움직였을때
					fish.move();
					count++;
				}
				if(i==4 && count==1) { //5회까지 1번 움직였을때
					fish.move();
					count++;
				}
			    if((bear.collide(fish)) == true) { // 정답일 경우
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
