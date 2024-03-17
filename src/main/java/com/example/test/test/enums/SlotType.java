package com.example.test.test.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public enum SlotType
{
    LOCAL,
    FROM_HOME,

    //В задании был FROM HOME без нижнего подчёркивания, но иначе enum не создаётся
    UNDEFINED
}
