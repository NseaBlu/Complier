import java.util.Stack;

//项集中的产生式

public class SetVirtualPro {

	
	public int productionNum; 
	public int pointer;
	public int []firstSet;
	public int firstSetNum;
	public boolean end;
	public SetVirtualPro(int productionNum,int pointer)
	{
		this.pointer=pointer;
		this.productionNum=productionNum;
		
		firstSet=new int[50];
		firstSetNum=0;
		end=false;
		
		
		
	}
	public SetVirtualPro(int productionNum,int pointer,int []firstSet,int firstsetNum)
	{
		this.pointer=pointer;
		this.productionNum=productionNum;
		
		this.firstSet=new int[50];
		this.firstSet=firstSet;
		this.firstSetNum=firstsetNum;
		end=false;
		
		
	}
	public SetVirtualPro()
	{
		firstSet=new int[50];
		firstSetNum=0;
		end=false;
	}
	public void addfirstset(int endsignNum)
	{
		boolean flag=true;
		if(this.firstSetNum==0)
		{	
			firstSet[firstSetNum]=endsignNum;
		    this.firstSetNum+=1;
		}
		else
		{
			int i;
			for(i=0;i<this.firstSetNum;i++)
			{
				if(firstSet[i]==endsignNum)
				{
					flag=false;
					break;
				}
				if(firstSet[i]>endsignNum)
				{
					break;
				}
			}
			
			if(flag)
		  {
				if(i<this.firstSetNum)
		
			{
				for(int j=this.firstSetNum;j>i;j--)
				{
					this.firstSet[j]=this.firstSet[j-1];
					
				}
				this.firstSet[i]=endsignNum;
				
			}
			else
			{
				this.firstSet[firstSetNum]=endsignNum;
			}
			  this.firstSetNum+=1;
		  }
		}
	}
	
}
