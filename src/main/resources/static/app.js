const API_URL = `${window.location.origin}/api/auth`;

// LOGIN
document.getElementById("loginForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const username = document.getElementById("loginUsername").value;
    const password = document.getElementById("loginPassword").value;

    try {
        const response = await fetch(`${API_URL}/login`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password })
        });

        const message = document.getElementById("message");

        if (response.ok) {
            const text = await response.text();
            message.style.color = "green";
            message.innerText = text;

            // Guardar usuario y redirigir
            localStorage.setItem("username", username);
            setTimeout(() => {
                window.location.href = "dashboard.html";
            }, 1500);
        } else {
            const error = await response.text();
            message.style.color = "red";
            message.innerText = error;
        }
    } catch (err) {
        document.getElementById("message").innerText = "❌ Error de conexión con el servidor.";
    }
});

// REGISTRO
document.getElementById("registerForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const username = document.getElementById("regUsername").value;
    const password = document.getElementById("regPassword").value;

    try {
        const response = await fetch(`${API_URL}/register`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username, password })
        });

        const message = document.getElementById("message");

        if (response.ok) {
            const text = await response.text();
            message.style.color = "green";
            message.innerText = text;
        } else {
            const error = await response.text();
            message.style.color = "red";
            message.innerText = error;
        }
    } catch (err) {
        document.getElementById("message").innerText = "❌ Error de conexión con el servidor.";
    }
});