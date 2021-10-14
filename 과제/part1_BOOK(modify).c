#include <stdio.h>
#include <stdlib.h>
#include <string.h>



// 1. �������� ���� ����ü  
typedef struct book {
    int bookNo;
    char title[30];
    char author[30];
}BOOK;
 
// 2. ��ũ�� ���  
#define SIZE 10
 
// 3. ����ü �迭, �ε��� �������� ����  
BOOK list[SIZE];    
int index =0 ;


// 4. �޴� �Լ�
void menu()
{
    printf("\n:::������� ���α׷�:::\n");
    printf(" 1. �������� ���\n");
    printf(" 2. �������� ��ȸ\n");
    printf(" 3. ��ü���� ���\n");
    printf(" 0. ���α׷� ����\n ");
}


// 5. �߰� �Լ�  
void addBook(){  	

	int num;        // �Է¹��� ���� ��ȣ  + å ��ȣ ���� Ȯ��  
	char title[31];
	char author[31];
		  if(index==SIZE){
         	printf("������� �� á���ϴ�. ������ �� �����ϴ�. \n");
         	return;
	    }  
	    
    	printf("�ű� å ��ȣ �Է� >>> ");
        scanf("%d",&num);
        while (getchar() != '\n');   //�Է� ���� ����� 
         if(num<1001 || num>9999){
             printf("å ��ȣ�� 1001~9999 ���̾�� �մϴ�. >>> ");
             return;
        } 
   
          printf("�ű� å ���� �Է� >>> ");
          scanf("%s", title);
    
          printf("�ű� å ���� �Է� >>> ");
          scanf("%s", author);
          	list[index].bookNo = num;
			strcpy(list[index].title,title);
			strcpy(list[index].author,author);
   			index++;
     
	 
       
}

// 6.�˻� �Լ�  
void queryBook(){  
    int i;
    int num;   // �Է� ���� ���� ��ȣ  
   
	printf("\n��ȸ�� å ��ȣ �Է� >>> ");
	scanf("%d", &num);
	     fflush(stdin);  
 
	for(i=0; i<index; i++){
	   if( list[i].bookNo == num){
	   	   
			printf("\n��ȸ ��� : %s  %s \n", list[i].title, list[i].author);
		    return;
		}
	}
		printf("������ȣ %d�� ���� ������ �����ϴ�.\n",num);

	
}

// 7. ��ü ��ȸ �Լ�  
void  printBook(){
	    int i;
		if(index == 0){
			printf("����� ������ �����ϴ�. \n");
			return; 
		}
		printf("::��ü ���� ���::\n");
		for(i=0; i<index; i++){	
	    	printf("%d %s %s \n", list[i].bookNo,  list[i].title, list[i].author );
	}  

}



// 8. main�Լ�  
int main(void){  

 while(1){
 
    int i = 0;
    menu();
    printf("  �޴� ����(1,2,3,0) >>>> ");
    scanf("%d", &i);
    switch(i){
    	case 1: addBook(); break;
    	case 2: queryBook(); break;
    	case 3: printBook(); break;
    	case 0: printf("�����������α׷� �����ϰڽ��ϴ�.\n"); return 0;
        default:  printf("�۾��� 1,2,3,0 �� �ϳ��Դϴ�");
	} 
}

}

