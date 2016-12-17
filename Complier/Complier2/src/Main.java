import java.util.Stack;

public class Main {

	private static  EndSign [] EndSignArray;
	private static  NotEndCode []NotEndCodeArray;
	public static Production []allProduction;
	private static GrammerAnaylise mp;
	public static int realProductionLength;
	public static Stack endsignFirst=new Stack<EndSign>();
	public static int []vainNum;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		         vainNum=new int[20];
			     mp = new GrammerAnaylise();
				try {
				
					 allProduction=new Production[50];
				     GrammerAnaylise.getChar(allProduction,realProductionLength);
				   //输出产生式
				  /*System.out.println(realProductionLength);
				   for(int k=0;k<40;k++)
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
		    }	*/
				  System.out.println("终结符个数："+GrammerAnaylise.getEndSignLength());
				  System.out.println("非终结符个数："+GrammerAnaylise.getNotEndCodeLenght());
				  
				  EndSignArray=GrammerAnaylise.getEndSignArray();
				  NotEndCodeArray=GrammerAnaylise.getNotEndCodeArray();
				  
				  System.out.println("终结符");
				  for(int i=0;i<GrammerAnaylise.getEndSignLength();i++)
				  {
					  System.out.println(EndSignArray[i].EndSignNum+"  "+EndSignArray[i].getEndSign());
				  }
				  System.out.println("非终结符");
				  for(int i=0;i<GrammerAnaylise.getNotEndCodeLenght();i++)
				  {
					  System.out.println(NotEndCodeArray[i].NotEndCodeNum+"  "+NotEndCodeArray[i].getNotEndCode());
				  }
				  
				  
				  
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int t;
				  for(int k=0;k<40;k++)
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
				  
				/*  System.out.println("能输出空的非终结符");
				  for(int k=0;k<GrammerAnaylise.getNotEndCodeLenght();k++)
				   {	       
						  	  
					  
					  if(NotEndCodeArray[k].vain)
						  System.out.println(NotEndCodeArray[k].getNotEndCode());
							
		
				    }	*/
				  
			  /*  System.out.println("能输出空的非终结符的序号");
				  for(int k=1;k<=vainNum[0];k++)
				   {	       
						  	  
					  
					 	  System.out.println(vainNum[k]);
							
		
				    }	*/
				  
				endsignFirst.clear();
				EndSign endsign1;
				for(int j=0;j<GrammerAnaylise.getNotEndCodeLenght();j++)
				{
					first(NotEndCodeArray[j]);
					while(!endsignFirst.isEmpty())
					{
						endsign1=(EndSign) endsignFirst.pop();
						NotEndCodeArray[j].mFirstset.firstSet.push(endsign1);
					}
					
				}
				
				System.out.println("非终结符的first集");
				EndSign endsign2;
				for(int j=0;j<GrammerAnaylise.getNotEndCodeLenght();j++)
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
	    
	
	//递归求first集
	public static void first( NotEndCode sign)
	{
		
		
		 Production production;
		 NotEndCode Code;
		 NotEndCode CodeTest;
		 EndSign result;
		 for(int i=0;i<40;i++)
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
					
						 endsignFirst.push(production.productionSign[k1]);
						 break;
						 
				 }
				 
				
				 
			 }
			 
			}
			 
		 }
		
		
		
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

}
