#include <stdio.h>

int main(void){
	
	char   a;   // a = ������(garbage) ���� 
	int    b;   // b = ������(garbage) ���� 
	double c;   // c = ������(garbage) ���� 
	char str[11]; 
	
	printf("���� �Է� >> ");
	scanf("%c", &a);   // �Ϲ� ������ '&������' 
	
	 printf("���� �Է� >> ");
	scanf("%d", &b);

	printf("�Ǽ� �Է� >> ");
	scanf("%lf", &c);
	
	printf("���ڿ� �Է� >> ");
	scanf("%s", str);        // �迭�� '�迭��' �Ǵ� '&�迭��[0]', �߰��� ������ ���� �ȵ� 
	// ���� �Է��� ������ �͵�  
//	gets(str);
//	fgets(str, sizeof(str), stdin);
	
	printf("�� �濡 ��� : %c, %d, %lf, %s", a,b,c,str);
	
	return 0;
}
