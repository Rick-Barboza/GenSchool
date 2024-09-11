# GenSchool

GenSchool é uma aplicação de gerenciamento escolar desenvolvida com Spring Boot. Ela permite realizar operações de CRUD (Create, Read, Update e Delete) em entidades como alunos, professores e turmas, além de gerenciar suas relações no banco de dados.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento da aplicação.
- **Spring Data JPA**: Para a comunicação com o banco de dados.
- **MySQL**: Banco de dados relacional utilizado.
- **Swagger**: Para documentação de APIs.
- **Maven**: Gerenciador de dependências e build da aplicação.

## Funcionalidades

- Gerenciamento de Alunos, Professores e Turmas.
- CRUD completo para as entidades:
  - Participante
- Integração com banco de dados.
- Documentação automática de APIs com Swagger.

## Instalação e Execução

Siga os passos abaixo para configurar e executar o projeto localmente.

### Pré-requisitos

- **Java 17** ou superior instalado.
- **Maven** instalado.
- **MySQL** configurado e rodando.

### End points

- **findAll** Retorna uma lista de participantes
- **findById** Retorna um participante especifico filtrado pelo id, com validaçoes para id inexistente ou incorreto
- **findByName** Retorna uma lista de participantes que contenha os carateres usados no filtro de pesquisa.
- **Post** Insere uma participante e retorna o mesmo com o Id gerando.
- **Put** Atualiza o participante filtrado pelo id, o id tambem será validado para casos de id incorreto ou inexistente
- **delete** Delete o participante pelo id, o id tambem será validado para casos de id incorreto ou inexistente.

**Importante** -> projeto apenas para testes, no caso do delete o participante sera excluido da base e nao inativado conforme Lei LGPD.


