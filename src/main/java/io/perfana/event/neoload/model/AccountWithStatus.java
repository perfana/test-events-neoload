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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * Represents an Account with its current initialization status.
 */

@Schema(name = "AccountWithStatus", description = "Represents an Account with its current initialization status.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class AccountWithStatus {

  private String id;

  /**
   * Initialization status of this account
   */
  public enum InitializationStatusEnum {
    INITIALIZING("INITIALIZING"),
    
    INITIALIZED("INITIALIZED"),
    
    ERROR("ERROR");

    private String value;

    InitializationStatusEnum(String value) {
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
    public static InitializationStatusEnum fromValue(String value) {
      for (InitializationStatusEnum b : InitializationStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private InitializationStatusEnum initializationStatus;

  private String name;

  public AccountWithStatus() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AccountWithStatus(String id, InitializationStatusEnum initializationStatus, String name) {
    this.id = id;
    this.initializationStatus = initializationStatus;
    this.name = name;
  }

  public AccountWithStatus id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the Account
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "id", example = "69c9a277bb9a473ca3d0d567", description = "ID of the Account", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AccountWithStatus initializationStatus(InitializationStatusEnum initializationStatus) {
    this.initializationStatus = initializationStatus;
    return this;
  }

  /**
   * Initialization status of this account
   * @return initializationStatus
  */
  @NotNull 
  @Schema(name = "initializationStatus", description = "Initialization status of this account", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("initializationStatus")
  public InitializationStatusEnum getInitializationStatus() {
    return initializationStatus;
  }

  public void setInitializationStatus(InitializationStatusEnum initializationStatus) {
    this.initializationStatus = initializationStatus;
  }

  public AccountWithStatus name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Account
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "My account", description = "Name of the Account", requiredMode = Schema.RequiredMode.REQUIRED)
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
    AccountWithStatus accountWithStatus = (AccountWithStatus) o;
    return Objects.equals(this.id, accountWithStatus.id) &&
        Objects.equals(this.initializationStatus, accountWithStatus.initializationStatus) &&
        Objects.equals(this.name, accountWithStatus.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, initializationStatus, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountWithStatus {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    initializationStatus: ").append(toIndentedString(initializationStatus)).append("\n");
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

