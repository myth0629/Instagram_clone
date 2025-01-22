const idInput = document.getElementById('username');
const pwInput = document.getElementById('password');
const loginInput = document.getElementById('login-container'); // ID로 요소 선택
const loginBtn = document.getElementById('btn_login');
const loginError = document.querySelector('.login_input_check');

function idCheck() {
    var hasAt = idInput.value.indexOf('@');
    return hasAt !== -1;
}

function pwCheck() {
    return pwInput.value.length >= 5;
}

function checkButtonActive() {
    const completedInput = (idCheck() && pwCheck());
    loginBtn.disabled = !completedInput || (loginError && loginError.textContent.trim() !== '');
}


loginInput.addEventListener('keyup', function (event) {
    checkButtonActive();
});

if(loginError) {
    checkButtonActive()
}