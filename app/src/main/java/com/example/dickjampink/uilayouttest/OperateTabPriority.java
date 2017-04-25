package com.example.dickjampink.uilayouttest;

/**
 * Created by DickJampink on 2017/3/25.
 */

class OperateTabPriority {
    int getCheckOperateLowBase(char text)
    {
        return this.CheckOperateLowBase(text);
    }

    char getOperate(char Op1, char Op2){

        return this.OperateTab[this.CheckOperateLowBase(Op1)][this.CheckOperateLowBase(Op2)];
    }

    private int CheckOperateLowBase (char text){
        for (int i=0;i<8;i++) {
            if (text == this.Operator[i]) {
                return i;
            }
        }
        return -1;
    }
    boolean CheckfinalTab(char Tab){

        switch (Tab)
        {
            case  '+':
                return true;
            case  '-':
                return true;
            case  '×':
                return true;
            case  '÷':
                return true;
        }
        return false;
    }

    private  char[] Operator = { '+' , '-' , '×' , '÷' , '(' , ')' , '#' , '^' };

    private  char[][] OperateTab = {

            // 运算符优先级表,a1表示运算符栈顶的元素，a2表示将要压栈的运算符，下列数组的对应的数据域就等于两个运算符的优先级
            // a1       a2  '+ ' '-' '×' '÷' '(' ')' '#' '^'

            /*' + '*/      {'>','>','<','<','<','>','>','<'},

            /*' - '*/      {'>','>','<','<','<','>','>','<'},

	        /*' ×'*/       {'>','>','>','>','<','>','>','<'},

	        /*' ÷ '*/      {'>','>','>','>','<','>','>','<'},

	        /*' ( '*/      {'<','<','<','<','<','=',' ','<'},

	        /*' ) '*/      {'>','>','>','>',' ','>','>','>'},

	        /*' # '*/      {'<','<','<','<','<',' ','=','<'},

	        /*' ^ '*/      {'>','>','>','>','<','>','>','>'},

    };

}
