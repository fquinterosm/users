package com.bci.users.domain.port.output.user;

public interface GetJWTToken {

    public String execute(String email);
}
