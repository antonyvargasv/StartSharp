@suitCustomer
Feature: Validar inicio de sesion

  Background: Validar inicio de sesion con credenciales correctas e incorrectas
    Given el usuario ingresa al sitio web

  Scenario Outline: Validar con credenciales correctas
    When ingresa credenciales correctas
      | user   | pass   | customer   | company   |
      | <user> | <pass> | <customer> | <company> |
    Then valida el idCustomer en el modulo productos <message>
    Examples:
      | user  | pass     | message  | customer | company   |
      | admin | serenity | J-001x01 | J-001x01 | empresa J |