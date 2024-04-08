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

import java.math.BigDecimal;
import java.util.Objects;

/**
 * An item with its values. It can be a ACTION, PAGE, REQUEST, or TRANSACTION. Percentiles are available only for transactions.
 */

@Schema(name = "ResultElementValue", description = "An item with its values. It can be a ACTION, PAGE, REQUEST, or TRANSACTION. Percentiles are available only for transactions.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ResultElementValue {

  private String id;

  private String name;

  private BigDecimal avgDuration;

  private BigDecimal avgTtfb;

  private BigDecimal count;

  private BigDecimal elementsPerSecond;

  private BigDecimal errorRate;

  private BigDecimal errors;

  private BigDecimal maxDuration;

  private BigDecimal maxTtfb;

  private BigDecimal minDuration;

  private BigDecimal minTtfb;

  private String parent;

  private BigDecimal perc50;

  private BigDecimal perc90;

  private BigDecimal perc95;

  private BigDecimal perc99;

  /**
   * SLA status of the item if this item has SLA.
   */
  public enum SlaStatusEnum {
    SUCCESS("SUCCESS"),
    
    WARN("WARN"),
    
    FAILED("FAILED");

    private String value;

    SlaStatusEnum(String value) {
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
    public static SlaStatusEnum fromValue(String value) {
      for (SlaStatusEnum b : SlaStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private SlaStatusEnum slaStatus;

  private String userPath;

  public ResultElementValue() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ResultElementValue(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public ResultElementValue id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier.
   * @return id
  */
  @NotNull @Pattern(regexp = "^[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}$") 
  @Schema(name = "id", example = "123e4567-e89b-12d3-a456-426655440000", description = "Unique identifier.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ResultElementValue name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResultElementValue avgDuration(BigDecimal avgDuration) {
    this.avgDuration = avgDuration;
    return this;
  }

  /**
   * Average response time, in seconds.
   * @return avgDuration
  */
  @Valid 
  @Schema(name = "avgDuration", example = "2.5587938931297707", description = "Average response time, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avgDuration")
  public BigDecimal getAvgDuration() {
    return avgDuration;
  }

  public void setAvgDuration(BigDecimal avgDuration) {
    this.avgDuration = avgDuration;
  }

  public ResultElementValue avgTtfb(BigDecimal avgTtfb) {
    this.avgTtfb = avgTtfb;
    return this;
  }

  /**
   * Average time to first byte, in seconds.
   * @return avgTtfb
  */
  @Valid 
  @Schema(name = "avgTtfb", example = "0.3832290076335878", description = "Average time to first byte, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("avgTtfb")
  public BigDecimal getAvgTtfb() {
    return avgTtfb;
  }

  public void setAvgTtfb(BigDecimal avgTtfb) {
    this.avgTtfb = avgTtfb;
  }

  public ResultElementValue count(BigDecimal count) {
    this.count = count;
    return this;
  }

  /**
   * Count statistics are the number of full executions of an element of a User Path. If the element is interrupted (because of error or end of test), then the count number is not incremented.
   * @return count
  */
  @Valid 
  @Schema(name = "count", example = "7890", description = "Count statistics are the number of full executions of an element of a User Path. If the element is interrupted (because of error or end of test), then the count number is not incremented.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("count")
  public BigDecimal getCount() {
    return count;
  }

  public void setCount(BigDecimal count) {
    this.count = count;
  }

  public ResultElementValue elementsPerSecond(BigDecimal elementsPerSecond) {
    this.elementsPerSecond = elementsPerSecond;
    return this;
  }

  /**
   * Average number of iterations of the element per second.
   * @return elementsPerSecond
  */
  @Valid 
  @Schema(name = "elementsPerSecond", example = "0.22", description = "Average number of iterations of the element per second.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("elementsPerSecond")
  public BigDecimal getElementsPerSecond() {
    return elementsPerSecond;
  }

  public void setElementsPerSecond(BigDecimal elementsPerSecond) {
    this.elementsPerSecond = elementsPerSecond;
  }

  public ResultElementValue errorRate(BigDecimal errorRate) {
    this.errorRate = errorRate;
    return this;
  }

  /**
   * Percentage of failed iterations out of count.
   * @return errorRate
  */
  @Valid 
  @Schema(name = "errorRate", example = "0.0", description = "Percentage of failed iterations out of count.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorRate")
  public BigDecimal getErrorRate() {
    return errorRate;
  }

  public void setErrorRate(BigDecimal errorRate) {
    this.errorRate = errorRate;
  }

  public ResultElementValue errors(BigDecimal errors) {
    this.errors = errors;
    return this;
  }

  /**
   * Count of failed iterations.
   * @return errors
  */
  @Valid 
  @Schema(name = "errors", example = "0", description = "Count of failed iterations.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errors")
  public BigDecimal getErrors() {
    return errors;
  }

  public void setErrors(BigDecimal errors) {
    this.errors = errors;
  }

  public ResultElementValue maxDuration(BigDecimal maxDuration) {
    this.maxDuration = maxDuration;
    return this;
  }

  /**
   * Maximum response time, in seconds.
   * @return maxDuration
  */
  @Valid 
  @Schema(name = "maxDuration", example = "21.107", description = "Maximum response time, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxDuration")
  public BigDecimal getMaxDuration() {
    return maxDuration;
  }

  public void setMaxDuration(BigDecimal maxDuration) {
    this.maxDuration = maxDuration;
  }

  public ResultElementValue maxTtfb(BigDecimal maxTtfb) {
    this.maxTtfb = maxTtfb;
    return this;
  }

  /**
   * Maximum time to first byte, in seconds.
   * @return maxTtfb
  */
  @Valid 
  @Schema(name = "maxTtfb", example = "15.617", description = "Maximum time to first byte, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maxTtfb")
  public BigDecimal getMaxTtfb() {
    return maxTtfb;
  }

  public void setMaxTtfb(BigDecimal maxTtfb) {
    this.maxTtfb = maxTtfb;
  }

  public ResultElementValue minDuration(BigDecimal minDuration) {
    this.minDuration = minDuration;
    return this;
  }

  /**
   * Minimum response time, in seconds.
   * @return minDuration
  */
  @Valid 
  @Schema(name = "minDuration", example = "1.289", description = "Minimum response time, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minDuration")
  public BigDecimal getMinDuration() {
    return minDuration;
  }

  public void setMinDuration(BigDecimal minDuration) {
    this.minDuration = minDuration;
  }

  public ResultElementValue minTtfb(BigDecimal minTtfb) {
    this.minTtfb = minTtfb;
    return this;
  }

  /**
   * Minimum time to first byte, in seconds.
   * @return minTtfb
  */
  @Valid 
  @Schema(name = "minTtfb", example = "0.1", description = "Minimum time to first byte, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("minTtfb")
  public BigDecimal getMinTtfb() {
    return minTtfb;
  }

  public void setMinTtfb(BigDecimal minTtfb) {
    this.minTtfb = minTtfb;
  }

  public ResultElementValue parent(String parent) {
    this.parent = parent;
    return this;
  }

  /**
   * Parent element of the item.
   * @return parent
  */
  
  @Schema(name = "parent", example = "my parent element", description = "Parent element of the item.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("parent")
  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public ResultElementValue perc50(BigDecimal perc50) {
    this.perc50 = perc50;
    return this;
  }

  /**
   * 50th percentile of the transaction duration, in seconds.
   * @return perc50
  */
  @Valid 
  @Schema(name = "perc50", example = "1.4815", description = "50th percentile of the transaction duration, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("perc50")
  public BigDecimal getPerc50() {
    return perc50;
  }

  public void setPerc50(BigDecimal perc50) {
    this.perc50 = perc50;
  }

  public ResultElementValue perc90(BigDecimal perc90) {
    this.perc90 = perc90;
    return this;
  }

  /**
   * 90th percentile of the transaction duration, in seconds.
   * @return perc90
  */
  @Valid 
  @Schema(name = "perc90", example = "6.57", description = "90th percentile of the transaction duration, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("perc90")
  public BigDecimal getPerc90() {
    return perc90;
  }

  public void setPerc90(BigDecimal perc90) {
    this.perc90 = perc90;
  }

  public ResultElementValue perc95(BigDecimal perc95) {
    this.perc95 = perc95;
    return this;
  }

  /**
   * 95th percentile of the transaction duration, in seconds.
   * @return perc95
  */
  @Valid 
  @Schema(name = "perc95", example = "8.781", description = "95th percentile of the transaction duration, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("perc95")
  public BigDecimal getPerc95() {
    return perc95;
  }

  public void setPerc95(BigDecimal perc95) {
    this.perc95 = perc95;
  }

  public ResultElementValue perc99(BigDecimal perc99) {
    this.perc99 = perc99;
    return this;
  }

  /**
   * 99th percentile of the transaction duration, in seconds.
   * @return perc99
  */
  @Valid 
  @Schema(name = "perc99", example = "17.005", description = "99th percentile of the transaction duration, in seconds.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("perc99")
  public BigDecimal getPerc99() {
    return perc99;
  }

  public void setPerc99(BigDecimal perc99) {
    this.perc99 = perc99;
  }

  public ResultElementValue slaStatus(SlaStatusEnum slaStatus) {
    this.slaStatus = slaStatus;
    return this;
  }

  /**
   * SLA status of the item if this item has SLA.
   * @return slaStatus
  */
  
  @Schema(name = "slaStatus", description = "SLA status of the item if this item has SLA.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("slaStatus")
  public SlaStatusEnum getSlaStatus() {
    return slaStatus;
  }

  public void setSlaStatus(SlaStatusEnum slaStatus) {
    this.slaStatus = slaStatus;
  }

  public ResultElementValue userPath(String userPath) {
    this.userPath = userPath;
    return this;
  }

  /**
   * The name of the user path in which the item is.
   * @return userPath
  */
  
  @Schema(name = "userPath", example = "my userpath", description = "The name of the user path in which the item is.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userPath")
  public String getUserPath() {
    return userPath;
  }

  public void setUserPath(String userPath) {
    this.userPath = userPath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultElementValue resultElementValue = (ResultElementValue) o;
    return Objects.equals(this.id, resultElementValue.id) &&
        Objects.equals(this.name, resultElementValue.name) &&
        Objects.equals(this.avgDuration, resultElementValue.avgDuration) &&
        Objects.equals(this.avgTtfb, resultElementValue.avgTtfb) &&
        Objects.equals(this.count, resultElementValue.count) &&
        Objects.equals(this.elementsPerSecond, resultElementValue.elementsPerSecond) &&
        Objects.equals(this.errorRate, resultElementValue.errorRate) &&
        Objects.equals(this.errors, resultElementValue.errors) &&
        Objects.equals(this.maxDuration, resultElementValue.maxDuration) &&
        Objects.equals(this.maxTtfb, resultElementValue.maxTtfb) &&
        Objects.equals(this.minDuration, resultElementValue.minDuration) &&
        Objects.equals(this.minTtfb, resultElementValue.minTtfb) &&
        Objects.equals(this.parent, resultElementValue.parent) &&
        Objects.equals(this.perc50, resultElementValue.perc50) &&
        Objects.equals(this.perc90, resultElementValue.perc90) &&
        Objects.equals(this.perc95, resultElementValue.perc95) &&
        Objects.equals(this.perc99, resultElementValue.perc99) &&
        Objects.equals(this.slaStatus, resultElementValue.slaStatus) &&
        Objects.equals(this.userPath, resultElementValue.userPath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, avgDuration, avgTtfb, count, elementsPerSecond, errorRate, errors, maxDuration, maxTtfb, minDuration, minTtfb, parent, perc50, perc90, perc95, perc99, slaStatus, userPath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultElementValue {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    avgDuration: ").append(toIndentedString(avgDuration)).append("\n");
    sb.append("    avgTtfb: ").append(toIndentedString(avgTtfb)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    elementsPerSecond: ").append(toIndentedString(elementsPerSecond)).append("\n");
    sb.append("    errorRate: ").append(toIndentedString(errorRate)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
    sb.append("    maxDuration: ").append(toIndentedString(maxDuration)).append("\n");
    sb.append("    maxTtfb: ").append(toIndentedString(maxTtfb)).append("\n");
    sb.append("    minDuration: ").append(toIndentedString(minDuration)).append("\n");
    sb.append("    minTtfb: ").append(toIndentedString(minTtfb)).append("\n");
    sb.append("    parent: ").append(toIndentedString(parent)).append("\n");
    sb.append("    perc50: ").append(toIndentedString(perc50)).append("\n");
    sb.append("    perc90: ").append(toIndentedString(perc90)).append("\n");
    sb.append("    perc95: ").append(toIndentedString(perc95)).append("\n");
    sb.append("    perc99: ").append(toIndentedString(perc99)).append("\n");
    sb.append("    slaStatus: ").append(toIndentedString(slaStatus)).append("\n");
    sb.append("    userPath: ").append(toIndentedString(userPath)).append("\n");
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

