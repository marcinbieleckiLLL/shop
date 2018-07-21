package com.simplycoolest.dte;

import com.simplycoolest.dto.AvailableUri;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marcin on 04.05.2018.
 */
@Getter
public enum Mappings {

    //zawsze mozna isc na home i na sama siebie

    NULL(createParamList(
            new AvailableUri(MappingConstants.allMapping, RequestMethod.GET)
    ), createParamList(
            new AvailableUri(MappingConstants.login, RequestMethod.GET),
            new AvailableUri(MappingConstants.shop, RequestMethod.GET),
            new AvailableUri(MappingConstants.home, RequestMethod.GET),
            new AvailableUri(MappingConstants.defaultMapping, RequestMethod.GET)
    ), new ArrayList<>()),
    HOME(createParamList(
            new AvailableUri(MappingConstants.home, RequestMethod.GET),
            new AvailableUri(MappingConstants.defaultMapping, RequestMethod.GET)
            ), createParamList(
                    new AvailableUri(MappingConstants.login, RequestMethod.GET),
                    new AvailableUri(MappingConstants.shop, RequestMethod.GET)
            ), new ArrayList<>()),
    LOGIN(createParamList(new AvailableUri(MappingConstants.login, RequestMethod.GET)),
            createParamList(
                    new AvailableUri(MappingConstants.register, RequestMethod.GET),
                    new AvailableUri(MappingConstants.login, RequestMethod.POST),
                    new AvailableUri(MappingConstants.facebookSingin, RequestMethod.POST)
            ), new ArrayList<>()),
    LOGIN_POST(createParamList(new AvailableUri(MappingConstants.login, RequestMethod.POST)),
            createParamList(
                    new AvailableUri(MappingConstants.login, RequestMethod.GET),
                    new AvailableUri(MappingConstants.shop, RequestMethod.GET)
            ), createStringList("g-recaptcha-response", "user")),
    REGISTER(createParamList(new AvailableUri(MappingConstants.register, RequestMethod.GET)),
            createParamList(
                    new AvailableUri(MappingConstants.shop, RequestMethod.GET),
                    new AvailableUri(MappingConstants.login, RequestMethod.GET),
                    new AvailableUri(MappingConstants.register, RequestMethod.POST)
            ), new ArrayList<>()),
    REGISTER_POST(createParamList(new AvailableUri(MappingConstants.register, RequestMethod.POST)),
            createParamList(
                    new AvailableUri(MappingConstants.shop, RequestMethod.GET),
                    new AvailableUri(MappingConstants.login, RequestMethod.GET),
                    new AvailableUri(MappingConstants.register, RequestMethod.GET)
            ), createStringList("g-recaptcha-response", "user")),
    SHOP(createParamList(new AvailableUri(MappingConstants.shop, RequestMethod.POST)),
            createParamList(
                    new AvailableUri(MappingConstants.shop, RequestMethod.GET),
                    new AvailableUri(MappingConstants.login, RequestMethod.GET),
                    new AvailableUri(MappingConstants.register, RequestMethod.GET)
            ), new ArrayList<>());


    private List<AvailableUri> currentUris;
    private List<AvailableUri> avaliableUrisToForward;
    private List<String> avaliableRequestParams;

    Mappings(List<AvailableUri> currentUris, List<AvailableUri> avaliableUrisToForward,
             List<String> avaliableRequestParams) {
        this.currentUris = currentUris;
        this.avaliableUrisToForward = avaliableUrisToForward;
        this.avaliableRequestParams = avaliableRequestParams;
    }

    public static Mappings getMappingByUri(AvailableUri uriContainer){
        return Arrays.stream(Mappings.values())
                .filter(m -> m.getCurrentUris().contains(uriContainer))
                .findFirst()
                .get();
    }

    private static List<String> createStringList(String... args){
        return Arrays.stream(args).collect(Collectors.toList());
    }

    private static List<AvailableUri> createParamList(AvailableUri... args){
        return Arrays.stream(args).collect(Collectors.toList());
    }
}
