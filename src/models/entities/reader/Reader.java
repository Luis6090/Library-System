package models.entities.reader;

public class Reader {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phoneNumber;
    private String cep;
    private String adressLine;
    private String adressNumber;
    private String neighborhood;
    private String city;
    private String stateCountry;

    public Reader(Long id,
                  String name,
                  String cpf,
                  String email,
                  String phoneNumber,
                  String cep, String adressLine,
                  String adressNumber,
                  String neighborhood,
                  String city,
                  String stateCountry
    ){

        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.cep = cep;
        this.adressLine = adressLine;
        this.adressNumber = adressNumber;
        this.neighborhood = neighborhood;
        this.city = city;
        this.stateCountry = stateCountry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        this.cep = cep;
    }

    public String getAdressLine() {
        return adressLine;
    }

    public void setAdressLine(String adressLine) {
        this.adressLine = adressLine;
    }

    public String getAdressNumber() {
        return adressNumber;
    }

    public void setAdressNumber(String adressNumber) {
        this.adressNumber = adressNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateCountry() {
        return stateCountry;
    }

    public void setStateCountry(String stateCountry) {
        this.stateCountry = stateCountry;
    }
}
