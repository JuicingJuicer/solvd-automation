package com.solvd.qa.carina.block4.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.api_url}/todos", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/todos/_post/rq.json")
@ResponseTemplatePath(path = "api/todos/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostToDoMethod extends AbstractApiMethodV2 {
    public PostToDoMethod() {
    }
}
