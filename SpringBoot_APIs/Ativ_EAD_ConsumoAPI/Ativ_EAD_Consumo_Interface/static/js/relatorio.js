document.addEventListener("DOMContentLoaded", () => {
    document.getElementById('tipoBusca').value = '';
});

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
        document.getElementById('funcionario').appendChild(option);
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
        document.getElementById('cargo').appendChild(option);
    })
})
.catch(error => console.log(error));

function addLinha(dados) {
    const tabela = document.getElementById('tabelaRelatorio');
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

function mostrarFiltros(filtro) {
    const filtroFuncionario = document.getElementById('filtroFuncionario');
    const filtroCargo = document.getElementById('filtroCargo');

    if(filtro === 'funcionario') {
        filtroFuncionario.style.display = 'block';
        filtroCargo.style.display = 'none';
        document.getElementById('cargo').value = '';
    } else {
        filtroCargo.style.display = 'block';
        filtroFuncionario.style.display = 'none';
        document.getElementById('funcionario').value = '';
    }
}

function buscar(event) {
    event.preventDefault();
    const funcionarioId = document.getElementById('funcionario').value;
    const cargoId = document.getElementById('cargo').value;
    const params = new URLSearchParams();
    if (funcionarioId) {
        params.append('funcionarioId', funcionarioId);
    } else {
        params.append('cargoId', cargoId)
    }

    fetch('http://localhost:8080/api/funcionarios-por-cargo?${params.toString()}', {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    })
    .then(response => response.json())
    .then(data => {
        const tabela = document.getElementById('tabelaRelatorio');
        tabela.innerHTML = ''; // Limpa a tabela antes de adicionar novos dados
        addLinha(data);
    })
    .catch(error => console.log(error));
}