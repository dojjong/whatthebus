package what.the.bus.driver.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import what.the.bus.driver.service.LogoutDriverService;

@Service
public class LogoutDriverServiceImpl implements LogoutDriverService {
	@Override
	public void logoutDriver(HttpSession session) {
		session.invalidate();
	}

}
