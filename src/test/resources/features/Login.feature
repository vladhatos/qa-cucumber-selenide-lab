@login
Feature: Autentificarea utilizatorului în HapifyMe
  Ca utilizator înregistrat
  Vreau să mă pot loga în aplicație
  Pentru a-mi accesa profilul și a vedea postările prietenilor


  Background:
    Given utilizatorul deschide pagina de login

  # Scenarii pozitive cu credentiale valide
  Scenario: Login cu succes folosind credențiale valide
    When utilizatorul introduce emailul "vlad.hatos@yahoo.com" si parola "Testing1!"
    And  utilizatorul apasă butonul de login
    Then utilizatorul ar trebui să fie redirecționat către homepage
    And  titlul paginii ar trebui sa contina "hapifyMe"

  # Scenarii negative cu credentiale invalide
  Scenario Outline: Login eșuat folosind credențiale invalide
    When utilizatorul introduce emailul "<email>" si parola "<password>"
    And  utilizatorul apasă butonul de login
    Then utilizatorul ar trebui să vadă un mesaj de eroare

    Examples:
      | email                 | password  |
      | invalidd@hapifyme.com | Test@1234 |
      |                       |           |
      | nonexistent@mail.com  |           |
      |                       | Test@1234 |

  # Logout
  Scenario: Utilizatorul se poate deloga cu succes
    When utilizatorul introduce emailul "vlad.hatos@yahoo.com" si parola "Testing1!"
    And  utilizatorul apasă butonul de login
    And  utilizatorul apasă butonul de logout
    Then utilizatorul ajunge pe login page
