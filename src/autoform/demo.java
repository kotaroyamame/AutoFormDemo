package autoform;

public class demo {


	public static void main(String[] args) {
		String url="http://ptb.jp/%E5%8B%95%E4%BD%9C%E3%83%86%E3%82%B9%E3%83%88";
		form form=new form(url);
		exel ex=new exel();
		String[][] list_;
		ex.setRetsuSize(2, 1);
		list_=ex.get(ex.getSE(0,1),ex.getSE(1,1));
		for(String[] a:list_){
			for(String b:a){
			System.out.println(b);
			}
		}
		form.input(list_);

//		ArrayList<String> teststring=new ArrayList<>();
//		teststring.add(0,"a");
//		teststring.add(0,"b");
//		System.out.println(teststring.get(0)+teststring.get(1));
	}

	
	

}

