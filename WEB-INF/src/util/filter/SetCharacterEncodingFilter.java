package util.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SetCharacterEncodingFilter implements Filter {

	// 字符编码  
	String encoding = null;
	@Override
	public void destroy() {		
		encoding = null;  
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,  
			FilterChain chain) throws IOException, ServletException {	
		
		// 判断字符编码是否为空  
		if(encoding != null){  
			// 设置request的编码格式  
			request.setCharacterEncoding(encoding);  
			// 设置response字符编码  
			response.setContentType("text/html; charset="+encoding); 
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			//httpResponse.setHeader("Cache-Control","no-store");
			//httpResponse.setHeader("Pragrma","no-cache");
			//httpResponse.setDateHeader("Expires",0);

		}  
		// 传递给下一过滤器  
		chain.doFilter(request, response);  
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		// 获取初始化参数  
		encoding = filterConfig.getInitParameter("encoding");  

	}

}
