package br.com.mercadolivre.bootcamp.desafio_quality.model.entities;

public enum DistrictsNames {

    ARTURALVIM("Artur Alvim"),
    LIBERDADE("Liberdade"),
    SE("Sé"),
    VILAMATILDE("Vila Matilde");

    public String districtName;


    DistrictsNames(String name) {
        districtName = name;
    }

    public String getDistrictName() {
        return districtName;
    }
}
