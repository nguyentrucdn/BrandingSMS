
package com.bagasus.sms.viettel;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CcApi", targetNamespace = "http://impl.bulkSms.ws/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CcApi {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getIp", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.GetIp")
    @ResponseWrapper(localName = "getIpResponse", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.GetIpResponse")
    @Action(input = "http://impl.bulkSms.ws/CcApi/getIpRequest", output = "http://impl.bulkSms.ws/CcApi/getIpResponse")
    public String getIp();

    /**
     * 
     * @param cpCode
     * @param password
     * @param user
     * @return
     *     returns com.bagasus.sms.viettel.CpBalance
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkBalance", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.CheckBalance")
    @ResponseWrapper(localName = "checkBalanceResponse", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.CheckBalanceResponse")
    @Action(input = "http://impl.bulkSms.ws/CcApi/checkBalanceRequest", output = "http://impl.bulkSms.ws/CcApi/checkBalanceResponse")
    public CpBalance checkBalance(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password,
        @WebParam(name = "CPCode", targetNamespace = "")
        String cpCode);

    /**
     * 
     * @param cpCode
     * @param password
     * @param receiverID
     * @param requestID
     * @param commandCode
     * @param serviceID
     * @param user
     * @param userID
     * @param contentType
     * @param content
     * @return
     *     returns com.bagasus.sms.viettel.Result
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "wsCpMt", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.WsCpMt")
    @ResponseWrapper(localName = "wsCpMtResponse", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.WsCpMtResponse")
    @Action(input = "http://impl.bulkSms.ws/CcApi/wsCpMtRequest", output = "http://impl.bulkSms.ws/CcApi/wsCpMtResponse")
    public Result wsCpMt(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password,
        @WebParam(name = "CPCode", targetNamespace = "")
        String cpCode,
        @WebParam(name = "RequestID", targetNamespace = "")
        String requestID,
        @WebParam(name = "UserID", targetNamespace = "")
        String userID,
        @WebParam(name = "ReceiverID", targetNamespace = "")
        String receiverID,
        @WebParam(name = "ServiceID", targetNamespace = "")
        String serviceID,
        @WebParam(name = "CommandCode", targetNamespace = "")
        String commandCode,
        @WebParam(name = "Content", targetNamespace = "")
        String content,
        @WebParam(name = "ContentType", targetNamespace = "")
        String contentType);

    /**
     * 
     * @param cpCode
     * @param password
     * @param user
     * @param timeReport
     * @return
     *     returns java.util.List<com.bagasus.sms.viettel.ReportHourBO>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "wsReportHour", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.WsReportHour")
    @ResponseWrapper(localName = "wsReportHourResponse", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.WsReportHourResponse")
    @Action(input = "http://impl.bulkSms.ws/CcApi/wsReportHourRequest", output = "http://impl.bulkSms.ws/CcApi/wsReportHourResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://impl.bulkSms.ws/CcApi/wsReportHour/Fault/Exception")
    })
    public List<ReportHourBO> wsReportHour(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password,
        @WebParam(name = "CPCode", targetNamespace = "")
        String cpCode,
        @WebParam(name = "timeReport", targetNamespace = "")
        String timeReport)
        throws Exception_Exception
    ;

    /**
     * 
     * @param cpCode
     * @param password
     * @param endDate
     * @param user
     * @param startDate
     * @return
     *     returns java.util.List<com.bagasus.sms.viettel.ReportDailyBO>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "wsReportDaily", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.WsReportDaily")
    @ResponseWrapper(localName = "wsReportDailyResponse", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.WsReportDailyResponse")
    @Action(input = "http://impl.bulkSms.ws/CcApi/wsReportDailyRequest", output = "http://impl.bulkSms.ws/CcApi/wsReportDailyResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://impl.bulkSms.ws/CcApi/wsReportDaily/Fault/Exception")
    })
    public List<ReportDailyBO> wsReportDaily(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password,
        @WebParam(name = "CPCode", targetNamespace = "")
        String cpCode,
        @WebParam(name = "startDate", targetNamespace = "")
        String startDate,
        @WebParam(name = "endDate", targetNamespace = "")
        String endDate)
        throws Exception_Exception
    ;

    /**
     * 
     * @param cpCode
     * @param password
     * @param startMonth
     * @param endMonth
     * @param user
     * @return
     *     returns java.util.List<com.bagasus.sms.viettel.ReportMonthBO>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "wsReportMonth", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.WsReportMonth")
    @ResponseWrapper(localName = "wsReportMonthResponse", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.WsReportMonthResponse")
    @Action(input = "http://impl.bulkSms.ws/CcApi/wsReportMonthRequest", output = "http://impl.bulkSms.ws/CcApi/wsReportMonthResponse", fault = {
        @FaultAction(className = Exception_Exception.class, value = "http://impl.bulkSms.ws/CcApi/wsReportMonth/Fault/Exception")
    })
    public List<ReportMonthBO> wsReportMonth(
        @WebParam(name = "User", targetNamespace = "")
        String user,
        @WebParam(name = "Password", targetNamespace = "")
        String password,
        @WebParam(name = "CPCode", targetNamespace = "")
        String cpCode,
        @WebParam(name = "startMonth", targetNamespace = "")
        String startMonth,
        @WebParam(name = "endMonth", targetNamespace = "")
        String endMonth)
        throws Exception_Exception
    ;

    /**
     * 
     * @param cpCode
     * @param date
     * @param password
     * @param pageNumber
     * @param alias
     * @param pageSize
     * @param username
     * @return
     *     returns com.bagasus.sms.viettel.FailSubReponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFailSub", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.GetFailSub")
    @ResponseWrapper(localName = "getFailSubResponse", targetNamespace = "http://impl.bulkSms.ws/", className = "com.bagasus.sms.viettel.GetFailSubResponse")
    @Action(input = "http://impl.bulkSms.ws/CcApi/getFailSubRequest", output = "http://impl.bulkSms.ws/CcApi/getFailSubResponse")
    public FailSubReponse getFailSub(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "cpCode", targetNamespace = "")
        String cpCode,
        @WebParam(name = "alias", targetNamespace = "")
        String alias,
        @WebParam(name = "date", targetNamespace = "")
        String date,
        @WebParam(name = "pageNumber", targetNamespace = "")
        String pageNumber,
        @WebParam(name = "pageSize", targetNamespace = "")
        String pageSize);

}