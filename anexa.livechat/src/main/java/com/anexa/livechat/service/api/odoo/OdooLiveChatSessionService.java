package com.anexa.livechat.service.api.odoo;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.anexa.livechat.domain.Session;

public interface OdooLiveChatSessionService {

	@Cacheable(cacheNames = "session", key = "{#channel, #db, #channelPhoneNumber, #contactPhoneNumber}")
	Session getMailSession(int channel, String db, String user, String pwd, String channelPhoneNumber,
			String contactPhoneNumber);

	@CacheEvict(cacheNames = "session", key = "{#channel, #db, #channelPhoneNumber, #contactPhoneNumber}")
	void deleteSession(int channel, String db, String channelPhoneNumber, String contactPhoneNumber);

	@Cacheable(cacheNames = "user", key = "{#db, #user, #pwd}")
	public int getUserId(String db, String user, String pwd);

	Object execute(String db, int uid, String pwd, String model, String method, List<?> args, Map<String, Object> kwargs);
}
