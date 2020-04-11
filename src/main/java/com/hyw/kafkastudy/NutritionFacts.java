package com.hyw.kafkastudy;

/**
 * @Auther: Huangyuanwei
 * @Date: 2019/11/1 09:59
 * @Description:
 */
public class NutritionFacts {

    private  int servingSize;
    private  int servings;
    private  int calores;

    public NutritionFacts(Builder builder) {

        if (builder.servingSize == 0){
            throw new IllegalArgumentException("参数错误");
        }

        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calores = builder.calores;
    }

    public static class Builder{
        private  int servingSize;
        private  int servings;
        private  int calores;



        public Builder builderServings(int servings){
            this.servings = servings;
            return this;
        }
        public Builder builderCalores(int calores){
            this.calores = calores;
            return this;
        }

        public NutritionFacts build(){
           return new NutritionFacts(this);
        }
    }

    public static void main(String[] args) {

    }

}
