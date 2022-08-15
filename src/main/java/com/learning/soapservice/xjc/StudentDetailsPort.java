
package com.learning.soapservice.xjc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentDetailsPort", targetNamespace = "http://www.learning.com/soapservice/xjc")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentDetailsPort {


    /**
     * 
     * @param studentDetailsRequest
     * @return
     *     returns com.learning.soapservice.xjc.StudentDetailsResponse
     */
    @WebMethod(operationName = "StudentDetails")
    @WebResult(name = "StudentDetailsResponse", targetNamespace = "http://www.learning.com/soapservice/xjc", partName = "StudentDetailsResponse")
    public StudentDetailsResponse studentDetails(
        @WebParam(name = "StudentDetailsRequest", targetNamespace = "http://www.learning.com/soapservice/xjc", partName = "StudentDetailsRequest")
        StudentDetailsRequest studentDetailsRequest);

}