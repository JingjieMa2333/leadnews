package com.heima.model.user.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginDto {
    @ApiModelProperty(value = "phone number",required = true)
    private String phone;
    @ApiModelProperty(value = "password",required = true)
    private String password;
}
