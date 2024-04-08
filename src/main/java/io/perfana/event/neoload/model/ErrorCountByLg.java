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
 * Number of errors for a Load Generator
 */

@Schema(name = "ErrorCountByLg", description = "Number of errors for a Load Generator")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ErrorCountByLg {

  private Long count;

  private String lg;

  public ErrorCountByLg() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ErrorCountByLg(Long count, String lg) {
    this.count = count;
    this.lg = lg;
  }

  public ErrorCountByLg count(Long count) {
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

  public ErrorCountByLg lg(String lg) {
    this.lg = lg;
    return this;
  }

  /**
   * Load Generator on which the error was encountered
   * @return lg
  */
  @NotNull 
  @Schema(name = "lg", example = "Lg", description = "Load Generator on which the error was encountered", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lg")
  public String getLg() {
    return lg;
  }

  public void setLg(String lg) {
    this.lg = lg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorCountByLg errorCountByLg = (ErrorCountByLg) o;
    return Objects.equals(this.count, errorCountByLg.count) &&
        Objects.equals(this.lg, errorCountByLg.lg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count, lg);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorCountByLg {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    lg: ").append(toIndentedString(lg)).append("\n");
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

