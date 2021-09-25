package ex9_Object;

public class Member {
	
	private String id;
	private String pwd;
	
	
	public Member(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	
	// @Override
	// public void equals(Object obj){
	// Member other = (Member)obj;
	// return id.equals(other.getId() && pws.equals(other.getPwd());
	// }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + pwd + "]";
	}
	
//	public String toString() {
//		return "id : " +id +", pwd : "+pwd;
//	}
	
	
}

	
	
   
