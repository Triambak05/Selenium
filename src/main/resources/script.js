// References for buttons and forms
const loginChoiceBtn = document.getElementById('login_choice_btn');
const signupChoiceBtn = document.getElementById('signup_choice_btn');
const choiceScreen = document.getElementById('choice_screen');
const loginForm = document.getElementById('login_form');
const signupForm = document.getElementById('signup_form');
const switchToSignup = document.getElementById('switch_to_signup');
const switchToLogin = document.getElementById('switch_to_login');

// Show login or signup forms
loginChoiceBtn.addEventListener('click', () => {
    choiceScreen.classList.add('hidden');
    loginForm.classList.remove('hidden');
});

signupChoiceBtn.addEventListener('click', () => {
    choiceScreen.classList.add('hidden');
    signupForm.classList.remove('hidden');
});

switchToSignup.addEventListener('click', (e) => {
    e.preventDefault();
    loginForm.classList.add('hidden');
    signupForm.classList.remove('hidden');
});

switchToLogin.addEventListener('click', (e) => {
    e.preventDefault();
    signupForm.classList.add('hidden');
    loginForm.classList.remove('hidden');
});

// Form Validation
signupForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const email = document.getElementById('student_email').value.trim();
    const phone = document.getElementById('student_contact').value.trim();
    const password = document.getElementById('student_password').value.trim();

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const phonePattern = /^[0-9]{10}$/;
    const passwordPattern = /^(?=.*[A-Z])(?=.*\d)[A-Za-z\d@$!%*?&]{8,}$/;

    if (!emailPattern.test(email)) {
        alert("Please enter a valid email address.");
        return;
    }

    if (!phonePattern.test(phone)) {
        alert("Please enter a valid 10-digit contact number.");
        return;
    }

    if (!passwordPattern.test(password)) {
        alert("Password must be at least 8 characters long, contain one uppercase letter and one number.");
        return;
    }

    alert("Account created successfully! You can now log in.");
    signupForm.reset();
    signupForm.classList.add('hidden');
    loginForm.classList.remove('hidden');
});

loginForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const email = document.getElementById('login_email').value.trim();
    const password = document.getElementById('login_password').value.trim();

    if (!email || !password) {
        alert("Please fill in both fields.");
        return;
    }

    // Placeholder for backend authentication
    alert("Login successful! (Demo only)");
    loginForm.reset();
});
