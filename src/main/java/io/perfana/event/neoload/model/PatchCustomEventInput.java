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

import java.util.Objects;

/**
 * Custom Event mutable fields
 */

@Schema(name = "PatchCustomEventInput", description = "Custom Event mutable fields")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class PatchCustomEventInput implements PatchEventInput {

  /**
   * Type of the Event
   */
  public enum TypeEnum {
    CUSTOM("CUSTOM");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TypeEnum type;

  private CustomEventDetails details;

  private String endOffset;

  public PatchCustomEventInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PatchCustomEventInput(TypeEnum type) {
    this.type = type;
  }

  public PatchCustomEventInput type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the Event
   * @return type
  */
  @NotNull 
  @Schema(name = "type", description = "Type of the Event", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return String.valueOf(type);
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public PatchCustomEventInput details(CustomEventDetails details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
  */
  @Valid 
  @Schema(name = "details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("details")
  public CustomEventDetails getDetails() {
    return details;
  }

  public void setDetails(CustomEventDetails details) {
    this.details = details;
  }

  public PatchCustomEventInput endOffset(String endOffset) {
    this.endOffset = endOffset;
    return this;
  }

  /**
   * The offset (ISO 8601 format) of the Event from the beginning of the Result
   * @return endOffset
  */
  
  @Schema(name = "endOffset", example = "PT1M23S", description = "The offset (ISO 8601 format) of the Event from the beginning of the Result", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endOffset")
  public String getEndOffset() {
    return endOffset;
  }

  public void setEndOffset(String endOffset) {
    this.endOffset = endOffset;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PatchCustomEventInput patchCustomEventInput = (PatchCustomEventInput) o;
    return Objects.equals(this.type, patchCustomEventInput.type) &&
        Objects.equals(this.details, patchCustomEventInput.details) &&
        Objects.equals(this.endOffset, patchCustomEventInput.endOffset);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, details, endOffset);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PatchCustomEventInput {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    endOffset: ").append(toIndentedString(endOffset)).append("\n");
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

