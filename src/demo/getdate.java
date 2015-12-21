package demo;
import java.time.LocalDate;
public class getdate {

	public getdate() {
		// TODO Auto-generated constructor stub
	}
	LocalDate date = LocalDate.now();
	int a=date.getDayOfMonth();
	public void get(){
		System.out.println(a);
	}
}

