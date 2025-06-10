fetch('http://localhost:8080/api/cargos', {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json'
    },
})
.then(response => response.json())
.then(data => {
    addLinha(data);
})
.catch(error => {
    console.log(error);
});

function addLinha(dados) {
    const tabela = document.getElementById('tabelaCargos');
    dados.forEach(element => {
        const linha = document.createElement('tr');
        linha.innerHTML = `
            <td class="px-4 py-2">${element.id}</td>
            <td class="px-4 py-2">${element.nome}</td>
            <td class="px-4 py-2">${element.descricao}</td>
            <td class="px-4 py-2">
                <button class="bg-red-500 text-white px-2 py-1 rounded" onclick="remover(this)">remover</button>
                <button class="bg-green-500 text-white px-2 py-1 rounded" onclick="editar(this)">editar</button>
            </td>
        `;
        tabela.appendChild(linha);
    });
}    

function adicionar(event) {
    event.preventDefault();
    const nome = document.getElementById('nome').value;
    const descricao = document.getElementById('descricao').value;
    if (nome && descricao) {
        document.getElementById('nome').value = "";
        document.getElementById('descricao').value = "";

        fetch('http://localhost:8080/api/cargos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({"nome":nome, "descricao":descricao})
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            this.addLinha([{"id":data.id,"nome":data.nome.trim(), "descricao":data.descricao.trim()}]);
        })
        .catch(error => {
            console.log(error);
        });

        Swal.fire({
            icon: 'success',
            title: 'Sucesso!',
            text: 'Cadastro feito com sucesso'
        });
    }
}

function remover(botao) {
    Swal.fire({
        icon: 'question',
        title: 'Você tem certeza?',
        showCancelButton: true,
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não'
    }).then((result) => {
        if (result.isConfirmed) {
            const linha = botao.closest('tr');
            linha.remove();
            Swal.fire('Confirmado!', '', 'success');
            const url = 'http://localhost:8080/api/cargos/' + linha.querySelector('td').textContent;
            fetch(url, {    
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => {
                if (response.ok) {
                    console.log("Cargo removido com sucesso");
                }
            })
            .catch(error => {
                console.log(error);
            });
        } else {
            Swal.fire('Cancelado', '', 'info');
        }
    });
}


function editar(botao) {
    Swal.fire({
        title: 'Editar cargo',
        html: `
            <form id="formEditar" class="bg-white shadow-md rounded p-4">
                <div class="mb-4">
                    <label for="nome" class="block text-gray-700 font-bold mb-2">Nome</label>
                    <input type="text" id="nomeEditar" class="w-full px-3 py-2 border rounded" required>
                </div>
                <div class="mb-4">
                    <label for="descricao" class="block text-gray-700 font-bold mb-2">Descrição</label>
                    <input type="text" id="descricaoEditar" class="w-full px-3 py-2 border rounded" required>
                </div>
            </form>`,
        showCancelButton: true,
        confirmButtonText: 'Salvar',
        cancelButtonText: 'Cancelar',
        didOpen: () => {
            const colunas = botao.closest('tr').querySelectorAll('td');
            const nomeOriginal = colunas[1].textContent;
            const descricaoOriginal = colunas[2].textContent;
            document.getElementById('nomeEditar').value = nomeOriginal;
            document.getElementById('descricaoEditar').value = descricaoOriginal;
        },
        preConfirm: () => {
            if (!document.getElementById('formEditar').checkValidity()) {
                document.getElementById('formEditar').reportValidity();
                return false;
            }
            const nomeEditar = document.getElementById('nomeEditar').value;
            const descricaoEditar = document.getElementById('descricaoEditar').value;
            if (nomeEditar && descricaoEditar) {
                const url = `http://localhost:8080/api/cargos/` + botao.closest('tr').querySelector('td').textContent;
                fetch(url, {
                    method: 'PUT',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({"nome": nomeEditar, "descricao": descricaoEditar})
                }).then(response => response.json())
                .then(data => {
                    console.log("Resposta da API: ", data);
                    const linhaEditar = botao.closest('tr');
                    linhaEditar.querySelectorAll('td')[1].textContent = data.nome;
                    linhaEditar.querySelectorAll('td')[2].textContent = data.descricao;
                })
                .catch(error => {
                    console.error("Erro ao editar dados:", error);
                });
                Swal.fire({
                    icon: 'success',
                    title: 'Sucesso!',
                    text: 'Cadastro editado com sucesso'
                });
            } 
        }   
    })
}
