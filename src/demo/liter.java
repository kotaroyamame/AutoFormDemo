package demo;

public class liter {
	private String name_="";
	private int eage_=0;

	public liter(String name) {
		// TODO Auto-generated constructor stub
		name_=name;
	}
	public liter(String name,int e) {
		// TODO Auto-generated constructor stub
		name_=name;
		eage_=e;
	}
	public void setEage(int e){
		eage_=e;
	}
	public String getName(){
		return name_;
	}
	public int getEage(){
		return eage_;
	}
	public void jikosyokai(){
		StringBuffer jo=new StringBuffer();
		jo.append("私の名前は");
		jo.append(name_);
		jo.append("です。年は");
		jo.append(eage_);
		jo.append("です。");
		jo.toString();
		System.out.println(jo);
	}
	
}
