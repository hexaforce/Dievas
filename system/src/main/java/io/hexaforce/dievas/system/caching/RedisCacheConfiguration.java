package io.hexaforce.dievas.system.caching;

import java.lang.reflect.Method;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.lang.Nullable;

/**
 * @author T.Tantaka
 *
 */
@Configuration
@EnableCaching
public class RedisCacheConfiguration extends CachingConfigurerSupport {

	@Bean
	public CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer() {
	    return new CacheManagerCustomizer<ConcurrentMapCacheManager>() {
	        @Override
	        public void customize(ConcurrentMapCacheManager cacheManager) {
	            cacheManager.setAllowNullValues(false);
	        }
	    };
	}
	
	@Override
	@Nullable
	public CacheManager cacheManager() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		
		RedisCacheManager cacheManager = RedisCacheManager.create(factory);

		cacheManager.initializeCaches();
		return cacheManager;
	}

	@Override
	@Nullable
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... params) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(target.getClass().getName());
				stringBuilder.append(method.getName());
				for (Object object : params) {
					stringBuilder.append(object.toString());
				}
				return stringBuilder.toString();
			}
		};
	}

	@Override
	@Nullable
	public CacheResolver cacheResolver() {
		return null;
	}

	@Override
	@Nullable
	public CacheErrorHandler errorHandler() {
		return new SimpleCacheErrorHandler() {
			@Override
			public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {

			}
		};
	}
	
}