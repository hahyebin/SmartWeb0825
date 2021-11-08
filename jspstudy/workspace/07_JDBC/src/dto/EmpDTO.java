package dto;

import java.sql.Date;

public class EmpDTO {

		private Long num;        // 사원번호 : emp_seq가 생성 
		private String name;     // 사원이름 
		private Date hire;       // 입사일자 : SYSDATE 생성  
		
		public EmpDTO() {
			// TODO Auto-generated constructor stub
		}

		public EmpDTO(String name) {   // 자바에서 생성하지 않는 건 생성자로 만들 필요가 없다.(나머지는 db에서 생성함)
			super();
			this.name = name;	
		}

		public Long getNum() {
			return num;
		}

		public void setNum(Long num) {
			this.num = num;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getHire() {
			return hire;
		}

		public void setHire(Date hire) {
			this.hire = hire;
		}
}
