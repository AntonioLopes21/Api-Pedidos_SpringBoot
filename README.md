# Api-Pedidos_SpringBoot

#Desafio proposto:
![img.png](images/img.png)

<h1>RETIFICAÇÃO FINAL DO PROJETO</h1>

``Formas de POST de cliente, produto e compra - Nova lógica de negócio (Já solicitada implementada)``
CLIENTE

![img.png](images/img_21.png)

PRODUTO

![img_1.png](images/img_22.png)

COMPRA - entidade associativa que vincula o produto e o cliente:

![img_2.png](images/img_23.png)

<h3>Como testar os endpoints:</h3>
No POSTMAN, INSOMNIA, THUNDER(VSCODE), ETC...

ESTRUTURA UTILIZADA NOS TESTES:
![img_16.png](images/img_16.png)

CLIENTE
rota do endpoint GET: ``http://localhost:8080/clientes``

Resposta:
![img_3.png](images/img_3.png)

-----------------------------------------------------------
rota do endpoint POST: ``http://localhost:8080/clientes``
![img_1.png](images/img_1.png)

Resposta:
![img_2.png](images/img_2.png)
-----------------------------------------------------------
rota do endpoint PUT: ``http://localhost:8080/clientes/{id}``
![img_4.png](images/img_4.png)

Resposta:
![img_5.png](images/img_5.png)
-----------------------------------------------------------
rota do endpoint DELETE: ``http://localhost:8080/clientes/{id}``
![img_6.png](images/img_6.png)

Resposta:
![img_7.png](images/img_7.png)

Para teste utilize novamente o GET.
-----------------------------------------------------------

<h3>PRODUTO</h3>

-----------------------------------------------------------

rota do endpoint GET: ``http://localhost:8080/produtos``
![img_8.png](images/img_8.png)

Resposta: (se vazia)
![img_9.png](images/img_9.png)
-----------------------------------------------------------

rota do endpoint POST: ``http://localhost:8080/produtos``
![img_10.png](images/img_10.png)

Resposta:
![img_11.png](images/img_11.png)
-----------------------------------------------------------

rota do endpoint PUT: ``http://localhost:8080/produtos/{id}``
![img_12.png](images/img_12.png)

Resposta: 
![img_13.png](images/img_13.png)
-----------------------------------------------------------

rota do endpoint DELETE: ``http://localhost:8080/produtos/{id}``
![img_14.png](images/img_14.png)

Resposta:
![img_15.png](images/img_15.png)
-----------------------------------------------------------

<h3>ENDPOITS COMPRA</h3>

-----------------------------------------------------------
rota do endpoint de GET ``localhost:8080/compras``
![img.png](images/img_17.png)

Resposta: (Não vazia)
![img_1.png](images/img_18.png)
-----------------------------------------------------------

rota do endpoint POST ``localhost:8080/compras``

Resposta:
![img_1.png](images/img_18.png)
-----------------------------------------------------------
rota do endpoint PUT ``localhost:8080/compras/{id}``

![img_2.png](images/img_19t.png)

Resposta:
Referencia outra compra com outros clientes e produtos
![img_3.png](images/img_20t.png)