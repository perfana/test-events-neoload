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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

/**
 * Test execution
 */

@Schema(name = "GetTestExecutionResponse", description = "Test execution")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class GetTestExecutionResponse {

  private String id;

  /**
   * Workflow status of the test execution
   */
  public enum StepEnum {
    INITIALIZING("INITIALIZING"),
    
    PREPARING_CONTROLLER("PREPARING_CONTROLLER"),
    
    FAILED_TO_PREPARE_CONTROLLER("FAILED_TO_PREPARE_CONTROLLER"),
    
    PREPARING_LGS("PREPARING_LGS"),
    
    FAILED_TO_PREPARE_LGS("FAILED_TO_PREPARE_LGS"),
    
    SENDING_PROJECT("SENDING_PROJECT"),
    
    FAILED("FAILED"),
    
    PREPARING_TEST("PREPARING_TEST"),
    
    STARTING_TEST("STARTING_TEST"),
    
    STARTED_TEST("STARTED_TEST"),
    
    CANCELLED("CANCELLED");

    private String value;

    StepEnum(String value) {
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
    public static StepEnum fromValue(String value) {
      for (StepEnum b : StepEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StepEnum step;

  public GetTestExecutionResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetTestExecutionResponse(String id) {
    this.id = id;
  }

  public GetTestExecutionResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the test execution, it is the same id which will be used for the test results
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426655440000", description = "ID of the test execution, it is the same id which will be used for the test results", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GetTestExecutionResponse step(StepEnum step) {
    this.step = step;
    return this;
  }

  /**
   * Workflow status of the test execution
   * @return step
  */
  
  @Schema(name = "step", description = "Workflow status of the test execution", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("step")
  public StepEnum getStep() {
    return step;
  }

  public void setStep(StepEnum step) {
    this.step = step;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetTestExecutionResponse getTestExecutionResponse = (GetTestExecutionResponse) o;
    return Objects.equals(this.id, getTestExecutionResponse.id) &&
        Objects.equals(this.step, getTestExecutionResponse.step);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, step);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetTestExecutionResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    step: ").append(toIndentedString(step)).append("\n");
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

