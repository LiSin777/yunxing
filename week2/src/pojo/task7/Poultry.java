package pojo.task7;

public abstract class  Poultry {
    public String name;
    public String symptom;
    public int age;
    public String illness;

    public Poultry() {
    }

    public Poultry(String name, String symptom, int age, String illness) {
        this.name = name;
        this.symptom = symptom;
        this.age = age;
        this.illness = illness;
    }
    public abstract void showSymptom();

    public void showMsg(){
        toString();
    }

    @Override
    public String toString() {
        return "Poultry{" +
                "name=" + name +
                ", symptom='" + symptom + '\'' +
                ", age=" + age +
                ", illness='" + illness + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
}
