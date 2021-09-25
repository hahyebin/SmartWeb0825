package exam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
  private int empNo;
  private String name;
  private String department;

	public void info() {
		System.out.print("사원번호: "+empNo + ", 사원명 :" +name + ", 부서명:"+department); 
	}
}
