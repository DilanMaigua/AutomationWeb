# new feature
# Tags: optional

Feature: Validacion de funcionalidad MyStore

  @MyStoreTest
  Scenario: Validación del Precio de un Producto
    Given estoy en la página de la tienda
    And me logueo con mi usuario "dilanmaigua@hotmail.com" y clave "Gitan*2024"
    When  navego a la categoria "Clothes" y subcategoria "Men"
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito