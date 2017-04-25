package com.example.dickjampink.uilayouttest;
import java.util.LinkedList;
/**
 * Created by DickJampink on 2017/3/25.
 */

class ReserveProcess<E> {
    //用LinkedList作为链栈的实现
    private LinkedList<E> ll= new LinkedList<>();

    //入栈：addfirst 从头插入链表，达到入栈的效果。
    void push(E e){
        ll.addFirst(e);
    }

    //查看栈顶元素但不移除
    E peek(){
        return ll.getFirst();
    }

    //出栈：从头移除链表，达到出栈的效果
    E pop(){
        return ll.removeFirst();
    }

    //判空
    boolean empty(){
        return ll.isEmpty();
    }

    //打印栈元素
    public String toString(){
        return ll.toString();
    }

    int Size(){
        return ll.size();
    }

    //清空栈
    void RecycleNull() {ll.clear();}
}
