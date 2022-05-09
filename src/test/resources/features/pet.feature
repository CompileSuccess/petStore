Feature:Pet Store

  Scenario: find pets by status  - Positive
    Given User send get request to the right url and "/pet/findByStatus" end point
    Then status code should be 200


    Scenario: find pets by id
      Given user send get request to the right url "/pet/{petID}" end point with path param with id 10
      Then status code should be 200


    Scenario: add new pet to the store
      Given user sends post request to the right url "/pet" endpoint
      Then status code should be 200

  @wip
    Scenario: delete a pet
      Given user send a delete request to the right url "/pet/{petID}" endpoint with path param with id 120
      Then status code should be 200
