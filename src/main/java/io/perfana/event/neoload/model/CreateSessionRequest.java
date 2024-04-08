/*
 * Copyright (C) 2024 Peter Paul Bakker, Perfana
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.perfana.event.neoload.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * CreateSessionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class CreateSessionRequest {

  private String login;

  private String password;

  private String accountId;

  public CreateSessionRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateSessionRequest(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public CreateSessionRequest login(String login) {
    this.login = login;
    return this;
  }

  /**
   * User login
   * @return login
  */
  @NotNull 
  @Schema(name = "login", example = "john.doe@company.com", description = "User login", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public CreateSessionRequest password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Password
   * @return password
  */
  @NotNull 
  @Schema(name = "password", example = "my-s3cure-P@ssw0rd", description = "Password", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CreateSessionRequest accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  /**
   * ID of the Account
   * @return accountId
  */
  @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "accountId", example = "69c9a277bb9a473ca3d0d567", description = "ID of the Account", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accountId")
  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSessionRequest createSessionRequest = (CreateSessionRequest) o;
    return Objects.equals(this.login, createSessionRequest.login) &&
        Objects.equals(this.password, createSessionRequest.password) &&
        Objects.equals(this.accountId, createSessionRequest.accountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(login, password, accountId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSessionRequest {\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

