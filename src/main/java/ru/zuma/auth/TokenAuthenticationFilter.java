package ru.zuma.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.web.filter.GenericFilterBean;
import ru.zuma.database.User;
import ru.zuma.database.UserRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class TokenAuthenticationFilter extends GenericFilterBean {

    Collection<? extends GrantedAuthority> authorities;
    private MyBasicAuthenticationEntryPoint entryPoint;
    private UserRepository userRepository;

    public TokenAuthenticationFilter(MyBasicAuthenticationEntryPoint entryPoint,
                                     UserRepository userRepository) {
        this.userRepository = userRepository;
        this.entryPoint = entryPoint;
        authorities = new ArrayList<>();
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest httpRequest = (HttpServletRequest)request;
        final HttpServletResponse httpResponse = (HttpServletResponse)response;

        //extract token from header
        String header = httpRequest.getHeader(entryPoint.getAccessTokenHeader());

        if (null != header) {
            String accessToken = header.substring(header.indexOf(' ') + 1);
            //get and check whether token is valid ( from DB or file wherever you are storing the token)

            //Populate SecurityContextHolder by fetching relevant information using token
            final User user = userRepository.findByAccessToken(accessToken);
            if (user == null) {
                entryPoint.commence(httpRequest, httpResponse, new SessionAuthenticationException("Unknown access token"));
                return;
            }

            final UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null, null);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            chain.doFilter(request, response);
        } else {
            entryPoint.commence(httpRequest, httpResponse, new SessionAuthenticationException("Authentication required"));
        }
    }
}