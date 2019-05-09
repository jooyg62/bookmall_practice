package bookshop.vo;

public class CartVo {
	private String category_name;
	private String title;
	private int price;
	private int count;
	private long book_no;
	private long member_no;
	
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getBook_no() {
		return book_no;
	}
	public void setBook_no(long book_no) {
		this.book_no = book_no;
	}
	public long getMember_no() {
		return member_no;
	}
	public void setMember_no(long member_no) {
		this.member_no = member_no;
	}
	@Override
	public String toString() {
		return "CartVo [category_name=" + category_name + ", title=" + title + ", price=" + price + ", count=" + count
				+ ", book_no=" + book_no + ", member_no=" + member_no + "]";
	}
}
