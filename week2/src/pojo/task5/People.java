package pojo.task5;

import pojo.task5.Monkey;

public class People extends Monkey {
    public People() {
    }

    @Override
    public void speak(){
        System.out.println("不错嘛,会说话");
    }

    public void think(){
        System.out.println("别说话认真思考");
    }
}
