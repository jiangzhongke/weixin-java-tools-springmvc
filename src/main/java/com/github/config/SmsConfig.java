package com.github.config;

import com.github.storage.SmsConfigStorage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Name
 * @Author Joe mailTo:jiangzhongke@baojinsuo.com
 * @Date 2016/10/31 下午4:12
 * @Desc
 */
@Configuration
public class SmsConfig {
    @Value("#{smsProperties.cl_tz_uri_old}")
    private String tzUriOld;
    @Value("#{smsProperties.cl_tz_account_old}")
    private String tzAccountOld;
    @Value("#{smsProperties.cl_tz_password_old}")
    private String tzPasswordOld;
    @Value("#{smsProperties.cl_tz_access_key_old}")
    private String tzAccessKeyOld;

    @Value("#{smsProperties.cl_tz_uri_new}")
    private String tzUriNew;
    @Value("#{smsProperties.cl_tz_account_new}")
    private String tzAccountNew;
    @Value("#{smsProperties.cl_tz_password_new}")
    private String tzPasswordNew;
    @Value("#{smsProperties.cl_tz_access_key_new}")
    private String tzAccessKeyNew;

    @Value("#{smsProperties.cl_yx_uri_new}")
    private String yxUriNew;
    @Value("#{smsProperties.cl_yx_account_new}")
    private String yxAccountNew;
    @Value("#{smsProperties.cl_yx_password_new}")
    private String yxPasswordNew;
    @Value("#{smsProperties.cl_yx_access_key_new}")
    private String yxAccessKeyNew;



    @Bean
    public SmsConfigStorage clTzOldConfigStorage(){
        SmsConfigStorage configStorage = new SmsConfigStorage(this.tzUriOld,this.tzAccountOld,this.tzPasswordOld,this.tzAccessKeyOld);
        return configStorage;
    }
    @Bean
    public SmsConfigStorage clTzNewConfigStorage(){
        SmsConfigStorage configStorage = new SmsConfigStorage(this.tzUriNew,this.tzAccountNew,this.tzPasswordNew,this.tzAccessKeyNew);
        return configStorage;
    }
    @Bean
    public SmsConfigStorage clYxNewConfigStorage(){
        SmsConfigStorage configStorage = new SmsConfigStorage(this.yxUriNew,this.yxAccountNew,this.yxPasswordNew,this.yxAccessKeyNew);
        return configStorage;
    }

    public String getTzUriOld() {
        return tzUriOld;
    }

    public void setTzUriOld(String tzUriOld) {
        this.tzUriOld = tzUriOld;
    }

    public String getTzAccountOld() {
        return tzAccountOld;
    }

    public void setTzAccountOld(String tzAccountOld) {
        this.tzAccountOld = tzAccountOld;
    }

    public String getTzPasswordOld() {
        return tzPasswordOld;
    }

    public void setTzPasswordOld(String tzPasswordOld) {
        this.tzPasswordOld = tzPasswordOld;
    }

    public String getTzUriNew() {
        return tzUriNew;
    }

    public void setTzUriNew(String tzUriNew) {
        this.tzUriNew = tzUriNew;
    }

    public String getTzAccountNew() {
        return tzAccountNew;
    }

    public void setTzAccountNew(String tzAccountNew) {
        this.tzAccountNew = tzAccountNew;
    }

    public String getTzPasswordNew() {
        return tzPasswordNew;
    }

    public void setTzPasswordNew(String tzPasswordNew) {
        this.tzPasswordNew = tzPasswordNew;
    }

    public String getYxUriNew() {
        return yxUriNew;
    }

    public void setYxUriNew(String yxUriNew) {
        this.yxUriNew = yxUriNew;
    }

    public String getYxAccountNew() {
        return yxAccountNew;
    }

    public void setYxAccountNew(String yxAccountNew) {
        this.yxAccountNew = yxAccountNew;
    }

    public String getYxPasswordNew() {
        return yxPasswordNew;
    }

    public void setYxPasswordNew(String yxPasswordNew) {
        this.yxPasswordNew = yxPasswordNew;
    }
}
