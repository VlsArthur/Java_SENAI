Atividade Prática: Criação de uma API CRUD com Spring Boot
Desenvolver uma API REST completa utilizando Spring Boot, com operações CRUD e
documentação via Swagger.

Requisitos obrigatórios:
Criar um banco de dados chamado: escola

Criar uma tabela chamada: alunos

Campos da Tabela:
• id → tipo: BIGINT, auto-increment, primary key, obrigatório.
• nome → tipo: String, obrigatório.
• email → tipo: String, não obrigatório.

Criar uma aplicação Spring Boot com as seguintes características:
• Utilizar Spring Web para criar os endpoints.
• Utilizar Spring Data JPA para integração com o banco de dados.
• Utilizar MySQL Driver para adicionar os drivers.
• Utilizar Lombok para simplificar o código.
• Utilizar Swagger (Springdoc) para documentação da API.

Implementar as seguintes rotas na API (/alunos):
• GET /alunos → listar todos os alunos.
• GET /alunos/{id} → buscar um aluno por ID.
• POST /alunos → cadastrar um novo aluno.
• PUT /alunos/{id} → atualizar os dados de um aluno.
• DELETE /alunos/{id} → deletar um aluno.