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
 * Request executed partially, the request contains errors
 */

@Schema(name = "PartialError", description = "Request executed partially, the request contains errors")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class PartialError {

  /**
   * Fixed value, it define the schema
   */
  public enum CategoryEnum {
    PARTIAL_ERROR("PARTIAL_ERROR");

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
  private List<@Valid ApiError> errors = new ArrayList<>();

  private Object result;

  public PartialError() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PartialError(CategoryEnum category, String description, List<@Valid ApiError> errors) {
    this.category = category;
    this.description = description;
    this.errors = errors;
  }

  public PartialError category(CategoryEnum category) {
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

  public PartialError description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the error
   * @return description
  */
  @NotNull 
  @Schema(name = "description", example = "Request executed partially, the request contains errors", description = "Description of the error", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PartialError errors(List<@Valid ApiError> errors) {
    this.errors = errors;
    return this;
  }

  public PartialError addErrorsItem(ApiError errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Errors encountered during execution
   * @return errors
  */
  @NotNull @Valid 
  @Schema(name = "errors", description = "Errors encountered during execution", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errors")
  public List<@Valid ApiError> getErrors() {
    return errors;
  }

  public void setErrors(List<@Valid ApiError> errors) {
    this.errors = errors;
  }

  public PartialError result(Object result) {
    this.result = result;
    return this;
  }

  /**
   * Result of the successful part of the request
   * @return result
  */
  
  @Schema(name = "result", description = "Result of the successful part of the request", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("result")
  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PartialError partialError = (PartialError) o;
    return Objects.equals(this.category, partialError.category) &&
        Objects.equals(this.description, partialError.description) &&
        Objects.equals(this.errors, partialError.errors) &&
        Objects.equals(this.result, partialError.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, description, errors, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartialError {\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

