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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Given property value is invalid
 */

@Schema(name = "InvalidPropertyValueError", description = "Given property value is invalid")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class InvalidPropertyValueError implements DashboardSeriesTileResourcePost400Response, SubscriptionResourceGet400Response, TestExecutionResourceCreate400Response {

  /**
   * Fixed value, it define the schema
   */
  public enum CategoryEnum {
    INVALID_PROPERTY_VALUE("INVALID_PROPERTY_VALUE");

    private String value;

    CategoryEnum(String value) {
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
    public static CategoryEnum fromValue(String value) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private CategoryEnum category;

  private String description;

  @Valid
  private List<@Valid InvalidPropertyValueErrorDescription> errors = new ArrayList<>();

  public InvalidPropertyValueError() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public InvalidPropertyValueError(CategoryEnum category, String description, List<@Valid InvalidPropertyValueErrorDescription> errors) {
    this.category = category;
    this.description = description;
    this.errors = errors;
  }

  public InvalidPropertyValueError category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * Fixed value, it define the schema
   * @return category
  */
  @NotNull 
  @Schema(name = "category", description = "Fixed value, it define the schema", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("category")
  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public InvalidPropertyValueError description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the error
   * @return description
  */
  @NotNull 
  @Schema(name = "description", example = "Given property value is invalid", description = "Description of the error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public InvalidPropertyValueError errors(List<@Valid InvalidPropertyValueErrorDescription> errors) {
    this.errors = errors;
    return this;
  }

  public InvalidPropertyValueError addErrorsItem(InvalidPropertyValueErrorDescription errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Validation errors
   * @return errors
  */
  @NotNull @Valid 
  @Schema(name = "errors", description = "Validation errors", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errors")
  public List<@Valid InvalidPropertyValueErrorDescription> getErrors() {
    return errors;
  }

  public void setErrors(List<@Valid InvalidPropertyValueErrorDescription> errors) {
    this.errors = errors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvalidPropertyValueError invalidPropertyValueError = (InvalidPropertyValueError) o;
    return Objects.equals(this.category, invalidPropertyValueError.category) &&
        Objects.equals(this.description, invalidPropertyValueError.description) &&
        Objects.equals(this.errors, invalidPropertyValueError.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, description, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvalidPropertyValueError {\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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

