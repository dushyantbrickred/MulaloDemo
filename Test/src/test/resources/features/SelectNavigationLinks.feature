Feature: Home Page of Vitality
 
  Scenario: Clicking Home Page Links
    Given that I am interested Discovery Vitality Navigation links	
    Then I validate the links on the join vitality page
    Then I validate the images on the join vitality page
    Then I validate invalid user credentials on the join vitality page
    Then I validate valid user credentials on the join vitality page
    Then I validate valid credentials with invalid ID number on the join vitality page

    
    