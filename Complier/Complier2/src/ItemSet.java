import java.util.Stack;

//�


public class ItemSet {

	public boolean shutornot;
	public Stack<SetVirtualPro>  mSetVirtualPro;
	public int setvirtualProNum;
	public int id;
	private Stack<SetVirtualPro> mm;
	public ItemSet(int id)
	{
		this.id=id;
		shutornot=false;
	    mSetVirtualPro=new Stack<SetVirtualPro>();
	    setvirtualProNum=0;
	}
	public ItemSet()
	{
		
	    mSetVirtualPro=new Stack<SetVirtualPro>();
	    setvirtualProNum=0;
	    shutornot=false;
	}
	public ItemSet(Stack<SetVirtualPro>  mSetVirtualPro2,int id)
	{
		
	
		SetVirtualPro m;
	    mSetVirtualPro=new Stack<SetVirtualPro>();
	    for(int i=0;i<mSetVirtualPro2.size();i++)
	    {
	    	m=new SetVirtualPro(mSetVirtualPro2.get(i).productionNum,mSetVirtualPro2.get(i).pointer,mSetVirtualPro2.get(i).firstSet,mSetVirtualPro2.get(i).firstSetNum);
	    	mSetVirtualPro.add(m);
	    }
	    setvirtualProNum=mSetVirtualPro2.size();
	    this.id=id;
	    shutornot=false;
	}
	public void addsetvirtualPro(SetVirtualPro svP)
	{
		
		
		
		if(setvirtualProNum==0)
		{
			mSetVirtualPro.push(svP);
		    this.setvirtualProNum+=1;
		}
		
		else
		{
			boolean flag=false;
			int pn=svP.productionNum;
			int i;
			for( i=0;i<this.setvirtualProNum;i++)
			{
			      if(this.mSetVirtualPro.get(i).productionNum==pn)
			      {
			    	  flag=true;
			    	  break;
			      }
			      if(this.mSetVirtualPro.get(i).productionNum>pn)
			    	  break;
			            	   
			            	   
			}
			if(!flag)
			{
				if(i==this.setvirtualProNum)
				{
					mSetVirtualPro.push(svP);
				    this.setvirtualProNum+=1;
				}
				else 
				{
					mm = new Stack<SetVirtualPro>();
				    while(this.mSetVirtualPro.size()>i)
				    {
				    	mm.push(this.mSetVirtualPro.pop());
				    	
				    }
				    
				    this.mSetVirtualPro.push(svP);
				    while(!mm.isEmpty())
				    {
				    	this.mSetVirtualPro.push(mm.pop());
				    	
				    }
				    this.setvirtualProNum+=1;
				}
			}
			else
			{
				if(this.mSetVirtualPro.get(i).pointer==svP.pointer)
				{
					for(int d2=0;d2<svP.firstSetNum;d2++)
					{
						this.mSetVirtualPro.get(i).addfirstset(svP.firstSet[d2]);
					}
				}
				else
				{
					if(this.mSetVirtualPro.get(i).pointer>svP.pointer)
					{
						mm = new Stack<SetVirtualPro>();
					    while(this.mSetVirtualPro.size()>i)
					    {
					    	mm.push(this.mSetVirtualPro.pop());
					    	
					    }
					    
					    this.mSetVirtualPro.push(svP);
					    while(!mm.isEmpty())
					    {
					    	this.mSetVirtualPro.push(mm.pop());
					    	
					    }
					    this.setvirtualProNum+=1;
					}
					else
					{
						mm = new Stack<SetVirtualPro>();
					    while(this.mSetVirtualPro.size()>(i+1))
					    {
					    	mm.push(this.mSetVirtualPro.pop());
					    	
					    }
					    
					    this.mSetVirtualPro.push(svP);
					    while(!mm.isEmpty())
					    {
					    	this.mSetVirtualPro.push(mm.pop());
					    	
					    }
					    this.setvirtualProNum+=1;
					}
				}
			}
			
			
		}
	}
}
