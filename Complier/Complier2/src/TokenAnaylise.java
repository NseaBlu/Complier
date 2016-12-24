import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TokenAnaylise {

	public static String string;
	public static int stringlength;
	public TokenAnaylise()
	{
		
	}
	//读取输入文件
		public static int getChar(EndSign []input) throws Exception{	
			
			File f= new File("D:\\","2.txt");
			if(!f.exists()){
				System.out.println("文件不存在，请输入正确的文件路径");
			}
			BufferedReader bf=new BufferedReader(new FileReader(f));
			int line=0;
			try {
				
				while((string=bf.readLine())!=null)
				{
					line+=1;
					System.out.println(string);
			        // System.out.println(ProductionNum);
					stringlength=string.length();
					char inputt;
					for(int i=0;i<stringlength;i++)
					{
						inputt=string.charAt(i);
						switch(inputt)
						{
						case 'c':
							input[i]=new EndSign("c",0);
								
							break;
							
							
						case 'd':
							input[i]=new EndSign("d",1);
							break;
						}
					}
					input[stringlength]=new EndSign("$",2);
					stringlength+=1;
					
				}
				bf.close();
				System.out.println("输入行数："+line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				if(bf!=null)
				{
					try {
						bf.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//System.out.println(string);
			
			
			return stringlength;
			
			
		}

	
	
}
