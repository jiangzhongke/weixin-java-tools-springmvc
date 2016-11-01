package com.github.model;

import com.github.storage.SmsConfigStorage;
import com.github.util.HttpSender;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Name
 * @Author Joe mailTo:jiangzhongke@baojinsuo.com
 * @Date 2016/10/31 下午5:30
 * SmsRequestBean{tunnel='cltzold', modelName='103', user='baojinsuo', mobile='18516550566', param={key2=3332, key1=1122}, key='XAVFzHSsj8MjOxSPxxR4zI0tOvheW0QRi7FDT6YEaFV'}
 * @Desc
 */
public class SmsModel {
    public static String sendSms(SmsConfigStorage configStorage,HttpServletRequest param) throws Exception {
        StringBuffer str = new StringBuffer();
        if (!param.getParameter("accesskey").equals(configStorage.getKey()))
            return "accesskey错误!无权调用!";
        if(!param.getParameter("tunnel").equals("cltzold")){
        switch (param.getParameter("user")){
            case "baojinsuo":
                str.append("【保金所】");
                break;
            case "mingpin":
                str.append("【名品消费宝】");
                break;
            default:
                return "头部名称不存在!当前存在参数:baojinsuo,mingpin,对应头部【保金所】,【名品消费宝】.请检查是否参数正确!";

        }}
        switch (param.getParameter("modelName")){
            case "101":
                str.append("您成功购买了"+param.getParameter("key1")+"元"+param.getParameter("key2")+"，年化利率"+param.getParameter("key3")+"%，理财周期"+param.getParameter("key4")+"到期日"+param.getParameter("key5")+"。");
                break;
            case "102":
                str.append("您购买的"+param.getParameter("key1")+"已到期，还款本金"+param.getParameter("key2")+"元，利息"+param.getParameter("key3")+"元。本息已返还到您的账户余额。");
                break;
            case "103":
                str.append("您的验证码是"+param.getParameter("key1"));
                break;
            case "104":
                str.append("您账户于"+param.getParameter("key1")+"发生一笔"+param.getParameter("key2")+"元的充值操作，已到账请查账户余额。");
                break;
            case "105":
                str.append("您账户于"+param.getParameter("key1")+"发生一笔"+param.getParameter("key2")+"元的取现操作，预计1-3个工作日到账，请注意银行通知。");
                break;
            case "106":
                str.append("今日"+param.getParameter("key1")+",到期产品共有"+param.getParameter("key2")+"个，第"+param.getParameter("key3")+"个，"+param.getParameter("key4")+"本金总共"+param.getParameter("key5")+"元，利息总共"+param.getParameter("key6")+"元。");
                break;
            default:
                str.append(param.getParameter("key1"));
                break;
        }
        if(param.getParameter("tunnel").equals("clyxnew")){
            str.append("退订回复TD");
        }
        configStorage.setMobile(param.getParameter("mobile"));
        configStorage.setMessage(str.toString());
        String sendStatus = HttpSender.batchSend(configStorage);
        return sendStatus;

    }
}
