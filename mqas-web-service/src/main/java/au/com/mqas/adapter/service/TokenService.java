package au.com.mqas.adapter.service;

import au.com.mqas.db.data.model.Token;
import au.com.mqas.db.data.model.UserInfo;

public interface TokenService<T extends Token> {

    T createToken(UserInfo userInfo);

    T verifyToken(String token);

}
