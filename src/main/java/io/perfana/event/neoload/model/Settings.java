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

import java.util.Objects;

/**
 * Settings
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class Settings {

  /**
   * Return the status of the reservation mode
   */
  public enum ReservationModeStatusEnum {
    ENABLED("RESERVATION_MODE_ENABLED"),
    
    DISABLED("RESERVATION_MODE_DISABLED");

    private String value;

    ReservationModeStatusEnum(String value) {
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
    public static ReservationModeStatusEnum fromValue(String value) {
      for (ReservationModeStatusEnum b : ReservationModeStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ReservationModeStatusEnum reservationModeStatus;

  public Settings reservationModeStatus(ReservationModeStatusEnum reservationModeStatus) {
    this.reservationModeStatus = reservationModeStatus;
    return this;
  }

  /**
   * Return the status of the reservation mode
   * @return reservationModeStatus
  */
  
  @Schema(name = "reservationModeStatus", description = "Return the status of the reservation mode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reservationModeStatus")
  public ReservationModeStatusEnum getReservationModeStatus() {
    return reservationModeStatus;
  }

  public void setReservationModeStatus(ReservationModeStatusEnum reservationModeStatus) {
    this.reservationModeStatus = reservationModeStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Settings settings = (Settings) o;
    return Objects.equals(this.reservationModeStatus, settings.reservationModeStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reservationModeStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Settings {\n");
    sb.append("    reservationModeStatus: ").append(toIndentedString(reservationModeStatus)).append("\n");
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

