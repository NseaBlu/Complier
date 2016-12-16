import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MainProcess {
  
	
	

	private static String string;
	private Stack<EndSign> EndSign;
	private Stack<NotEndCode> NotEndCode;
	private static EndSign [] EndSignArray;
	private static NotEndCode []NotEndCodeArray;
	private static int EndSignLength;
	private static int NotEndCodeLength;
	
	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
        
		MainProcess mp=new MainProcess();
		mp.getChar();
		
	}

	public MainProcess()
	{
		EndSignArray=new EndSign[200];
		NotEndCodeArray=new NotEndCode[200];
		EndSignLength=0;
		NotEndCodeLength=0;
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
					return true;
				}
			}
		}
		
		return false;
		
	}
	//分析产生式
	public static void analyseCode(String s)
	{
		int sLength;
		int i;
		int startIndex;
		int endIndex;
	    String subString;
	    char before;
	    char next;
		char character;
		
		sLength=s.length();
		for(i=0;i<sLength;i++)
		{
			character=s.charAt(i);
			switch(character)
			{
			case '<':
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
			NotEndCode Code=new NotEndCode(subString);
			
			if(!isInNotEndCodeArray(Code))
			{
				
				NotEndCodeArray[NotEndCodeLength]=Code;
				System.out.println(subString);
				NotEndCodeLength+=1;
			}
			i=endIndex;
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
					
					EndSignArray[EndSignLength]=endcode;
					System.out.println(subString);
					EndSignLength+=1;
				}
				i=endIndex;
				break;
			
			}
		}
		
	}
	//读取产生式文件
	public static void getChar() throws Exception{	
		
		File f= new File("D:\\","语法分析.txt");
		if(!f.exists()){
			System.out.println("文件不存在，请输入正确的文件路径");
		}
		BufferedReader bf=new BufferedReader(new FileReader(f));
		System.out.print("");
		int line=0;
		   
		try {
			while((string=bf.readLine())!=null)
			{
				line+=1;
				//System.out.println(string);
				analyseCode(string);
				
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

	public Stack<EndSign> getEndSign() {
		return EndSign;
	}

	public void setEndSign(Stack<EndSign> endSign) {
		EndSign = endSign;
	}

	public Stack<NotEndCode> getNotEndCode() {
		return NotEndCode;
	}

	public void setNotEndCode(Stack<NotEndCode> notEndCode) {
		NotEndCode = notEndCode;
	}

	public EndSign [] getEndSignArray() {
		return EndSignArray;
	}

	public void setEndSignArray(EndSign [] endSignArray) {
		EndSignArray = endSignArray;
	}

	public NotEndCode [] getNotEndCodeArray() {
		return NotEndCodeArray;
	}

	public void setNotEndCodeArray(NotEndCode [] notEndCodeArray) {
		NotEndCodeArray = notEndCodeArray;
	}

	public int getEndSignLength() {
		return EndSignLength;
	}

	public void setEndSignLength(int endSignLength) {
		EndSignLength = endSignLength;
	}

	public int getNotEndCodeLenght() {
		return NotEndCodeLength;
	}

	public void setNotEndCodeLenght(int notEndCodeLenght) {
		NotEndCodeLength = notEndCodeLenght;
	}
	
}
