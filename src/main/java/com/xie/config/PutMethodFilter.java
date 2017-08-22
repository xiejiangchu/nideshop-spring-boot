package com.xie.config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.HttpPutFormContentFilter;

/**
 * @Author xie
 * @Date 17/2/26 下午10:11.
 */

@Component
public class PutMethodFilter extends HttpPutFormContentFilter {
}
