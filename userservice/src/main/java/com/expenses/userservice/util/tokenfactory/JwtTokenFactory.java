package com.expenses.userservice.util.tokenfactory;

import com.expenses.userservice.config.ApplicationConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

public class JwtTokenFactory implements  AccessTokenFactory{
    @Override
    public AccessToken tokenFactory() {
      return new JwtAccessToken();
    }
}
