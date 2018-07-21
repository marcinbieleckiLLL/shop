package com.simplycoolest.controller.abstracts;

import com.simplycoolest.dte.BannerNames;
import com.simplycoolest.dte.Views;
import com.simplycoolest.dto.ValidationView;
import com.simplycoolest.utils.validation.ValidationErrors;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Marcin on 27.02.2018.
 */
@Component
public abstract class ValidationMain extends BannerMain {

    protected <T extends Object> String handleErrorsChecking(ValidationView validationView, T t){
        List<ValidationErrors> errorsList = validationView.getErrorsList();
        if(errorsList.isEmpty()){
            return handleCorrect(validationView.getIfCoorect(), t, validationView.getBannerName());
        }
        return handleError(errorsList, validationView.getIfError());
    }

    private <T extends Object> String handleCorrect(Views ifCoorect, T t, BannerNames bannerName){
        setAttributesToBanner(bannerName.getName(), t);
        doActionWhenNoError(t);
        return ifCoorect.getView();
    }

    private String handleError(List<ValidationErrors> errorsList, Views ifError){
        setErrorAttributes(errorsList);
        return ifError.getView();
    }

    protected void setErrorAttributes(List<ValidationErrors> errorsList){
        currentModelMap.addAttribute("errorList", jsonUtils.listToJson(errorsList));
    }

    protected abstract <T extends Object> void doActionWhenNoError(T t);
}
