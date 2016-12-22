
public class AnayliseTable {

	public actiongoto [][]actiontable;
	public actiongoto [][]gototable;
	public AnayliseTable()
	{
		actiontable=new actiongoto[100][100];
		gototable=new actiongoto[100][100];
		
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				
				actiontable[i][j]=new actiongoto();
				
			}
		}
		for(int i=0;i<100;i++)
		{
			for(int j=0;j<100;j++)
			{
				
				gototable[i][j]=new actiongoto();
				
			}
		}
	}
	
	
	
}
