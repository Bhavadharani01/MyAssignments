package week1.day1;

public class Mobile {
	
public void makeCall() {
      String mobileModel = "Pixel";
      float mobileWeight =	32.3f;
      System.out.println("MobileModel: "+mobileModel);
      System.out.println("MobileWeight: "+mobileWeight);
	}

public void sendMsg() {
	boolean isFullcharged = true;
	int mobileCost = 10000;
	System.out.println("Is Fully Charged: "+isFullcharged);
	System.out.println("Mobile Cost: "+mobileCost);
}

public static void main(String[] args) {

	System.out.println("This is my mobile");
	
	Mobile obj = new Mobile();
	obj.makeCall();
	obj.sendMsg();

}
}
//* ASSIGNMENT 2