package com.student.service.util;

import com.student.service.model.StudentDTO;
import com.student.service.model.StudentDetailsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class Patcher {

    public static void patch(StudentDTO incompleteData, StudentDetailsDTO studentDetailsDTO) throws IllegalAccessException {
        Class<?> incompleteDataClass = StudentDTO.class;
        Class<?> existingDataClass = StudentDetailsDTO.class;
        Field[] innerFields = incompleteDataClass.getDeclaredFields();
        Field[] extistingDatafields= existingDataClass.getDeclaredFields();
        Map<String, Object> map = new HashMap<>();
        for(Field field: innerFields){
            log.info("field name is "+field.getName());
            field.setAccessible(true);

            Object value = field.get(incompleteData);
            if(value != null){
                map.put(field.getName().toString(), value);
            }
            else field.setAccessible(false);
        }
        for(Field field: extistingDatafields){
            field.setAccessible(true);
            if(map.containsKey(field.getName())){
                field.set(studentDetailsDTO,map.get(field.getName()));
            }
        }
    }
}
