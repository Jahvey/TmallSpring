//package xyz.ivyxjc.security.matcher;
//
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Ehcache;
//import net.sf.ehcache.Element;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.ExcessiveAttemptsException;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.cache.Cache;
//
//import java.util.concurrent.atomic.AtomicInteger;
//
///**
// * <p>User: Zhang Kaitao
// * <p>Date: 14-1-28
// * <p>Version: 1.0
// */
//public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
//
//    private Cache<String, AtomicInteger> passwordRetryCache;
//
//    public RetryLimitHashedCredentialsMatcher(org.apache.shiro.cache.CacheManager cacheManager) {
//        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
//    }
//
//    @Override
//    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//        String username = (String)token.getPrincipal();
//        //retry count + 1
//        AtomicInteger retryCount = passwordRetryCache.get(username);
//        if(retryCount == null) {
//            retryCount = new AtomicInteger(0);
//            passwordRetryCache.put(username, retryCount);
//        }
//        if(retryCount.incrementAndGet() > 5) {
//            //if retry count > 5 throw
//            throw new ExcessiveAttemptsException();
//        }
//
//        boolean matches = super.doCredentialsMatch(token, info);
//        if(matches) {
//            //clear retry count
//            passwordRetryCache.remove(username);
//        }
//        return matches;
//    }
//}
