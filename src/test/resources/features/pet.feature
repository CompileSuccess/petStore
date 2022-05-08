Feature:Pet Store

  Scenario: find pets by status  - Positive
    Given User send get request to the right url and "/pet/findByStatus" end point
    Then status code should be 200

  @wip
    Scenario: find pets by id
      Given user send get request to the right url "/pet/{petID}" end point with path param with id 10
      Then status code should be 200

