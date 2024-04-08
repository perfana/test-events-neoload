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
 * Cloud Credits information
 */

@Schema(name = "CloudCredits", description = "Cloud Credits information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class CloudCredits {

  private Double available;

  private Double initial;

  public CloudCredits available(Double available) {
    this.available = available;
    return this;
  }

  /**
   * Number of available Cloud Credits
   * @return available
  */
  
  @Schema(name = "available", example = "13.37", description = "Number of available Cloud Credits", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("available")
  public Double getAvailable() {
    return available;
  }

  public void setAvailable(Double available) {
    this.available = available;
  }

  public CloudCredits initial(Double initial) {
    this.initial = initial;
    return this;
  }

  /**
   * Number of initial Cloud Credits
   * @return initial
  */
  
  @Schema(name = "initial", example = "1337.42", description = "Number of initial Cloud Credits", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("initial")
  public Double getInitial() {
    return initial;
  }

  public void setInitial(Double initial) {
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
    CloudCredits cloudCredits = (CloudCredits) o;
    return Objects.equals(this.available, cloudCredits.available) &&
        Objects.equals(this.initial, cloudCredits.initial);
  }

  @Override
  public int hashCode() {
    return Objects.hash(available, initial);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloudCredits {\n");
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

