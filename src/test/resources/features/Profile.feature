@profile
Feature: Cautare de useri si vizionarea setarilor profilului
  Ca un utilizator inregistrat
  Vreau sa pot cauta alti useri si sa pot vedea setarile
  Ca sa pot interactiona cu alti prieteni

  Background:
    Given utilizatorul s-a logat cu emailul "vlad.hatos@yahoo.com" si parola "Testing1!"

  # Cautarea unui user si accesarea profilului
  Scenario: Cautarea unui user si accesarea profilului
    When utilizatorul caută "George" în bara de navigare
    Then ar trebui să vadă o listă de rezultate care conține "George"
    When utilizatorul da click pe primul rezultat
    Then pagina utilizatorului trebuie accesata

  # Cautarea unui utilizator inexistent
  Scenario: Cautarea unui utilizator inexistent
    When utilizatorul cauta un utilizator inexistent in search bar
    Then o pagina fara rezultate e afisata

  # Editare profil
  Scenario: Update informatii profil in Settings
    When utilizatorul navigheaza la Settings
    And  utilizatorul editeaza urmatoarele valori:
      | first_name   | last_name     |
      | VladUPDATED  | HatosUPDATED  |
      | VladUPDATED2 | HatosUPDATED2 |
    And  utilizatorul da click pe Update
    Then noile setari sunt salvate
