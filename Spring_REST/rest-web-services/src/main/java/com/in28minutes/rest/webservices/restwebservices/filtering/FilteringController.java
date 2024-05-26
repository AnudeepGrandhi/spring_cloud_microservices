package com.in28minutes.rest.webservices.restwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value1", "value2", "value3", "value4", "value5");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("value1", "value2", "value3", "value4", "value5"),
                new SomeBean("value6", "value7", "value8", "value9", "value0"));
    }

    ///Dynamic Filtering - Logic to filter is now have to be defined in our Rest API
    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue dynamicFiltering(){
        SomeOtherBean someOtherBean = new SomeOtherBean("value1", "value2", "value3", "value4", "value5");

        /////If you have specific serialization instructions that you want to pass to the jackson convertor,
        ////then we make use of MappingJacksonValue and it allows you to set filters
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someOtherBean);

        ////Create a filter on the bean.
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");

        ///Create a filter provider defining the number of filters that you would want to apply
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeOtherBeanFiler", filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue dynamicFilteringList(){
        List<SomeOtherBean> someOtherBeans = Arrays.asList(new SomeOtherBean("value1", "value2", "value3", "value4", "value5"),
                new SomeOtherBean("value6", "value7", "value8", "value9", "value0"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someOtherBeans);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field4");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeOtherBeanFiler", filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
