/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.bci.users.api;

import com.bci.users.api.model.ApiErrorResponse;
import com.bci.users.api.model.ApiUserRequest;
import com.bci.users.api.model.ApiUserResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "user", description = "the user API")
@RequestMapping(value = "")
public interface UserApi {

    @ApiOperation(value = "delete an user", nickname = "deleteUserById", notes = "use an id to delete an user", response = ApiUserResponse.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ApiUserResponse.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "user not found"),
        @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/user/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.DELETE)
    ResponseEntity<ApiUserResponse> deleteUserById(@ApiParam(value = "",required=true) @PathVariable("id") UUID id);


    @ApiOperation(value = "get an user", nickname = "getUserById", notes = "use an id to get an user", response = ApiUserResponse.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ApiUserResponse.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "user not found"),
        @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/user/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<ApiUserResponse> getUserById(@ApiParam(value = "",required=true) @PathVariable("id") UUID id);


    @ApiOperation(value = "save an user", nickname = "postUser", notes = "Save an user", response = ApiUserResponse.class, tags={ "user", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "A successful status", response = ApiUserResponse.class),
        @ApiResponse(code = 500, message = "Response with error.", response = ApiErrorResponse.class) })
    @RequestMapping(value = "/user",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ApiUserResponse> postUser(@ApiParam(value = "user to save."  )  @Valid @RequestBody ApiUserRequest user);

}
