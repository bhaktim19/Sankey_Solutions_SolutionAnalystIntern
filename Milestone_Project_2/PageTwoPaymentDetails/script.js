window.onload = function() {
  document.getElementById("firstName").addEventListener("blur", validateFirstNameOnBlur);
  document.getElementById("lastName").addEventListener("blur", validateLastNameOnBlur);
  document.getElementById("email").addEventListener("blur", validateEmailOnBlur);
  document.getElementById("phone").addEventListener("blur", validatePhoneOnBlur);
  document.getElementById("country").addEventListener("blur", validateCountryOnBlur);
}

function validateFirstNameOnBlur() {
  var firstName = document.getElementById("firstName").value.trim();
  if (firstName === "") {
      alert("Please enter your first name.");
      return false;
  }
  return true;
}

function validateLastNameOnBlur() {
  var lastName = document.getElementById("lastName").value.trim();
  if (lastName === "") {
      alert("Please enter your last name.");
      return false;
  }
  return true;
}

function validateEmailOnBlur() {
  var email = document.getElementById("email").value.trim();
  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
      alert("Please enter a valid email address.");
      return false;
  }
  return true;
}

function validatePhoneOnBlur() {
  var phone = document.getElementById("phone").value.trim();
  var phoneRegex = /^\d{10}$/;
  if (!phoneRegex.test(phone)) {
      alert("Please enter a valid phone number (10 digits).");
      return false;
  }
  return true;
}

function validateCountryOnBlur() {
  var country = document.getElementById("country").value.trim();
  if (country === "") {
      alert("Please enter your country.");
      return false;
  }
  return true;
}





  function validateAndSubmit() {
    var fullName = document.getElementById("full-name").value;
    var cardNumber = document.getElementById("card-number").value;
    var expDate = document.getElementById("exp-date").value;
    var cvc = document.getElementById("cvc").value;

    // Perform validation checks here
    if (fullName.trim() === "") {
        alert("Please enter full name on the card");
        return;
    }
    if (cardNumber.trim() === "" || isNaN(cardNumber) || cardNumber.length !== 16) {
        alert("Please enter a valid card number");
        return;
    }
    var expDateParts = expDate.split('/');
        var expMonth = parseInt(expDateParts[0], 10);

        // Check if the month is within the valid range (1 to 12)
        if (isNaN(expMonth) || expMonth < 1 || expMonth > 12) {
            alert("Please enter a valid expiry date (MM/YY)");
            return;
        }
    if (cvc.trim() === "" || isNaN(cvc)) {
        alert("Please enter a valid CVC");
        return;
    }

    
    alert("Payment successful!");
    
}

function saveToShortcut() {
    var fullName = document.getElementById("full-name").value;
    var cardNumber = document.getElementById("card-number").value;
    var expDate = document.getElementById("exp-date").value;
    var cvc = document.getElementById("cvc").value;

    // Perform validation checks here
    if (fullName.trim() === "") {
        alert("Please enter full name on the card");
        return;
    }
    if (cardNumber.trim() === "" || isNaN(cardNumber) || cardNumber.length !== 16) {
        alert("Please enter a valid card number");
        return;
    }
    var expDateParts = expDate.split('/');
        var expMonth = parseInt(expDateParts[0], 10);

        // Check if the month is within the valid range (1 to 12)
        if (isNaN(expMonth) || expMonth < 1 || expMonth > 12) {
            alert("Please enter a valid expiry date (MM/YY)");
            return;
        }
    if (cvc.trim() === "" || isNaN(cvc)) {
        alert("Please enter a valid CVC");
        return;
    }
    
    alert("Card details saved to shortcut!");
    
}

function validateEmail() {
    var email = document.getElementById("email-input").value;
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (emailRegex.test(email)) {
      alert("Email is valid. You have subscribed now!");
      // Here you can add code to perform subscription or any further action
    } else {
      alert("Please enter a valid email address.");
    }
}