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

import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * One line of result log
 */

@Schema(name = "ResultLogEntry", description = "One line of result log")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class ResultLogEntry {

  private OffsetDateTime date;

  /**
   * Level of log.
   */
  public enum LevelEnum {
    INFO("INFO"),
    
    ERROR("ERROR");

    private String value;

    LevelEnum(String value) {
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
    public static LevelEnum fromValue(String value) {
      for (LevelEnum b : LevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private LevelEnum level;

  private String line;

  public ResultLogEntry() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ResultLogEntry(OffsetDateTime date, LevelEnum level, String line) {
    this.date = date;
    this.level = level;
    this.line = line;
  }

  public ResultLogEntry date(OffsetDateTime date) {
    this.date = date;
    return this;
  }

  /**
   * Date and time in UTC when this log occurs.
   * @return date
  */
  @NotNull @Valid 
  @Schema(name = "date", example = "2021-01-30T08:30Z", description = "Date and time in UTC when this log occurs.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
  public OffsetDateTime getDate() {
    return date;
  }

  public void setDate(OffsetDateTime date) {
    this.date = date;
  }

  public ResultLogEntry level(LevelEnum level) {
    this.level = level;
    return this;
  }

  /**
   * Level of log.
   * @return level
  */
  @NotNull 
  @Schema(name = "level", description = "Level of log.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("level")
  public LevelEnum getLevel() {
    return level;
  }

  public void setLevel(LevelEnum level) {
    this.level = level;
  }

  public ResultLogEntry line(String line) {
    this.line = line;
    return this;
  }

  /**
   * Text of the log line.
   * @return line
  */
  @NotNull 
  @Schema(name = "line", example = "Lock controller c0e9f2cf5e43", description = "Text of the log line.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("line")
  public String getLine() {
    return line;
  }

  public void setLine(String line) {
    this.line = line;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultLogEntry resultLogEntry = (ResultLogEntry) o;
    return Objects.equals(this.date, resultLogEntry.date) &&
        Objects.equals(this.level, resultLogEntry.level) &&
        Objects.equals(this.line, resultLogEntry.line);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, level, line);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResultLogEntry {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    level: ").append(toIndentedString(level)).append("\n");
    sb.append("    line: ").append(toIndentedString(line)).append("\n");
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

