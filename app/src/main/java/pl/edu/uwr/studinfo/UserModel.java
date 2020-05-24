package pl.edu.uwr.studinfo;

public class UserModel {
    private String nr_indeksu;
    private String pass1;
    private String pass2;

    public UserModel(String nr_indeksu, String pass1, String pass2) {
        this.nr_indeksu = nr_indeksu;
        this.pass1 = pass1;
        this.pass2 = pass2;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "nr_indeksu='" + nr_indeksu + '\'' +
                ", pass1='" + pass1 + '\'' +
                ", pass2='" + pass2 + '\'' +
                '}';
    }
    // getters and setters

    public String getNr_indeksu() {
        return nr_indeksu;
    }

    public void setNr_indeksu(String nr_indeksu) {
        this.nr_indeksu = nr_indeksu;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
}
