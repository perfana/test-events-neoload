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

import java.util.Objects;

/**
 * Represents Workspace available fields modifications.
 */

@Schema(name = "WorkspacePatchInput", description = "Represents Workspace available fields modifications.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class WorkspacePatchInput {

  private WorkspaceQuota quota;

  private Boolean quotaLimitEnabled;

  public WorkspacePatchInput quota(WorkspaceQuota quota) {
    this.quota = quota;
    return this;
  }

  /**
   * Get quota
   * @return quota
  */
  @Valid 
  @Schema(name = "quota", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quota")
  public WorkspaceQuota getQuota() {
    return quota;
  }

  public void setQuota(WorkspaceQuota quota) {
    this.quota = quota;
  }

  public WorkspacePatchInput quotaLimitEnabled(Boolean quotaLimitEnabled) {
    this.quotaLimitEnabled = quotaLimitEnabled;
    return this;
  }

  /**
   * Is quota limitation enabled
   * @return quotaLimitEnabled
  */
  
  @Schema(name = "quotaLimitEnabled", example = "true", description = "Is quota limitation enabled", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quotaLimitEnabled")
  public Boolean getQuotaLimitEnabled() {
    return quotaLimitEnabled;
  }

  public void setQuotaLimitEnabled(Boolean quotaLimitEnabled) {
    this.quotaLimitEnabled = quotaLimitEnabled;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkspacePatchInput workspacePatchInput = (WorkspacePatchInput) o;
    return Objects.equals(this.quota, workspacePatchInput.quota) &&
        Objects.equals(this.quotaLimitEnabled, workspacePatchInput.quotaLimitEnabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quota, quotaLimitEnabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkspacePatchInput {\n");
    sb.append("    quota: ").append(toIndentedString(quota)).append("\n");
    sb.append("    quotaLimitEnabled: ").append(toIndentedString(quotaLimitEnabled)).append("\n");
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

