#include <stdio.h>
#include <string.h>
#include <math.h>


// 1. �л����� ����ü  
typedef struct stu_info{
	char name[31];       //�л��̸�   �ִ����� 31 
    int kor, eng, math;  // �л� ���� ���� ���� ���� 
    int total;           // ���� 
    double avg;          // ���  
	
}Stu_info;

// 2. ��ũ�� ��� ����  
#define SIZE 3

// 3. ����ü ���� ���� ����  
Stu_info student[SIZE];
int i=0;

// 4. �л����� ���� �Լ�  
void inputinformation(){

	 
	int korinput;  // ���� ���� �Է� + ����(0~100) ���� Ȯ��  
	int mathinput; // ���� ���� �Է� + ����(0~100) ���� Ȯ��  
	int enginput;  // ���� ���� �Է� + ����(0~100) ���� Ȯ��  
	
	 printf("�л� 3���� ������ ���ʴ�� �Է��ϼ���. \n\n");
	 
	 for(i=0; i<SIZE; i++){
	 
		printf("�л� %d �̸� >>> ", i+1);
		    gets(student[i].name);    //���� ó�� ���� gets�Լ�  
		   
		     
        printf("���� >>> ");
         scanf("%d", &korinput);
        while (getchar() != '\n');
		if( korinput<0 || korinput>100){     // ���� ����� continueȰ���Ͽ� �ٽ� �Է��ϱ�  
            printf("������ 0~100 ���̾�� �մϴ�. \n");
            i--;                             // i--; ������ ���� �л����� �Ѿ�� ������ �ʿ� 
            continue;
        }  else{
             student[i].kor = korinput;    // ���� ������ ��ü_������ �ֱ�  
            }
     
	    printf("���� >>> ");
		      scanf("%d", &enginput);
            while (getchar() != '\n');
		if( enginput<0 || enginput>100){
            printf("������ 0~100 ���̾�� �մϴ�. \n");
             i--;
            continue;
        }  else{
             student[i].eng = enginput;
            }
            
        printf("���� >>> ");
		      scanf("%d", &mathinput);
            while (getchar() != '\n');
		if( mathinput<0 || mathinput>100){
            printf("������ 0~100 ���̾�� �մϴ�. \n");
             i--;
            continue;
        }  else{
             student[i].math = mathinput;
            }
		   
		  while (getchar() != '\n');   
		    
     	student[i].total = student[i].kor+student[i].eng+student[i].math;       //�� �л�����
		student[i].avg = (double)student[i].total / 3;                            //���

   }		
}
	
	

// 5. �л����� ���� ���� �Լ� 
void generateFile(){
	
	FILE *fp = fopen("score.csv", "wt");  //������  
	
    if(fp == NULL){   
    	printf("���� ���⿡ �����߽��ϴ�. \n");
    	return;
	} 
	else{	
		printf("���� ���⿡ �����߽��ϴ�. \n");
	}
	
	fprintf(fp, "%s, %s, %s, %s, %s, %s \n", "����","����","����","����","����","���");   

	for(i=0;i<SIZE;i++){
     fprintf(fp, "%s, %d, %d, %d, %d, %.2f \n", student[i].name, student[i].kor, 
	student[i].eng, student[i].math, student[i].total, student[i].avg);	
    }
     printf("\nscore.csv������ �����Ǿ����ϴ�.");
  
	 fclose(fp);
}


// 6. main �Լ� (�л� ���� �Է� -> ��������) 
int main(void){
  
   inputinformation();
   generateFile();
   
	return 0;
}

