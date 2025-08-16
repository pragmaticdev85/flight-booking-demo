package com.example.demo.controller;

import com.example.demo.model.dto.PassengerDetails;
import com.example.demo.model.responses.PassengerAllowList;
import com.example.demo.model.responses.PassengerValidationResponse;
import com.example.demo.service.PassengerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/passenger")
public class PassengerVerificationController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/allow-list")
    public PassengerAllowList getAllowList() {
        return PassengerAllowList.builder().passengerNames(this.passengerService.allowList().toArray(new String[0])).build();
    }

    @PostMapping
    public PassengerValidationResponse isValid(@RequestBody @Valid PassengerDetails passengerDetails) {
        PassengerValidationResponse passengerValidationResponse = PassengerValidationResponse.builder().build();
        boolean isValid = passengerService.isValidPassenger(passengerDetails.getName());
        if (isValid) passengerValidationResponse.setSuccessMsg(String.format("Passenger -> [%s] is valid", passengerDetails.getName()));
        else {
            passengerValidationResponse.setErrorMsg(String.format("Passenger -> [%s] is not valid", passengerDetails.getName()));
        }
        return passengerValidationResponse;
    }
}
