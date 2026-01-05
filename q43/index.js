var com_num = [];
var user_num =[];
var count=0;
for(i=0;i<6;i++){
    user_num[i] = Math.floor(Math.random() * 45)+1;
}


while(com_num.length<6){
    var r = Math.floor(Math.random() * 45) + 1;
    if(!com_num.includes(r)){
        com_num.push(r);
    }
    }
document.writeln("사용자 숫자"+user_num+"<br>");
document.writeln("컴푸터 숫자"+com_num+"<br>");

for(i=0;i<6;i++){
    for(j=0;j<6;j++){
        if(com_num[i]==user_num[j]){
            count++;
        }
    }
}
document.writeln("맞춘 숫자"+count+"<br>");

if(count<=2){
    document.writeln("꽝입니다!");
}
else if(count==3){
    document.writeln("5등입니다!");
}
else if(count==4){
    document.writeln("4등입니다!");
}
else if(count==5){
    document.writeln("3등등입니다!");
}
else if(count==6){
    document.writeln("당첨입니다!");
}