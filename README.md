
---

# Scheduler API

## Descrição

A **Scheduler API** é uma aplicação RESTful construída com Java e Spring Boot que permite aos usuários gerenciar listas de tarefas, incluindo criação de tarefas, subtarefas, listagem, edição, exclusão e aplicação de filtros. A API também fornece funcionalidades de favoritar tarefas, ordená-las e verificar se as tarefas estão em dia ou atrasadas.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **PostgreSQL**
- **Spring Validation**
- **JUnit 5**
- **Mockito**
- **Maven**

## Funcionalidades

1. **Criação de Lista de Tarefas**: Permite ao usuário criar listas de tarefas com um título.
2. **Criação de Tarefa**: Adiciona uma nova tarefa a uma lista, com título, descrição, data de conclusão prevista, status (pendente ou concluída), e data de conclusão real.
3. **Criação de Subtarefa**: Adiciona uma subtarefa vinculada a uma tarefa.
4. **Listagem de Listas de Tarefas**: Exibe todas as tarefas agrupadas por listas, ordenadas por favoritos e data de criação.
5. **Filtros**: Filtra tarefas por status (concluídas ou não concluídas) e favoritos.
6. **Edição de Tarefa**: Permite editar o título, a descrição e a data prevista de uma tarefa.
7. **Exclusão de Tarefa**: Permite excluir uma tarefa específica.
8. **Exclusão de Tarefas Concluídas**: Remove todas as tarefas concluídas de uma lista.
9. **Alteração de Status**: Altera o status de uma tarefa entre "pendente" e "concluída".
10. **Favoritar Tarefa**: Permite favoritar ou desfavoritar uma tarefa ou subtarefa.
11. **Ordenação de Tarefas**: As tarefas são ordenadas primeiro pelos favoritos e depois pela data de criação, das mais antigas para as mais recentes.
12. **Indicação de Tarefas Atrasadas**: Exibe se a tarefa está "em dia" ou "atrasada" e quantos dias está atrasada.

## Instalação

### Pré-requisitos

- **Java 17** ou superior
- **Maven 3.8+**
- **PostgreSQL 13+**

### Passos para Instalação

1. **Clone o Repositório**
   ```bash
   git clone https://github.com/username/todolist-api.git
   cd Scheduler-api
   ```

2. **Configuração do Banco de Dados**

   Configure o banco de dados PostgreSQL e ajuste o `application.properties` ou `application.yml` conforme necessário:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/Scheduler
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
   ```

3. **Compilar e Executar a Aplicação**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Acessar a API**

   A API estará disponível em: `http://localhost:8080/api`

## Endpoints

### Listas de Tarefas

- **GET /api/tasklists** - Retorna todas as listas de tarefas.
- **POST /api/tasklists** - Cria uma nova lista de tarefas.
    - Body: `{ "title": "Nome da Lista" }`

### Tarefas

- **GET /api/tasks** - Retorna todas as tarefas, ordenadas por favoritos e data de criação.
- **POST /api/tasks** - Cria uma nova tarefa.
    - Body: `{ "title": "Título da Tarefa", "description": "Descrição", "dueDate": "yyyy-MM-dd", "favorite": false }`
- **PUT /api/tasks/{id}** - Atualiza uma tarefa existente.
    - Body: `{ "title": "Novo Título", "description": "Nova Descrição", "dueDate": "yyyy-MM-dd" }`
- **DELETE /api/tasks/{id}** - Exclui uma tarefa.
- **PUT /api/tasks/{id}/status** - Altera o status de uma tarefa.
    - Body: `{ "completed": true }`

### Subtarefas

- **POST /api/tasks/{taskId}/subtasks** - Cria uma nova subtarefa para uma tarefa específica.
    - Body: `{ "name": "Nome da Subtarefa" }`

## Validações e Regras de Negócio

1. **Validação de Dados**:
    - O título de uma tarefa deve ter pelo menos 5 caracteres.
    - A descrição não pode estar vazia.
2. **Data Prevista**:
    - A data prevista para conclusão deve ser uma data no futuro.
3. **Ordenação de Tarefas**:
    - As tarefas são ordenadas primeiro pelos favoritos e depois pela data de criação.
4. **Indicação de Atraso**:
    - Tarefas atrasadas são identificadas com o número de dias de atraso.

## Testes

### Testes Unitários

Os testes unitários são escritos com JUnit 5 e Mockito. Eles validam o comportamento de serviços e componentes individuais da aplicação.

### Testes de Integração

Os testes de integração verificam a interação entre os componentes da aplicação, incluindo chamadas a endpoints e persistência de dados.

### Executando os Testes

Para executar todos os testes:

```bash
mvn test
```

## Contribuições

Se deseja contribuir com este projeto, siga os passos abaixo:

1. Faça um fork do repositório.
2. Crie uma nova branch com a sua feature (`git checkout -b feature/MinhaFeature`).
3. Faça o commit das suas alterações (`git commit -m 'Adicionando nova feature'`).
4. Envie para a branch (`git push origin feature/MinhaFeature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

Para mais informações ou dúvidas, entre em contato:

- Email: ricardo.martins18@fatec.sp.gov.br
- LinkedIn: [Perfil](https://www.linkedin.com/in/ricardo-ferreira-martins-9a688214b/)
- GitHub: [Repositório](https://github.com/RickFerry)

---
