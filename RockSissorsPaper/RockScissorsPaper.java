package designpattern;
import java.util.Scanner;

public class RockScissorsPaper {
	public static void main(String[] arg) {
		int A, B;
		String a, b;
		Scanner scan = new Scanner(System.in); //문자 입력을 위해 Scanner 지정
		while(true) {
			while(true) {
				System.out.print("person-A >> ");
				a = scan.next();
				if(a.equals("가위")) { //문자열 값 자체를 비교하기 위해 equals매소드 사용
					A = 1; 
					break;
				}
				else if(a.equals("바위")) {
					A = 2;
					break;
				}
				else if(a.equals("보")) {
					A = 3;
					break;
				}
				else {
					System.out.println("다시 입력 하세요");
				}
			}
			while(true) {
				System.out.print("person-B >> ");
				b = scan.next();
				if(b.equals("가위")) {
					B = 1;
					break;
				}
				else if(b.equals("바위")) {
					B = 2;
					break;
				}
				else if(b.equals("보")) {
					B = 3;
					break;
				}
				else {
					System.out.println("다시 입력 하세요");
				}
			}
		if(A==B) {
			System.out.println("비겼습니다. 게임을 계속 진행합니다");
		}
		else if(A==1&&B==2||A==2&&B==3||A==3&&B==1) {
			System.out.println("결과 : 승자는 B 입니다");
			break;
		}
		else {
			System.out.println("결과 : 승자는 A 입니다.");
			break;
		}
	  }
		
   }
}
