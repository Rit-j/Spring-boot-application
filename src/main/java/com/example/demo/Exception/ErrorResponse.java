package com.example.demo.Exception;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "error")
public class ErrorResponse
{
    public ErrorResponse(String message, List<String> details, String errorCode) {
        super();
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
    }

    private String errorCode;
    private String message;

    private List<String> details;

}
