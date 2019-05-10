package bookshop.vo;

import java.util.List;

public class OrderVo {
	private Long no;
	private String addr;
	private Long member_no;
	private String name;
	private int price;
	private String content;
	private String serialNo;
	
	private List<OrderDetailVo> orderDetailList;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Long getMember_no() {
		return member_no;
	}

	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public List<OrderDetailVo> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetailVo> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", addr=" + addr + ", member_no=" + member_no + ", name=" + name + ", price="
				+ price + ", content=" + content + ", serialNo=" + serialNo + ", orderDetailList=" + orderDetailList
				+ "]";
	}
	
}
