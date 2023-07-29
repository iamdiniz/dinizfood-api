# EMPRESA DE DELIVERY DE COMIDA ( EM DESENVOLVIMENTO ) API REST

 - REST API de uma empresa de Delivery de Comida (em desenvolvimento).

 - Nessa REST API você verá Boas Práticas usadas no mercado de trabalho usadas para desenvolvimento de uma REST API, como uso 
  correto dos código de status HTTP, uso dos verbos de forma correta, CRUD, Retornar respostas personalizadas, testes de integração etc...

 - Tecnologias e conceitos usados: Java, Spring, OO, MySQL, Flyway, Lombok, Maven, JPA, Spring Web, Padrão de Camadas, MVC, Hibernate, Tratamento de exceções da API.

 - Tecnologias e conceitos que ainda serão utilizados: Bean Validation, JUnit, DTO, ModelMapper.

  ![Screenshot (37)](https://github.com/iamdiniz/dinizfood-api/assets/72664530/281d289f-64a6-430a-92b1-b9441c94bbb9)

 - No momento esses são os recursos disponiveis na aplicação:

  ![Screenshot (45)](https://github.com/iamdiniz/dinizfood-api/assets/72664530/ce613d4d-1e6c-475e-b9dd-bd89f318027c)

  ![Screenshot (47)](https://github.com/iamdiniz/dinizfood-api/assets/72664530/b008410f-a45e-49b0-9a72-2e53f394791d)

 - Baixe a coleção: [DinizFood.postman_collection.zip](https://github.com/iamdiniz/dinizfood-api/files/12044137/DinizFood.postman_collection.zip)

 - Diagrama de classes:

   ![Diagrama](https://github.com/iamdiniz/dinizfood-api/assets/72664530/d631e38d-ea02-495b-aa15-4a335c4c1919)

 - Exemplo da aplicação em uso

   - Retornando um 404 not found com resposta personalizada

    ![Screenshot (67)](https://github.com/iamdiniz/dinizfood-api/assets/72664530/c3c409a3-f047-473c-b0af-ddeae61251dc)


 OBS:

 - Você não vai conseguir remover cozinhas que tem vinculo com restaurante (DataIntegrityViolationException)
   
 - Você não consegue criar um restaurante vinculando ele com uma cozinha que não existe!! (Verifique se a cozinha existe antes de 
   vincular)
  
 - Você não consegue remover estado que está em uso com cidade!!! (DataIntegrityViolationException)
   
 - Todos os recursos caso você envie uma request em algo inexistente, ele irá retornar um 404
   
 - Se você tentar mudar algo que está em uso, irá retornar um 409 Conflict.
