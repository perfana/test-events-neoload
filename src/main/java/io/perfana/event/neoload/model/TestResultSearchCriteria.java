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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.*;

/**
 * Test Result search criteria
 */

@Schema(name = "TestResultSearchCriteria", description = "Test Result search criteria")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-04-06T15:29:22.895694+02:00[Europe/Amsterdam]", comments = "Generator version: 7.4.0")
public class TestResultSearchCriteria {

  @Valid
  private Set<String> projects = new LinkedHashSet<>();

  @Valid
  private List<@Valid SimpleTestSettingsDefinition> tests = new ArrayList<>();

  public TestResultSearchCriteria() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TestResultSearchCriteria(Set<String> projects, List<@Valid SimpleTestSettingsDefinition> tests) {
    this.projects = projects;
    this.tests = tests;
  }

  public TestResultSearchCriteria projects(Set<String> projects) {
    this.projects = projects;
    return this;
  }

  public TestResultSearchCriteria addProjectsItem(String projectsItem) {
    if (this.projects == null) {
      this.projects = new LinkedHashSet<>();
    }
    this.projects.add(projectsItem);
    return this;
  }

  /**
   * The list of project names attached to Test Results that belong to the specified workspace.
   * @return projects
  */
  @NotNull 
  @Schema(name = "projects", description = "The list of project names attached to Test Results that belong to the specified workspace.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("projects")
  public Set<String> getProjects() {
    return projects;
  }

  @JsonDeserialize(as = LinkedHashSet.class)
  public void setProjects(Set<String> projects) {
    this.projects = projects;
  }

  public TestResultSearchCriteria tests(List<@Valid SimpleTestSettingsDefinition> tests) {
    this.tests = tests;
    return this;
  }

  public TestResultSearchCriteria addTestsItem(SimpleTestSettingsDefinition testsItem) {
    if (this.tests == null) {
      this.tests = new ArrayList<>();
    }
    this.tests.add(testsItem);
    return this;
  }

  /**
   * The list of tests attached to Test Results that belong to the specified workspace.
   * @return tests
  */
  @NotNull @Valid 
  @Schema(name = "tests", description = "The list of tests attached to Test Results that belong to the specified workspace.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("tests")
  public List<@Valid SimpleTestSettingsDefinition> getTests() {
    return tests;
  }

  public void setTests(List<@Valid SimpleTestSettingsDefinition> tests) {
    this.tests = tests;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestResultSearchCriteria testResultSearchCriteria = (TestResultSearchCriteria) o;
    return Objects.equals(this.projects, testResultSearchCriteria.projects) &&
        Objects.equals(this.tests, testResultSearchCriteria.tests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projects, tests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestResultSearchCriteria {\n");
    sb.append("    projects: ").append(toIndentedString(projects)).append("\n");
    sb.append("    tests: ").append(toIndentedString(tests)).append("\n");
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

