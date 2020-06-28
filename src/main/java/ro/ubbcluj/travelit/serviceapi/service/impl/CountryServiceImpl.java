package ro.ubbcluj.travelit.serviceapi.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import ro.ubbcluj.travelit.serviceapi.model.Country;
import ro.ubbcluj.travelit.serviceapi.model.User;
import ro.ubbcluj.travelit.serviceapi.repository.CountryRepository;
import ro.ubbcluj.travelit.serviceapi.repository.UserRepository;
import ro.ubbcluj.travelit.serviceapi.service.CountryService;

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
    private final UserRepository userRepository;

    @Value("classpath:data.json")
    private Resource data;
    @Value("classpath:users.json")
    private Resource users;

    public CountryServiceImpl(CountryRepository countryRepository, UserRepository userRepository) {
        this.countryRepository = countryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Country> getAll() {
        return StreamSupport.stream(countryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Country getById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found!"));
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

    @Override
    public Country getByName(String name) {
        return countryRepository.findCountryByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Country not found!"));
    }

    void prePopulateDatabase() {
        try {
            CollectionType listOfCountry = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Country.class);
            CollectionType listOfUsers = OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, User.class);
            countryRepository.saveAll(OBJECT_MAPPER.readValue(asString(data), listOfCountry));
            userRepository.saveAll(OBJECT_MAPPER.readValue(asString(users), listOfUsers));
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

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }
}
