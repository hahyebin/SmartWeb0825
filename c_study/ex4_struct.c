#include <stdio.h>

// ���� ������ ����ü �����ϱ�(��� �Լ����� ����� �� �ִ�.) 
 
// ����ü ����(����ü �����)
// ����ü product�� ���� ���ο� �̸� Product�� �ο��Ѵ�. (����ü Product ����)
typedef struct product {
	long pNo;
	char pName[21];
	int  price;
}Product; //Product�� �������� �ڷ����� �ȴ�.  


// ����ü ���� ���� (���� ������ ����)
Product p;  //Product Ÿ���� ���� p

void a(){
	// ���� ���� Product p ��밡��  
	printf("��ǰ��ȣ �Է� >> "); 	scanf("%d", &p.pNo);
	printf("��ǰ�� �Է� >> ");      scanf("%s", p.pName);    //pName�� �迭  
	printf("��ǰ���� �Է� >> ");    scanf("%d", &p.price); 
}

void b(){
	// ���� ���� Product p ��밡�� 
	 printf("��ǰ��ȣ : %d\n", p.pNo);
	 printf("��ǰ�� : %s\n", p.pName);
	 printf("��ǰ���� : %d\n", p.price); 
	
	
} 

#define LENGTH 3 
// Product �迭�� �������� �����ϸ� c(), d() ��� ��� ������.  
Product products[3];

void c(){
	int i;
  //  Product newProduct;
    
	for(i=0; i<LENGTH; i++){
	  printf("%d��° ��ǰ ���� �Է�\n", i+1);
 	  printf("��ǰ��ȣ �Է� >> ");    scanf("%d", &products[i].pNo);
	  printf("��ǰ�� �Է� >> ");      scanf("%s", products[i].pName);    //pName�� �迭  
	  printf("��ǰ���� �Է� >> ");    scanf("%d", &products[i].price); 
	//  newProduct = products[i];
	}
	
	
	
}
void d(){
	int i;
		for(i=0; i<LENGTH; i++){
			printf("%d. ��ȣ : %d, �̸�: %s, ���� : %d\n",i+1, products[i].pNo,products[i].pName, products[i].price);
	
        }
	
}


int main(){
	
//	a();
//	b();
	c();  //��ǰ 3���� �Է� �޴� �Լ�  : Product products[3]; 
	d();  //��ǰ 3���� ��� �ϴ� �Լ�  
	
	return 0;
}