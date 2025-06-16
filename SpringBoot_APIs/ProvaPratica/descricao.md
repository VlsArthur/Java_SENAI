Prova Prática – Técnico em Desenvolvimento de Sistemas
Tema: Catálogo de Livros de Biblioteca

Orientações Gerais
• Desligue e guarde o seu telefone celular.
• Antes de iniciar a prova, leia atentamente as instruções contidas neste
caderno e esclareça as dúvidas com o avaliador, caso necessário. Para
isso, você terá os 30 minutos iniciais de ambientação para ler a prova na
íntegra e reconhecer o posto de trabalho, além de verificar se todas as
ferramentas, documentos e tecnologias estão disponíveis.
• Aguarde o avaliador sinalizar o fim da ambientação ou informe a ele que
você quer iniciar a prova. A partir desse momento contará o tempo de 03
horas para que você realize as atividades.
• Para a execução desta prova, estão disponíveis no seu posto de trabalho:
máquinas, equipamentos, instrumentos, ferramentas, materiais de
consumo e toda documentação técnica necessária para realização das
atividades.
• Durante a prova, lembre-se de cumprir todas as exigências referentes às
normas de saúde, segurança do trabalho e de meio ambiente, incluindo o
uso de equipamentos de proteção individual, de acordo com a atividade.
• Ao final da avaliação, este caderno e demais itens disponibilizados devem
ser devolvidos ao avaliador.
• Para registrar o final da sua prova, você deverá assinar o canhoto da prova
junto com o seu avaliador.
• O avaliador está à disposição para dirimir qualquer dúvida, desde que não
seja referente à resolução da prova.

Contextualização
Uma biblioteca pública está em processo de modernização e precisa de um
sistema que auxilie no cadastro dos livros e dos bibliotecários responsáveis por
cada registro.
Atualmente, os dados são organizados em planilhas, o que dificulta a consulta e o
controle de empréstimos. O novo sistema deve permitir:

• O cadastro de bibliotecários com seus dados básicos.
• O cadastro de livros, vinculados a um bibliotecário.
• A edição, exclusão e alteração do status dos livros (Disponível,
Emprestado, Reservado).

Desafio
Utilizando os conhecimentos adquiridos ao longo do curso, desenvolva uma
aplicação de catálogo de livros com os seguintes requisitos:
Dados do bibliotecário:
• ID (gerado automaticamente)
• Nome
• E-mail
Dados do livro:
• ID (gerado automaticamente)
• ID do bibliotecário responsável (chave estrangeira)
• Título
• Autor
• Gênero (Romance, Técnico, Fantasia, etc.)
• Status (Disponível, Emprestado, Reservado) – padrão: Disponível
• Data de cadastro
Regras de negócio:
• Um bibliotecário pode cadastrar vários livros, mas cada livro deve estar
vinculado a apenas um bibliotecário.
• Todos os campos são obrigatórios.
• O sistema deve permitir cadastrar, editar e excluir registros de livros.
• O status do livro pode ser alterado após o cadastro.

Entregas
No Entrega Descrição

1

Diagrama Entidade-
Relacionamento (DER)

Modelo lógico do banco contendo as tabelas
bibliotecarios e livros, com seus campos,
relacionamentos e tipos.

2
Criação do Banco de
Dados

Criação das tabelas no SGBD com todos os campos
obrigatórios e exportação do script .sql.

3
Diagrama de Caso de
Uso

Diagrama ilustrando o fluxo de uso do sistema de
cadastro.

4 API Spring Boot

Backend com os endpoints de cadastro, listagem,
edição e exclusão de bibliotecários e livros.

5
Tela de Cadastro de
Bibliotecário

Formulário com validação e persistência dos
dados.

6 Tela de Cadastro de Livro

Formulário que permite associar o livro a um
bibliotecário já existente, com os campos
necessários e controle de status.

Wireframes / Interface (Sugestão)
Você pode usar a mesma estrutura visual da prova original, apenas adaptando os
rótulos e campos ao tema do catálogo de livros. O layout é livre, desde que
cumpra as funcionalidades descritas.

Resumo das Entregas
• Arquivo .JPG com o DER.
• Script .SQL com a estrutura e dados do banco.
• Arquivo .JPG com o diagrama de caso de uso.
• Pasta compactada com o código-fonte da API Spring Boot e das interfaces
desenvolvidas.