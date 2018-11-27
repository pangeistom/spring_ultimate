package com.ctrip.service.Cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.ctrip.entity.bo.User;
import org.springframework.stereotype.Component;

@Component
public class LocalCacheManager {

    @CreateCache(expire = 100, cacheType = CacheType.LOCAL, localLimit = 500)
    private Cache<String, User> userCache;

    public void setUserCache(String key, User userinfo) {
        userCache.put(key, userinfo);
    }

    public User getUserCache(String key) {
        return userCache.get(key);
    }
}
