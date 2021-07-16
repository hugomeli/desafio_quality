package br.com.mercadolivre.bootcamp.desafio_quality.model.service;

import br.com.mercadolivre.bootcamp.desafio_quality.model.DTO.DistrictDTO;
import br.com.mercadolivre.bootcamp.desafio_quality.model.entities.District;
import br.com.mercadolivre.bootcamp.desafio_quality.model.repository.DistrictRepository;
import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.DistrictAlreadySavedException;
import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.DistrictNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void update(District district) {
        if (this.districtRepository.findByName(district.getName()) == null){
            throw new DistrictNotFoundException("Bairro " + district.getName() + " inexistente");
        }
        this.districtRepository.update(district);
    }

    public void delete(String districtName){
        if (this.districtRepository.findByName(districtName) == null){
            throw new DistrictNotFoundException("Bairro " + districtName + " inexistente");
        }
        this.districtRepository.deleteByName(districtName);
    }

    public District read(String districtName) {
        District districtFounded = this.districtRepository.findByName(districtName);
        if (districtFounded == null){
            throw new DistrictNotFoundException("Bairro " + districtName + " inexistente");
        }
        return districtFounded;
    }

    public List<DistrictDTO> readAll() {
        List<District> districts = this.districtRepository.readAll();
        return DistrictDTO.converte(districts);
    }
}
