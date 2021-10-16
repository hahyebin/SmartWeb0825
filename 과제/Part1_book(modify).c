#include <stdio.h>
#include <stdlib.h>
#include <string.h>



// 1. 도서정보 저장 구조체  
typedef struct book {
    int bookNo;
    char title[30];
    char author[30];
}BOOK;
 
// 2. 매크로 상수  
#define SIZE 10
 
// 3. 구조체 배열, 인덱스 전역변수 선언  
BOOK list[SIZE];    
int index =0 ;


// 4. 메뉴 함수
void menu()
{
    printf("\n:::도서등록 프로그램:::\n");
    printf(" 1. 도서정보 등록\n");
    printf(" 2. 도서정보 조회\n");
    printf(" 3. 전체도서 목록\n");
    printf(" 0. 프로그램 종료\n ");
}


// 5. 추가 함수  
void addBook(){  	

	int num;        // 입력받을 도서 번호  + 책 번호 범위 확인  
	char title[31];
	char author[31];
		  if(index==SIZE){
         	printf("저장공간 꽉 찼습니다. 저장할 수 없습니다. \n");
         	return;
	    }  
	    
    	printf("신규 책 번호 입력 >>> ");
        scanf("%d",&num);
        while (getchar() != '\n');   //입력 버퍼 지우기 
         if(num<1001 || num>9999){
             printf("책 번호는 1001~9999 사이어야 합니다. >>> ");
             return;
        } 
   
          printf("신규 책 제목 입력 >>> ");
          scanf("%s", title);
    
          printf("신규 책 저자 입력 >>> ");
          scanf("%s", author);
          	list[index].bookNo = num;
			strcpy(list[index].title,title);
			strcpy(list[index].author,author);
   			index++;
     
	 
       
}

// 6.검색 함수  
void queryBook(){  
    int i;
    int num;   // 입력 받을 도서 번호  
   
	printf("\n조회할 책 번호 입력 >>> ");
	scanf("%d", &num);
	     fflush(stdin);  
 
	for(i=0; i<index; i++){
	   if( list[i].bookNo == num){
	   	   
			printf("\n조회 결과 : %s  %s \n", list[i].title, list[i].author);
		    return;
		}
	}
		printf("도서번호 %d를 가진 도서가 없습니다.\n",num);

	
}

// 7. 전체 조회 함수  
void  printBook(){
	    int i;
		if(index == 0){
			printf("저장된 도서가 없습니다. \n");
			return; 
		}
		printf("::전체 도서 목록::\n");
		for(i=0; i<index; i++){	
	    	printf("%d %s %s \n", list[i].bookNo,  list[i].title, list[i].author );
	}  

}



// 8. main함수  
int main(void){  

 while(1){
 
    int i = 0;
    menu();
    printf("  메뉴 선택(1,2,3,0) >>>> ");
    scanf("%d", &i);
    switch(i){
    	case 1: addBook(); break;
    	case 2: queryBook(); break;
    	case 3: printBook(); break;
    	case 0: printf("도서관리프로그램 종료하겠습니다.\n"); return 0;
        default:  printf("작업은 1,2,3,0 중 하나입니다");
	} 
}

}

