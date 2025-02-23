# Desafio - Persistência com Spring Data JPA e Flyway 💾

## 🎯 Objetivo do Desafio
O objetivo desta etapa é adaptar o sistema para utilizar **Spring Data JPA** com um banco de dados em memória **H2**, garantindo persistência dos dados e facilitando a execução das consultas. Além disso, os alunos deverão refatorar os relatórios para consultar no banco de dados e, como tarefa adicional, finalizar o CRUD de pedidos.

## 📝 Tarefas

### 1️⃣ **Configuração do Spring Data JPA e Banco de Dados**
- Adicione as dependências necessárias no `pom.xml`:
  - `spring-boot-starter-data-jpa`
  - `h2`
  - `flyway-core`
- Configure o banco de dados no `application.properties` para utilizar o **H2** em modo memória.

### 2️⃣ **Mapeamento das Entidades**
- Analise a estrutura do banco de dados descrita no arquivo:  
  📄 `src/main/resources/db/migration/V1__cria-tabelas-iniciais.sql`
- Crie as entidades do sistema e mapeie corretamente os relacionamentos.
- Utilize **JPA annotations** (`@Entity`, `@Id`, `@GeneratedValue`, `@OneToMany`, etc.).
- Valide o funcionamento executando a aplicação.

### 3️⃣ **Refatoração dos Relatórios para Banco de Dados**
- Atualize as funcionalidades do menu para buscar os dados diretamente do banco de dados.
- Substitua as operações com **Streams e coleções em memória** por **consultas utilizando Spring Data JPA**.
- Utilize **JPQL**, **Derived Queries** (`findBy`, `countBy`, `sumBy`, etc.) ou **SQL**.
- Valide os relatórios gerados para garantir que os dados estejam corretos.

---

## 🚀 Tarefa Opcional: Finalizar CRUD de Pedidos
- **Cadastrar pedido**: Adapte a funcionalidade existente para persistir os novos pedidos no banco de dados.
- **Excluir pedido**: Atualize a funcionalidade para remover pedidos do banco de dados.
- **Listar pedidos**: Implemente uma opção para visualizar todos os pedidos cadastrados.
- **Editar pedido**: Permita que o usuário atualize informações de um pedido já existente.

---

### 🔍 Pontos de Atenção
- **Configuração correta do Spring Data JPA e H2**: A aplicação inicia corretamente e conecta ao banco?
- **Mapeamento das entidades**: As classes refletem corretamente a estrutura das tabelas?
- **Substituição adequada das Streams**: As consultas no banco são eficientes e retornam os dados corretamente?
- **CRUD de pedidos**: As operações de inserção, remoção e listagem funcionam como esperado?

💡 **Dica:** Consulte a [documentação oficial do Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) para entender melhor os tipos de queries e o funcionamento das interfaces `JpaRepository`.

🚀 **Agora é com você!** Implemente a persistência no sistema e adapte os relatórios para o banco de dados! ✅
