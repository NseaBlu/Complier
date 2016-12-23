
public class EndSign extends Sign {

	
	private String EndSign;
    public int EndSignNum;
	public EndSign(String s)
	{
		this.EndSign=s;
		this.setType(0);
	}
	public EndSign(String s,int EndSignNum)
	{
		this.EndSign=s;
		this.EndSignNum=EndSignNum;
		this.setType(0);
	}
	public String getEndSign() {
		return EndSign;
	
	}

	public void setEndSign(String endSign) {
		EndSign = endSign;
	}
	
	
	public  String getSignString()
	{
		return EndSign;
	}
	
	public int getSignNum()
	{
		return EndSignNum;
	}
}
