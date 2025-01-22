const phoneInput = document.getElementById('phone');
const pwInput = document.getElementById('password');
const emailInput = document.getElementById('email');
const nameInput = document.getElementById('name');
const signupBtn = document.getElementById('btn_signup');
const loginInput = document.getElementsByClassName('container')[0];

// 이메일에 @가 포함되는지 확인
function  emailCheck(){
    var hasAt = emailInput.value.indexOf('@');
    return hasAt !== -1;
}

function pwCheck(){
    return pwInput.value.length >= 5;
}

function phoneCheck() {
    return phoneInput.value.length >= 5;
}

function nameCheck() {
    return nameInput.value.length >= 1;
}

loginInput.addEventListener('keyup', function (event) {
    const completedInput = (emailCheck() && pwCheck() && phoneCheck() && nameCheck());
    signupBtn.disabled = !completedInput;
})