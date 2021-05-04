let button = document.getElementById("asd");
button.addEventListener('click',function(){
        stepodown();
    }
);
function stepodown(){
    let input = document.getElementById('ada');
    if (input){
        input.stepDown();

        document.getElementById("p1").innerHTML = document.getElementById('ada').value*16000 + " руб";
        S1();
    }
}
let button1 = document.getElementById("vak");
button1.addEventListener('click',function(){
    stepoUp();}
);
function stepoUp(){
    let input = document.getElementById('ada');

    if (input){
        input.stepUp();

        document.getElementById("p1").innerHTML = document.getElementById('ada').value*16000 + " руб";
        S1();
    }
}
let button2 = document.getElementById("asdd");
button2.addEventListener('click',function(){
    stepodownn();}
);
function stepodownn(){
    let input = document.getElementById('adad');

    if (input){
        input.stepDown();

        document.getElementById("p2").innerHTML = document.getElementById('adad').value*3000 + " руб";
        S1();
    }
}
let button3 = document.getElementById("vakd");
button3.addEventListener('click',function(){
    stepoUpp();}
);
function stepoUpp(){
    let input = document.getElementById('adad');

    if (input){
        input.stepUp();

        document.getElementById("p2").innerHTML = document.getElementById('adad').value*3000 + " руб";
        S1();


    }
}
function prees(){
    document.getElementById('ada').value=0;
    document.getElementById('p3').innerHTML = document.getElementById('adad').value*3000 +" Руб";
    document.getElementById('p4').innerHTML =document.getElementById('adad').value;

}
function pree(){
    document.getElementById('adad').value=0;
    document.getElementById('p3').innerHTML = document.getElementById('ada').value*16000 +" Руб";
    document.getElementById('p4').innerHTML =document.getElementById('ada').value;
}
function S1(){


    document.getElementById('p3').innerHTML = document.getElementById('ada').value*16000+document.getElementById('adad').value*3000 +" Руб";
    document.getElementById('p4').innerHTML = +document.getElementById('ada').value + +document.getElementById('adad').value;
}
let button4 = document.getElementById("aaad");
button4.addEventListener('click',function(){
    pree();}
);
let button5 = document.getElementById("aaadd");
button5.addEventListener('click',function(){
    prees();}
);