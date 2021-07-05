# Aula 4 - Tratamento de Erros e Prática Integrativa - TM

## Prática Integrativa - Link Tracker

Este repositório contém a solução da prática integrativa.

- POST ``` /aula4/tm/link ```
    - criação de um link tracker
    - body request:
    ```
    {
        "url": "https://www.google.com"
    }
    ```
    - o response será um json com o id do link e um token que deverá ser enviado no header quando se desejar fazer o redirecionamento
    - body response:
    ```
    {
        "linkId": 1,
        "token": "yktngyktngyktng"
    }
    ```
  
- GET ``` /aula4/tm/link/{linkId} ```
    - rota para fazer o redirecionamento para a url original
    - o header deve conter o token recebido como response na criação do link tracker
    - caso o header não contenha o token
    ```
    {
      "message": "Header param token not found"
    }
    ```
    - caso o token seja inválido ou o linkId não exista:
    ```
    {
        "message": "Link inválido!"
    }
    ```
  
- GET ``` /aula4/tm/metrics/{linkId} ```
    - retorna o número de vezes que o link tracker redirecionou para a url ocultada
    - body response:
    ```
    {
        "redirects": 1
    }
    ```
    - caso o linkId não exista:
    ```
    {
        "message": "Link inválido!"
    }
    ```
  
- POST ``` /aula4/tm/invalidate/{linkId} ```
    - invalida o redirecionamento de um link tracker (o link é removido da base de dados)
    - caso o linkId não exista:
    ```
    {
        "message": "Link inválido!"
    }
    ```