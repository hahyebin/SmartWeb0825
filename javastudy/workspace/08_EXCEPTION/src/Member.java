import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//ToString Override 
    
public class Member {
    private String id;
    private String password;
	
  public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	//  @NoArgsConstructor
//    public Member() {
//		// TODO Auto-generated constructor stub
//	}
//    
//   // @AllArgsConstructor
//    public Member(String id, String password) {
//		super();
//		this.id = id;
//		this.password = password;
//	}
//    


}
