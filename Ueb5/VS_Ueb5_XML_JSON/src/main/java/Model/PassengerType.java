package Model;

/**
 * Erstellt von  sebsch on 30.12.16.
 */
public class PassengerType {
    private String sex;
    private String country;
    private String name;
    private Boolean packages;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPackages() {
        return packages;
    }

    public void setPackages(Boolean packages) {
        this.packages = packages;
    }

    public String toString(){

        String  p =  (!packages) ? "no" : "";

        return "\nName: \t" + this.name
                + "\nCountry: \t" + this.country
                +"\nSex \t" + this.sex
                + "\nhas " + p + " laguage";
    }
}
