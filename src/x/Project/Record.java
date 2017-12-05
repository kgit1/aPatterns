package x.Project;

import java.time.LocalDateTime;

public class Record {

	private Product product;
	private LocalDateTime date;
	private String commentary;

	public Record(Product product, String commentary) {
		this.product = product;
		this.date = LocalDateTime.now();
		this.commentary = commentary;
	}

	public Product getProduct() {
		return product;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getCommentary() {
		return commentary;
	}

	@Override
	public String toString() {
		return "Record [product=" + product + ", date=" + date + ", commentary=" + commentary + "]";
	}

}
