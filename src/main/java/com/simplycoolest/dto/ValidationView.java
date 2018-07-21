package com.simplycoolest.dto;

import com.simplycoolest.dte.BannerNames;
import com.simplycoolest.dte.Views;
import com.simplycoolest.utils.validation.ValidationErrors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Marcin on 25.02.2018.
 */
@Getter
@Setter
@AllArgsConstructor
public class ValidationView {
    List<ValidationErrors> errorsList;
    Views ifError;
    Views ifCoorect;
    BannerNames bannerName;
}
