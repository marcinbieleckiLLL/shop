package com.simplycoolest.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Marcin on 04.05.2018.
 */
@EqualsAndHashCode
@AllArgsConstructor
public class AvailableUri {
    public String uri;
    public RequestMethod method;
}
