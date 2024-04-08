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
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * Field available to create a test execution
 */

@Schema(name = "TestExecutionInput", description = "Field available to create a test execution")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestExecutionInput {

  private String testId;

  private String description;

  private String duration;

  private String name;

  private String reservationId;

  private Integer sapVu;

  private Integer webVu;

  public TestExecutionInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TestExecutionInput(String testId) {
    this.testId = testId;
  }

  public TestExecutionInput testId(String testId) {
    this.testId = testId;
    return this;
  }

  /**
   * Test setting id which will be used to configure the test execution
   * @return testId
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "testId", example = "123e4567-e89b-12d3-a456-426655440000", description = "Test setting id which will be used to configure the test execution", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("testId")
  public String getTestId() {
    return testId;
  }

  public void setTestId(String testId) {
    this.testId = testId;
  }

  public TestExecutionInput description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Test execution description
   * @return description
  */
  
  @Schema(name = "description", example = "Test with standard load capacity", description = "Test execution description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TestExecutionInput duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Test duration
   * @return duration
  */
  
  @Schema(name = "duration", example = "PT25M", description = "Test duration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public TestExecutionInput name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Test execution name
   * @return name
  */
  
  @Schema(name = "name", example = "Trial user paths #1", description = "Test execution name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TestExecutionInput reservationId(String reservationId) {
    this.reservationId = reservationId;
    return this;
  }

  /**
   * Requested Reservation ID
   * @return reservationId
  */
  @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$")
  @Schema(name = "reservationId", example = "123e4567-e89b-12d3-a456-426655440000", description = "Requested Reservation ID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reservationId")
  public String getReservationId() {
    return reservationId;
  }

  public void setReservationId(String reservationId) {
    this.reservationId = reservationId;
  }

  public TestExecutionInput sapVu(Integer sapVu) {
    this.sapVu = sapVu;
    return this;
  }

  /**
   * Requested SAP VU count
   * @return sapVu
  */
  
  @Schema(name = "sapVu", example = "100", description = "Requested SAP VU count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sapVu")
  public Integer getSapVu() {
    return sapVu;
  }

  public void setSapVu(Integer sapVu) {
    this.sapVu = sapVu;
  }

  public TestExecutionInput webVu(Integer webVu) {
    this.webVu = webVu;
    return this;
  }

  /**
   * Requested Web VU count
   * @return webVu
  */
  
  @Schema(name = "webVu", example = "100", description = "Requested Web VU count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("webVu")
  public Integer getWebVu() {
    return webVu;
  }

  public void setWebVu(Integer webVu) {
    this.webVu = webVu;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestExecutionInput testExecutionInput = (TestExecutionInput) o;
    return Objects.equals(this.testId, testExecutionInput.testId) &&
        Objects.equals(this.description, testExecutionInput.description) &&
        Objects.equals(this.duration, testExecutionInput.duration) &&
        Objects.equals(this.name, testExecutionInput.name) &&
        Objects.equals(this.reservationId, testExecutionInput.reservationId) &&
        Objects.equals(this.sapVu, testExecutionInput.sapVu) &&
        Objects.equals(this.webVu, testExecutionInput.webVu);
  }

  @Override
  public int hashCode() {
     return Objects.hash(testId, description, duration, name, reservationId, sapVu, webVu);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestExecutionInput {\n");
    sb.append("    testId: ").append(toIndentedString(testId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    reservationId: ").append(toIndentedString(reservationId)).append("\n");
    sb.append("    sapVu: ").append(toIndentedString(sapVu)).append("\n");
    sb.append("    webVu: ").append(toIndentedString(webVu)).append("\n");
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

