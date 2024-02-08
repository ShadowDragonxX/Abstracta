Feature: Automatizacion de OpenCart Abstracta
  Scenario: entrar
    Given arranco la URL de OpenCart
    Then hago click en la barra de busqueda y busco iphone
    And hago click en el primer resultado
    And agrego al carrito el producto
    And ingreso al carrito de compras
    And valido que el item este dentro del carro
    And elimino el item del carro
    And valido que no este el item dentro del carro