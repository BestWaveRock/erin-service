package com.erin.base.service;

import com.erin.base.utils.LocaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

public class I18nService {

    private Logger logger = LoggerFactory.getLogger(LocaleUtils.class);

    private final MessageSource messageSource;

    public I18nService(MessageSource messageSource) {
        logger.info("构造了 I18nService");
        this.messageSource = messageSource;
    }

    public String getMessage(String msgKey, Object[] args) {
        return messageSource.getMessage(msgKey, args, LocaleUtils.getCurrentLocale());
    }

    public String getMessage(String msgKey) {
        return messageSource.getMessage(msgKey, null, LocaleUtils.getCurrentLocale());
    }
}
