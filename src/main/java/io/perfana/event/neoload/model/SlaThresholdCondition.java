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

import java.util.Objects;

/**
 * SLA Threshold condition
 */

@Schema(name = "SlaThresholdCondition", description = "SLA Threshold condition")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class SlaThresholdCondition {

  /**
   * SLA Threshold operator
   */
  public enum OperatorEnum {
    LESS_THAN("LESS_THAN"),
    
    GREATER_THAN("GREATER_THAN"),
    
    EQUALS("EQUALS"),
    
    BETWEEN("BETWEEN");

    private String value;

    OperatorEnum(String value) {
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
    public static OperatorEnum fromValue(String value) {
      for (OperatorEnum b : OperatorEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private OperatorEnum operator;

  /**
   * SLA Threshold severity
   */
  public enum SeverityEnum {
    WARNING("WARNING"),
    
    CRITICAL("CRITICAL");

    private String value;

    SeverityEnum(String value) {
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
    public static SeverityEnum fromValue(String value) {
      for (SeverityEnum b : SeverityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private SeverityEnum severity;

  private Double max;

  private Double min;

  public SlaThresholdCondition() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SlaThresholdCondition(OperatorEnum operator, SeverityEnum severity) {
    this.operator = operator;
    this.severity = severity;
  }

  public SlaThresholdCondition operator(OperatorEnum operator) {
    this.operator = operator;
    return this;
  }

  /**
   * SLA Threshold operator
   * @return operator
  */
  @NotNull 
  @Schema(name = "operator", description = "SLA Threshold operator", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("operator")
  public OperatorEnum getOperator() {
    return operator;
  }

  public void setOperator(OperatorEnum operator) {
    this.operator = operator;
  }

  public SlaThresholdCondition severity(SeverityEnum severity) {
    this.severity = severity;
    return this;
  }

  /**
   * SLA Threshold severity
   * @return severity
  */
  @NotNull 
  @Schema(name = "severity", description = "SLA Threshold severity", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("severity")
  public SeverityEnum getSeverity() {
    return severity;
  }

  public void setSeverity(SeverityEnum severity) {
    this.severity = severity;
  }

  public SlaThresholdCondition max(Double max) {
    this.max = max;
    return this;
  }

  /**
   * SLA Threshold max
   * @return max
  */
  
  @Schema(name = "max", description = "SLA Threshold max", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("max")
  public Double getMax() {
    return max;
  }

  public void setMax(Double max) {
    this.max = max;
  }

  public SlaThresholdCondition min(Double min) {
    this.min = min;
    return this;
  }

  /**
   * SLA Threshold min
   * @return min
  */
  
  @Schema(name = "min", description = "SLA Threshold min", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("min")
  public Double getMin() {
    return min;
  }

  public void setMin(Double min) {
    this.min = min;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SlaThresholdCondition slaThresholdCondition = (SlaThresholdCondition) o;
    return Objects.equals(this.operator, slaThresholdCondition.operator) &&
        Objects.equals(this.severity, slaThresholdCondition.severity) &&
        Objects.equals(this.max, slaThresholdCondition.max) &&
        Objects.equals(this.min, slaThresholdCondition.min);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operator, severity, max, min);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SlaThresholdCondition {\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    max: ").append(toIndentedString(max)).append("\n");
    sb.append("    min: ").append(toIndentedString(min)).append("\n");
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

