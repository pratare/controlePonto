# controlePonto
Sistema de controle de ponto

## Listar todos os usuários: GET /usuarios
Exemplo:
[
    {
        "id": 1,
        "name": "Jose da Silva",
        "cpf": "8764325671",
        "email": "teste.teste@hotmail.com",
        "cadastro": "2020-02-18T23:58:43.812+0000",
        "totalHorasTrabalhadas": 0,
        "pontos": []
    },
    {
        "id": 2,
        "name": "Maria da Silva",
        "cpf": "32682717543",
        "email": "mariasilva@gmail.com",
        "cadastro": "2020-02-18T00:00:00.000+0000",
        "totalHorasTrabalhadas": 0,
        "pontos": []
    }
]

## Exibir dados do usuário: GET /usuarios/{id}
 Exemplo:
 {
	"id": 1,
	"name": "Jose da Silva",
	"cpf": "8764325671",
	"email": "teste.teste@hotmail.com",
	"cadastro": "2020-02-18T23:58:43.812+0000",
	"totalHorasTrabalhadas": 0,
	"pontos": []
}

## Cadastrar um usuário: POST /usuario
Exemplo Entrada:
{
	"name": "Pedro Teste",
	"cpf": "12376589743",
	"email": "pedro.teste@gmail.com",
	"cadastro": "2020-02-18"
}

## Alterar um usuário: PUT /usuario/{id}
Exemplo Entrada:
{
	"name": "Pedro Teste da Silva",
	"cpf": "12376589743",
	"email": "pedro.teste@gmail.com"
}

## Inserir uma entrada/saída no ponto: POST /usuario/[id}/ponto
Exemplo Entrada:
{
	"tipoPonto": "E"
}

## Consultar todas as entradas e saídas no ponto de um determinado usuário: GET /usuario/[id}/ponto
 Exemplo:
 [
    {
        "id": 2,
        "data": "2020-02-18",
        "duracao": "PT4.801S",
        "entrada": "2020-02-18T21:27:42.406",
        "saida": "2020-02-18T21:27:47.207",
        "tipoPonto": null
    },
    {
        "id": 3,
        "data": "2020-02-18",
        "duracao": "PT4.405S",
        "entrada": "2020-02-18T21:28:05.527",
        "saida": "2020-02-18T21:28:09.932",
        "tipoPonto": null
    }
]

Author
renato prata: renatoprata@gmail.com
https://github.com/pratare
mysql: #Descalvado12

https://gitlab.com/itau-spec-1/java/101-proposta-case-cartoes
https://spring.io/guides/gs/accessing-data-mysql/#initial
