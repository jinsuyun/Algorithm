package java_basic;

public class practice_polymorphism2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // ���� �ڵ��� �߸��� �κа� �� �߸��ƴ��� �����Ͻÿ�
      
		/*
		 * par p = new chi(); chi c =(chi) new par();
		 */

      // ���� �ڵ��� ���� ��� ������? ���� ������ �߻��Ѵٸ� �� ������ �߻��ϴ��� �����Ͻÿ�
      
		/*
		 * par p = new chi(); System.out.println(p.x); p.method(p.x);
		 * System.out.println(p.x);
		 */
       
      // ���� �ڵ��� ���� ��� ������? ���� ������ �߻��Ѵٸ� �� ������ �߻��ϴ��� �����Ͻÿ�
      par2 p = new chi2();
      chi2 c = (chi2)p;
      System.out.println(c.x);
      c.method(c.x);
      System.out.println(c.x);
      System.out.println(p.x);
      p.method(p.x);
      System.out.println(p.x);
      
/*���� �� : */
   }

}

class par {
   int x = 10;

   void method(int x) {
      this.x = 30;
   }
}

class chi extends par {
   int x = 20;

   void method(int x) {
      this.x = 100;
   }
}

class par2 {
   int x = 30;

   void method(int x) {
      x = 1000;
   }
}

class chi2 extends par2 {
   int x = 40;

   void method(int x) {
      x = 10000;
   }
}