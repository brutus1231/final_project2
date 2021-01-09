package pl.sda.final_project.model;

public enum City {

    WARSAW("Warszawa");

    private String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

}
