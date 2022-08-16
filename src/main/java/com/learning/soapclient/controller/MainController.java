package com.learning.soapclient.controller;

import com.learning.soapclient.config.WebServiceTemplateConfig;
import com.learning.soapservice.xjc.StudentDetailsPort;
import com.learning.soapservice.xjc.StudentDetailsPortService;
import com.learning.soapservice.xjc.StudentDetailsRequest;
import com.learning.soapservice.xjc.StudentDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    WebServiceTemplateConfig config;

    @GetMapping("/")
    public StudentDetailsResponse test(){
        StudentDetailsPortService service = new StudentDetailsPortService();
        StudentDetailsPort studentService = service.getStudentDetailsPortSoap11();
        StudentDetailsRequest request = new StudentDetailsRequest();
        request.setName("test1");
        return (StudentDetailsResponse) config.someWsCall(request);
      //  return studentService.studentDetails(request);
    }
}
