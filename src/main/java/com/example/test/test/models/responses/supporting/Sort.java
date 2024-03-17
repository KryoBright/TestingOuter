package com.example.test.test.models.responses.supporting;

import com.example.test.test.models.enums.Direction;
import com.example.test.test.models.enums.Field;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@AllArgsConstructor
public class Sort
{
    private Field field;
    private Direction direction;
}
