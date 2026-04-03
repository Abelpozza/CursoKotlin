# Sistema de Cadastro de Remédios em Kotlin

Projeto desenvolvido em **Kotlin** com execução em **console**, com foco em praticar organização de código, separação de responsabilidades e manipulação de dados de forma simples e funcional.

## Sobre o projeto

Este sistema permite o cadastro e a listagem de remédios por meio de um menu interativo no terminal.  
O objetivo foi praticar conceitos importantes da linguagem Kotlin, como:

- classes e `data class`
- listas mutáveis
- separação de responsabilidades
- regras de negócio em camada de serviço
- manipulação e formatação de datas
- validação de entrada do usuário

## Funcionalidades

- Cadastrar novo remédio
- Listar remédios cadastrados
- Validar datas no formato `dd/MM/yyyy`
- Exibir mensagens de erro para entradas inválidas
- Encerrar o sistema pelo menu

## Estrutura do projeto

O projeto foi organizado de forma simples para treinar uma separação parecida com camadas:

- **Domain / Entidade**  
  Representação do remédio com informações como nome, data do lote, fabricante, dosagem e uso recomendado.

- **Service**  
  Responsável por armazenar e retornar a lista de remédios cadastrados.

- **Utils**  
  Funções auxiliares para leitura de texto, leitura de data e formatação.

- **View / Menu**  
  Parte responsável pela interação com o usuário no terminal.

## Tecnologias utilizadas

- Kotlin
- Programação orientada a objetos
- Estrutura em camadas simples
- Manipulação de datas com `LocalDate`
- Leitura de dados via terminal

## Exemplo de uso

```bash
===== MENU =====
1 - Cadastrar novo remédio
2 - Listar remédios cadastrados
3 - Sair
