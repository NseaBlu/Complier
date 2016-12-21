
public class actiongoto {

	
	
	//1:移进  status:状态  2：规约  产生式头的编号    3：goto  状态
	int actiontype;
	int tostatus;
	public actiongoto(int actiontype,int tostatus)
	{
		this.actiontype=actiontype;
		this.tostatus=tostatus;
		
	}
	
	public actiongoto()
	{
		this.actiontype=0;
		this.tostatus=0;
	}
	
	
}
