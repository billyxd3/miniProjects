package com.itacademy.softserve.util;

import com.itacademy.softserve.dto.UserDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionManager {
    public void createSession(UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("userDto", userDto);
        Cookie cookie = new Cookie("id_session", session.getId());
        response.addCookie(cookie);
    }

    public boolean isActiveSession(HttpServletRequest request) {
        boolean isActive = true;
        HttpSession session = request.getSession(false);
        Cookie idSessionCookie = null;
        if ((request != null) && (request.getCookies() != null)) {
            for (Cookie currentCookie : request.getCookies()) {
                if (currentCookie.getName().equals("id_session")) {
                    idSessionCookie = currentCookie;
                    break;
                }
            }
        }
        isActive = isActive && (session != null)
                && (session.getAttribute("userDto") != null)
                && (((UserDto) (session.getAttribute("userDto"))).getName() != null)
                && (idSessionCookie != null);
        isActive = isActive
                && (idSessionCookie.getValue().equals(session.getId()));

        return isActive;
    }

    public void destroySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
    }
}
