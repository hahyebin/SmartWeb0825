/* 각 문제는 function 내부만 작업하시오. */

$(document).ready(function(){
    // 1-4) 화면 로드 포커싱 
     $("#userId").focus(); 
    fnCheckId();
    fnCheckPw();
    fnCheckName();
    fnCheckEmail();
    fnCheckSubmit();
});

// 1. 아이디
function fnCheckId(){
    // 아이디정규식
    let regId = /^[a-zA-Z0-9_-]{4,}$/;

        $('#userId').on('keyup',function(){ 
               // this == event.target == userId
               if( $('#userId').val().length < 4 ){
                $('#msgId').text('아이디는 소문자/숫자 4자 이상 사용가능합니다.');
                $('#msgId').addClass('msg_red');   
               } else if(( $('#userId').val().length >=4) && (regId.test( $('#userId').val()) )){
                 $('#msgId').text('올바른형식입니다.');
                 $('#msgId').addClass('msg_green');
                 $('#msgId').removeClass('msg_red');
                  } 
               });

}

// 2. 비밀번호
function fnCheckPw(){
    // 비밀번호정규식
    let regPwd = /^[a-zA-Z0-9!@$%^&*()]{8,20}$/;
    // blur로 벗어날때표시
    $('#userPw').on('blur', function(){       
        let pwdValidResult = /[a-z]/.test( $('#userPw').val()) + 
                                      /[A-Z]/.test( $('#userPw').val()) + 
                                      /[0-9]/.test( $('#userPw').val()) +
                                      /[^a-zA-Z0-9]/.test( $('#userPw').val());
                                      
                 if(regPwd.test( $('#userPw').val()) &&  pwdValidResult>=3) {
                     $("#msgPw").text('사용 가능한 비밀번호 입니다.');
                     $("#msgPw").addClass('msg_green');
                     $("#msgPw").removeClass('msg_red');
                    
                 } else {
                    $("#msgPw").text('비밀번호는 8~20자의 영문 대/소문자, 숫자, 특수문자 등 3종류 이상으로 조합해주세요.');
                    $("#msgPw").addClass('msg_red');
                    $("#msgPw").removeClass('msg_green');
                 }
    
             });
}
 
// 3. 이름
function fnCheckName(){
    // 이름 정규식 
    let regName = /^[a-zA-Z가-힣]{1,30}$/;
   // 입력할때마다 + 벗어남 
    $('#userName').on('keyup blur', function(){
                 // 이름 입력 안할 때
                 if( $('#userName').val() == ''){
                    $('#msgName').text('이름을 입력해주세요');
                    $('#msgName').addClass('msg_red');
                 //이름 문제없을 때 
                 } else if( regName.test( $('#userName').val() )){   // 공백이 아니면 테스트 통과
                    $('#msgName').text('사용 가능한 이름입니다.');
                    $('#msgName').addClass('msg_green');
                    $('#msgName').removeClass('msg_red');
                // 입력 이름에 영문 한굴 이외 들어갈 때 
                 } else {
                     $('#msgName').text('이름은 한글, 영문 대소문자만 사용해주세요.'); 
                     $('#msgName').addClass('msg_red');
                 }
             });// end of function  



}

// 4. 이메일
function fnCheckEmail(){
    // 이메일 정규식 
    let regEmail = /^[0-9a-zA-Z-_]+@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}/;  
      // 입력할때마다 + 벗어남 
    $("#userEmail").on('keyup blur',function(){
                 if( regEmail.test(  $("#userEmail").val() )){
                    $("#msgEmail").text( '올바른이메일형식입니다.');
                    $("#msgEmail").addClass('msg_green');
                    $("#msgEmail").removeClass('msg_red');
                 }  else {
                  
                     $("#msgEmail").text('올바른 이메일 형식을 입력해주세요');
                     $("#msgEmail").addClass('msg_red');
                 }
             });
}

// 5. 서브밋
function fnCheckSubmit(){
    $('#join_form').on('submit',function(event){
       if( confirm('가입할까요?') ){
            alert('가입하겠습니다.');
            return true;
       } else {
            alert('취소하겠습니다.');
            event.preventDefault();
            return false;  
       }
      

    });
}