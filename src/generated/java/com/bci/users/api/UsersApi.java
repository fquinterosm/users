/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.bci.users.api;

import com.bci.users.api.model.ApiErrorResponse;
import com.bci.users.api.model.ApiUsersResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "users", description = "the users API")
@RequestMapping(value = "")
public interface UsersApi {

    @ApiOperation(value = "get users", nickname = "getUsers", notes = "Returns all users", response = ApiUsersResponse.class, tags={ "users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "A list of users.", response = ApiUsersResponse.class),
        @ApiResponse(code = 500, message = "Response with error.", response = ApiErrorResponse.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<ApiUsersResponse> getUsers();

}
