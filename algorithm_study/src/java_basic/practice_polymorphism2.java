package java_basic;

public class practice_polymorphism2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      // 다음 코드의 잘못된 부분과 왜 잘못됐는지 서술하시오
      
		/*
		 * par p = new chi(); chi c =(chi) new par();
		 */

      // 다음 코드의 실행 출력 내용은? 만약 오류가 발생한다면 왜 오류가 발생하는지 서술하시오
      
		/*
		 * par p = new chi(); System.out.println(p.x); p.method(p.x);
		 * System.out.println(p.x);
		 */
       
      // 다음 코드의 실행 출력 내용은? 만약 오류가 발생한다면 왜 오류가 발생하는지 서술하시오
      par2 p = new chi2();
      chi2 c = (chi2)p;
      System.out.println(c.x);
      c.method(c.x);
      System.out.println(c.x);
      System.out.println(p.x);
      p.method(p.x);
      System.out.println(p.x);
      
/*정답 란 : */
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