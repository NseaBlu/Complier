import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class GrammerAnaylise {
  
	
	

	private static String string;
	private static  EndSign [] EndSignArray;
	private static  NotEndCode []NotEndCodeArray;
	private static  int EndSignLength;
	private static  int NotEndCodeLength;
	private static Production returnProduction;
	public static int helpNum;
	
	
	
	public GrammerAnaylise()
	{
		EndSignArray=new EndSign[200];
		NotEndCodeArray=new NotEndCode[200];
		EndSignLength=0;
		NotEndCodeLength=0;
	}
	
	//判断是否是字母
	public static boolean isLetter(char c){
		if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
			return true;
		}
		else
			return false;
	}
	//判断是否存了这个终结符
	public static boolean isInEndSignArray(EndSign endcode)
	{
		EndSign endcodeTest;
		if(EndSignLength==0)
		{
			return false;
		}
		else
		{
			for(int i=0;i<EndSignLength;i++)
			{
				endcodeTest=EndSignArray[i];
				String s1=endcodeTest.getEndSign();
				String s2=endcode.getEndSign();
				if(s1.equals(s2))
				{
					helpNum=endcodeTest.EndSignNum;
					return true;
				}
			}
		}
		return false;
		
	}
	//判断是否存了这个非终结符
	public static boolean isInNotEndCodeArray(NotEndCode code)
	{
		
		NotEndCode codeTest;
		
		if(NotEndCodeLength==0)
			return false;
		else 
		{
			for(int i=0;i<NotEndCodeLength;i++)
			{
				//System.out.println(NotEndCodeLength);
				codeTest=NotEndCodeArray[i];
				String s1=code.getNotEndCode();
				//System.out.println(s1);
				//System.out.println(NotEndCodeArray[i]);
				String s2=codeTest.getNotEndCode();
				if(s1.equals(s2))
				{
					helpNum=codeTest.NotEndCodeNum;
					return true;
				}
			}
		}
		
		return false;
		
	}
	//分析产生式
	public static Production analyseCode(String s)
	{
		
		Production returnProduction = new Production();
		int sLength;
		int i;
		int startIndex;
		int endIndex;
	    String subString;
	   // char before;
	    char next;
		char character;
		 NotEndCode Code;
		sLength=s.length();
		for(i=0;i<sLength;i++)
		{
			character=s.charAt(i);
			switch(character)
			{
			case '<':
				if((i+1)<sLength)
		 {	    next=s.charAt(i+1);
				if(isLetter(next))
		    {
			    startIndex=i;
			    for(endIndex=i+1;endIndex<sLength;endIndex++)
			   {
				
				 if(s.charAt(endIndex)=='>')
					break;
			   }
			
			   if(endIndex==sLength)
				subString=s.substring(startIndex);
			   else
			    subString=s.substring(startIndex, endIndex+1);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
			    
			   Code=new NotEndCode(subString);
			
			   if(!isInNotEndCodeArray(Code))
			  {
				
				Code.NotEndCodeNum=NotEndCodeLength;//编号
				NotEndCodeArray[NotEndCodeLength]=Code;
				//System.out.println("非终结符");
				//System.out.println(subString);
				
				NotEndCodeLength+=1;
			  }
			   else
			   {
				   Code.NotEndCodeNum=helpNum;
			   }
			   //将符号放进产生式
			   if(i==0)
				{
				   
					returnProduction.setHead(Code);//存放产生式头
					returnProduction.productionLength=0;//给产生式体编号
				}
				
				else
					{
					returnProduction.setProductionBody(returnProduction.productionLength, Code);
					returnProduction.productionLength+=1;
					}
			    i=endIndex;
		    }
				else
			{
					startIndex=i;
					for(endIndex=i+1;endIndex<sLength;endIndex++)
					{
						
						if(s.charAt(endIndex)=='<'||s.charAt(endIndex)==' ')
							break;
					}
					
					if(endIndex==sLength)
						subString=s.substring(startIndex);
					else
					    subString=s.substring(startIndex, endIndex);
					//subString=s.substring(startIndex, endIndex);
					EndSign endcode=new EndSign(subString);
					
					if(!isInEndSignArray(endcode))
					{
						
						endcode.EndSignNum=EndSignLength;//编号
						EndSignArray[EndSignLength]=endcode;
						//System.out.println("终结符");
						//System.out.println(subString);
						EndSignLength+=1;
						
						
					}
					else
					   {
						   endcode.EndSignNum=helpNum;
					   }
					//将符号放进产生式
					returnProduction.setProductionBody(returnProduction.productionLength, endcode);
					returnProduction.productionLength+=1;
					i=endIndex;
			}
		}
		else
		{
					subString=s.substring(i);
                    EndSign endcode=new EndSign(subString);
					
					if(!isInEndSignArray(endcode))
					{
						
						endcode.EndSignNum=EndSignLength;//编号
						EndSignArray[EndSignLength]=endcode;
						//System.out.println("终结符");
						//System.out.println(subString);
						EndSignLength+=1;
						
					}
					else
					   {
						   endcode.EndSignNum=helpNum;
					   }
					//将符号放进产生式
					returnProduction.setProductionBody(returnProduction.productionLength, endcode);
					returnProduction.productionLength+=1;
					
		 }
			 break; 
			case '→':
			break;
			case ' ':
				//System.out.println("空格跳过");
			break;
			default:
				startIndex=i;
				for(endIndex=i+1;endIndex<sLength;endIndex++)
				{
					
					if(s.charAt(endIndex)=='<'||s.charAt(endIndex)==' ')
						break;
				}
				
				if(endIndex==sLength)
					subString=s.substring(startIndex);
				else
				    subString=s.substring(startIndex, endIndex);
				//subString=s.substring(startIndex, endIndex);
				EndSign endcode=new EndSign(subString);
				
				if(!isInEndSignArray(endcode))
				{
					
					endcode.EndSignNum=EndSignLength;//编号
					EndSignArray[EndSignLength]=endcode;
					//System.out.println("终结符");
					//System.out.println(subString);
					EndSignLength+=1;
					
				}
				else
				 {
					   endcode.EndSignNum=helpNum;
				  }
				//将符号放进产生式
				returnProduction.setProductionBody(returnProduction.productionLength, endcode);
				returnProduction.productionLength+=1;
				i=endIndex;
				break;
			
			}
		}
		return returnProduction;
		
	}
	//读取产生式文件
	public static void getChar(Production []allProduction, int realProductionLength) throws Exception{	
		
		File f= new File("D:\\","语法分析.txt");
		if(!f.exists()){
			System.out.println("文件不存在，请输入正确的文件路径");
		}
		BufferedReader bf=new BufferedReader(new FileReader(f));
		System.out.print("");
		int line=0;
		realProductionLength=0;  
		Production production=new Production();
		try {
			
			while((string=bf.readLine())!=null)
			{
				line+=1;
				//System.out.println(string);
				production=analyseCode(string);
				production.ProductionNum=realProductionLength;
		      // System.out.println(ProductionNum);
				allProduction[realProductionLength]=production;
				
				/*//输出产生式
				System.out.println(allProduction[ProductionNum].ProductionNum+allProduction[ProductionNum].getHead().getNotEndCode());
				
				for(int j=0;j<allProduction[ProductionNum].productionLength;j++)
				{
					if(j!=(allProduction[ProductionNum].productionLength-1))
					{
						System.out.print(allProduction[ProductionNum].productionSign[j].getSignString()+allProduction[ProductionNum].productionSign[j].getSignNum()+' ');
					}
					else
					{
						System.out.println(allProduction[ProductionNum].productionSign[j].getSignString()+allProduction[ProductionNum].productionSign[j].getSignNum());
					}
				}
				*/
				realProductionLength+=1;
			}
			bf.close();
			System.out.println(line);
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
		
		
	}

	

	public  static  EndSign [] getEndSignArray() {
		return EndSignArray;
	}

	public  static void setEndSignArray(EndSign [] endSignArray) {
		EndSignArray = endSignArray;
	}

	public  static  NotEndCode [] getNotEndCodeArray() {
		return NotEndCodeArray;
	}

	public static void setNotEndCodeArray(NotEndCode [] notEndCodeArray) {
		NotEndCodeArray = notEndCodeArray;
	}

	public  static int getEndSignLength() {
		return EndSignLength;
	}

	public  static void setEndSignLength(int endSignLength) {
		EndSignLength = endSignLength;
	}

	public  static int getNotEndCodeLenght() {
		return NotEndCodeLength;
	}

	public  static void setNotEndCodeLenght(int notEndCodeLenght) {
		NotEndCodeLength = notEndCodeLenght;
	}
	
}
