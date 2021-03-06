package com.aegis.crmsystem.controllers.v1.http;

import com.aegis.crmsystem.constants.SwaggerConst;
import com.aegis.crmsystem.dto.request.users.CreateUserDto;
import com.aegis.crmsystem.dto.request.users.DeleteUserDto;
import com.aegis.crmsystem.dto.request.users.PatchUserDto;
import com.aegis.crmsystem.dto.request.users.PutUserDto;
import com.aegis.crmsystem.models.User;
import com.aegis.crmsystem.servies.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@Validated
@RequestMapping("api/v1/admin")
@Api(tags= SwaggerConst.Admin.API_TITLE)
public class AdminController {
    @Autowired
    private UsersService userService;

    @PostMapping("user/create")
    @ApiOperation(value = SwaggerConst.Admin.CREATE_USER)
    public User createUser(@RequestBody CreateUserDto createUserDto) {
        return userService.create(createUserDto);
    }

    @DeleteMapping("user/{id}")
    @ApiOperation(value = SwaggerConst.Admin.DELETE_USER)
    public User deleteUser(@RequestBody DeleteUserDto deleteUserDto) {
        return userService.delete(deleteUserDto);
    }

    @PutMapping("user/{id}")
    @ApiOperation(value = SwaggerConst.Admin.UPDATE_USER)
    public User updateUser(@RequestBody PutUserDto patchUserDto) {
        return userService.put(patchUserDto);
    }

    @PatchMapping("user/{id}")
    @ApiOperation(value = SwaggerConst.Admin.UPDATE_USER)
    public User patchUser(@RequestBody PatchUserDto patchUserDto) {
        return userService.patch(patchUserDto);
    }
}
