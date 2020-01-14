package java_basic;

public class practice_abstract {

	public static void main(String[] args) {
		// �߻�ȭ
		// ���ϼ��� ���� ������� �ʿ伺�� �ִٸ� �߻�ȭ Ŭ������ �����Ѵ�.
		// �߻�ȭ�� �ƴϴ��� �������̵� �������� �ڵ带 © �� ������ ����ΰ� �ָ�����
		basicCal c = new basicCal(1, 2);
		System.out.println(c.add(c.x, c.y));//3
		System.out.println();
		basicCal2 b = new basicCal2(1, 2);
		System.out.println(b.add(b.x, b.y));//3

		Calculator2 c2 = new Calculator2(4, 2) {//�ڼ�Ŭ������ �߻� �޼��带 ������ ���� �ƴ� abstract class��ü�� �ҷ��ö��� ���� ���Ǹ� ���־���Ѵ�. 
			@Override
			int mul(int x, int y) {
				// TODO Auto-generated method stub
				return x+y;
			}

			@Override
			int minus(int x, int y) {
				// TODO Auto-generated method stub
				return x-y;
			}

			@Override
			int div(int x, int y) {
				// TODO Auto-generated method stub
				return x/y;
			}

			@Override
			int add(int x, int y) {
				// TODO Auto-generated method stub
				return x*y;
			}
		};
		System.out.println();
		System.out.println(c2.add());//�Ϲ� �޼��带 �ҷ��� ��
		System.out.println(c2.add(2,3));//2,3�� �߻� add�޼��忡 ������� �ʰ� �߻�޼��忡�� �ۼ��� 4,2�� ����ȴ�. 
		System.out.println(c2.x+" "+c2.y);//4 2
	};

}

class Calculator {
	int x, y;

	Calculator(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class basicCal extends Calculator {
	basicCal(int x, int y) {
		super(x, y);
	}

	int add(int x, int y) {
		return x + y;
	}

	int minus(int x, int y) {
		return x - y;
	}

	int div(int x, int y) {
		return x / y;
	}

	int mul(int x, int y) {
		return x * y;
	}
}

abstract class Calculator2 {//�߻� Ŭ���������� �Ϲ� �޼��嵵 ���� �� �ִ�.
	int x, y;

	Calculator2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	abstract int add(int x, int y);// �߻� �޼��� ����

	abstract int minus(int x, int y);

	abstract int div(int x, int y);

	abstract int mul(int x, int y);

	int add() {
		return 10;
	};// �Ϲ� �޼��� --> �����ε��� �������� �Ű����� Ÿ���� �ٲٰ� ���� �̸����� ����

	int add(int x) {// �߻� �޼��� ����
		return x;
	}
}

class basicCal2 extends Calculator2 {
	basicCal2(int x, int y) {
		super(x, y);
	}

	int add(int x, int y) {// �߻� �޼��� ����
		return x + y;
	}

	int minus(int x, int y) {
		return x - y;
	}

	int div(int x, int y) {
		return x / y;
	}

	int mul(int x, int y) {
		return x * y;
	}
}

abstract class basicCal3 extends Calculator2 {// �߻� Ŭ������ abstract�� ����� �޼��带 �ݵ�� ���� �����ؾ��Ѵ�. �׷��� �ʴٸ� �ڼ� Ŭ������ absract Ŭ������
												// �����ؾ��Ѵ�.
	basicCal3(int x, int y) {
		super(x, y);
	}

	int add(int x, int y) {
		return x + y;
	}

	int minus(int x, int y) {
		return x - y;
	}

}
