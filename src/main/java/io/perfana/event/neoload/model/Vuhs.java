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

import java.util.Objects;

/**
 * VUHs information
 */

@Schema(name = "Vuhs", description = "VUHs information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Vuhs {

  private Long available;

  private Long initial;

  public Vuhs available(Long available) {
    this.available = available;
    return this;
  }

  /**
   * Number of available VUHs
   * @return available
  */
  
  @Schema(name = "available", example = "42", description = "Number of available VUHs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("available")
  public Long getAvailable() {
    return available;
  }

  public void setAvailable(Long available) {
    this.available = available;
  }

  public Vuhs initial(Long initial) {
    this.initial = initial;
    return this;
  }

  /**
   * Number of initial VUHs
   * @return initial
  */
  
  @Schema(name = "initial", example = "1337", description = "Number of initial VUHs", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("initial")
  public Long getInitial() {
    return initial;
  }

  public void setInitial(Long initial) {
    this.initial = initial;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vuhs vuhs = (Vuhs) o;
    return Objects.equals(this.available, vuhs.available) &&
        Objects.equals(this.initial, vuhs.initial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(available, initial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Vuhs {\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    initial: ").append(toIndentedString(initial)).append("\n");
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

