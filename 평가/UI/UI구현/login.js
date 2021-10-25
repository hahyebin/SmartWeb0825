$(document).ready(function(){

    // 2-1) 아아디 비밀번호 입력 없을 시 alert창 + 커서 + submit금지 
    $('form').on('submit',function(){

        if( $('#userId').val() == ''){
           alert('아이디를 입력하세요.');
           $('#userId').focus();
           event.preventDefault();
           return false;

        } else if(  $('#userId').val().length <4 ){
            $('#userId').focus();
            event.preventDefault();
            return false;
        }    
        else if(  $('#userPw').val() == '' ){
            alert('비밀번호를 입력하세요.');
            $('#userPw').focus();
            event.preventDefault();
            return false;
    // 2-2) index.html 파일을 생성할 필요는 없고, submit에 필요한 코드만 login.html에 작성하시오. 
        } else
            return true;
    });

    // 2-3) 아이디를 입력할때마다 입력된 아이디가 4글자 이상인지 점검한 결과를 나타내도록 구현하시오.
        // (1) 4글자 미만인 경우 : "아이디는 4자 이상입니다.", 빨간색
        // (2) 4글자 이상인 경우 : "정상적인 아이디입니다.", 파란색

    $('#userId').on('keyup',function() {
        if ( $('#userId').val().length <4 ){
            $('.msg_red').text('아이디는 4자 이상입니다.');
            $('.msg_red').removeClass('msg_blue');
          
        } else {
            $('#msg').text('정상적인 아이디입니다.');
            $('.msg_red').addClass('msg_blue');
        }
    });

 }); // onload

