package mk.ukim.finki.wp2025.repository.impl;

import mk.ukim.finki.wp2025.bootstrap.DataHolder;
import mk.ukim.finki.wp2025.model.Manufacturer;
import mk.ukim.finki.wp2025.repository.ManufacturerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepositoryImpl implements ManufacturerRepository {

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return DataHolder.manufacturers.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        DataHolder.manufacturers.removeIf(m -> m.getId().equals(manufacturer.getId()));
        DataHolder.manufacturers.add(manufacturer);
        return manufacturer;
    }

    @Override
    public List<Manufacturer> findAll() {
        return DataHolder.manufacturers;
    }

    @Override
    public List<Manufacturer> search(String text) {
        return DataHolder.manufacturers.stream()
                .filter(m -> m.getName().contains(text) || m.getAddress().contains(text))
                .toList();
    }

    @Override
    public void delete(Long id) {
        DataHolder.manufacturers.removeIf(m -> m.getId().equals(id));
    }
}
