package br.com.mercadolivre.bootcamp.desafio_quality.model.service;

import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import br.com.mercadolivre.bootcamp.desafio_quality.model.repository.DistrictRepository;
import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.DistrictAlreadySavedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public void create(District district) {
        if (this.districtRepository.findByName(district.getName()) != null){
            throw new DistrictAlreadySavedException(
                    "O bairro " + district.getName() + " já está cadastrado no sistema!");
        }
        this.districtRepository.save(district);
    }
}
