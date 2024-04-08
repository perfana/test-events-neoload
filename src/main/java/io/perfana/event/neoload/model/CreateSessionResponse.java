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
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CreateSessionResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class CreateSessionResponse {

  @Valid
  private List<@Valid Account> accounts = new ArrayList<>();

  public CreateSessionResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateSessionResponse(List<@Valid Account> accounts) {
    this.accounts = accounts;
  }

  public CreateSessionResponse accounts(List<@Valid Account> accounts) {
    this.accounts = accounts;
    return this;
  }

  public CreateSessionResponse addAccountsItem(Account accountsItem) {
    if (this.accounts == null) {
      this.accounts = new ArrayList<>();
    }
    this.accounts.add(accountsItem);
    return this;
  }

  /**
   * Accounts of this user. Contains all accounts if account id was not specified in request and user has multiple accounts. Contains the account used to create the session if the user has only one account or the account id was specified in the request.
   * @return accounts
  */
  @NotNull @Valid 
  @Schema(name = "accounts", description = "Accounts of this user. Contains all accounts if account id was not specified in request and user has multiple accounts. Contains the account used to create the session if the user has only one account or the account id was specified in the request.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accounts")
  public List<@Valid Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<@Valid Account> accounts) {
    this.accounts = accounts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateSessionResponse createSessionResponse = (CreateSessionResponse) o;
    return Objects.equals(this.accounts, createSessionResponse.accounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateSessionResponse {\n");
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
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

