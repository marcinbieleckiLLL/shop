package com.simplycoolest.utils.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Marcin on 25.02.2018.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ValidationProperty {
    private String propertyValue;
    private String propertyName;
    private int correctMinLength;
}
