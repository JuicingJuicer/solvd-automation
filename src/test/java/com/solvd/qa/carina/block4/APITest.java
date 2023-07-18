package com.solvd.qa.carina.block4;

import com.solvd.qa.carina.block4.api.GetToDoMethod;
import com.solvd.qa.carina.block4.api.PatchToDoMethod;
import com.solvd.qa.carina.block4.api.PostToDoMethod;
import com.solvd.qa.carina.demo.api.GetUserMethods;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test()
    public void testGetTodos() {
        GetToDoMethod api = new GetToDoMethod();

        api.callAPIExpectSuccess();

        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/todos/_get/rs.schema");
    }

    @Test()
    public void testCreateToDo() throws Exception{
        PostToDoMethod api = new PostToDoMethod();
        api.setProperties("api/todos/todo.properties");

        api.callAPIExpectSuccess();

        api.validateResponse();
    }

    @Test()
    public void testCreateToDoMissingSomeField() throws Exception{
        PostToDoMethod api = new PostToDoMethod();
        api.setProperties("api/todos/todo.properties");
        api.getProperties().remove("title");

        api.callAPIExpectSuccess();

        api.validateResponse();
    }

    @Test()
    public void testPatchToDo() throws Exception{
        PostToDoMethod api = new PostToDoMethod();
        api.setProperties("api/todos/todo.properties");
        PatchToDoMethod api2 = new PatchToDoMethod();
        api2.setProperties("api/todos/todo.properties");

        Response response = api.callAPIExpectSuccess();
        LOGGER.info("Old: " + response.jsonPath().getString("0.title"));
        api.validateResponse();

        api2.addProperty("completed", "true");
        Response response2 = api2.callAPIExpectSuccess();
        LOGGER.info("New: " + response2.jsonPath().getString("title"));
        api2.validateResponse();
    }
}
