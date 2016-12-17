
public class NotEndCode extends Sign {
	
	
	private String NotEndCode;
    public int NotEndCodeNum;
    
	public NotEndCode(String s)
	{
	
		this.NotEndCode=s;
		 this.setType(1);
		
	}

	public String getNotEndCode() {
		return NotEndCode;
	}

	public void setNotEndCode(String notEndCode) {
		NotEndCode = notEndCode;
	}
	
	public  String getSignString()
	{
		return NotEndCode;
	}
	public int getSignNum()
	{
		return NotEndCodeNum;
	}
}
