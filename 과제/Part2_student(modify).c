#include <stdio.h>
#include <string.h>
#include <math.h>


// 1. 학생정보 구조체  
typedef struct stu_info{
	char name[31];       //학생이름   최대저장 31 
    int kor, eng, math;  // 학생 국어 영어 수학 성적 
    int total;           // 총점 
    double avg;          // 평균  
	
}Stu_info;

// 2. 매크로 상수 선언  
#define SIZE 3

// 3. 구조체 전역 변수 선언  
Stu_info student[SIZE];
int i=0;

// 4. 학생정보 저장 함수  
void inputinformation(){

	 
	int korinput;  // 국어 점수 입력 + 점수(0~100) 범위 확인  
	int mathinput; // 수학 점수 입력 + 점수(0~100) 범위 확인  
	int enginput;  // 영어 점수 입력 + 점수(0~100) 범위 확인  
	
	 printf("학생 3명의 정보를 차례대로 입력하세요. \n\n");
	 
	 for(i=0; i<SIZE; i++){
	 
		printf("학생 %d 이름 >>> ", i+1);
		    gets(student[i].name);    //공백 처리 위한 gets함수  
		   
		     
        printf("국어 >>> ");
         scanf("%d", &korinput);
        while (getchar() != '\n');
		if( korinput<0 || korinput>100){     // 범위 벗어나면 continue활용하여 다시 입력하기  
            printf("점수는 0~100 사이어야 합니다. \n");
            i--;                             // i--; 없으면 다음 학생으로 넘어가기 때문에 필요 
            continue;
        }  else{
             student[i].kor = korinput;    // 범위 맞으면 객체_점수에 넣기  
            }
     
	    printf("영어 >>> ");
		      scanf("%d", &enginput);
            while (getchar() != '\n');
		if( enginput<0 || enginput>100){
            printf("점수는 0~100 사이어야 합니다. \n");
             i--;
            continue;
        }  else{
             student[i].eng = enginput;
            }
            
        printf("수학 >>> ");
		      scanf("%d", &mathinput);
            while (getchar() != '\n');
		if( mathinput<0 || mathinput>100){
            printf("점수는 0~100 사이어야 합니다. \n");
             i--;
            continue;
        }  else{
             student[i].math = mathinput;
            }
		   
		  while (getchar() != '\n');   
		    
     	student[i].total = student[i].kor+student[i].eng+student[i].math;       //각 학생총점
		student[i].avg = (double)student[i].total / 3;                            //평균

   }		
}
	
	

// 5. 학생정보 파일 저장 함수 
void generateFile(){
	
	FILE *fp = fopen("score.csv", "wt");  //쓰기모드  
	
    if(fp == NULL){   
    	printf("파일 열기에 실패했습니다. \n");
    	return;
	} 
	else{	
		printf("파일 열기에 성공했습니다. \n");
	}
	
	fprintf(fp, "%s, %s, %s, %s, %s, %s \n", "성명","국어","영어","수학","총점","평균");   

	for(i=0;i<SIZE;i++){
     fprintf(fp, "%s, %d, %d, %d, %d, %.2f \n", student[i].name, student[i].kor, 
	student[i].eng, student[i].math, student[i].total, student[i].avg);	
    }
     printf("\nscore.csv파일이 생성되었습니다.");
  
	 fclose(fp);
}


// 6. main 함수 (학생 정보 입력 -> 파일저장) 
int main(void){
  
   inputinformation();
   generateFile();
   
	return 0;
}

