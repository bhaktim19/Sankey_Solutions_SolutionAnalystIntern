function submit() {
    
    var firstName = document.getElementById("firstName").value.trim();
    var lastName = document.getElementById("lastName").value.trim();
    var phoneNumber = document.getElementById("phoneNumber").value.trim();
    var cardNumber = document.getElementById("cardNumber").value.trim();
    var cvc = document.getElementById("cvc").value.trim();
    var expDate = document.getElementById("exp-date").value.trim();

    
    var nameRegex = /^[a-zA-Z\s]+$/;
    var phoneRegex = /^\d{10}$/;
    var cardRegex = /^\d{16}$/;
    var cvcRegex = /^\d{3}$/;
    var expRegex = /^(0[1-9]|1[0-2])\/\d{2}$/;

    
    var isValid = true;
    var errorMessages = [];

    
    if (!nameRegex.test(firstName)) {
        isValid = false;
        errorMessages.push("Please enter a valid first name.");
    }

    
    if (!nameRegex.test(lastName)) {
        isValid = false;
        errorMessages.push("Please enter a valid last name.");
    }

    
    if (!phoneRegex.test(phoneNumber)) {
        isValid = false;
        errorMessages.push("Please enter a valid phone number.");
    }

    
    if (!cardRegex.test(cardNumber)) {
        isValid = false;
        errorMessages.push("Please enter a valid card number.");
    }

    
    if (!cvcRegex.test(cvc)) {
        isValid = false;
        errorMessages.push("Please enter a valid CVC.");
    }

    
    if (!expRegex.test(expDate)) {
        isValid = false;
        errorMessages.push("Please enter a valid expiry date (MM/YY).");
    }



    
    if (!isValid) {
        alert(errorMessages.join("\n"));
     
    }
    else{
        alert("Payment done successfully...");
        // Reset the form after successful submission
        document.getElementById("firstName").value = "";
        document.getElementById("lastName").value = "";
        document.getElementById("phoneNumber").value = "";
        document.getElementById("cardNumber").value = "";
        document.getElementById("cvc").value = "";
        document.getElementById("exp-date").value = "";
    }

    var formData = {
        firstName: firstName,
        lastName: lastName,
        phoneNumber: phoneNumber,
        cardNumber: cardNumber,
        cvc: cvc,
        expDate: expDate
    };

    
    console.log("Form data:", formData);
   

    return false;
}


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
          

