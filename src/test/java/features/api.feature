Feature: Test automation Rest API

  @api
  Scenario: Test get list data normal
    Given prepare url for "GET_LIST_USERS"
    And hit get API get list user
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test create new user normal
    Given prepare url for "CREATE_NEW_USERS"
    And hit get API post create new user
    Then validation status code is equals 201
    Then validation response body create users
    Then validation response json with JSONSchema "post_create_new_user_normal.json"

    #ini adalah delete create user yang baru dibuat
  @api
  Scenario: Test delete user normal
    Given prepare url for "CREATE_NEW_USERS"
    And hit get API post create new user
    Then validation status code is equals 201
    Then validation response body create users
    And hit get API delete new user
    Then validation status code is equals 204

    #masih mencoba tapi tidak bisa
  @api
  Scenario: Test delete user
    Given prepare url for "DELETE_USERS"
    And hit get API delete user

  @api
  Scenario: Test update user normal
    Given prepare url for "CREATE_NEW_USERS"
    And hit get API post create new user
    Then validation status code is equals 201
    Then validation response body create users
    And hit get API update new user
    Then validation status code is equals 200
    Then validation response body update users