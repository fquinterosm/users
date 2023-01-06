package com.bci.users.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

/**
 * ApiUserResponse
 */
@Validated




public class ApiUserResponse   {
  @JsonProperty("id")
  private UUID id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("phones")
  @Valid
  private List<ApiPhones> phones = null;

  @JsonProperty("created")
  private String created = null;

  @JsonProperty("modified")
  private String modified = null;

  @JsonProperty("last_login")
  private String lastLogin = null;

  @JsonProperty("token")
  private String token = null;

  @JsonProperty("isactive")
  private Boolean isactive = null;

  public ApiUserResponse id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  @Valid

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public ApiUserResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Francisco Quinteros", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ApiUserResponse email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public ApiUserResponse password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  @ApiModelProperty(example = "adsad#2342.2", value = "")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public ApiUserResponse phones(List<ApiPhones> phones) {
    this.phones = phones;
    return this;
  }

  public ApiUserResponse addPhonesItem(ApiPhones phonesItem) {
    if (this.phones == null) {
      this.phones = new ArrayList<ApiPhones>();
    }
    this.phones.add(phonesItem);
    return this;
  }

  /**
   * Get phones
   * @return phones
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ApiPhones> getPhones() {
    return phones;
  }

  public void setPhones(List<ApiPhones> phones) {
    this.phones = phones;
  }

  public ApiUserResponse created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  **/
  @ApiModelProperty(example = "2023-01-03T20:41:19.101+0000", value = "")


  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public ApiUserResponse modified(String modified) {
    this.modified = modified;
    return this;
  }

  /**
   * Get modified
   * @return modified
  **/
  @ApiModelProperty(example = "2023-01-03T20:41:19.101+0000", value = "")


  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }

  public ApiUserResponse lastLogin(String lastLogin) {
    this.lastLogin = lastLogin;
    return this;
  }

  /**
   * Get lastLogin
   * @return lastLogin
  **/
  @ApiModelProperty(example = "2023-01-03T20:41:19.101+0000", value = "")


  public String getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(String lastLogin) {
    this.lastLogin = lastLogin;
  }

  public ApiUserResponse token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
  **/
  @ApiModelProperty(example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c", value = "")


  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public ApiUserResponse isactive(Boolean isactive) {
    this.isactive = isactive;
    return this;
  }

  /**
   * Get isactive
   * @return isactive
  **/
  @ApiModelProperty(example = "true", value = "")


  public Boolean isIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiUserResponse apiUserResponse = (ApiUserResponse) o;
    return Objects.equals(this.id, apiUserResponse.id) &&
        Objects.equals(this.name, apiUserResponse.name) &&
        Objects.equals(this.email, apiUserResponse.email) &&
        Objects.equals(this.password, apiUserResponse.password) &&
        Objects.equals(this.phones, apiUserResponse.phones) &&
        Objects.equals(this.created, apiUserResponse.created) &&
        Objects.equals(this.modified, apiUserResponse.modified) &&
        Objects.equals(this.lastLogin, apiUserResponse.lastLogin) &&
        Objects.equals(this.token, apiUserResponse.token) &&
        Objects.equals(this.isactive, apiUserResponse.isactive);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, password, phones, created, modified, lastLogin, token, isactive);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiUserResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    phones: ").append(toIndentedString(phones)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
    sb.append("    lastLogin: ").append(toIndentedString(lastLogin)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    isactive: ").append(toIndentedString(isactive)).append("\n");
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

