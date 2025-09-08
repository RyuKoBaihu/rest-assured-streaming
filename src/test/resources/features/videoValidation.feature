@VideoValidations
Feature: YouTube Video Validation with Public Data

  Scenario: Validate that the video is available
    Given I have the YouTube video id "SnzoFzCAG5Y"
    When I request the video status
    Then the video should be public and processed

  Scenario: Validate that the video has views
    Given I have the YouTube video id "SnzoFzCAG5Y"
    When I request the video statistics
    Then the video should have more than 0 views

  Scenario: Validate that the video has duration
    Given I have the YouTube video id "SnzoFzCAG5Y"
    When I request the video details
    Then the video should have a valid duration
