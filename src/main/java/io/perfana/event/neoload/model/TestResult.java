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
import jakarta.validation.constraints.Pattern;

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Test Result
 */

@Schema(name = "TestResult", description = "Test Result")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestResult {

  private String id;

  private String author;

  private Boolean debug;

  private String duration;

  private Integer lgCount;

  private Boolean locked;

  private String name;

  private String project;

  /**
   * Quality Status of the Test Result.
   */
  public enum QualityStatusEnum {
    PASSED("PASSED"),
    
    FAILED("FAILED"),
    
    COMPUTING("COMPUTING"),
    
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

  private String scenario;

  private OffsetDateTime startDate;

  private Boolean startedByNlw;

  /**
   * Status of the Test Result.
   */
  public enum StatusEnum {
    INIT("INIT"),
    
    STARTING("STARTING"),
    
    RUNNING("RUNNING"),
    
    TERMINATED("TERMINATED"),
    
    UNKNOWN("UNKNOWN"),

    PASSED("PASSED"),

    FAILED("FAILED"),

    COMPUTING("COMPUTING");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  /**
   * Reason that caused the test to end.
   */
  public enum TerminationReasonEnum {
    POLICY("POLICY"),
    
    VARIABLE("VARIABLE"),
    
    MANUAL("MANUAL"),
    
    LG_AVAILABILITY("LG_AVAILABILITY"),
    
    LICENSE("LICENSE"),
    
    FAILED_TO_START("FAILED_TO_START"),
    
    CANCELLED("CANCELLED"),
    
    RESERVATION_ENDED("RESERVATION_ENDED"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    TerminationReasonEnum(String value) {
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
    public static TerminationReasonEnum fromValue(String value) {
      for (TerminationReasonEnum b : TerminationReasonEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TerminationReasonEnum terminationReason;

  private Integer vusCount;

  private String workspaceId;

  private String description;

  private OffsetDateTime endDate;

  private Long errors;

  private ExternalUrl externalUrl;

  private Double requestPerSecond;

  private String statisticsSamplingInterval;

  private SimpleTestSettingsDefinition test;

  private Double transactionTime;

  public TestResult() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TestResult(String id, String author, Boolean debug, String duration, Integer lgCount, Boolean locked, String name, String project, QualityStatusEnum qualityStatus, String scenario, OffsetDateTime startDate, Boolean startedByNlw, StatusEnum status, TerminationReasonEnum terminationReason, Integer vusCount, String workspaceId) {
    this.id = id;
    this.author = author;
    this.debug = debug;
    this.duration = duration;
    this.lgCount = lgCount;
    this.locked = locked;
    this.name = name;
    this.project = project;
    this.qualityStatus = qualityStatus;
    this.scenario = scenario;
    this.startDate = startDate;
    this.startedByNlw = startedByNlw;
    this.status = status;
    this.terminationReason = terminationReason;
    this.vusCount = vusCount;
    this.workspaceId = workspaceId;
  }

  public TestResult id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique id of the Test Result.
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426655440000", description = "The unique id of the Test Result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public TestResult author(String author) {
    this.author = author;
    return this;
  }

  /**
   * First and Last name of the person who launched the test.
   * @return author
  */
  @NotNull 
  @Schema(name = "author", example = "John Doe", description = "First and Last name of the person who launched the test.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("author")
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public TestResult debug(Boolean debug) {
    this.debug = debug;
    return this;
  }

  /**
   * Indicates that the Test Result is in debug mode
   * @return debug
  */
  @NotNull 
  @Schema(name = "debug", example = "false", description = "Indicates that the Test Result is in debug mode", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("debug")
  public Boolean getDebug() {
    return debug;
  }

  public void setDebug(Boolean debug) {
    this.debug = debug;
  }

  public TestResult duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Test Result duration (ISO 8601 format). During running, if the result don't have a planned duration, the value is PT0S.
   * @return duration
  */
  @NotNull 
  @Schema(name = "duration", example = "PT25M", description = "Test Result duration (ISO 8601 format). During running, if the result don't have a planned duration, the value is PT0S.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public TestResult lgCount(Integer lgCount) {
    this.lgCount = lgCount;
    return this;
  }

  /**
   * Total number of Load Generators used in the Test Result.
   * @return lgCount
  */
  @NotNull 
  @Schema(name = "lgCount", example = "2", description = "Total number of Load Generators used in the Test Result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("lgCount")
  public Integer getLgCount() {
    return lgCount;
  }

  public void setLgCount(Integer lgCount) {
    this.lgCount = lgCount;
  }

  public TestResult locked(Boolean locked) {
    this.locked = locked;
    return this;
  }

  /**
   * Indicates that the Test Result is protected against automatic deletion.
   * @return locked
  */
  @NotNull 
  @Schema(name = "locked", example = "true", description = "Indicates that the Test Result is protected against automatic deletion.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("locked")
  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public TestResult name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Test Result.
   * @return name
  */
  @NotNull 
  @Schema(name = "name", example = "Trial user paths", description = "Name of the Test Result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TestResult project(String project) {
    this.project = project;
    return this;
  }

  /**
   * Name of the project.
   * @return project
  */
  @NotNull 
  @Schema(name = "project", example = "My Project", description = "Name of the project.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("project")
  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public TestResult qualityStatus(QualityStatusEnum qualityStatus) {
    this.qualityStatus = qualityStatus;
    return this;
  }

  /**
   * Quality Status of the Test Result.
   * @return qualityStatus
  */
  @NotNull 
  @Schema(name = "qualityStatus", example = "PASSED", description = "Quality Status of the Test Result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("qualityStatus")
  public QualityStatusEnum getQualityStatus() {
    return qualityStatus;
  }

  public void setQualityStatus(QualityStatusEnum qualityStatus) {
    this.qualityStatus = qualityStatus;
  }

  public TestResult scenario(String scenario) {
    this.scenario = scenario;
    return this;
  }

  /**
   * Name of the scenario.
   * @return scenario
  */
  @NotNull 
  @Schema(name = "scenario", example = "My Scenario", description = "Name of the scenario.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("scenario")
  public String getScenario() {
    return scenario;
  }

  public void setScenario(String scenario) {
    this.scenario = scenario;
  }

  public TestResult startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Date and time in UTC when the test started.
   * @return startDate
  */
  @NotNull @Valid 
  @Schema(name = "startDate", example = "2021-01-30T08:30Z", description = "Date and time in UTC when the test started.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startDate")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public TestResult startedByNlw(Boolean startedByNlw) {
    this.startedByNlw = startedByNlw;
    return this;
  }

  /**
   * True when the Result has been started from the platform NeoLoad Web or from the NeoLoad CLI. False when it has been started from the Controller GUI or NeoLoadCMD.
   * @return startedByNlw
  */
  @NotNull 
  @Schema(name = "startedByNlw", description = "True when the Result has been started from the platform NeoLoad Web or from the NeoLoad CLI. False when it has been started from the Controller GUI or NeoLoadCMD.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startedByNlw")
  public Boolean getStartedByNlw() {
    return startedByNlw;
  }

  public void setStartedByNlw(Boolean startedByNlw) {
    this.startedByNlw = startedByNlw;
  }

  public TestResult status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the Test Result.
   * @return status
  */
  @NotNull 
  @Schema(name = "status", example = "TERMINATED", description = "Status of the Test Result.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public TestResult terminationReason(TerminationReasonEnum terminationReason) {
    this.terminationReason = terminationReason;
    return this;
  }

  /**
   * Reason that caused the test to end.
   * @return terminationReason
  */
  @NotNull 
  @Schema(name = "terminationReason", example = "POLICY", description = "Reason that caused the test to end.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("terminationReason")
  public TerminationReasonEnum getTerminationReason() {
    return terminationReason;
  }

  public void setTerminationReason(TerminationReasonEnum terminationReason) {
    this.terminationReason = terminationReason;
  }

  public TestResult vusCount(Integer vusCount) {
    this.vusCount = vusCount;
    return this;
  }

  /**
   * Maximum number of VUs required by the scenario when it starts. Default to 0 if unknown.
   * @return vusCount
  */
  @NotNull 
  @Schema(name = "vusCount", example = "50", description = "Maximum number of VUs required by the scenario when it starts. Default to 0 if unknown.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("vusCount")
  public Integer getVusCount() {
    return vusCount;
  }

  public void setVusCount(Integer vusCount) {
    this.vusCount = vusCount;
  }

  public TestResult workspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
    return this;
  }

  /**
   * Unique identifier representing a Workspace.
   * @return workspaceId
  */
  @NotNull @Pattern(regexp = "^[0-9a-f]{24}$") 
  @Schema(name = "workspaceId", example = "69c9a277bb9a473ca3d0d567", description = "Unique identifier representing a Workspace.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("workspaceId")
  public String getWorkspaceId() {
    return workspaceId;
  }

  public void setWorkspaceId(String workspaceId) {
    this.workspaceId = workspaceId;
  }

  public TestResult description(String description) {
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

  public TestResult endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Date and time in UTC when the test stopped. During running, this is the planned end date. It is empty during running when the duration is unknown.
   * @return endDate
  */
  @Valid 
  @Schema(name = "endDate", example = "2021-01-30T08:30Z", description = "Date and time in UTC when the test stopped. During running, this is the planned end date. It is empty during running when the duration is unknown.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endDate")
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public TestResult errors(Long errors) {
    this.errors = errors;
    return this;
  }

  /**
   * Get errors
   * @return errors
  */
  
  @Schema(name = "errors", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errors")
  public Long getErrors() {
    return errors;
  }

  public void setErrors(Long errors) {
    this.errors = errors;
  }

  public TestResult externalUrl(ExternalUrl externalUrl) {
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

  public TestResult requestPerSecond(Double requestPerSecond) {
    this.requestPerSecond = requestPerSecond;
    return this;
  }

  /**
   * Get requestPerSecond
   * @return requestPerSecond
  */
  
  @Schema(name = "requestPerSecond", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestPerSecond")
  public Double getRequestPerSecond() {
    return requestPerSecond;
  }

  public void setRequestPerSecond(Double requestPerSecond) {
    this.requestPerSecond = requestPerSecond;
  }

  public TestResult statisticsSamplingInterval(String statisticsSamplingInterval) {
    this.statisticsSamplingInterval = statisticsSamplingInterval;
    return this;
  }

  /**
   * The pace at which statistics will be updated during runtime (ISO 8601 format).
   * @return statisticsSamplingInterval
  */
  
  @Schema(name = "statisticsSamplingInterval", example = "PT1S", description = "The pace at which statistics will be updated during runtime (ISO 8601 format).", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("statisticsSamplingInterval")
  public String getStatisticsSamplingInterval() {
    return statisticsSamplingInterval;
  }

  public void setStatisticsSamplingInterval(String statisticsSamplingInterval) {
    this.statisticsSamplingInterval = statisticsSamplingInterval;
  }

  public TestResult test(SimpleTestSettingsDefinition test) {
    this.test = test;
    return this;
  }

  /**
   * Get test
   * @return test
  */
  @Valid 
  @Schema(name = "test", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("test")
  public SimpleTestSettingsDefinition getTest() {
    return test;
  }

  public void setTest(SimpleTestSettingsDefinition test) {
    this.test = test;
  }

  public TestResult transactionTime(Double transactionTime) {
    this.transactionTime = transactionTime;
    return this;
  }

  /**
   * Get transactionTime
   * @return transactionTime
  */
  
  @Schema(name = "transactionTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transactionTime")
  public Double getTransactionTime() {
    return transactionTime;
  }

  public void setTransactionTime(Double transactionTime) {
    this.transactionTime = transactionTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestResult testResult = (TestResult) o;
    return Objects.equals(this.id, testResult.id) &&
        Objects.equals(this.author, testResult.author) &&
        Objects.equals(this.debug, testResult.debug) &&
        Objects.equals(this.duration, testResult.duration) &&
        Objects.equals(this.lgCount, testResult.lgCount) &&
        Objects.equals(this.locked, testResult.locked) &&
        Objects.equals(this.name, testResult.name) &&
        Objects.equals(this.project, testResult.project) &&
        Objects.equals(this.qualityStatus, testResult.qualityStatus) &&
        Objects.equals(this.scenario, testResult.scenario) &&
        Objects.equals(this.startDate, testResult.startDate) &&
        Objects.equals(this.startedByNlw, testResult.startedByNlw) &&
        Objects.equals(this.status, testResult.status) &&
        Objects.equals(this.terminationReason, testResult.terminationReason) &&
        Objects.equals(this.vusCount, testResult.vusCount) &&
        Objects.equals(this.workspaceId, testResult.workspaceId) &&
        Objects.equals(this.description, testResult.description) &&
        Objects.equals(this.endDate, testResult.endDate) &&
        Objects.equals(this.errors, testResult.errors) &&
        Objects.equals(this.externalUrl, testResult.externalUrl) &&
        Objects.equals(this.requestPerSecond, testResult.requestPerSecond) &&
        Objects.equals(this.statisticsSamplingInterval, testResult.statisticsSamplingInterval) &&
        Objects.equals(this.test, testResult.test) &&
        Objects.equals(this.transactionTime, testResult.transactionTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, author, debug, duration, lgCount, locked, name, project, qualityStatus, scenario, startDate, startedByNlw, status, terminationReason, vusCount, workspaceId, description, endDate, errors, externalUrl, requestPerSecond, statisticsSamplingInterval, test, transactionTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestResult {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("    debug: ").append(toIndentedString(debug)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    lgCount: ").append(toIndentedString(lgCount)).append("\n");
    sb.append("    locked: ").append(toIndentedString(locked)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    qualityStatus: ").append(toIndentedString(qualityStatus)).append("\n");
    sb.append("    scenario: ").append(toIndentedString(scenario)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    startedByNlw: ").append(toIndentedString(startedByNlw)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    terminationReason: ").append(toIndentedString(terminationReason)).append("\n");
    sb.append("    vusCount: ").append(toIndentedString(vusCount)).append("\n");
    sb.append("    workspaceId: ").append(toIndentedString(workspaceId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    externalUrl: ").append(toIndentedString(externalUrl)).append("\n");
    sb.append("    requestPerSecond: ").append(toIndentedString(requestPerSecond)).append("\n");
    sb.append("    statisticsSamplingInterval: ").append(toIndentedString(statisticsSamplingInterval)).append("\n");
    sb.append("    test: ").append(toIndentedString(test)).append("\n");
    sb.append("    transactionTime: ").append(toIndentedString(transactionTime)).append("\n");
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

