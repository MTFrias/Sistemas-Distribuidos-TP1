# TP1 - Threads e Objetos Distribuídos.


## Enunciado

Queremos uma aplicação que permita gerir os produtos de um tipo de negócio. 
Dependendo do tipo de negócio, os produtos devem estar organizados em categorias;
Cada produto deve ter um preço de compra e um preço de venda; 
Cada produto deve ter um stock mínimo, isto é, um valor a partir do qual, sempre que a 
quantidade de produto seja inferior ao stock mínimo, deve ser dado um aviso para repor o stock; 
A entrada de um produto deve ser registada como uma compra;
A saída de um produto deve ser registada como uma venda;
Para cada compra e para cada venda deve ficar registada a respectiva data. 

Deverá ser possível realizar as seguintes operações:
1– Registar um produto;
2 – Adicionar uma certa quantidade de um produto já existente;
3 – Dar saída de um produto (se um produto é vendido ou atinge o seu prazo de validade 
é retirada a quantidade correspondente do stock);
4 – Eliminar um produto (caso deixe de existir no negócio);
5 – Consultar produtos existentes. Prever vários tipos de consultas;
6 – Consultar as vendas (listar todas/ consultar por ordem de valor/produto mais vendido
7 – Consultar as compras feitas a um fornecedor (listar todas/ consultar por ordem de 
valor
Pretende-se uma aplicação cliente/servidor em java RMI, em que no processo servidor 
um ou vários objetos remotos disponibilizam as operações descritas acima. Devem existir dois tipos de processos cliente: 
- O processo Fornecedor e o processo Vendedor. O processo Fornecedor permitirá 
realizar as operações de registo, entrada e eliminação de produtos, deve também permitir consultar as operações de compras (do ponto de vista da empresa).
- O processo Vendedor tem acesso às operações de saída de produtos, consulta de 
produtos e vendas.

É suposto que os processos cliente sejam executados dentro da organização pelos seus 
funcionários. Os que tratam das compras aos fornecedores acederão aos processos do tipo Fornecedor; os que tratam das vendas, acederão aos processos do tipo Vendedor
Sempre que é realizada uma venda, é verificado se a quantidade existente do produto 
vendido permanece maior ou igual ao valor de seu stock mínimo. Caso fique inferior, o 
processo Fornecedor deverá receber um callback, com um aviso para repor o stock do 
produto em causa. 
