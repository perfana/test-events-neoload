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
 * Represents a user workspace.
 */

@Schema(name = "UserWorkspace", description = "Represents a user workspace.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class UserWorkspace {

  private String id;

  private Boolean enabledForAllUsers;

  private String name;

  public UserWorkspace() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UserWorkspace(String id, Boolean enabledForAllUsers, String name) {
    this.id = id;
    this.enabledForAllUsers = enabledForAllUsers;
    this.name = name;
  }

  public UserWorkspace id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the Workspace
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "id", example = "69c9a277bb9a473ca3d0d567", description = "ID of the Workspace", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserWorkspace enabledForAllUsers(Boolean enabledForAllUsers) {
    this.enabledForAllUsers = enabledForAllUsers;
    return this;
  }

  /**
   * Is workspace enabled for all users
   * @return enabledForAllUsers
  */
  @NotNull 
  @Schema(name = "enabledForAllUsers", example = "false", description = "Is workspace enabled for all users", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("enabledForAllUsers")
  public Boolean getEnabledForAllUsers() {
    return enabledForAllUsers;
  }

  public void setEnabledForAllUsers(Boolean enabledForAllUsers) {
    this.enabledForAllUsers = enabledForAllUsers;
  }

  public UserWorkspace name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Workspace
   * @return name
  */
  @NotNull 
  @Schema(name = "name", description = "Name of the Workspace", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserWorkspace userWorkspace = (UserWorkspace) o;
    return Objects.equals(this.id, userWorkspace.id) &&
        Objects.equals(this.enabledForAllUsers, userWorkspace.enabledForAllUsers) &&
        Objects.equals(this.name, userWorkspace.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, enabledForAllUsers, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserWorkspace {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    enabledForAllUsers: ").append(toIndentedString(enabledForAllUsers)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

