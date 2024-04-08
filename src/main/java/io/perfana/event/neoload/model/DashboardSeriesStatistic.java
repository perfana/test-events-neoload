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
 * DashboardSeriesStatistic
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class DashboardSeriesStatistic {

  /**
   * Gets or Sets name
   */
  public enum NameEnum {
    AVGDURATION("avgDuration"),
    
    MINDURATION("minDuration"),
    
    MAXDURATION("maxDuration"),
    
    COUNT("count"),
    
    THROUGHPUT("throughput"),
    
    ELEMENTSPERSECOND("elementsPerSecond"),
    
    ERRORS("errors"),
    
    ERRORSPERSECOND("errorsPerSecond"),
    
    ERRORRATE("errorRate"),
    
    AVGTTFB("avgTtfb"),
    
    MINTTFB("minTtfb"),
    
    MAXTTFB("maxTtfb"),
    
    STEP("step"),
    
    AVERAGE("average"),
    
    PERCENTILES("percentiles");

    private String value;

    NameEnum(String value) {
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
    public static NameEnum fromValue(String value) {
      for (NameEnum b : NameEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private NameEnum name;

  /**
   * A unit for Dashboard Series
   */
  public enum XAxisUnitEnum {
    SECONDS("SECONDS"),
    
    PERCENTAGE("PERCENTAGE"),
    
    ERRORS_PER_SECOND("ERRORS_PER_SECOND"),
    
    ERRORS("ERRORS"),
    
    ELEMENTS("ELEMENTS"),
    
    ELEMENTS_PER_SECOND("ELEMENTS_PER_SECOND"),
    
    BITS_PER_SECOND("BITS_PER_SECOND"),
    
    EMPTY("EMPTY");

    private String value;

    XAxisUnitEnum(String value) {
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
    public static XAxisUnitEnum fromValue(String value) {
      for (XAxisUnitEnum b : XAxisUnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private XAxisUnitEnum xAxisUnit;

  /**
   * A unit for Dashboard Series
   */
  public enum YAxisUnitEnum {
    SECONDS("SECONDS"),
    
    PERCENTAGE("PERCENTAGE"),
    
    ERRORS_PER_SECOND("ERRORS_PER_SECOND"),
    
    ERRORS("ERRORS"),
    
    ELEMENTS("ELEMENTS"),
    
    ELEMENTS_PER_SECOND("ELEMENTS_PER_SECOND"),
    
    BITS_PER_SECOND("BITS_PER_SECOND"),
    
    EMPTY("EMPTY");

    private String value;

    YAxisUnitEnum(String value) {
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
    public static YAxisUnitEnum fromValue(String value) {
      for (YAxisUnitEnum b : YAxisUnitEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private YAxisUnitEnum yAxisUnit;

  public DashboardSeriesStatistic() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DashboardSeriesStatistic(NameEnum name, XAxisUnitEnum xAxisUnit, YAxisUnitEnum yAxisUnit) {
    this.name = name;
    this.xAxisUnit = xAxisUnit;
    this.yAxisUnit = yAxisUnit;
  }

  public DashboardSeriesStatistic name(NameEnum name) {
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
  public NameEnum getName() {
    return name;
  }

  public void setName(NameEnum name) {
    this.name = name;
  }

  public DashboardSeriesStatistic xAxisUnit(XAxisUnitEnum xAxisUnit) {
    this.xAxisUnit = xAxisUnit;
    return this;
  }

  /**
   * A unit for Dashboard Series
   * @return xAxisUnit
  */
  @NotNull 
  @Schema(name = "xAxisUnit", description = "A unit for Dashboard Series", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("xAxisUnit")
  public XAxisUnitEnum getxAxisUnit() {
    return xAxisUnit;
  }

  public void setxAxisUnit(XAxisUnitEnum xAxisUnit) {
    this.xAxisUnit = xAxisUnit;
  }

  public DashboardSeriesStatistic yAxisUnit(YAxisUnitEnum yAxisUnit) {
    this.yAxisUnit = yAxisUnit;
    return this;
  }

  /**
   * A unit for Dashboard Series
   * @return yAxisUnit
  */
  @NotNull 
  @Schema(name = "yAxisUnit", description = "A unit for Dashboard Series", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("yAxisUnit")
  public YAxisUnitEnum getyAxisUnit() {
    return yAxisUnit;
  }

  public void setyAxisUnit(YAxisUnitEnum yAxisUnit) {
    this.yAxisUnit = yAxisUnit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DashboardSeriesStatistic dashboardSeriesStatistic = (DashboardSeriesStatistic) o;
    return Objects.equals(this.name, dashboardSeriesStatistic.name) &&
        Objects.equals(this.xAxisUnit, dashboardSeriesStatistic.xAxisUnit) &&
        Objects.equals(this.yAxisUnit, dashboardSeriesStatistic.yAxisUnit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, xAxisUnit, yAxisUnit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DashboardSeriesStatistic {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    xAxisUnit: ").append(toIndentedString(xAxisUnit)).append("\n");
    sb.append("    yAxisUnit: ").append(toIndentedString(yAxisUnit)).append("\n");
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

