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
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * Test Result mutable fields
 */

@Schema(name = "TestResultInput", description = "Test Result mutable fields")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestResultInput {

  private String description;

  private ExternalUrl externalUrl;

  private Boolean locked;

  private String name;

  /**
   * Quality Status of the Test Result.
   */
  public enum QualityStatusEnum {
    PASSED("PASSED"),
    
    FAILED("FAILED"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    QualityStatusEnum(String value) {
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
    public static QualityStatusEnum fromValue(String value) {
      for (QualityStatusEnum b : QualityStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private QualityStatusEnum qualityStatus;

  private String testId;

  private String workspaceId;

  public TestResultInput description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description of the Test Result.
   * @return description
  */
  
  @Schema(name = "description", example = "Load test on common trial user usage", description = "Description of the Test Result.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TestResultInput externalUrl(ExternalUrl externalUrl) {
    this.externalUrl = externalUrl;
    return this;
  }

  /**
   * Get externalUrl
   * @return externalUrl
  */
  @Valid 
  @Schema(name = "externalUrl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("externalUrl")
  public ExternalUrl getExternalUrl() {
    return externalUrl;
  }

  public void setExternalUrl(ExternalUrl externalUrl) {
    this.externalUrl = externalUrl;
  }

  public TestResultInput locked(Boolean locked) {
    this.locked = locked;
    return this;
  }

  /**
   * Locks a Test Result (avoid automatic deletion).
   * @return locked
  */
  
  @Schema(name = "locked", example = "true", description = "Locks a Test Result (avoid automatic deletion).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("locked")
  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public TestResultInput name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Test Result.
   * @return name
  */
  @Pattern(regexp = "^\\S.*$") 
  @Schema(name = "name", example = "Trial user paths", description = "Name of the Test Result.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TestResultInput qualityStatus(QualityStatusEnum qualityStatus) {
    this.qualityStatus = qualityStatus;
    return this;
  }

  /**
   * Quality Status of the Test Result.
   * @return qualityStatus
  */
  
  @Schema(name = "qualityStatus", example = "PASSED", description = "Quality Status of the Test Result.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("qualityStatus")
  public QualityStatusEnum getQualityStatus() {
    return qualityStatus;
  }

  public void setQualityStatus(QualityStatusEnum qualityStatus) {
    this.qualityStatus = qualityStatus;
  }

  public TestResultInput testId(String testId) {
    this.testId = testId;
    return this;
  }

  /**
   * Unique identifier of the test.
   * @return testId
  */
  
  @Schema(name = "testId", example = "5ed5350f-9f2f-4e2a-9acb-cdbcee874256", description = "Unique identifier of the test.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("testId")
  public String getTestId() {
    return testId;
  }

  public void setTestId(String testId) {
    this.testId = testId;
  }

  public TestResultInput workspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

  /**
   * Unique identifier representing a Workspace.
   * @return workspaceId
  */
  @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "workspaceId", example = "69c9a277bb9a473ca3d0d567", description = "Unique identifier representing a Workspace.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("workspaceId")
  public String getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestResultInput testResultInput = (TestResultInput) o;
    return Objects.equals(this.description, testResultInput.description) &&
        Objects.equals(this.externalUrl, testResultInput.externalUrl) &&
        Objects.equals(this.locked, testResultInput.locked) &&
        Objects.equals(this.name, testResultInput.name) &&
        Objects.equals(this.qualityStatus, testResultInput.qualityStatus) &&
        Objects.equals(this.testId, testResultInput.testId) &&
        Objects.equals(this.workspaceId, testResultInput.workspaceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, externalUrl, locked, name, qualityStatus, testId, workspaceId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestResultInput {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    externalUrl: ").append(toIndentedString(externalUrl)).append("\n");
    sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    qualityStatus: ").append(toIndentedString(qualityStatus)).append("\n");
    sb.append("    testId: ").append(toIndentedString(testId)).append("\n");
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
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

