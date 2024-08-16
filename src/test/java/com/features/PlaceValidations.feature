

Feature: Validating My Place API(POST,GET)

 @Addplace
  Scenario Outline: Verify whether the Place is Getting Succesfully Added Or NOT
    Given Add Place Payload with "<name>" "<language>" "<Address>"
    When user Call "AddPlaceApi" with "POST" HTTP Request
    Then the Api Call is success with Status Code 200 
    And "status" in Response body is  "OK"
    And "scope" in Resonse Body is "APP"
    And verify place_id created maps to "<name>" using "GetPlaceApi"
    
    Examples: 
    |name   | language| Address   |
    |AAHouse| Tamil   | Anna Nagar|
   # |BBHouse| Telugu  | Nehru House|
   @DeletePlace
   Scenario: verify if delete API Functionality is Working
   Given DeletePlace Payload
   When user Call "DeletePlaceApit" with "POST" HTTP Request
   Then the Api Call is success with Status Code 200 
   And "status" in Response body is  "OK"
    
  