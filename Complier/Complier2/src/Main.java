
public class Main {

	private static  EndSign [] EndSignArray;
	private static  NotEndCode []NotEndCodeArray;
	public static Production []allProduction;
	private static GrammerAnaylise mp;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   
			     mp = new GrammerAnaylise();
				try {
				
				  allProduction=new Production[50];
				  GrammerAnaylise.getChar(allProduction);
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
