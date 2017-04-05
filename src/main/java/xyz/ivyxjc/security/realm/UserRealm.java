package xyz.ivyxjc.security.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import xyz.ivyxjc.bean.User;
import xyz.ivyxjc.service.UserService;

import java.sql.Connection;

/**
 * Created by jc on 4/3/2017.
 */

@ComponentScan("xyz.ivyxjc.service.impl")
public class UserRealm extends JdbcRealm {

    @Autowired
    private UserService mUserService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        AuthenticationInfo info = null;

        User user =mUserService.get(username);
        String password=user.getPassword();
        if (password == null) {
            throw new UnknownAccountException("No account found for user [" + username + "]");
        }

        SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(
                username,
                password,
                ByteSource.Util.bytes(user.getCredentialSalt()),
                getName());

        saInfo.setCredentialsSalt(ByteSource.Util.bytes(username));

        info = saInfo;



        return info;
    }
}
