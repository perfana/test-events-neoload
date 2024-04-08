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

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a workspace quota
 */

@Schema(name = "WorkspaceQuota", description = "Represents a workspace quota")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class WorkspaceQuota {

  private BigDecimal sap;

  private BigDecimal web;

  public WorkspaceQuota sap(BigDecimal sap) {
    this.sap = sap;
    return this;
  }

  /**
   * Quota limitation for Sap Vu
   * @return sap
  */
  @Valid 
  @Schema(name = "sap", example = "10.0", description = "Quota limitation for Sap Vu", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sap")
  public BigDecimal getSap() {
    return sap;
  }

  public void setSap(BigDecimal sap) {
    this.sap = sap;
  }

  public WorkspaceQuota web(BigDecimal web) {
    this.web = web;
    return this;
  }

  /**
   * Quota limitation for Web Vu
   * @return web
  */
  @Valid 
  @Schema(name = "web", example = "10.0", description = "Quota limitation for Web Vu", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("web")
  public BigDecimal getWeb() {
    return web;
  }

  public void setWeb(BigDecimal web) {
    this.web = web;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkspaceQuota workspaceQuota = (WorkspaceQuota) o;
    return Objects.equals(this.sap, workspaceQuota.sap) &&
        Objects.equals(this.web, workspaceQuota.web);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sap, web);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkspaceQuota {\n");
    sb.append("    sap: ").append(toIndentedString(sap)).append("\n");
    sb.append("    web: ").append(toIndentedString(web)).append("\n");
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

