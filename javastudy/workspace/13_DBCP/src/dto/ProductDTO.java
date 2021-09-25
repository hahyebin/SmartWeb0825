package dto;
                              
import java.sql.Date;

public class ProductDTO {
     
	//field
	private long pNo;
	private String pName;
	private int price;
	private Date pDate;
	
	
	
	// getter, setter, toString()
	public long getpNo() {
		return pNo;
	}
	public void setpNo(long pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
	}
	@Override
	public String toString() {
		return "ProductDTO [제품번호=" + pNo + ", 제품명=" + pName + ", 가격=" + price + ", 등록일=" + pDate + "]";
	}
	
}
