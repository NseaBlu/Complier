
public class Production {

	private NotEndCode head;//����ʽͷ
    public Sign []productionSign;//����ʽ��
    public int pointer;//ָʾ��ǰ����ʽ�ķ���λ��
    public int productionLength;//����ʽ�峤��
    public int ProductionNum;
    public Production(NotEndCode head,Sign []productionSign)
    {
    	
    	this.head=head;
    	this.productionSign=productionSign;
    	pointer=0;
    	productionLength=productionSign.length;
    	
    }
	public Production() {
		// TODO Auto-generated constructor stub
		
		productionSign=new Sign[20];
	}
	
	public void setProductionBody(int num,Sign sign)
	{
		this.productionSign[num]=sign;
	}
	public NotEndCode getHead() {
		return head;
	}

	public void setHead(NotEndCode head) {
		this.head = head;
	}

	public Sign [] getProductionSign() {
		return productionSign;
	}

	public void setProductionSign(Sign [] productionSign) {
		this.productionSign = productionSign;
	}
	
	
	
}
