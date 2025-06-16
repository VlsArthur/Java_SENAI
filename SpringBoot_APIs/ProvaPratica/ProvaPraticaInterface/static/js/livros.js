        //API GET
    fetch('http://localhost:8080/api/livros', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      },
    })
    .then(response => response.json())
    .then(data => {
      addlinha(data);
    })
    .catch(error => {
      console.log(error);
    });
    

  //Adicionar Linha na Tabela
  function addlinha(dadosAPI){
      const tabela = document.getElementById('tabelaCorpo');
      dadosAPI.forEach(element => {   
        const linha = document.createElement('tr');
        //Adicionando HTML
        linha.innerHTML = `
          <tr>
          <td class="px-4 py-2">${element.id}</td>
          <td class="px-4 py-2">${element.bibliotecario.nome}</td>
              <td class="px-4 py-2">${element.titulo}</td>
              <td class="px-4 py-2">${element.autor}</td>
              <td class="px-4 py-2">${element.genero}</td>
              <td class="px-4 py-2">${element.status}</td>
              <td class="px-4 py-2">${element.data_cadastro}</td>
              <td class="px-4 py-2">
                <button class="bg-red-500 text-white px-2 py-1 rounded" onclick="remover(this)">remover</button>
                <button class="bg-green-500 text-white px-2 py-1 rounded" onclick="editar(this)">editar</button>
              </td>
              
          </tr>
        `;
        
        tabela.appendChild(linha);
      });
    }

    //Cadastrar Novas pessoas do formulario
    function cadastrar(event){
      event.preventDefault();
      const responsavel = document.getElementById('responsavel').value;
      const titulo = document.getElementById('titulo').value;
      const autor = document.getElementById('autor').value;
      const genero = document.getElementById('genero').value;
      if(responsavel && titulo && autor && genero){
        //Limpando os campos
        document.getElementById('titulo').value = "";
        document.getElementById('autor').value = "";
        document.getElementById('responsavel').value = "";
        document.getElementById('genero').value = "";
        //API POST  
        fetch('http://localhost:8080/api/livros', { 
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({"bibliotecario": {"id": responsavel },"titulo":titulo, "autor":autor, "genero":genero})
        })
        .then(response => response.json())
        .then(data => {
          console.log("Resposta da API:", data);
          //Adicionando Linha com nosso Cadastro
          this.addlinha([{"id":data.id,"bibliotecario:":data.bibliotecario,"titulo":data.titulo, "autor":data.autor, "genero":data.genero, "status":data.status, "data_cadastro": data.data_cadastro}]);
          // dessa forma conseguimos manipular o id
        })
        .catch(error => {
          console.error("Erro ao enviar dados:", error);
        });
    ''

          Swal.fire({
            icon: 'success',
            title: 'Sucesso!',
            text: 'Cadastro feito com sucesso'
          });
      }else{
        Swal.fire({
          icon: 'error',
          title: 'Erro!',
          text: 'Falta dados para cadastar'
        });
      }
    }

    //Remover Alguma Linha da tabela
    function remover(dadosbotao){
      Swal.fire({
        icon: 'question',
        title: 'Você tem certeza?',
        showCancelButton: true,
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não'
      }).then((result) => {
        if (result.isConfirmed) {
            const linharemover = dadosbotao.closest('tr');
            linharemover.remove();
          Swal.fire('Confirmado!', '', 'success');
          const livroremover = linharemover.querySelector('td').textContent;
          const url = 'http://localhost:8080/api/livros/' + livroremover;
          fetch(url, {    
            method: 'DELETE',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({"id":livroremover})
          }).then(response => {
            if (response.ok) {
              console.log("Livro removido com sucesso");
            }
          })
          .catch(error => {
            console.error("Erro ao remover livro:", error);
          });
        } else {
          Swal.fire('Cancelado', '', 'info');
        }
      });
    }

      function editar(botao_editar) {
        Swal.fire({
          title: 'Editar livro',
          html: `
            <form id="formEditar" class="bg-white shadow-md rounded p-4">
              <div class="mb-4">
                <label for="statusEditar" class="block text-gray-700 font-bold mb-2">Status</label>
                <input type="text" id="statusEditar" class="w-full px-3 py-2 border rounded" required>
              </div>
            </form>`,
          showCancelButton: true,
          confirmButtonText: 'Salvar',
          cancelButtonText: 'Cancelar',
          didOpen: () => {
            const colunas = botao_editar.closest('tr').querySelectorAll('td');
            const statusOriginal = colunas[5].textContent;
            document.getElementById('statusEditar').value = statusOriginal;
          },
          preConfirm: () => {
            if (!document.getElementById('formEditar').checkValidity()) {
              document.getElementById('formEditar').reportValidity();
              return false;
            }
            const statusEditar = document.getElementById('statusEditar').value;
            if (statusEditar) {
              const url = `http://localhost:8080/api/livros/` + botao_editar.closest('tr').querySelector('td').textContent;
              fetch(url, {
                method: 'PUT',
                headers: {
                  'Content-Type': 'application/json'
                },
                body: JSON.stringify({"status": statusEditar})
              }).then(response => response.json())
              .then(data => {
                console.log("Resposta da API: ", data);
                // Atualizar a linha na tabela
                const linhaEditar = botao_editar.closest('tr');
                linhaEditar.querySelectorAll('td')[5].textContent = data.status;
              })
              .catch(error => {
                console.error("Erro ao editar dados:", error);
              });
              Swal.fire({
                icon: 'success',
                title: 'Sucesso!',
                text: 'Cadastro editado com sucesso'
              });
            } else {
              Swal.fire({
                icon: 'error',
                title: 'Erro!',
                text: 'Falta dados para cadastar'
              });
            }
          }
        })
      }