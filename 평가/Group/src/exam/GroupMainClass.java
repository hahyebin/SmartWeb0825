package exam;

public class GroupMainClass {

	public static void main(String[] args) {
		Group group = new Group("코리아그룹");
		group.hireEmployee(new Regular(1000, "리차드","개발부",3000000));
		group.hireEmployee(new Regular(1001, "에밀리","운영부",3500000));
		group.hireEmployee(new Temporary(1002, "제임스","총무부",9000,208));
		group.hireEmployee(new Temporary(1003, "앨리스","영업부",10000,208));
		group.info();
		group.dropEmployee(1000);
		group.info();
	}

}
