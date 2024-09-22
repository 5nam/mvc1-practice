package hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * http://localhost:8080/response-header
 */

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // [status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        // 캐시 무효화
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");

        resp.setHeader("my-header", " hello"); // 사용자 정의 헤더 추가

        // [Header 편의 메서드]
        content(resp);
        cookie(resp);
        redirect(resp);

        // [message body]
        PrintWriter writer = resp.getWriter();
        writer.println("ok");
    }

    // redirect 편의 메서드
    private void redirect(HttpServletResponse resp) throws IOException {
        //Status Code 302
        //Location: /basic/hello-form.html

        //response.setStatus(HttpServletResponse.SC_FOUND); 302
        //response.setHeader("Location", "/basic/hello-form.html");
        resp.sendRedirect("/basic/hello-form.html");
    }

    // 쿠키 편의 메서드
    private void cookie(HttpServletResponse resp) {
        //Set-Cookie : myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

    // Content 편의 메서드
    private void content(HttpServletResponse resp) {
        //Content-Type : text/plain;charset=utf-8
        //Content-Length: 2
        //response.setHeader("Content-Type", "text/plain;charset=utf-8);
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.setContentLength(2); // 생략 시 자동 생성
    }
}
