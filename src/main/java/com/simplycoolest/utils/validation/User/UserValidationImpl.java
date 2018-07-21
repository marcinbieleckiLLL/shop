package com.simplycoolest.utils.validation.User;

import com.simplycoolest.entities.UserData;
import com.simplycoolest.service.NonSocialMediaService;
import com.simplycoolest.utils.annotations.logging.LogMethodName;
import com.simplycoolest.utils.validation.ValidationErrors;
import com.simplycoolest.utils.validation.ValidationProperty;
import com.simplycoolest.utils.validation.ValidationUtilsImpl;
import com.simplycoolest.utils.validation.ValidationUtilsPresent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Marcin on 25.02.2018.
 */
@Service
public class UserValidationImpl extends ValidationUtilsImpl implements ValidationUtilsPresent{

    private static final String[] FIELDS_TO_VALIDATION = {"username", "email", "password"};
    private static final int[] LENGTH_TO_VALIDATION = {6, 5, 8};

    @Autowired
    ValidationUtilsImpl.Helper helper;

    @Autowired
    @Qualifier("userServiceImpl")
    NonSocialMediaService nonSocialMediaService;

    @Autowired
    AlreadyExist alreadyExist;

    @LogMethodName(value = UserValidationImpl.class)
    @Override
    public <T> ValidationErrors validateAlreadyPresent(T t) {
        return returnIfPresent(alreadyExist.isAlreadyInDatabase((UserData) t));
    }

    @Override
    protected <T> void prepareToValidation(T t) {
        UserData userData = (UserData) t;
        clearAllData();
        createProperties(userData);
    }

    protected void createInterfaces(){
        Function<ValidationProperty, List<ValidationErrors>> username = vp -> validateUsernameOrPassword(vp);
        Function<ValidationProperty, List<ValidationErrors>> email = vp -> validateUserEmail(vp);
        Function<ValidationProperty, List<ValidationErrors>> password = vp -> validateUsernameOrPassword(vp);

        listWithInterfaces.add(username);
        listWithInterfaces.add(email);
        listWithInterfaces.add(password);
    }

    protected void createProperties(UserData userData){
        listWithProperties.add(new ValidationProperty(userData.getUsername(), FIELDS_TO_VALIDATION[0], LENGTH_TO_VALIDATION[0]));
        listWithProperties.add(new ValidationProperty(userData.getEmail(), FIELDS_TO_VALIDATION[1], LENGTH_TO_VALIDATION[1]));
        listWithProperties.add(new ValidationProperty(userData.getPassword(), FIELDS_TO_VALIDATION[2], LENGTH_TO_VALIDATION[2]));
    }

    private List<ValidationErrors> validateUsernameOrPassword(ValidationProperty v){
        return helper.validateEmptyAndLength(v);
    }

    private List<ValidationErrors> validateUserEmail(ValidationProperty v){
        List<ValidationErrors> list = new ArrayList<>();
        list.addAll(helper.validateEmptyAndLength(v));
        if(list.isEmpty())
            list.add(helper.validateEmail(v));
        return list;
    }

    @Component
    private class AlreadyExist{
        private static final String IS_ALREADY_PRESENT_INFO = "This user is already in database! Please choose another email";
        private static final String IS_ALREADY_UNPRESENT_INFO = "There is no such user! Check data which you have provided.";

        public ValidationErrors isAlreadyInDatabase(UserData userData){
            return new ValidationErrors(FIELDS_TO_VALIDATION[1], nonSocialMediaService.isUserExist(userData),
                IS_ALREADY_PRESENT_INFO);
        }

        public ValidationErrors isNotInDatabase(UserData userData){
            return new ValidationErrors(FIELDS_TO_VALIDATION[1], !nonSocialMediaService.isUserExist(userData),
                    IS_ALREADY_UNPRESENT_INFO);
        }
    }
}
