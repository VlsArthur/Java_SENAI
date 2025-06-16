fetch("http://localhost:8080/api/funcionarios-por-cargo", {
    method: 'GET',
    headers: { 'Content-Type': 'application/json' }
})
.then(response => response.json())
.then(data => {
    addLinha(data);
})
.catch(error => console.log(error));

fetch("http://localhost:8080/api/funcionarios", {
    method: 'GET',
    headers: { 'Content-Type': 'application/json' }
})
.then(response => response.json())
.then(data => {
    data.forEach(element => {
        const option = document.createElement('option');
        option.value = element.id;
        option.textContent = element.nome;
        document.getElementById('selectFuncionario').appendChild(option);
    })
})
.catch(error => console.log(error));

fetch("http://localhost:8080/api/cargos", {
    method: 'GET',
    headers: { 'Content-Type': 'application/json' }
})
.then(response => response.json())
.then(data => {
    data.forEach(element => {
        const option = document.createElement('option');
        option.value = element.id;
        option.textContent = element.nome;
        document.getElementById('selectCargo').appendChild(option);
    })
})
.catch(error => console.log(error));


function addLinha(dados) {
    const tabela = document.getElementById('tabelaVinculos');
    dados.forEach(element => {
        const linha = document.createElement('tr');
        linha.innerHTML = `
        <td class="px-4 py-2">${element.id}</td>
        <td class=px-4 py-2>${element.funcionario.nome}</td>
        <td class="px-4 py-2">${element.cargo.nome}</td>
        <td class="px-4 py-2">${element.data_inicio}</td>
        <td class="px-4 py-2">${element.data_fim}</td>
        <td class="px-4 py-2">${element.detalhes}</td>
        `
        tabela.appendChild(linha);
    })
}

function vincular(event) {
    event.preventDefault();
    const funcionario_id = document.getElementById('selectFuncionario').value;
    const cargo_id = document.getElementById('selectCargo').value;
    const data_inicio = document.getElementById('data_inicio').value;
    const data_fim = document.getElementById('data_fim').value;
    const detalhes = document.getElementById('detalhes').value;
    if (funcionario_id && cargo_id && data_inicio) {
        document.getElementById('selectFuncionario').value = "";
        document.getElementById('selectCargo').value = "";
        document.getElementById('data_inicio').value = "";
        document.getElementById('data_fim').value = "";
        document.getElementById('detalhes').value = "";

        fetch('http://localhost:8080/api/funcionarios-por-cargo', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "funcionario": {
                    "id": funcionario_id
                },
                "cargo": {
                    "id": cargo_id
                },
                "data_inicio": data_inicio,
                "data_fim": data_fim,
                "detalhes": detalhes
            })
        })
        .then(response => response.json())
        .then(data => {
            const url = "http://localhost:8080/api/funcionarios-por-cargo/" + data.id;
            fetch(url, {
                method: 'GET',
                headers: { 'Content-Type': 'application/json' }
            })
            .then(response => response.json())
            .then(data => {
                addLinha([data]);
            })
        })

        Swal.fire({
            icon: 'success',
            title: 'Sucesso!',
            content: 'Vínculo registrado com sucesso!'
        })
    }
}



/*
const url = "http://localhost:8080/api/funcionarios-por-cargo/" + data.id;
    fetch(url, {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    })
    .then(response => response.json())
    .then(data => {
        addLinha(data);
    })
*/