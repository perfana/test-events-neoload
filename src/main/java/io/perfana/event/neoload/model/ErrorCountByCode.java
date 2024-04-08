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

import java.util.Objects;

/**
 * Number of errors with a specific error code
 */

@Schema(name = "ErrorCountByCode", description = "Number of errors with a specific error code")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ErrorCountByCode {

  private String code;

  private Long count;

  public ErrorCountByCode() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorCountByCode(String code, Long count) {
    this.code = code;
    this.count = count;
  }

  public ErrorCountByCode code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Error code
   * @return code
  */
  @NotNull 
  @Schema(name = "code", example = "error code", description = "Error code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ErrorCountByCode count(Long count) {
    this.count = count;
    return this;
  }

  /**
   * Number of errors
   * @return count
  */
  @NotNull 
  @Schema(name = "count", example = "1", description = "Number of errors", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("count")
  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorCountByCode errorCountByCode = (ErrorCountByCode) o;
    return Objects.equals(this.code, errorCountByCode.code) &&
        Objects.equals(this.count, errorCountByCode.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorCountByCode {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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

