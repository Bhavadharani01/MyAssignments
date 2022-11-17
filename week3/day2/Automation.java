package week3.day2;

public class Automation extends MultipleLangauge implements TestTool  {

	public void java() {
		System.out.println("Java");
		
	}

	public void Selenium() {
		System.out.println("Selenium");
		
	}

	@Override
	public void ruby() {
		System.out.println("Ruby");
		
	}
	
	public static void main(String[] args) {
		Automation obj = new Automation();
		obj.java();
		obj.Selenium();
		obj.ruby();
		obj.python();
	}

}
