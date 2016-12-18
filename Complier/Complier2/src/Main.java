import java.util.Stack;

public class Main {

	private static  EndSign [] EndSignArray;
	private static  NotEndCode []NotEndCodeArray;
	public static Production []allProduction;
	private static GrammerAnaylise mp;
	public static int realProductionLength;
	public static Stack endsignFirst=new Stack<EndSign>();
	public static int []vainNum;
	public static int endSignLength;
	public static int notEndCodeLength;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		         vainNum=new int[20];
			     mp = new GrammerAnaylise();
			    
			 	
			 	    init();//初始化
			 	    
				    printfEndSign();//输出终结符
				    printfNotEndCode();//输出非终结符
				    printfAllProduction();//输出所有产生式
				    printfNotEndCodeFirstSet();//输出非终结符的first集
				 
				    System.out.println("能输出空的非终结符");
				    for(int k=0;k<notEndCodeLength;k++)
				    {	       
						  	  
					  
					     if(NotEndCodeArray[k].vain)
						  System.out.println(NotEndCodeArray[k].getNotEndCode());
							
		
				     }	
				  
			        System.out.println("能输出空的非终结符的序号");
				   for(int k=1;k<=vainNum[0];k++)
				   {	       
						  	  
					  
					 	  System.out.println(vainNum[k]);
							
		
				    }	
			
				
				
	
	}
	
	
	public static void init()
	{
		 allProduction=new Production[50];
	
		try {
			
			
	 		realProductionLength=GrammerAnaylise.getChar(allProduction);

		     EndSignArray=GrammerAnaylise.getEndSignArray();
		     NotEndCodeArray=GrammerAnaylise.getNotEndCodeArray();
		     
		     
		     endSignLength=GrammerAnaylise.getEndSignLength();
	         notEndCodeLength=GrammerAnaylise.getNotEndCodeLenght();
					
	         System.out.println("终结符个数："+endSignLength);
		     System.out.println("非终结符个数："+notEndCodeLength);
		     System.out.println("产生式个数："+realProductionLength);
		  
		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		findGenVainNotEndSignNum();//找出能推出空的非终结符
    	findAllNotEndSignFirstSet();//找出所有非终结符的first集
    	signAllNotEndSign();
	}
	
	
	
	public static void findAllNotEndSignFirstSet()
	{
		//求每个非终结符的  first集
		endsignFirst.clear();
		EndSign endsign1;
		for(int j=0;j<notEndCodeLength;j++)
		{
			first(NotEndCodeArray[j]);
			while(!endsignFirst.isEmpty())
			{
				endsign1=(EndSign) endsignFirst.pop();
				NotEndCodeArray[j].mFirstset.firstSet.push(endsign1);
			}
			
		}
		
	}
	
	
	public static void findGenVainNotEndSignNum()
	{
		//找出能推出空的非终结符
		int t;
		  for(int k=0;k<realProductionLength;k++)
		   {	       
				  	  
					if(allProduction[k].productionSign[0].getSignString().equals("ε"))
					{
						t=allProduction[k].getHead().NotEndCodeNum;
						vainNum[0]+=1;
						vainNum[vainNum[0]]=t;
						NotEndCodeArray[t].vain=true;
					    
					}
					else
					{
                         t=allProduction[k].getHead().NotEndCodeNum;
						
						NotEndCodeArray[t].vain=false;
					}
		    }	
	}
	
	
	//递归求first集
	public static void first( NotEndCode sign)
	{
		
		
		 Production production;
		 NotEndCode Code;
		 NotEndCode CodeTest;
		 EndSign result;
		 for(int i=0;i<realProductionLength;i++)
		 {
			 
		
			 production=allProduction[i];
			 Code= production.getHead();
			 if(sign.getNotEndCode().equals(Code.getNotEndCode()))
			 {
				// System.out.println(i);
				 
				 for(int k1=0;k1<production.productionLength;k1++)
			 {
				 if(production.productionSign[k1].type==1)
				 {
					 
					 NotEndCode middle=(NotEndCode) production.productionSign[k1];
					 int testNum;
					 testNum=middle.getSignNum();
					 if(middle.getNotEndCode().equals(Code.getNotEndCode()))				 
					 {
						 
						 
						 if(!iscanGenVain(testNum))
						 break;
						 
						 else continue;
					 }
					 else
					 {
					 CodeTest=(NotEndCode) production.productionSign[k1];
					 first(CodeTest);
					 }
					
					 if((k1!=(production.productionLength-1))&&!iscanGenVain(production.productionSign[k1+1].getSignNum()))
						 break;
					
				 }
				 else 
				 {
					
					 if(!isIntheEndSignStack(production.productionSign[k1]))
						 endsignFirst.push(production.productionSign[k1]);
						 break;
						 
				 }
				 
				
				 
			 }
			 
			}
			 
		 }
		
		
	
	}
	
	
	//检查非终结符是否已经存在，使用全局变量的栈
	public static boolean isIntheEndSignStack(Sign endsignTest)
	{
		
		int i;
		EndSign mEndsign3;
		for(i=0;i<endsignFirst.size();i++)
		{ 
			
			mEndsign3=(EndSign) endsignFirst.get(i);
			if(endsignTest.getSignString().equals(mEndsign3.getSignString()))
				return true;
			
		}
		return false;
		
	}
	//按照编号看是否生成空串
   public static boolean iscanGenVain(int testNum)
   {
	   
	     for(int k=1;k<=vainNum[0];k++)
	     {
	    	 if(testNum==vainNum[k])
	    		 return true;
	    	 
	     }
	   
	         return false;
	   
   }
   
   //标记所有非终结符可产生的产生式的编号
   public static void signAllNotEndSign()
   {
	   int k;
	   NotEndCode mHead;
	   int notendcodeNum;
	   int productionNum;
	   int j;
	   for(k=0;k<realProductionLength;k++)
	   {
		   mHead=allProduction[k].getHead();
		   notendcodeNum=mHead.getSignNum();
		   productionNum=allProduction[k].ProductionNum;
		   j=NotEndCodeArray[notendcodeNum].canGenProductionNum;
		   NotEndCodeArray[notendcodeNum].canGenProductionArrary[j]=productionNum;
		   NotEndCodeArray[notendcodeNum].canGenProductionNum+=1;
	   }
   }
   
   public static void printfAllProduction()
   {
	   //输出产生式
		  System.out.println(realProductionLength);
		   for(int k=0;k<realProductionLength;k++)
      {	       
		  	   System.out.println(allProduction[k].ProductionNum+allProduction[k].getHead().getNotEndCode());
			
			for(int j=0;j<allProduction[k].productionLength;j++)
			 {
				if(j!=(allProduction[k].productionLength-1))
				{
					System.out.print(allProduction[k].productionSign[j].getSignString()+allProduction[k].productionSign[j].getSignNum()+
							allProduction[k].productionSign[j].getType()+' ');
				}
				else
				{
					System.out.println(allProduction[k].productionSign[j].getSignString()+allProduction[k].productionSign[j].getSignNum()+
							allProduction[k].productionSign[j].getType());
				}
			 }
       }	
   }
   
   
   public static void printfNotEndCodeFirstSet()
   {
	   System.out.println("非终结符的first集");
		EndSign endsign2;
		for(int j=0;j<notEndCodeLength;j++)
		{
			System.out.println(NotEndCodeArray[j].getNotEndCode()+":");
			for(int i=0;i<NotEndCodeArray[j].mFirstset.firstSet.size();i++)
			{
				endsign2=NotEndCodeArray[j].mFirstset.firstSet.get(i);
				System.out.print(endsign2.getEndSign()+" ");
			}
			System.out.println(" ");
		}
   }
 
   
   public static void printfEndSign()
   {
     System.out.println("终结符");
	  for(int i=0;i<endSignLength;i++)
	  {
		  System.out.println(EndSignArray[i].EndSignNum+"  "+EndSignArray[i].getEndSign());
	  }
   }
   
   public static void printfNotEndCode()
   {
	  System.out.println("非终结符及非终结符可推出的产生式的编号");
	  for(int i=0;i<notEndCodeLength;i++)
	  {
		  System.out.println(NotEndCodeArray[i].NotEndCodeNum+"  "+NotEndCodeArray[i].getNotEndCode());
		  for(int j=0;j<NotEndCodeArray[i].canGenProductionNum;j++)
		  {
			  System.out.print(NotEndCodeArray[i].canGenProductionArrary[j]+" ");
		  }
		  System.out.println(" ");
		  
	  }
   }
	  

}
