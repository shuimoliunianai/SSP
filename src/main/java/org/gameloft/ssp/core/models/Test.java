package org.gameloft.ssp.core.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ningzhen.ge on 2016/9/20.
 */
@Component
@Scope("request")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"name", "age"})
public class Test {
    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private String age;

    public Test()
    {

    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("age")
    public String getAge() {
        return age;
    }
    @JsonProperty("age")
    public void setAge(String age) {
        this.age = age;
    }
}
