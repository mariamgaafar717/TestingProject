Feature: Scroll feature
  @withArrow
  Scenario: Verify scroll up using Arrow button and scroll down functionality
    Given User is on home page and scroll down to bottom
    When  User Click on Arrow button to move upward
    Then  page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen

  @WithoutArrow
  Scenario: Verify scroll up Without Arrow button and scroll down functionality
    Given User is on home page and scroll down to bottom
    When  User scroll up page to top
    Then  page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen