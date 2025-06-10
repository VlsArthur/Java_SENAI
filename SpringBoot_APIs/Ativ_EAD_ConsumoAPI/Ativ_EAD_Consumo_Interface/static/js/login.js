function login(event) {
    event.preventDefault();
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;
    if (email && senha) {
        document.getElementById('senha').value = "";
        document.getElementById('email').value = "";
        window.location.replace("http://localhost:5500/Ativ_EAD_Consumo_Interface/index.html")
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Erro!',
            text: 'Falta dados para cadastrar'
        })
    }
}