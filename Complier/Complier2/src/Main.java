
public class Main {

	private static  EndSign [] EndSignArray;
	private static  NotEndCode []NotEndCodeArray;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   
			     GrammerAnaylise mp=new GrammerAnaylise();
				try {
				
				   GrammerAnaylise.getChar();
				  System.out.println(GrammerAnaylise.getEndSignLength());
				  System.out.println(GrammerAnaylise.getNotEndCodeLenght());
				  
				  EndSignArray=GrammerAnaylise.getEndSignArray();
				  NotEndCodeArray=GrammerAnaylise.getNotEndCodeArray();
				  System.out.println("ÖÕ½á·û");
				  for(int i=0;i<GrammerAnaylise.getEndSignLength();i++)
				  {
					  System.out.println(EndSignArray[i].getEndSign());
				  }
				  System.out.println("·ÇÖÕ½á·û");
				  for(int i=0;i<GrammerAnaylise.getNotEndCodeLenght();i++)
				  {
					  System.out.println(NotEndCodeArray[i].getNotEndCode());
				  }
				  
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	}

}
