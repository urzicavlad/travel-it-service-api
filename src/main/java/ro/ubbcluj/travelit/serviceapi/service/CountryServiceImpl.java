package ro.ubbcluj.travelit.serviceapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ro.ubbcluj.travelit.serviceapi.model.Country;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Collections;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class CountryServiceImpl implements CountryService {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Value("classpath:data.json")
    private Resource resource;


    @Override
    public List<Country> getAllCountries() {
        try {
            return OBJECT_MAPPER.readValue(asString(resource), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Country.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
