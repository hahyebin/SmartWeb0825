#include <stdio.h>


// �Լ��� �ݵ�� ȣ��(����)�ϱ� ���� ���ǵǾ�(�������) �־�� �Ѵ�. 
void a(){
  
    // �迭���� 
	 int arr[3];
	  
	//c���� �迭 ���̴� ����ؼ� ���Ѵ�.
	  printf("�迭 ũ�� : %d����Ʈ\n", sizeof(arr));
	  printf("��� ũ�� : %d����Ʈ\n", sizeof(int));
	  printf("�迭 ���� : %d��\n", sizeof(arr)/sizeof(int));
     
 }

void b(){

	//�迭 ���� 
	int arr[3];    // �ڵ� �ʱ�ȭ�� ����.  ���� ������ ����. 
	// �迭 ���� 
	int length = sizeof(arr)/sizeof(int);
	//�迭 �ε��� ����  
	int i=0; 
	//�迭 ��� 
	for( i=0; i<length; i++){
		printf("%d\n", arr[i]);
	} 
	
	
} 

void c(){
	// �迭 + ���� + �ε���
	int arr[3];
	int i;
	int length = sizeof(arr)/sizeof(int);
	// �Է� �� ��� 
	for(i=0; i<length; i++){
	    printf("%d��° ��Ҹ� �Է��Ͻÿ� >>>  \n", i+1);
		scanf("%d", &arr[i]);                    //scanf() ���� & �ʿ���  
	} 
    for(i=0; i<length; i++){
    	printf("%d��° ��� = %d \n", i+1, arr[i]);
	}
	
} 

void quiz1(){
	// 5���� ������ �Է� �޾Ƽ� �迭�� �����Ѵ�. 
	// ����� ��Ұ� Ȧ���̸� 0���� �ٲٽÿ�.
	// ��ü ��� 
	int arr[5];
	int i ;
	int length = sizeof(arr)/sizeof(int);
	for(i=0; i<length; i++) {
		printf("%d��° ��Ҹ� �Է��ϼ��� >> \n", i+1);
		scanf("%d", &arr[i]);
	
	}
		for(i=0; i<length; i++) {
	     if(arr[i] % 2 != 0){
			arr[i] = 0;
		}
		   printf("%d��° ��� : %d \n", i+1, arr[i]);
		} 
	
	
	
	
}

void d(){
	
	int length = 3;    // ����  
	int arr[length];   //������ �迭�� ���̰� �� �� ����  
	
} 


#define LENGTH 3  //PRE-PROCESSOR�� ó���ϴ� ��ó��, ��ũ�ζ�� ��
                  //������ LENGTH�� ��Ÿ���� 3���� �ٲ㼭 ������ �� ��.(�ܼ� ġȯ) 
void d2(){
	int arr[LENGTH];   // ������ �� int arr[3]; ������� ��ȯ��. �׷��� ������ ���� 
	int i;
	for(i=0; i<LENGTH; i++){
		printf("%d\n", arr[i]);
	} 
} 

void str1(){
	//���ڿ� ������ ���� char Ÿ���� �迭�� ��ġ�� �迭��  �ٸ���.
	 char str[6] = "hello";  //"���ڿ�" + "�ι���"�� ũ�Ⱑ �ʿ� 
	 printf("%d\n",str);  // "�ι���" �������� ��� ����Ͻÿ�, �ݺ��� �ʿ� ����  
}

void str2(){
	char str[6]; // ���� ���� �ִ� 5�� ����
	printf("���ڿ� �Է� >>> ");
	scanf("%s", str);   // �迭�� scanf���� & �ʿ� ����. 
	printf("�Էµ� ���ڿ��� %s�̴�.\n", str);

}


void str3(){
	char * str = "hello";
	printf("%s\n",str);
}


void str4(){
	char * str[3];  //���ڿ��� 3�� ������ �� �ִ� �迭 
	int i;
//	str[0] = "hello";
//	str[1] = "my";
//	str[2] = "c";
//    printf("%s %s %s\n", str[0], str[1], str[2]);
	for( i=0; i<3; i++){
		printf("���ڿ� �Է� > ");
		scanf("%s", str[i]);
		 while (getchar() != '\n'); 
		 
	} 
	for(i=0; i<LENGTH; i++)
    	printf("%s", str[i]);
    		fflush(stdin);
}

void quiz2(){
	// �̸�, ����, Ű, �����Ը� �Է� �޾Ƽ� ����Ͻÿ�
	// ���ڿ�, ����, �Ǽ�, �Ǽ� 
	char name[10];
	int age;
	double height;
	double weight;
	
	printf("�̸� > ");	 scanf("%s", name);
	printf("���� > ");   scanf("%d", &age);
	printf("Ű > ");     scanf("%lf", &height);
	printf("������ > "); scanf("%lf", &weight);   // double�� scanf()�� %lf�� ����.(%f �� ��) 

    printf("�̸� : %s\n", name);
    printf("���� : %d\n", age);
    printf("Ű   : %lfcm\n", height);
    printf("������ : %lfkg\n", weight);   // double�� printf()�� %f, %lf ��� �� ����  


}


int main(void){
	
/*	if(���ǽ�){
		return -1;  ������ ���� ó�� 
		 
}   */

   

	quiz2();
	
	return 0;
}






