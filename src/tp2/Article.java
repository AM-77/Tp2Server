package tp2;

import java.util.Date;

public class Article {
	
	private String id;
	private int q;
	private Date lastOp;
	
	public Article() {}
	
	public Article(String id, int q, Date lastOp) {
		this.id = id;
		this.q = q;
		this.lastOp = lastOp;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public int getQ() {
		return q;
	}
	
	public void setQ(int q) {
		this.q = q;
	}
	
	public Date getLastOp() {
		return lastOp;
	}
	
	public void setLastOp(Date lastOp) {
		this.lastOp = lastOp;
	}
	
}
