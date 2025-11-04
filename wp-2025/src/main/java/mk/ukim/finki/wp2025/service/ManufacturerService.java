package mk.ukim.finki.wp2025.service;

import mk.ukim.finki.wp2025.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    Optional<Manufacturer> findById(Long id);

    Manufacturer create(String name, String address);

    Manufacturer update(Long id, String name, String address);

    List<Manufacturer> findAll();

    List<Manufacturer> search(String text);

    void delete(Long id);
}
