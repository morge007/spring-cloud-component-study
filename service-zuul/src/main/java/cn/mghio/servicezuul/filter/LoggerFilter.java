package cn.mghio.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.util.HTTPRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * <p>****************************************************************************</p>
 * <p><b>Copyright © 2018 102 programmer team All Rights Reserved<b></p>
 * <ul style="margin:15px;">
 * <li>Description : cn.mghio.servicezuul.filter</li>
 * <li>Version     : 1.0</li>
 * <li>Creation    : 2018年07月06日</li>
 * <li>@author     : 追（☆_☆）梦 <maguihai1920@gmail.com></li>
 * </ul>
 * <p>****************************************************************************</p>
 */
@Component
public class LoggerFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        logger.debug("start LoggerFilter...");

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        // 请求的类型
        String method = request.getMethod();
        Map<String, List<String>> params = HTTPRequestUtils.getInstance().getQueryParams();
        // 请求的开始时间
        long startTime = (long) ctx.get("startTime");
        // 请求的异常信息
        Throwable throwable = ctx.getThrowable();
        // 请求的uri
        String uri = request.getRequestURI();
        // 请求的ip地址
        String ip = request.getRemoteAddr();
        // 请求的状态
        int statusCode = ctx.getResponseStatusCode();
        // 请求耗时
        long duration = System.currentTimeMillis() - startTime;

        logger.debug("end LoggerFilter..");
        return null;
    }
}
