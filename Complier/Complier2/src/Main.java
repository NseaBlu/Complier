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
	public static Stack<ItemSet> allItemSet;
	public static Stack<ItemSet> allItemSetnotPop;
	public static SetVirtualPro addgrammer;
	public static int allItemSetNum;
	private static ItemSet testItemSet;
	private static Stack testSetVirtualPro;
	public static AnayliseTable mAnayliseTable;
	public static boolean endornot;
	public static int originstatus;
	public static int nowstatus;
	public static actiongoto ggttoo;
	public static actiongoto aacctt;
	private static boolean setequalornot;
	
	public static TokenAnaylise ta;
	public static EndSign[] inputSign;//输入存储
	public static int inputSignNum;
	public static Stack<status> inputstatus;//状态压栈
	public static Stack<EndSign> inputRecieve;//接受输入
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		          vainNum=new int[20];
			      mp = new GrammerAnaylise();
			      ta=new TokenAnaylise();
			      inputSign=new EndSign[50];
			      allItemSet=new Stack<ItemSet>();
			      allItemSetnotPop=new Stack<ItemSet>();
			      mAnayliseTable=new AnayliseTable();
			      inputRecieve=new Stack<EndSign>();
			      inputstatus=new Stack<status>();
			      
			      
			      endornot=false;
			      try {
					inputSignNum=TokenAnaylise.getChar(inputSign);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      for(int inputI=0;inputI<inputSignNum;inputI++)
			      {
			    	  System.out.println(inputSign[inputI].getEndSign()+" "+inputSign[inputI].getSignNum());
			      }
			      
			      
			      
			      
			 	/*  init();//初始化
			 	    
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
		
			 	   allItemSetNum=0;
			 	   addgrammer=new SetVirtualPro(realProductionLength-1,0);
			 	   addgrammer.addfirstset(endSignLength-1);
				   ItemSet firstItemSet=new ItemSet(allItemSetNum);
				   firstItemSet.addsetvirtualPro(addgrammer);
				   firstItemSet=closure(firstItemSet);
				   for(int i=0;i<firstItemSet.setvirtualProNum;i++)
			 	   {
			 		   System.out.print("0:"+firstItemSet.mSetVirtualPro.get(i).productionNum);
			 	   }
				   System.out.println(" ");	   
				   // firstItemSet=closure(firstItemSet);
				    
				   allItemSet.push(firstItemSet);
				   allItemSetnotPop.push(firstItemSet);
				   allItemSetNum+=1;
				   System.out.println(":::"+allItemSetNum);
				   ItemSet middleItemSet=new ItemSet();
				 
				   ItemSet middleItemSet22=new ItemSet();
				   int time=0;
				 
				   while(!allItemSet.isEmpty())
				   {
					 // if(time==10)break;
					   ItemSet keepmiddleItemSet=new ItemSet();
					   keepmiddleItemSet=allItemSet.pop();
					   
					   originstatus=keepmiddleItemSet.id;
					   
					   //输入终结符
					   for(int d1=0;d1< notEndCodeLength-1;d1++)
					   {
						   System.out.println("集合编号"+keepmiddleItemSet.id);
						   for(int i=0;i< keepmiddleItemSet.setvirtualProNum;i++)
					 	   {
					 		   System.out.println("keep"+ keepmiddleItemSet.mSetVirtualPro.get(i).productionNum+" "+keepmiddleItemSet.mSetVirtualPro.get(i).pointer);
					 		   for(int ppp=0;ppp<keepmiddleItemSet.mSetVirtualPro.get(i).firstSetNum;ppp++)
					 		   {
					 			   System.out.print(keepmiddleItemSet.mSetVirtualPro.get(i).firstSet[ppp]);
					 		   }
					 		   System.out.println(" ");
					 	   }
						   middleItemSet=new ItemSet(keepmiddleItemSet.mSetVirtualPro,keepmiddleItemSet.id);
						   System.out.println("输入非终结符："+NotEndCodeArray[d1].getSignString());
						   middleItemSet22=Goto(middleItemSet,d1,1);
						   if(middleItemSet22.setvirtualProNum==0)
						   {
							   
						   }
						   else
						   {
							   middleItemSet22.id=allItemSetNum;
							   if(middleItemSet22.shutornot)break;
							   else
							   {
								  
								   ItemSet testItemset;
								   for(int tt=0;tt< allItemSetnotPop.size();tt++)
								   {
									   System.out.println("总集合的元素个数："+allItemSetnotPop.size());
									   setequalornot=true;
									   testItemSet= allItemSetnotPop.get(tt);
									   System.out.println("对比的集合编号"+testItemSet.id);
									   if(testItemSet.setvirtualProNum!=middleItemSet22.setvirtualProNum)
									   {
										   System.out.println("集合元素个数不相等："+testItemSet.setvirtualProNum+middleItemSet22.setvirtualProNum);
										   setequalornot=false;
									   }
									   else
									   {
										   System.out.println("集合元素个数相等："+testItemSet.setvirtualProNum+middleItemSet22.setvirtualProNum);
										   for(int tt2=0;tt2<middleItemSet22.setvirtualProNum;tt2++)
										   {
											   
											   if(testItemSet.mSetVirtualPro.get(tt2).productionNum==middleItemSet22.mSetVirtualPro.get(tt2).productionNum)
											   {
												   System.out.println("集合里的产生式相等：");
												   if(testItemSet.mSetVirtualPro.get(tt2).firstSetNum==middleItemSet22.mSetVirtualPro.get(tt2).firstSetNum)
												   {
													  System.out.println("first集个数相等：");
													   for(int tt3=0;tt3<testItemSet.mSetVirtualPro.get(tt2).firstSetNum;tt3++)
													   {
														   if(testItemSet.mSetVirtualPro.get(tt2).firstSet[tt3]==middleItemSet22.mSetVirtualPro.get(tt2).firstSet[tt3]);
														   else
															   {
															     System.out.println("first集不一样");
															     setequalornot=false;
															     break;
															      
															   }
													   }
												   }
												   else 
													   {
													   System.out.println("first集个数不相等：");
													      setequalornot=false;
													      break;
													   }
											   }
											   else 
												   {
												   System.out.println("集合里的产生式不相等：");
												      setequalornot=false;
												      break;
												   }
											
										   }
										   if(setequalornot)break;
									   }
									   
								   }
								   
							        if(!setequalornot)
							      { nowstatus=middleItemSet22.id;
							            allItemSetnotPop.push(middleItemSet22);
							             ggttoo=new actiongoto(3,nowstatus);
							               mAnayliseTable.gototable[originstatus][d1]=ggttoo;
							  // System.out.print("shshi "+mAnayliseTable.gototable[originstatus][d1].actiontype+"."+mAnayliseTable.gototable[originstatus][d1].tostatus+" ");
							         //  System.out.println("ggttoo");
							                 allItemSet.push(middleItemSet22);
							                  allItemSetNum+=1;
							      }
							        else
							        {
							          System.out.println("有相同");
							           nowstatus=testItemSet.id;
							           ggttoo=new actiongoto(1,nowstatus);
						               mAnayliseTable.gototable[originstatus][d1]=ggttoo;
							        }
							  
							   
							   }
						   }
						  
						   
						   System.out.println("项集总个数"+allItemSetNum);
						   System.out.println("项集总个数"+" middleItemSet22编号："+ middleItemSet22.id);
						   for(int i=0;i<middleItemSet22.setvirtualProNum;i++)
					 	   {
					 		   System.out.println("拓展产生式编号"+middleItemSet22.mSetVirtualPro.get(i).productionNum);
					 	   }
					   }
					   
					  
					 
					   
					   //输入fei终结符
					   for(int d2=0;d2< endSignLength-1;d2++)
					   {
						   
						   for(int i=0;i< keepmiddleItemSet.setvirtualProNum;i++)
					 	   {
					 		   System.out.println("keep"+ keepmiddleItemSet.mSetVirtualPro.get(i).productionNum+" "+keepmiddleItemSet.mSetVirtualPro.get(i).pointer);
					 		  for(int ppp=0;ppp<keepmiddleItemSet.mSetVirtualPro.get(i).firstSetNum;ppp++)
					 		   {
					 			   System.out.print(keepmiddleItemSet.mSetVirtualPro.get(i).firstSet[ppp]);
					 		   }
					 		   System.out.println(" ");
					 	   
					 	   
					 	   }
						   middleItemSet=new ItemSet(keepmiddleItemSet.mSetVirtualPro,keepmiddleItemSet.id);
						   System.out.println("输入非终结符:"+EndSignArray[d2].getSignString());
						   middleItemSet22=Goto(middleItemSet,d2,0);
						   if(middleItemSet22.setvirtualProNum==0)
						   {
							   
						   }
						   else
						   {
							   middleItemSet22.id=allItemSetNum;
							   if(middleItemSet22.shutornot)break;
							   else
							   {
								   ItemSet testItemset;
								  
								   for(int tt=0;tt<allItemSetnotPop.size();tt++)
								   {
									   System.out.println("总集合的元素个数："+allItemSetnotPop.size());
									   setequalornot=true;
									   testItemSet=allItemSetnotPop.get(tt);
									   System.out.println("对比的集合编号"+testItemSet.id);
									   if(testItemSet.setvirtualProNum!=middleItemSet22.setvirtualProNum)
									   {
										   
										  System.out.println("集合元素个数不相等："+testItemSet.setvirtualProNum+middleItemSet22.setvirtualProNum);
										   setequalornot=false;
									   }
									   else
									   {
										   
										   System.out.println("集合元素个数相等："+testItemSet.setvirtualProNum+middleItemSet22.setvirtualProNum);
										   for(int tt2=0;tt2<middleItemSet22.setvirtualProNum;tt2++)
										   {
											   if(testItemSet.mSetVirtualPro.get(tt2).productionNum==middleItemSet22.mSetVirtualPro.get(tt2).productionNum)
											   {
												   
												   System.out.println("集合里的产生式相等：");
												   if(testItemSet.mSetVirtualPro.get(tt2).firstSetNum==middleItemSet22.mSetVirtualPro.get(tt2).firstSetNum)
												   {
													   System.out.println("first集个数相等");
													   for(int tt3=0;tt3<testItemSet.mSetVirtualPro.get(tt2).firstSetNum;tt3++)
													   {
														   if(testItemSet.mSetVirtualPro.get(tt2).firstSet[tt3]==middleItemSet22.mSetVirtualPro.get(tt2).firstSet[tt3]);
														   else
															   {
															   System.out.println("first集不一样");
															     setequalornot=false;
															     break;
															      
															   }
													   }
												   }
												   else 
													   {
													   
													     System.out.println("first集个数不相等：");
													      setequalornot=false;
													      break;
													   }
											   }
											   else 
												   {
												     System.out.println("集合里的产生式不相等：");
												      setequalornot=false;
												      break;
												   }
											 if(setequalornot)
												 {
												    
												 System.out.println("有相同");
												      break;
												 }
										   }
										   
										   if(setequalornot)
											 {
											    
											 System.out.println("有相同");
											      break;
											 }
									   }
								   }
								   if(!setequalornot)
								   {   nowstatus=middleItemSet22.id;
							   allItemSetnotPop.push(middleItemSet22);
							   aacctt=new actiongoto(1,nowstatus);
							   mAnayliseTable.actiontable[originstatus][d2]=aacctt;
							   allItemSet.push(middleItemSet22);
							   allItemSetNum+=1;
								   }
								   else
								   {
									   nowstatus=testItemSet.id;
									   aacctt=new actiongoto(1,nowstatus);
									   mAnayliseTable.actiontable[originstatus][d2]=aacctt;
								   }
							   }
						   }
						  
						   System.out.println("项集总个数"+allItemSetNum);
						   System.out.println("项集总个数"+" middleItemSet22编号："+ middleItemSet22.id);
						   for(int i=0;i<middleItemSet22.setvirtualProNum;i++)
					 	   {
					 		   System.out.println("拓展产生式编号"+middleItemSet22.mSetVirtualPro.get(i).productionNum);
					 	   }
					   }
					   
					   System.out.print( "状态"+"  |");
					   int oo;
					   for( oo=0;oo<endSignLength;oo++)
						   System.out.print( EndSignArray[oo].getEndSign()+"   |");
						   for( oo=endSignLength;oo<(endSignLength+notEndCodeLength-1);oo++)
						  {
						      System.out.print( NotEndCodeArray[oo-endSignLength].getNotEndCode()+" |");
						   }
						   System.out.println(" ");
					   for(int i=0;i<15;i++)
					   {
						   
						   int j;
						   System.out.print(i+"  |");
						   for(j=0;j<endSignLength;j++)
						   System.out.print(mAnayliseTable.actiontable[i][j].actiontype+"."+mAnayliseTable.actiontable[i][j].tostatus+" |");
						   for(j=endSignLength;j<(endSignLength+notEndCodeLength-1);j++)
						  {
						      System.out.print(mAnayliseTable.gototable[i][j-endSignLength].actiontype+"."+mAnayliseTable.gototable[i][j-endSignLength].tostatus+" |");
						   }
						   System.out.println(" ");
					   }
					   time+=1;
				   }
			 	 
			 	    
			 )*/
			      
			      
			     
			      
			 
			     
			      
			      
			      
			      
	
	}
	
	//语法分析
    //栈 符号 输入  动作
	//1:移进  status:状态  2：规约  产生式头的编号    3：goto  状态
	
	//public static EndSign[] inputSign;//输入存储
	//public static int inputSignNum;
	//public static Stack<status> inputstatus;//状态压栈
	//public static Stack<EndSign> inputRecieve;//接受输入
	public  static void Anaylise()
	{
		
		
		//初始化状态栈
		status statush;
		statush=new status(0);
		inputstatus.push(statush);
		
		
		
		
	}
	
	//闭包函数
	public static ItemSet closure(ItemSet I)
	{
		
		
		
		testSetVirtualPro = new Stack<SetVirtualPro>();
		
		
		for(int i=0;i<I.mSetVirtualPro.size();i++)
		{
			testSetVirtualPro.push(I.mSetVirtualPro.get(i));
		}
		
		
		SetVirtualPro help;
		SetVirtualPro help2 ;
		SetVirtualPro help3;
		int []totalFirstSet=new int[40];
		int totalFirstNum=0;
		int productionNum;
		int mpointer;
		int signNum;
		int signtype;
		int signtype2;
		int i;
		int helpProductionLength;
		int endsignNum2;
		int notendcodeNum2;
		int notendcodeNum3;
		int pp;
		while(!testSetVirtualPro.isEmpty())
		{
		   //  System.out.println("1");
			
			help=(SetVirtualPro) testSetVirtualPro.pop();
			mpointer=help.pointer;
			productionNum=help.productionNum;
			helpProductionLength=allProduction[productionNum].productionLength;
			if(mpointer==allProduction[productionNum].productionLength);//到达产生式末尾
			else
			{
				//  System.out.println("1");
				signtype=allProduction[productionNum].productionSign[mpointer].type;
				
				if(signtype==0);//遇到终结符
				else
				{
					
				//	System.out.println("1");
					help2=new SetVirtualPro();
					//算出first集
					
					for(i=mpointer+1;i<=helpProductionLength;i++)
				{
						if(i==helpProductionLength)//到达产生式末尾
					{
						//	System.out.println("1");
						for(int t=0;t<help.firstSetNum;t++)
						{
							help2.addfirstset(help.firstSet[t]);
						}
					}
					else 
					{
						signtype2=allProduction[productionNum].productionSign[i].type;
						
						if(signtype2==0)
						{
							endsignNum2=allProduction[productionNum].productionSign[i].getSignNum();
							help2.addfirstset(endsignNum2);
						}
						else
						{
							
						    notendcodeNum2=allProduction[productionNum].productionSign[i].getSignNum();
							for(int p=0;p<NotEndCodeArray[notendcodeNum2].mFirstset.firstSet.size();p++)	
							{
								EndSign endsign;
								endsign=NotEndCodeArray[notendcodeNum2].mFirstset.firstSet.get(p);
								help2.addfirstset(endsign.getSignNum());
								
							}
							if(!iscanGenVain(notendcodeNum2))	
								break;
							
						}
					}
				 }
					//System.out.println("1");
					notendcodeNum3=allProduction[productionNum].productionSign[mpointer].getSignNum();
					
				for(int	q=0;q< NotEndCodeArray[notendcodeNum3].canGenProductionNum;q++)
				{
				//	System.out.println("1");
					int m=NotEndCodeArray[notendcodeNum3].canGenProductionArrary[q];
					int n;
					
					help3=new SetVirtualPro(m,0,help2.firstSet,help2.firstSetNum);
					for(n=0;n<I.mSetVirtualPro.size();n++)
					{
						pp=I.mSetVirtualPro.get(n).productionNum;
						if(pp==m){
							break;
						}
					}
				//	if(n==I.mSetVirtualPro.size())
				//	{
						
						  // System.out.println("2");
							
						testSetVirtualPro.push(help3);
						I.addsetvirtualPro(help3);
				
						
				//	}
					
				}
					
					
			   }
				
				
				
				
				
			}
				
			
			
			
			
			
			
		}
	
		SetVirtualPro cc=new SetVirtualPro();
		  for(int i1=0;i1<I.setvirtualProNum;i1++)
	 	   {
	 		   System.out.println("closure:"+I.mSetVirtualPro.get(i1).productionNum);
	 		cc=  I.mSetVirtualPro.get(i1);
	 		
	 		  for(int j1=0;j1<cc.firstSetNum;j1++)
	 		  {
	 			  System.out.print(cc.firstSet[j1]+" ");
	 		  }
	 		  System.out.println(" ");
	 	   }
		
		
		
		
		return I;
		
	}
	public static ItemSet Goto(ItemSet I,int signNum,int signtype)
	{
		
		int id=I.id;
		ItemSet returnItemSet=new ItemSet();
		SetVirtualPro stacksvP;
		int pp;
		int signnum2;
		int productionNum;
		int addnum=0;
		int endtruenum=0;
        for(int i=0;i<I.setvirtualProNum;i++)
        {
        	
        	
        	//System.out.println("3");
        	stacksvP=I.mSetVirtualPro.get(i);
        	pp=stacksvP.pointer;
        	productionNum=stacksvP.productionNum;
        	 System.out.println("goto:productionNum"+productionNum);
        	if(pp!=allProduction[productionNum].productionLength)
        	{
        		if(allProduction[productionNum].productionSign[pp].getSignNum()==signNum&&allProduction[productionNum].productionSign[pp].type==signtype)
        	
        	  {
        			 
        			System.out.println("YES");
        		    stacksvP.pointer+=1;
        		    
        		    returnItemSet.addsetvirtualPro(stacksvP);
        		    addnum+=1;
        	  }
        	}
        	else
        	{
        		actiongoto ag;
        		System.out.println("规约"+id+signNum);
    			if(productionNum==(realProductionLength-1))
    			    ag=new actiongoto(4,productionNum);
    			else ag=new actiongoto(2,productionNum);
    			int guiyueafter;
        		for(int d3=0;d3<stacksvP.firstSetNum;d3++)
        		{
        			
        			guiyueafter=stacksvP.firstSet[d3];
        			mAnayliseTable.actiontable[id][guiyueafter]=new actiongoto();
        			 mAnayliseTable.actiontable[id][guiyueafter]=ag;
        			 System.out.println("规约+++"+guiyueafter+" "+ mAnayliseTable.actiontable[id][guiyueafter].actiontype+ mAnayliseTable.actiontable[id][guiyueafter].tostatus);
        			
        		}
        		
        		stacksvP.end=true;
        		endtruenum+=1;
        	}
        	
        }
		if(endtruenum==I.setvirtualProNum)
		{
			I.shutornot=true;
			return I;
		}
		
		else return closure(returnItemSet);
		
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
    	EndSignArray[endSignLength]=new EndSign("$");//终结符加入一个结束符
    	EndSignArray[endSignLength].EndSignNum=endSignLength;
    	endSignLength+=1;
    	NotEndCodeArray[notEndCodeLength]=new NotEndCode("<G>");
    	NotEndCodeArray[notEndCodeLength].NotEndCodeNum=notEndCodeLength;
    	notEndCodeLength+=1;
    	
    	Production addProduction=new Production();//增广文法
    	addProduction.setHead(NotEndCodeArray[notEndCodeLength-1]);
        addProduction.setProductionBody(0, NotEndCodeArray[0]);
        addProduction.productionLength=1;
        addProduction.ProductionNum=realProductionLength;
        allProduction[realProductionLength]=addProduction;
        realProductionLength+=1;
        //System.out.println(allProduction[realProductionLength-1].ProductionNum+allProduction[realProductionLength-1].getHead().getNotEndCode());
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
