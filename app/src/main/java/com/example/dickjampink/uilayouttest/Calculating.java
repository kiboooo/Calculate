package com.example.dickjampink.uilayouttest;


import android.util.Log;

import java.math.BigDecimal;
/**
 * Created by DickJampink on 2017/3/25.
 */
 class Calculating  {
    //构建 操作数栈 和  操作符栈 ；
    private ReserveProcess<String> number = new ReserveProcess<>();
    private ReserveProcess<String> Operate = new ReserveProcess<>();

    //构造方法
    String Calculate(String Expression) throws Exception {

        String Exp = Expression;
        String TempString = "";
        OperateTabPriority check = new OperateTabPriority();
        Operate.push("#");

        while (Exp.length() >= 0) {
            if (Exp.length() > 0) {

                /*
                  检查是否是操作符：
                       与操作符数组相比对。
                       若是操作符，则返回相应的下标
                       若不是操作符，则返回 -1
                 */
                if (check.getCheckOperateLowBase(Exp.charAt(0)) == -1) {

                    //使用字符串拼接，分离出操作符和操作数
                    TempString += Exp.charAt(0);

                    Exp=Exp.substring(1, Exp.length());

                    if (Exp.length()==0) number.push(TempString);

                } else if (check.getCheckOperateLowBase(Exp.charAt(0)) != -1) {
                    String data1, data2, operator;

                    if (!TempString.equals("")){
                        number.push(TempString);
                        TempString = "";
                    }


                    /*
                      将得到的运算符，与运算符栈栈顶的数据相比较，根据优先级数组的关系，进行相应的运算。
                           比栈顶优先级高入栈；
                           比栈顶优先级低，出栈操作符和操作数进行运算后，再压入操作数栈
                           优先级同级，则出现（）相遇，把栈顶出栈即可
                     */
                    switch (check.getOperate(Operate.peek().charAt(0), Exp.charAt(0))) {

                        case '>':
                            data2 = number.pop();
                            data1 = number.pop();
                            operator = Operate.pop();
                            number.push(this.Result(data1, data2, operator));
                            break;
                        case '<':
                            Operate.push(Exp.charAt(0)+"");
                            Exp=Exp.substring(1, Exp.length());

                            break;
                        case '=':
                            Operate.pop();
                            Exp=Exp.substring(1, Exp.length());
                            break;
                    }

                }
            } else if (!Operate.peek().equals("#")){
                try {
                    String data1, data2, operator;
                    data2 = number.pop();
                    data1 = number.pop();
                    operator = Operate.pop();
                    number.push(this.Result(data1, data2, operator));
                } catch (Exception e) {

                    number.RecycleNull();
                    Operate.RecycleNull();
                    throw e;

                }

            }
            else if (Operate.peek().equals("#")) break;
        }
        return number.pop();
    }

    /**
     * 操作数和操作符的相对应出栈进行与运算：
     */
    private String Result(String number1, String number2, String operate) throws  Exception{
        Double result;

        BigDecimal num1 = new BigDecimal(number1);
        BigDecimal num2 = new BigDecimal(number2);

        switch (operate) {
            case "+":

                result = num1.add(num2).doubleValue();
                return result.toString();

            case "-":

                result = num1.subtract(num2).doubleValue();
                return result.toString();

            case "×":

                result = num1.multiply(num2).doubleValue();
                return result.toString();

            case "÷": {

                try {

                    result = num1.divide(num2, 8, BigDecimal.ROUND_HALF_UP).doubleValue();
                    return result.toString();

                } catch (Exception e) {


                    //出现异常，清空两个栈，释放资源
                    number.RecycleNull();
                    Operate.RecycleNull();
                    //把异常向上级抛出，由上级捕获并进行处理。
                    throw e;
                }
            }
        }
        return "";
    }
}
