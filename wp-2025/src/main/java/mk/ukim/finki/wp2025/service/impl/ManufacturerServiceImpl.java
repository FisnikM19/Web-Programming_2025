package mk.ukim.finki.wp2025.service.impl;

import mk.ukim.finki.wp2025.model.Manufacturer;
import mk.ukim.finki.wp2025.model.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.wp2025.repository.ManufacturerRepository;
import mk.ukim.finki.wp2025.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public Manufacturer create(String name, String address) {
        return manufacturerRepository.save(new Manufacturer(name, address));
    }

    @Override
    public Manufacturer update(Long id, String name, String address) {
        if (manufacturerRepository.findById(id).isEmpty()) {
            throw new ManufacturerNotFoundException(id);
        }

        return manufacturerRepository.save(new Manufacturer(id, name, address));
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public List<Manufacturer> search(String text) {
        return manufacturerRepository.search(text);
    }

    @Override
    public void delete(Long id) {
        manufacturerRepository.delete(id);
    }
}
