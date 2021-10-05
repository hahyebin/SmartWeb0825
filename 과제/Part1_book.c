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


// 함수구현  
void menu();       // 메뉴  
void addBook();    //추가 
void queryBook();  //검색  
void printBook();  //전체 조회  


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
BOOK newBOOK;  

    	printf("신규 책 번호 입력 >>> ");
        while(1){
         scanf("%d",&num);
         while (getchar() != '\n');   //입력 버퍼 지우기 
         if(num<1001 || num>9999){
             printf("책 번호는 1001~9999 사이어야 합니다. >>> ");
        }  else{
             newBOOK.bookNo = num;
             break;
        }
    } // end of while 
          printf("신규 책 제목 입력 >>> ");
          scanf("%s", newBOOK.title);
    
          printf("신규 책 저자 입력 >>> ");
          scanf("%s", newBOOK.author);
   
       //   printf(">>추가된 책\n");    // 확인을 위한 코드  
       //   printf("책번호 : %d, 제목 : %s, 저자 : %s\n", newBOOK.bookNo, newBOOK.title, newBOOK.author); 
     
	 
         if(index==SIZE){
         	printf("저장공간 꽉 찼습니다. 저장할 수 없습니다. \n");
	    }  else {
	    	list[index]=newBOOK;
	    	index++;
	    }
}

// 6.검색 함수  
void queryBook(){  
    int i;
    int num;   // 입력 받을 도서 번호  
    int is_success=0;   //도서 번호 유무 확인을 위한 변수선언(초기는 false) 
	printf("\n조회할 책 번호 입력 >>> ");
	scanf("%d", &num);
	     fflush(stdin);  
 
	for(i=0; i<index; i++){
	   if( list[i].bookNo == num){
	   	     is_success = 1;   // 도서번호가 있다면 is_success = true로 변환  
			printf("\n조회 결과 : %s  %s \n", list[i].title, list[i].author);
		     break;
		}
	}
	if(!is_success){   // !is_success는 true이기 때문에 실행  
		printf("도서번호 %d를 가진 도서가 없습니다.\n",num);
	}
	
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
 return 0;
}

