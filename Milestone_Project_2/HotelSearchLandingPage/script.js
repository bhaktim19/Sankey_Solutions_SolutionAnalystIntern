function subscribe() {
    var emailInput = document.getElementById("emailInput");
    var email = emailInput.value;
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(email)) {
        alert("Please enter a valid email address.");
    } else {
       
        alert("Subscription successful! Thank you for subscribing.");
       
        emailInput.value = "";
    }
}