@suitLogin
Feature: Validar inicio de sesion

  Background: Validar inicio de sesion con credenciales correctas e incorrectas
    Given el usuario ingresa al sitio web

  Scenario Outline: Validar con credenciales correctas
    When ingresa credenciales correctas
      | user   | pass   |
      | <user> | <pass> |
    Then valida el texto en el modulo producto <message>
    Examples:
      | user  | pass     | message   |
      | admin | serenity | Dashboard |


  Scenario Outline: Validar con credenciales incorrectas
    When ingresa credenciales incorrectas
      | user   | pass   |
      | <user> | <pass> |
    Then valida el error en el modulo productos <message>
    Examples:
      | user  | pass      | message                       |
      | admin | serenityX | Invalid username or password! |



