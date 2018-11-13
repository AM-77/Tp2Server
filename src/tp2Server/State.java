package tp2Server;

import java.util.Date;

public class State {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private int q;
	private Date lastOp;
	
	public State(String id){
		this.id = id;
		
		this.q = this.get_q();
		this.lastOp = this.get_lastOp();
	}
	
	public int get_q(){
		return 0;
	}
	
	public Date get_lastOp(){
		return new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getq() {
		return q;
	}

	public void setq(int q) {
		this.q = q;
	}

	public Date getLastOp() {
		return lastOp;
	}

	public void setLastOp(Date lastOp) {
		this.lastOp = lastOp;
	}
	
}
