package http;

/**
 * Created by iltaek on 2020/06/11 Blog : http://blog.iltaek.me Github : http://github.com/iltaek
 */
public class HttpRequest {

    private final RequestLine requestLine;
    private final HttpHeaders headers;
    private final Cookies cookies;
    private final QueryString queryString;

    public HttpRequest(RequestLine requestLine, HttpHeaders headers, QueryString queryString) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.cookies = getCookies(headers);
        this.queryString = queryString;
    }

    private Cookies getCookies(HttpHeaders headers) {
        return new Cookies(headers.getHeader(HttpHeaderNames.COOKIE.toString()));
    }

    public String getPath() {
        return requestLine.getPath();
    }

    public String getHeader(String key) {
        return headers.getHeader(key);
    }

    public String getCookie(String key) {
        return cookies.getCookie(key);
    }

    public String getParameter(String key) {
        return queryString.getParameter(key);
    }

    public HttpMethod getMethod() {
        return requestLine.getMethod();
    }
}
