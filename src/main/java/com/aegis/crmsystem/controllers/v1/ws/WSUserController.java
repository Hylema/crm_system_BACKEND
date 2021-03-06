package com.aegis.crmsystem.controllers.v1.ws;

import com.aegis.crmsystem.Auth;
import com.aegis.crmsystem.constants.SwaggerConst;
import com.aegis.crmsystem.domain.Views;
import com.aegis.crmsystem.dto.role.RoleDto;
import com.aegis.crmsystem.dto.role.RoleDtoWithFk;
import com.aegis.crmsystem.models.User;
import com.aegis.crmsystem.servies.RoleService;
import com.aegis.crmsystem.servies.UsersService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@Validated
public class WSUserController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private UsersService userService;

    @Autowired
    private RoleService roleService;

    @JsonView({Views.Message.class})
    @ApiOperation(value = SwaggerConst.User.ALL_USERS)

    @MessageMapping("/getAllUser")
    public void getAllUsers() {
        List<User> listUsers = userService.findAll();

        simpMessagingTemplate.convertAndSendToUser(
                Auth.jwtUser.getUser().getEmail(),
                "/usr/getAll",
                listUsers
        );
    }

    @ApiOperation(value = SwaggerConst.User.ALL_ROLE)
    public List<RoleDto> getAllRoles() {
        return roleService.findAll();
    }

    @ApiOperation(value = SwaggerConst.User.ALL_USERS_BY_ROLE)
    public RoleDtoWithFk getAllUsersByRole() {
        return roleService.getById(1L);
    }
}
