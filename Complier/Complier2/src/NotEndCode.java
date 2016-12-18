
public class NotEndCode extends Sign {
	
	
	private String NotEndCode;
    public int NotEndCodeNum;
    public boolean vain;
    public FirstSet mFirstset;
    public int canGenProductionNum;
    public int []canGenProductionArrary;
    
    
    
	public NotEndCode(String s)
	{
	
		this.NotEndCode=s;
		 this.setType(1);
		 mFirstset=new FirstSet();
		 canGenProductionNum=0;
		 canGenProductionArrary=new int[50];
		
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
