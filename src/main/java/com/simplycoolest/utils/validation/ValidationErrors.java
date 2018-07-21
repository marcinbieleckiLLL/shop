package com.simplycoolest.utils.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Marcin on 25.02.2018.
 */
@AllArgsConstructor
@Getter
@Setter
public class ValidationErrors {
    private String property;
    private boolean isError;
    private String message;
}
