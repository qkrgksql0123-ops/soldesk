const defaultId="dog";
const defaultPW=1234;

var i;
var p;


var login_box;
function login(){
    var id = i.value;
    var pw = p.value;

    if(defaultId==id && defaultPW==pw){
        
       login_box.innerHTML="회원님 안녕하세요!"; 
    }
    else{
        alert("등록이 안된 회원입니다.")
    }
}


window.onload=function(){
    i = document.getElementById("id");
    p = document.getElementById("pw");
    login_box = document.getElementById("box");
}