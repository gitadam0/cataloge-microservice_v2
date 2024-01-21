package com.example.Cataloguemicroservice.customErrors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientErrorResponse {
    private int  statusCode;
    String message;
    String timeStampoftheError;

}
