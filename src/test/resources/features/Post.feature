@post
Feature: Functionalitate postare pe feed
  Ca utilizator inregistrat
  Vreau sa pot crea o postare pe feed
  Ca prietenii sa vada ce am postat

  Background:
    Given utilizatorul s-a logat cu emailul "vlad.hatos@yahoo.com" si parola "Testing1!"

  # Creem o postare valida
  Scenario: Crearea unei postari pe feed
    When utilizatorul scrie "TEST: Creare postare automata." in input field
    And  utilizatorul apasa pe butonul de Post
    Then postarea noua trebuie sa apara in feed
