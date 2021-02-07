package pojo.task7;

public class Duck extends Poultry{

    public Duck() {
    }

    public Duck(String name, String symptom, int age, String illness) {
        super(name, symptom, age, illness);
    }

    @Override
    public void showSymptom() {
        System.out.println("动物种类：" + getName());
        System.out.println("年龄：" + getAge());
        System.out.println("入院原因：" + getIllness());
        System.out.println("症状为：" + getSymptom());
    }
}
