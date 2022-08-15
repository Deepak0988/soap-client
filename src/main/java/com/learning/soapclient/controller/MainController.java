package com.learning.soapclient.controller;

import com.learning.soapclient.config.SOAPConnector;
import com.learning.soapservice.xjc.StudentDetailsPort;
import com.learning.soapservice.xjc.StudentDetailsPortService;
import com.learning.soapservice.xjc.StudentDetailsRequest;
import com.learning.soapservice.xjc.StudentDetailsResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private SOAPConnector soapConnector;

    public MainController(SOAPConnector soapConnector){
        this.soapConnector = soapConnector;
    }

    @GetMapping("/")
    public StudentDetailsResponse test(){
        StudentDetailsPortService service = new StudentDetailsPortService();
        StudentDetailsPort studentService = service.getStudentDetailsPortSoap11();
        StudentDetailsRequest request = new StudentDetailsRequest();
        request.setName("test1");
        return (StudentDetailsResponse) soapConnector.callWebService("https://localhost:9001/service/student-detail", request);
      //  return studentService.studentDetails(request);
    }
}
