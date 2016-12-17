
public class setProduction extends Production {



	private EndSign []firstEndSign;//first集符号
	public int firstEndSignLength;//first集符号长度
	

	public setProduction(NotEndCode head, Sign[] productionSign) {
		super(head, productionSign);
		// TODO Auto-generated constructor stub
	}
	
	
	public EndSign [] getFirstEndSign() {
		return firstEndSign;
	}

	public void setFirstEndSign(EndSign [] firstEndSign) {
		this.firstEndSign = firstEndSign;
	}
	
	
}
