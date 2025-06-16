        //API GET
    fetch('http://localhost:8080/api/bibliotecarios', {
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
              <td class="px-4 py-2">${element.nome}</td>
              <td class="px-4 py-2">${element.email}</td>
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
      const nome = document.getElementById('nome').value;
      const email = document.getElementById('email').value;
      if(nome && email){
        //Limpando os campos
        document.getElementById('nome').value = "";
        document.getElementById('email').value = "";

        //API POST  
        fetch('http://localhost:8080/api/bibliotecarios', { 
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({"nome":nome, "email":email})
        })
        .then(response => response.json())
        .then(data => {
          console.log("Resposta da API:", data);
          //Adicionando Linha com nosso Cadastro
          this.addlinha([{"id":data.id,"nome":data.nome.trim(), "email":data.nome.trim()}]);
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
            // const linharemover = botao.closest('tr');
            // nome do parametro errado
            const linharemover = dadosbotao.closest('tr');
            linharemover.remove();
          Swal.fire('Confirmado!', '', 'success');
          const bibliotecarioremover = linharemover.querySelector('td').textContent;
          const url = 'http://localhost:8080/api/bibliotecarios/' + bibliotecarioremover;
          fetch(url, {    
            method: 'DELETE',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify({"id":bibliotecarioremover})
          }).then(response => {
            if (response.ok) {
              console.log("Bibliotecário removido com sucesso");
            }
          })
          .catch(error => {
            console.error("Erro ao remover bibliotecario:", error);
          });
        } else {
          Swal.fire('Cancelado', '', 'info');
        }
      });
    }

      function editar(botao_editar) {
        Swal.fire({
          title: 'Editar bibliotecario',
          html: `
            <form id="formEditar" class="bg-white shadow-md rounded p-4">
              <div class="mb-4">
                <label for="nome" class="block text-gray-700 font-bold mb-2">Nome</label>
                <input type="text" id="nomeEditar" class="w-full px-3 py-2 border rounded" required>
              </div>
              <div class="mb-4">
                <label for="email" class="block text-gray-700 font-bold mb-2">E-mail</label>
                <input type="email" id="emailEditar" class="w-full px-3 py-2 border rounded" required>
              </div>
            </form>`,
          showCancelButton: true,
          confirmButtonText: 'Salvar',
          cancelButtonText: 'Cancelar',
          didOpen: () => {
            const colunas = botao_editar.closest('tr').querySelectorAll('td');
            const nomeOriginal = colunas[1].textContent;
            const emailOriginal = colunas[2].textContent;
            document.getElementById('nomeEditar').value = nomeOriginal;
            document.getElementById('emailEditar').value = emailOriginal;
          },
          preConfirm: () => {
            if (!document.getElementById('formEditar').checkValidity()) {
              document.getElementById('formEditar').reportValidity();
              return false;
            }
            const nomeEditar = document.getElementById('nomeEditar').value;
            const emailEditar = document.getElementById('emailEditar').value;
            if (nomeEditar && emailEditar) {
              const url = `http://localhost:8080/api/bibliotecarios/` + botao_editar.closest('tr').querySelector('td').textContent;
              fetch(url, {
                method: 'PUT',
                headers: {
                  'Content-Type': 'application/json'
                },
                body: JSON.stringify({"nome": nomeEditar, "email": emailEditar})
              }).then(response => response.json())
              .then(data => {
                console.log("Resposta da API: ", data);
                // Atualizar a linha na tabela
                const linhaEditar = botao_editar.closest('tr');
                linhaEditar.querySelectorAll('td')[1].textContent = data.nome;
                linhaEditar.querySelectorAll('td')[2].textContent = data.email;
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