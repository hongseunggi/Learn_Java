package designpattern;
import java.util.Scanner;

public class RockScissorsPaper {
	public static void main(String[] arg) {
		int A, B;
		String a, b;
		Scanner scan = new Scanner(System.in); //���� �Է��� ���� Scanner ����
		while(true) {
			while(true) {
				System.out.print("person-A >> ");
				a = scan.next();
				if(a.equals("����")) { //���ڿ� �� ��ü�� ���ϱ� ���� equals�żҵ� ���
					A = 1; 
					break;
				}
				else if(a.equals("����")) {
					A = 2;
					break;
				}
				else if(a.equals("��")) {
					A = 3;
					break;
				}
				else {
					System.out.println("�ٽ� �Է� �ϼ���");
				}
			}
			while(true) {
				System.out.print("person-B >> ");
				b = scan.next();
				if(b.equals("����")) {
					B = 1;
					break;
				}
				else if(b.equals("����")) {
					B = 2;
					break;
				}
				else if(b.equals("��")) {
					B = 3;
					break;
				}
				else {
					System.out.println("�ٽ� �Է� �ϼ���");
				}
			}
		if(A==B) {
			System.out.println("�����ϴ�. ������ ��� �����մϴ�");
		}
		else if(A==1&&B==2||A==2&&B==3||A==3&&B==1) {
			System.out.println("��� : ���ڴ� B �Դϴ�");
			break;
		}
		else {
			System.out.println("��� : ���ڴ� A �Դϴ�.");
			break;
		}
	  }
		
   }
}
