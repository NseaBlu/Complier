
public class Main {

	private static  EndSign [] EndSignArray;
	private static  NotEndCode []NotEndCodeArray;
	public static Production []allProduction;
	private static GrammerAnaylise mp;
	public static int realProductionLength;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   
			     mp = new GrammerAnaylise();
				try {
				
					 allProduction=new Production[50];
				  GrammerAnaylise.getChar(allProduction,realProductionLength);
				  
				System.out.println(realProductionLength);
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
		    }	
				  System.out.println(GrammerAnaylise.getEndSignLength());
				  System.out.println(GrammerAnaylise.getNotEndCodeLenght());
				  
				  EndSignArray=GrammerAnaylise.getEndSignArray();
				  NotEndCodeArray=GrammerAnaylise.getNotEndCodeArray();
				  
				  System.out.println("ÖÕ½á·û");
				  for(int i=0;i<GrammerAnaylise.getEndSignLength();i++)
				  {
					  System.out.println(EndSignArray[i].EndSignNum+"  "+EndSignArray[i].getEndSign());
				  }
				  System.out.println("·ÇÖÕ½á·û");
				  for(int i=0;i<GrammerAnaylise.getNotEndCodeLenght();i++)
				  {
					  System.out.println(NotEndCodeArray[i].NotEndCodeNum+"  "+NotEndCodeArray[i].getNotEndCode());
				  }
				  
				  
				  
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}

}
