package ro.ubbcluj.travelit.serviceapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ro.ubbcluj.travelit.serviceapi.model.Country;
import ro.ubbcluj.travelit.serviceapi.repository.CountryRepository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class CountryServiceImpl implements CountryService {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final CountryRepository countryRepository;

    @Value("classpath:data.json")
    private Resource resource;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {
        return StreamSupport.stream(countryRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Country getById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Country not found!"));
    }

    @Override
    public String populateDatabase() {
        prePopulateDatabase();
        return "Done!";
    }

    @Override
    public Page<Country> getPaginated(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }


    void prePopulateDatabase() {
        try {
            countryRepository.saveAll(OBJECT_MAPPER.readValue(asString(resource),
                    OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Country.class)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
