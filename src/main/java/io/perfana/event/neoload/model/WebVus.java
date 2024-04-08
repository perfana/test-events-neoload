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
 * Web VU information
 */

@Schema(name = "WebVus", description = "Web VU information")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class WebVus {

  private Long available;

  private Long licenseMaximum;

  private Long workspaceMaximum;

  public WebVus available(Long available) {
    this.available = available;
    return this;
  }

  /**
   * Currency available
   * @return available
  */
  
  @Schema(name = "available", example = "42", description = "Currency available", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("available")
  public Long getAvailable() {
    return available;
  }

  public void setAvailable(Long available) {
    this.available = available;
  }

  public WebVus licenseMaximum(Long licenseMaximum) {
    this.licenseMaximum = licenseMaximum;
    return this;
  }

  /**
   * Maximum currency available in the license
   * @return licenseMaximum
  */
  
  @Schema(name = "licenseMaximum", example = "1337", description = "Maximum currency available in the license", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("licenseMaximum")
  public Long getLicenseMaximum() {
    return licenseMaximum;
  }

  public void setLicenseMaximum(Long licenseMaximum) {
    this.licenseMaximum = licenseMaximum;
  }

  public WebVus workspaceMaximum(Long workspaceMaximum) {
    this.workspaceMaximum = workspaceMaximum;
    return this;
  }

  /**
   * Maximum currency available in the workspace
   * @return workspaceMaximum
  */
  
  @Schema(name = "workspaceMaximum", example = "1337", description = "Maximum currency available in the workspace", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("workspaceMaximum")
  public Long getWorkspaceMaximum() {
    return workspaceMaximum;
  }

  public void setWorkspaceMaximum(Long workspaceMaximum) {
    this.workspaceMaximum = workspaceMaximum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WebVus webVus = (WebVus) o;
    return Objects.equals(this.available, webVus.available) &&
        Objects.equals(this.licenseMaximum, webVus.licenseMaximum) &&
        Objects.equals(this.workspaceMaximum, webVus.workspaceMaximum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(available, licenseMaximum, workspaceMaximum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WebVus {\n");
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    licenseMaximum: ").append(toIndentedString(licenseMaximum)).append("\n");
    sb.append("    workspaceMaximum: ").append(toIndentedString(workspaceMaximum)).append("\n");
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

