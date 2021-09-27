#include <stdio.h>


// 함수는 반드시 호출(실행)하기 전에 정의되어(만들어져) 있어야 한다. 
void a(){
  
    // 배열선언 
	 int arr[3];
	  
	//c에서 배열 길이는 계산해서 구한다.
	  printf("배열 크기 : %d바이트\n", sizeof(arr));
	  printf("요소 크기 : %d바이트\n", sizeof(int));
	  printf("배열 길이 : %d개\n", sizeof(arr)/sizeof(int));
     
 }

void b(){

	//배열 선언 
	int arr[3];    // 자동 초기화가 없다.  현재 쓰레기 상태. 
	// 배열 길이 
	int length = sizeof(arr)/sizeof(int);
	//배열 인덱스 선언  
	int i=0; 
	//배열 요소 
	for( i=0; i<length; i++){
		printf("%d\n", arr[i]);
	} 
	
	
} 

void c(){
	// 배열 + 길이 + 인덱스
	int arr[3];
	int i;
	int length = sizeof(arr)/sizeof(int);
	// 입력 및 출력 
	for(i=0; i<length; i++){
	    printf("%d번째 요소를 입력하시오 >>>  \n", i+1);
		scanf("%d", &arr[i]);                    //scanf() 사용시 & 필요함  
	} 
    for(i=0; i<length; i++){
    	printf("%d번째 요소 = %d \n", i+1, arr[i]);
	}
	
} 

void quiz1(){
	// 5개의 정수를 입력 받아서 배열에 저장한다. 
	// 저장된 요소가 홀수이면 0으로 바꾸시오.
	// 전체 출력 
	int arr[5];
	int i ;
	int length = sizeof(arr)/sizeof(int);
	for(i=0; i<length; i++) {
		printf("%d번째 요소를 입력하세요 >> \n", i+1);
		scanf("%d", &arr[i]);
	
	}
		for(i=0; i<length; i++) {
	     if(arr[i] % 2 != 0){
			arr[i] = 0;
		}
		   printf("%d번째 요소 : %d \n", i+1, arr[i]);
		} 
	
	
	
	
}

void d(){
	
	int length = 3;    // 변수  
	int arr[length];   //변수는 배열의 길이가 될 수 없음  
	
} 


#define LENGTH 3  //PRE-PROCESSOR가 처리하는 전처리, 매크로라고 함
                  //앞으로 LENGTH가 나타나면 3으로 바꿔서 컴파일 할 것.(단순 치환) 
void d2(){
	int arr[LENGTH];   // 컴파일 시 int arr[3]; 모습으로 변환됨. 그래서 문제가 없음 
	int i;
	for(i=0; i<LENGTH; i++){
		printf("%d\n", arr[i]);
	} 
} 

void str1(){
	//문자열 저장을 위한 char 타입의 배열은 수치형 배열과  다르다.
	 char str[6] = "hello";  //"문자열" + "널문자"의 크기가 필요 
	 printf("%d\n",str);  // "널문자" 이전까지 모두 출력하시오, 반복문 필요 없음  
}

void str2(){
	char str[6]; // 영문 기준 최대 5자 가능
	printf("문자열 입력 >>> ");
	scanf("%s", str);   // 배열은 scanf에서 & 필요 없음. 
	printf("입력된 문자열은 %s이다.\n", str);

}


void str3(){
	char * str = "hello";
	printf("%s\n",str);
}


void str4(){
	char * str[3];  //문자열을 3개 저장할 수 있는 배열 
	int i;
//	str[0] = "hello";
//	str[1] = "my";
//	str[2] = "c";
//    printf("%s %s %s\n", str[0], str[1], str[2]);
	for( i=0; i<3; i++){
		printf("문자열 입력 > ");
		scanf("%s", str[i]);
		 while (getchar() != '\n'); 
		 
	} 
	for(i=0; i<LENGTH; i++)
    	printf("%s", str[i]);
    		fflush(stdin);
}

void quiz2(){
	// 이름, 나이, 키, 몸무게를 입력 받아서 출력하시오
	// 문자열, 정수, 실수, 실수 
	char name[10];
	int age;
	double height;
	double weight;
	
	printf("이름 > ");	 scanf("%s", name);
	printf("나이 > ");   scanf("%d", &age);
	printf("키 > ");     scanf("%lf", &height);
	printf("몸무게 > "); scanf("%lf", &weight);   // double의 scanf()는 %lf만 가능.(%f 안 됨) 

    printf("이름 : %s\n", name);
    printf("나이 : %d\n", age);
    printf("키   : %lfcm\n", height);
    printf("몸무게 : %lfkg\n", weight);   // double의 printf()는 %f, %lf 모두 ㄴ 가능  


}


int main(void){
	
/*	if(조건식){
		return -1;  비정상 종료 처리 
		 
}   */

   

	quiz2();
	
	return 0;
}






