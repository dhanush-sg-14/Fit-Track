function saveSignup(event) {
    event.preventDefault(); // Prevent form refresh

    // Get values
    const name = document.getElementById("signup-name").value;
    const contact = document.getElementById("signup-contact").value;
    const password = document.getElementById("signup-password").value;

    // Save to localStorage
    localStorage.setItem("userName", name);
    localStorage.setItem("userContact", contact);
    localStorage.setItem("userPassword", password);

    // Redirect to next page
    window.location.href = "secondpage.html";
}