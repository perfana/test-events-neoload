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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SLA Threshold
 */

@Schema(name = "SlaThreshold", description = "SLA Threshold")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class SlaThreshold {

  private String id;

  @Valid
  private List<@Valid SlaThresholdCondition> conditions = new ArrayList<>();

  /**
   * Family of SLA Threshold
   */
  public enum FamilyEnum {
    RUN("PER_RUN"),
    
    TIME_INTERVAL("PER_TIME_INTERVAL");

    private String value;

    FamilyEnum(String value) {
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
    public static FamilyEnum fromValue(String value) {
      for (FamilyEnum b : FamilyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private FamilyEnum family;

  /**
   * Identifier of SLA Threshold
   */
  public enum IdentifierEnum {
    AVERAGE_REQUEST_RESPONSE_TIME("AVERAGE_REQUEST_RESPONSE_TIME"),
    
    AVERAGE_PAGE_RESPONSE_TIME("AVERAGE_PAGE_RESPONSE_TIME"),
    
    AVERAGE_CONTAINER_RESPONSE_TIME("AVERAGE_CONTAINER_RESPONSE_TIME"),
    
    PERCENTILE_CONTAINER_RESPONSE_TIME("PERCENTILE_CONTAINER_RESPONSE_TIME"),
    
    AVERAGE_HITS_PER_SECOND("AVERAGE_HITS_PER_SECOND"),
    
    AVERAGE_THROUGHPUT_PER_SECOND("AVERAGE_THROUGHPUT_PER_SECOND"),
    
    TOTAL_ERRORS("TOTAL_ERRORS"),
    
    TOTAL_HITS("TOTAL_HITS"),
    
    TOTAL_THROUGHPUT("TOTAL_THROUGHPUT"),
    
    AVERAGE_RESPONSE_TIME("AVERAGE_RESPONSE_TIME"),
    
    ERRORS_PER_SECOND("ERRORS_PER_SECOND"),
    
    ERROR_PERCENTILE("ERROR_PERCENTILE");

    private String value;

    IdentifierEnum(String value) {
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
    public static IdentifierEnum fromValue(String value) {
      for (IdentifierEnum b : IdentifierEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private IdentifierEnum identifier;

  public SlaThreshold() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SlaThreshold(String id, List<@Valid SlaThresholdCondition> conditions, FamilyEnum family, IdentifierEnum identifier) {
    this.id = id;
    this.conditions = conditions;
    this.family = family;
    this.identifier = identifier;
  }

  public SlaThreshold id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of SLA Threshold
   * @return id
  */
  @NotNull 
  @Schema(name = "id", description = "Id of SLA Threshold", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public SlaThreshold conditions(List<@Valid SlaThresholdCondition> conditions) {
    this.conditions = conditions;
    return this;
  }

  public SlaThreshold addConditionsItem(SlaThresholdCondition conditionsItem) {
    if (this.conditions == null) {
      this.conditions = new ArrayList<>();
    }
    this.conditions.add(conditionsItem);
    return this;
  }

  /**
   * Conditions of SLA Threshold
   * @return conditions
  */
  @NotNull @Valid 
  @Schema(name = "conditions", description = "Conditions of SLA Threshold", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("conditions")
  public List<@Valid SlaThresholdCondition> getConditions() {
    return conditions;
  }

  public void setConditions(List<@Valid SlaThresholdCondition> conditions) {
    this.conditions = conditions;
  }

  public SlaThreshold family(FamilyEnum family) {
    this.family = family;
    return this;
  }

  /**
   * Family of SLA Threshold
   * @return family
  */
  @NotNull 
  @Schema(name = "family", description = "Family of SLA Threshold", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("family")
  public FamilyEnum getFamily() {
    return family;
  }

  public void setFamily(FamilyEnum family) {
    this.family = family;
  }

  public SlaThreshold identifier(IdentifierEnum identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * Identifier of SLA Threshold
   * @return identifier
  */
  @NotNull 
  @Schema(name = "identifier", description = "Identifier of SLA Threshold", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("identifier")
  public IdentifierEnum getIdentifier() {
    return identifier;
  }

  public void setIdentifier(IdentifierEnum identifier) {
    this.identifier = identifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SlaThreshold slaThreshold = (SlaThreshold) o;
    return Objects.equals(this.id, slaThreshold.id) &&
        Objects.equals(this.conditions, slaThreshold.conditions) &&
        Objects.equals(this.family, slaThreshold.family) &&
        Objects.equals(this.identifier, slaThreshold.identifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, conditions, family, identifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SlaThreshold {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    family: ").append(toIndentedString(family)).append("\n");
    sb.append("    identifier: ").append(toIndentedString(identifier)).append("\n");
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

