package com.bci.users.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * ApiUsersResponse
 */
@Validated




public class ApiUsersResponse   {
  @JsonProperty("users")
  @Valid
  private List<ApiUserResponse> users = null;

  public ApiUsersResponse users(List<ApiUserResponse> users) {
    this.users = users;
    return this;
  }

  public ApiUsersResponse addUsersItem(ApiUserResponse usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<ApiUserResponse>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ApiUserResponse> getUsers() {
    return users;
  }

  public void setUsers(List<ApiUserResponse> users) {
    this.users = users;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiUsersResponse apiUsersResponse = (ApiUsersResponse) o;
    return Objects.equals(this.users, apiUsersResponse.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiUsersResponse {\n");
    
    sb.append("    users: ").append(toIndentedString(users)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

