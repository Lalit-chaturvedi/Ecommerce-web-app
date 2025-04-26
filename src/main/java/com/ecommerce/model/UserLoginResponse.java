package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import lombok.Data;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * UserLoginResponse
 */

@Setter
@Data
public class UserLoginResponse {

  private @Nullable String token;

  private @Nullable String message;

  public UserLoginResponse token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   */
  
  @Schema(name = "token", example = "User logged in successfully", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

    public UserLoginResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  
  @Schema(name = "message", example = "Login successful", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

    @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserLoginResponse userLoginResponse = (UserLoginResponse) o;
    return Objects.equals(this.token, userLoginResponse.token) &&
        Objects.equals(this.message, userLoginResponse.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserLoginResponse {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

