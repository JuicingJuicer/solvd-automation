package com.solvd.qa.carina.block4.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.api_url}/todos/${id}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/todos/_patch/rq.json")
@ResponseTemplatePath(path = "api/todos/_patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchToDoMethod extends AbstractApiMethodV2 {
    public PatchToDoMethod() {
    }
}
