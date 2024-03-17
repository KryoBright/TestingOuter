package com.example.test.test.responses.supporting;

import com.example.test.test.enums.Direction;
import com.example.test.test.enums.Field;
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
