package AssignmentTwo.CSC_340;

public class Mods {

    public String summary;

    public double mod_id;

    public String name;

    public String domain_name;

    public Mods(String name, double mod_id, String summary, String domain_name ) {
        this.name = name;
        this.mod_id = mod_id;
        this.domain_name = domain_name;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMod_id() {
        return mod_id;
    }

    public void setMod_id(Double mod_id){
        this.mod_id = mod_id;
    }

    public String getdomain_name(){
        return domain_name;
    }

    public void setdomain_name(String domain_name) {
        this.domain_name = domain_name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
