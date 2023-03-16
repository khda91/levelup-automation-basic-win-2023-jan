Feature: Add to compare list product
    In order to compare several products
    As a shop user
    I want to add selected items to compare list

    Scenario: Selected items added to compare list
        Given I open DNS shop Home page
        And banner should be displayed on the page
        And I select 'Смартфоны и фототехника' category in Menu on the Home page
        And I select 'Смартфоны и гаджеты' subcategory in Menu on the Category page
        And I select 'Смартфоны' subcategory in Menu on the Subcategory page
        When I add 1,2,3 items to compare list on Products List page
        Then counter on 'Сравнение' button should be equal 3 in the header
        When I click 'Сравнение' button in the page header
        Then selected items should be displayed on the Compare Products page
