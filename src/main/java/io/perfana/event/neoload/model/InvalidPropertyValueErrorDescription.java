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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given property value is invalid
 */

@Schema(name = "InvalidPropertyValueErrorDescription", description = "Given property value is invalid")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class InvalidPropertyValueErrorDescription {

  private String message;

  @Valid
  private Map<String, String> messageProperties = new HashMap<>();

  private String validationType;

  public InvalidPropertyValueErrorDescription() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InvalidPropertyValueErrorDescription(String message, Map<String, String> messageProperties, String validationType) {
    this.message = message;
    this.messageProperties = messageProperties;
    this.validationType = validationType;
  }

  public InvalidPropertyValueErrorDescription message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Message describing the validation issue
   * @return message
  */
  @NotNull 
  @Schema(name = "message", example = "Property \"name\" is required", description = "Message describing the validation issue", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public InvalidPropertyValueErrorDescription messageProperties(Map<String, String> messageProperties) {
    this.messageProperties = messageProperties;
    return this;
  }

  public InvalidPropertyValueErrorDescription putMessagePropertiesItem(String key, String messagePropertiesItem) {
    if (this.messageProperties == null) {
      this.messageProperties = new HashMap<>();
    }
    this.messageProperties.put(key, messagePropertiesItem);
    return this;
  }

  /**
   * Dynamic values used in the message
   * @return messageProperties
  */
  @NotNull 
  @Schema(name = "messageProperties", description = "Dynamic values used in the message", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("messageProperties")
  public Map<String, String> getMessageProperties() {
    return messageProperties;
  }

  public void setMessageProperties(Map<String, String> messageProperties) {
    this.messageProperties = messageProperties;
  }

  public InvalidPropertyValueErrorDescription validationType(String validationType) {
    this.validationType = validationType;
    return this;
  }

  /**
   * Validation type
   * @return validationType
  */
  @NotNull 
  @Schema(name = "validationType", example = "required", description = "Validation type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("validationType")
  public String getValidationType() {
    return validationType;
  }

  public void setValidationType(String validationType) {
    this.validationType = validationType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvalidPropertyValueErrorDescription invalidPropertyValueErrorDescription = (InvalidPropertyValueErrorDescription) o;
    return Objects.equals(this.message, invalidPropertyValueErrorDescription.message) &&
        Objects.equals(this.messageProperties, invalidPropertyValueErrorDescription.messageProperties) &&
        Objects.equals(this.validationType, invalidPropertyValueErrorDescription.validationType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, messageProperties, validationType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvalidPropertyValueErrorDescription {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    messageProperties: ").append(toIndentedString(messageProperties)).append("\n");
    sb.append("    validationType: ").append(toIndentedString(validationType)).append("\n");
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

