package com.example.test.test.controllers;

import com.example.test.test.entities.Slot;
import com.example.test.test.exception.ErrorResponse;
import com.example.test.test.responses.Id;
import com.example.test.test.responses.SlotWithAllIds;
import com.example.test.test.responses.SlotWithScheduleTemplateId;
import com.example.test.test.services.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/slot")
public class SlotController
{
    private final SlotService slotService;

    @PostMapping
    public Object createSlot(
            @RequestBody SlotWithScheduleTemplateId slot
    )
    {
        return slotService.createSlot(slot);
    }

    @GetMapping("/{id}")
    public Object readSlot(
            @PathVariable String id
    )
    {
        return slotService.findSlot(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SlotWithAllIds>> readSlots()
    {
        return ResponseEntity.ok(slotService.findAllSlots());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponse
                .builder()
                .message("Не удалось создать слот на основе полученных полей возможно вы неправильно указали время (YYYY-MM-DDTHH:mm:ss+HH:mm) или ввели не все требуемые поля")
                .timestamp(ZonedDateTime.now())
                .status(400)
                .error("Bad Request")
                .path("/slot")
                .build()
        );
    }


}
