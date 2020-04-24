package designpattern;
import java.util.Scanner;
public class Cardgame {
	public static void restart() { //게임을 재시작할지 말지 여부를 묻는 메소드
		Scanner scan = new Scanner(System.in);
		for(;;) {
			System.out.print("More game?[y/n]");
			char c = scan.next().charAt(0);
			try {					// try catch 문을 통해 예외처리를 해준다.
				if(c=='y'||c=='Y') { 
					cardstart();
				}
				else if(c=='n'||c=='N') {
					break;
				}
				else throw new Exception();	//예외를 강제로 catch문에 던진다, y,Y,n,N 외의 다른 문자가 입련된 경우
			}
			catch(Exception e) { //try문에서 던진 exception을 받아 처리하는 부분
				System.out.println("Please Enter the Correct Word.");
				
			}
		}
			System.out.println("Done."); 
		return; //사용자가 n/N을 눌렀을때 메소드를 끝맽기 위해 반환 main으로 반환 시킨다.
	}
	public static void card(int i) { //게임을 진행하는 메소드
		Scanner scan = new Scanner(System.in);
		int UserNum = 0;
		if(i==1) { // for문을 통한 카드게임 진행
			System.out.println("Hidden number is created. Try it");
			int rand = (int)(Math.random()*100); //0~99까지의 랜덤한 수를 생성한다. 
			for(;;) { // for문을 무한반복문으로 실행 시킨다.
				try { // try문을 이용해  예외처리
					UserNum = scan.nextInt();
				}
				catch(Exception e) { //예외가 발생했을때 실행되는 catch부분
					System.out.println(e);
					break;
				}
				if(UserNum>rand) { // 사용자가 입력한 수가 랜덤수 보다 클 경우 Lower를 출력 
					System.out.println("Lower");
				}
				else if(UserNum<rand) {
					System.out.println("Higher"); //반대
				}
				else break; // 맞췄을 때 중지
			}
		}
		else if(i==2) { //while문을 통한 카드게임
			System.out.println("Hidden number is created. Try it");
			int rand = (int)(Math.random()*100);
			while(true) {
				try {
					UserNum = scan.nextInt();
				}
				catch(Exception e) {
					System.out.println(e);
					break;
				}
				if(UserNum>rand) {
					System.out.println("Lower"); // for문과 동일
				}
				else if(UserNum<rand) {
					System.out.println("Higher");
				}
				else break;
			}
		}
		else if(i==3) {
			System.out.println("Hidden number is created. Try it");
			int rand = (int)(Math.random()*100);
			do { // do while문을 통한 카드게임 구현부
				try {
					UserNum = scan.nextInt();
				}
				catch(Exception e) {
					System.out.println(e);
					break;
				}
				if(UserNum>rand) {
					System.out.println("Lower"); 
				}
				else if(UserNum<rand){
					System.out.println("Higher");
				}
				else break;
			}while(true); // do while, while, for문 모두 구성이 같다. 
						  // 차이점으로 do while의 경우 최초 1회는 무조건 실행된다는 특징이 있다.(조건의 적합 여부 상관x)
		}
		restart(); // 게임 종료시 restart메소드 호출
	}
	public static void cardstart() { //게임진행 반복문을 선택하는 메소드
		System.out.println("1. for 2. while 3. do while");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		card(a); // 입력된 수 를 card 메소드에 전달 해 준다.
	}
	public static void main(String[] args) { //프로그램의 main 메소드
		cardstart(); // cardstart 메소드를 호출하므로써 프로그램을 동작시키는 역할을 한다.
		System.out.print("Bye Bye");
	}
}
