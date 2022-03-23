Feature: EnrichmentTaskFactory test

  Scenario: Check if EnrichmentTaskFactory is ready to be run
    Given Create a EnrichmentTaskFactory Object
    And EnrichmentTaskFactory consists a CyNetworkManager which contains NetworkSet
    And NetworkSet is not empty
    When  Request status of is EnrichmentTaskFactory ready
    Then  Returned value should be "true"

  Scenario: Check if EnrichmentTaskFactory is ready to be run
    Given Create a EnrichmentTaskFactory Object
    And EnrichmentTaskFactory consists a CyNetworkManager which contains NetworkSet
    When  Request status of is EnrichmentTaskFactory ready
    Then  Returned value should be "false"

  Scenario: Check if EnrichmentTaskFactory is ready to be run
    Given Create a EnrichmentTaskFactory Object
    When  Request status of is EnrichmentTaskFactory ready
    Then  Returned value should be "false"
