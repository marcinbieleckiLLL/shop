package com.simplycoolest.utils.validation;

import com.simplycoolest.utils.annotations.logging.LogMethodName;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Marcin on 24.02.2018.
 */
@Service
public abstract class ValidationUtilsImpl implements ValidationUtils{

    protected List<Function> listWithInterfaces = new ArrayList<>();
    protected List<ValidationErrors> listWithErrors = new ArrayList<>();
    protected List<ValidationProperty> listWithProperties = new ArrayList<>();

    @LogMethodName(value = ValidationUtils.class)
    @Override
    public <T> List<ValidationErrors> validate(T t) {
        prepareToValidation(t);
        createInterfaces();
        createValidationErrors();
        return returnActiveValidationErrors();
    }

    private void createValidationErrors(){
        IntStream.range(0, listWithProperties.size())
                .forEach(i -> listWithErrors
                        .addAll((List<ValidationErrors>) listWithInterfaces.get(i).apply(listWithProperties.get(i))));
    }

    private List<ValidationErrors> returnActiveValidationErrors(){
        return listWithErrors.stream().filter(ve -> ve.isError()).collect(Collectors.toList());
    }

    protected abstract <T> void prepareToValidation(T t);
    protected abstract void createInterfaces();

    protected void clearAllData(){
        listWithErrors.clear();
        listWithInterfaces.clear();
        listWithProperties.clear();
    }

    protected ValidationErrors returnIfPresent(ValidationErrors validationErrors){
        return validationErrors.isError() ? validationErrors:null;
    }

    @Component
    public static class Helper{

        private static final Pattern EMAIL_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        private static final String EMPTY_INFO = "%s cannot be empty!";
        private static final String LENGTH_INFO = "%s cannot be shorter than %d signs!";
        private static final String EMAIL_INFO = "%s needs to be an email!";

        public List<ValidationErrors> validateEmptyAndLength(ValidationProperty v){
            List<ValidationErrors> listWithErrors = new ArrayList<>();
            ValidationErrors validationEmptyError = validateNotEmpty(v);
            ValidationErrors validationLengthError = validateLength(v);
            listWithErrors.add(validationEmptyError);

            if(!validationEmptyError.isError())
                listWithErrors.add(validationLengthError);

            return listWithErrors;
        }

        public ValidationErrors validateNotEmpty(ValidationProperty v){
            return new ValidationErrors(v.getPropertyName(), isEmpty(v.getPropertyValue()),
                    String.format(EMPTY_INFO, v.getPropertyName()));
        }

        public ValidationErrors validateLength(ValidationProperty v){
            return new ValidationErrors(v.getPropertyName(), !isCorrectLength(v.getPropertyValue(), v.getCorrectMinLength()),
                    String.format(LENGTH_INFO, v.getPropertyName(), v.getCorrectMinLength()));
        }

        public ValidationErrors validateEmail(ValidationProperty v){
            return new ValidationErrors(v.getPropertyName(), !isEmail(v.getPropertyValue()),
                    String.format(EMAIL_INFO, v.getPropertyName()));
        }

        private boolean isEmpty(String property){
            return property.isEmpty();
        }

        private boolean isCorrectLength(String property, int length){
            return property.length() >= length;
        }

        private boolean isEmail(String property){
            Matcher matcher = EMAIL_REGEX .matcher(property);
            return matcher.find();
        }
    }
}
