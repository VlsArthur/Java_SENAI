/*
● Campos do Formulário:
○ Nome
○ Email
○ Senha
○ CEP
○ Endereço
○ Número
○ Bairro
○ Cidade
○ Estado
 */

function cadastrar(event) {
    event.preventDefault();
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;
    const cep = document.getElementById('cep').value;
    const logradouro = document.getElementById('logradouro').value;
    const numero = document.getElementById('numero').value;
    const complemento = document.getElementById('complemento').value;
    const bairro = document.getElementById('bairro').value;
    const cidade = document.getElementById('cidade').value;
    const estado = document.getElementById('estado').value;
    if (nome && email && senha && cep && logradouro && numero && complemento && bairro && cidade && estado) {
        
        document.getElementById('nome').value = "";
        document.getElementById('email').value = "";
        document.getElementById('senha').value = "";
        document.getElementById('cep').value = "";
        document.getElementById('logradouro').value = "";
        document.getElementById('numero').value = "";
        document.getElementById('complemento').value = "";
        document.getElementById('bairro').value = "";
        document.getElementById('cidade').value = "";
        document.getElementById('estado').value = "";
        
        fetch ('http://localhost:8080/api/usuarios', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({"nome":nome,
                "email":email,
                "senha":senha,
                "cep":cep,
                "logradouro":logradouro,
                "numero":numero,
                "complemento":complemento,
                "bairro":bairro,
                "cidade":cidade,
                "estado":estado
            })
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.log(error);
        })

        Swal.fire({
            icon: 'success',
            title: 'Sucesso!', 
            content: 'Cadastro efetuado com sucesso',
            confirmButtonText: "Continuar",
            preConfirm: () => {
                window.location.replace("http://localhost:5500/Ativ_EAD_Consumo_Interface/login.html");
            }
        })
    } else {
        Swal.fire({
            icon: 'error',
            title: 'Erro!',
            text: 'Falta dados para cadastrar'
        })
    }
}

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

function sair() {
    window.location.replace("http://localhost:5500/Ativ_EAD_Consumo_Interface/login.html")
}

function limpa_formulário_cep() {
            //Limpa valores do formulário de cep.
            document.getElementById('rua').value=("");
            document.getElementById('bairro').value=("");
            document.getElementById('cidade').value=("");
            document.getElementById('estado').value=("");
    }

    function meu_callback(conteudo) {
        if (!("erro" in conteudo)) {
            //Atualiza os campos com os valores.
            document.getElementById('logradouro').value=(conteudo.logradouro);
            document.getElementById('bairro').value=(conteudo.bairro);
            document.getElementById('cidade').value=(conteudo.localidade);
            document.getElementById('estado').value=(conteudo.uf);
        } //end if.
        else {
            //CEP não Encontrado.
            limpa_formulário_cep();
            alert("CEP não encontrado.");
        }
    }
        
    function pesquisacep(valor) {

        //Nova variável "cep" somente com dígitos.
        var cep = valor.replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep != "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if(validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                document.getElementById('logradouro').value="...";
                document.getElementById('bairro').value="...";
                document.getElementById('cidade').value="...";
                document.getElementById('estado').value="...";

                //Cria um elemento javascript.
                var script = document.createElement('script');

                //Sincroniza com o callback.
                script.src = 'https://viacep.com.br/ws/'+ cep + '/json/?callback=meu_callback';

                //Insere script no documento e carrega o conteúdo.
                document.body.appendChild(script);

            } //end if.
            else {
                //cep é inválido.
                limpa_formulário_cep();
                alert("Formato de CEP inválido.");
            }
        } //end if.
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cep();
        }
    };