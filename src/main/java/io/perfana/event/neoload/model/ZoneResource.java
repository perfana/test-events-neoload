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

import java.util.Objects;

/**
 * This object can represent a Controller or a Load Generator
 */

@Schema(name = "ZoneResource", description = "This object can represent a Controller or a Load Generator")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ZoneResource {

  private String name;

  /**
   * Status of the resource
   */
  public enum StatusEnum {
    AVAILABLE("AVAILABLE"),
    
    RESERVED("RESERVED"),
    
    BUSY("BUSY");

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

  private String version;

  public ZoneResource() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ZoneResource(String name, StatusEnum status, String version) {
    this.name = name;
    this.status = status;
    this.version = version;
  }

  public ZoneResource name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the controller or address of the load generator
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "resource.domain.com:7100", description = "Name of the controller or address of the load generator", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ZoneResource status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the resource
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "AVAILABLE", description = "Status of the resource", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ZoneResource version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Version of the resource
   * @return version
  */
  @NotNull 
  @Schema(name = "version", example = "2023.3.1", description = "Version of the resource", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ZoneResource zoneResource = (ZoneResource) o;
    return Objects.equals(this.name, zoneResource.name) &&
        Objects.equals(this.status, zoneResource.status) &&
        Objects.equals(this.version, zoneResource.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, status, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZoneResource {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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

