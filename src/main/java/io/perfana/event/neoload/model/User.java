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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a User.
 */

@Schema(name = "User", description = "Represents a User.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class User {

  private String id;

  private String email;

  /**
   * Role of the user
   */
  public enum RoleEnum {
    NONE("NONE"),
    
    GUEST("GUEST"),
    
    TESTER("TESTER"),
    
    NEOLOAD_ADMIN("NEOLOAD_ADMIN"),
    
    ACCOUNT_ADMIN("ACCOUNT_ADMIN");

    private String value;

    RoleEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RoleEnum fromValue(String value) {
      for (RoleEnum b : RoleEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private RoleEnum role;

  /**
   * Status of the User
   */
  public enum StatusEnum {
    PENDING("PENDING"),
    
    ACTIVE("ACTIVE");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  @Valid
  private List<@Valid UserWorkspace> workspaces = new ArrayList<>();

  private String firstName;

  private String lastName;

  private OffsetDateTime lastSuccessfulLogin;

  private String login;

  public User() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public User(String id, String email, RoleEnum role, StatusEnum status, List<@Valid UserWorkspace> workspaces) {
    this.id = id;
    this.email = email;
    this.role = role;
    this.status = status;
    this.workspaces = workspaces;
  }

  public User id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the User
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "id", example = "69c9a277bb9a473ca3d0d567", description = "ID of the User", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email of the User
   * @return email
  */
  @NotNull @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") 
  @Schema(name = "email", example = "jdoe@tricentis.com", description = "Email of the User", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Role of the user
   * @return role
  */
  @NotNull 
  @Schema(name = "role", description = "Role of the user", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("role")
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public User status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the User
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "PENDING", description = "Status of the User", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public User workspaces(List<@Valid UserWorkspace> workspaces) {
    this.workspaces = workspaces;
    return this;
  }

  public User addWorkspacesItem(UserWorkspace workspacesItem) {
    if (this.workspaces == null) {
      this.workspaces = new ArrayList<>();
    }
    this.workspaces.add(workspacesItem);
    return this;
  }

  /**
   * Workspaces of the user
   * @return workspaces
  */
  @NotNull @Valid 
  @Schema(name = "workspaces", description = "Workspaces of the user", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("workspaces")
  public List<@Valid UserWorkspace> getWorkspaces() {
    return workspaces;
  }

  public void setWorkspaces(List<@Valid UserWorkspace> workspaces) {
    this.workspaces = workspaces;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the User
   * @return firstName
  */
  
  @Schema(name = "firstName", example = "John", description = "First name of the User", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the User
   * @return lastName
  */
  
  @Schema(name = "lastName", example = "Doe", description = "Last name of the User", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User lastSuccessfulLogin(OffsetDateTime lastSuccessfulLogin) {
    this.lastSuccessfulLogin = lastSuccessfulLogin;
    return this;
  }

  /**
   * Date and time in UTC when the user logged in for the last time.
   * @return lastSuccessfulLogin
  */
  @Valid 
  @Schema(name = "lastSuccessfulLogin", description = "Date and time in UTC when the user logged in for the last time.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastSuccessfulLogin")
  public OffsetDateTime getLastSuccessfulLogin() {
    return lastSuccessfulLogin;
  }

  public void setLastSuccessfulLogin(OffsetDateTime lastSuccessfulLogin) {
    this.lastSuccessfulLogin = lastSuccessfulLogin;
  }

  public User login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Login of the User
   * @return login
  */
  @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$") 
  @Schema(name = "login", example = "jdoe@tricentis.com", description = "Login of the User", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("login")
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.role, user.role) &&
        Objects.equals(this.status, user.status) &&
        Objects.equals(this.workspaces, user.workspaces) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.lastSuccessfulLogin, user.lastSuccessfulLogin) &&
        Objects.equals(this.login, user.login);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, role, status, workspaces, firstName, lastName, lastSuccessfulLogin, login);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    workspaces: ").append(toIndentedString(workspaces)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    lastSuccessfulLogin: ").append(toIndentedString(lastSuccessfulLogin)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
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

