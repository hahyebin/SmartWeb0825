#include <stdio.h>
#include <string.h>

#define LENGTH 10

typedef struct book{
	int bookNo;
	char title[31];
	char author[31];
}BOOK;  //Book 타입의 정의 

BOOK books[LENGTH];  //Book books[10];
int idx = 0; 

void menu(){
	printf("\n:::도서등록 프로그램:::\n");
    printf(" 1. 도서정보 등록\n");
    printf(" 2. 도서정보 조회\n");
    printf(" 3. 전체도서 목록\n");
    printf(" 0. 프로그램 종료\n ");
} 
void addBook(){
	int bookNo;
	char title[31];
	char author[31];
	//Book을 저장할 인덱스는 idx이다.
	// 인덱스 가용 범위 : 0 ~ (LENGTH - 1)
	if(idx == LENGTH){
		printf("배열이 꽉 찼음\n");
		return;
	} 
	//책번호 : 1001 ~ 9999 
	printf("책 번호 입력 >>> ");
	scanf("%d", &bookNo); 
	if(bookNo <= 1000 || bookNo >= 10000){
		printf("잘못된 책 번호입니다.\n");
		return;
	}
	printf("책 제목 입력 >>> ");
	scanf("%s", title);
	printf("책 저자 입력 >>> ");
	scanf("%s", author);
	books[idx].bookNo = bookNo;
	strcpy(books[idx].title,title);
	strcpy(books[idx].author,author);
	idx++;
}

void queryBook(){
	int i; 
	int findNo;
	if(idx == 0){
		printf("조회된 책이 없습니다.\n");
		return;
	}
	printf("조회할 책 번호 >> ");
	scanf("%d", &findNo);
	// Book은 books배열에 idx만큼 저장되어 있다. 
	for(i=0; i<idx; i++){
		if(findNo == books[i].bookNo){
			printf("제목: %s, 저자: %s", books[i].title, books[i].author);
			return;
		}
	} 
	//조회가 끝나면 없는 책이다.
	printf("책 번호 %d은 없는 책입니다.\n", findNo); 	
}

void printBook(){
	int i;
		if(idx == 0){
		printf("조회된 책이 없습니다.\n");
		return;
	}
	for(i=0; i<idx; i++){
		printf("%d, %s, %s\n", books[i].bookNo, books[i].title, books[i].author);
	}
}

int main(){
	int choice;
	while(1){
		menu();
		printf("작업 선택 >>> ");
		scanf("%d", &choice);
		switch(choice){
			case 1: addBook(); break;
			case 2: queryBook(); break;
			case 3: printBook(); break;
			case 0: printf("종료합니다.\n"); return 0;
			default: printf("없는 작업입니다. 다시 입력하세요.\n");
		}
	}
}















