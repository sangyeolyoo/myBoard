package com.example.demo.cookie;

import javax.servlet.http.Cookie;

public class CookieHandler {

	//쿠기 생성
	public Cookie setCookie(int idx) throws Exception {
		Cookie newCookie = new Cookie("cookie" + idx, "|" + idx + "|");
		newCookie.setMaxAge(60 * 60 * 24);
		newCookie.setPath("/");

		return newCookie;
	}
	
	//쿠키 확인
	public boolean isCookie(int idx, Cookie[] receiveCookies) throws Exception {
		Cookie[] cookies = receiveCookies;
		boolean flag = false;
		
		for (Cookie cook : cookies) {
			if (cook.getName().equals("cookie" + idx)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	//쿠키 삭제
	public Cookie[] delete(Cookie[] receiveCookies) throws Exception {
		Cookie[] cookies = receiveCookies;
		if( cookies != null ){
			for( Cookie cook : cookies) {
				cook.setMaxAge(0);
			}
		}
		return cookies;
	}
}
