package com.exam.lk_17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LK_1797 {

    public static void main(String[] args) {
        // 输入 输出构造过于麻烦  直接提交代码进行验证

    }

    class AuthenticationManager {

        private int  timeToLive;

        private Map<String, Integer> cache;

        public AuthenticationManager(int timeToLive) {
            this.timeToLive = timeToLive;
            this.cache = new HashMap<>();
        }

        public void generate(String tokenId, int currentTime) {
            cache.put(tokenId, currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            expire(currentTime);
            if (cache.get(tokenId) != null) {
                cache.put(tokenId, currentTime);
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            expire(currentTime);
            Set<String> set = cache.keySet();
            return cache.size();
        }

        private void expire(int currentTime) {
            Iterator<String> iterator = cache.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Integer i = cache.get(key);
                if (i != null && i + timeToLive <= currentTime) {
                    iterator.remove();
                    cache.remove(key);
                }
            }
        }
    }
}
