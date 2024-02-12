/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zad6;
import static com.mycompany.zad6.Zad6.maxTerm;
import java.util.*; 
/**
 *
 * @author gumil
 */
public class Zad6 {
    static boolean isSimple(int k){
        if (k==0) return false;
        if (k==1) return true;
        if (k==2) return true; 
        boolean simple = false; 
        for (int i=2;i<Math.sqrt(k)+1;i++){
            if (k%i!=0) simple = true;
            else return false; 
        }
        return simple; 
    }
    
    static ArrayList<Integer> listSimple(int n){
        ArrayList<Integer> list = new ArrayList(); 
        for (int i=2; i<n+1;i++){
            if (isSimple(i)) list.add(i);
        }
        return list;
    }
    
    static ArrayList<Integer> listDivisors(int n){
        ArrayList<Integer> power = new ArrayList(); 
        int i=2; 
        while(n!=1){ 
            if (isSimple(i)){
                int count=0; boolean divisor = true; 
                while (divisor){
                    if (n%i==0){
                        n=n/i; count++; 
                    }
                    else divisor = false; 
                }
                power.add(count);
            }
            i++; 
        }
        return power;
    }
    
    static ArrayList<Integer> maxTerm(int n){
        ArrayList<Integer> term = new ArrayList();
        switch (n){
            case 0 -> {
                term.add(n); return term; 
            }
            case 1 -> {
                term.add(n); return term; 
            }
            case 2 -> {
                term.add(n); return term; 
            }
            case 3 -> {
                term.add(1);term.add(2); return term; 
            }
        }
        int i=1; 
        while (n>i){
            int difference = n-i; 
            if (difference>i+1) {
                n=n-i; term.add(i); i++; 
            }
            else {
               term.add(n); n=0; 
            }
        }
        return term; 
    }
    
    public static void main(String[] args) {
       int func =0; int sum =0; 
       ArrayList<Integer> divisors = listDivisors(16); 
       for (int i=0; i<divisors.size();i++){
          if(divisors.get(i)!=0){
            func = maxTerm(divisors.get(i)).size(); 
            sum = func + sum;   
          } 
       }
       System.out.println(sum);
    }    
}
//задача нуждается в пояснении. Функция, где нужно максимальное количество операций деления по особому правилу,
//простое число Q в степени w, такое, чтоб больше это число не повторялось. какая была логика - разложить сначала на простые числа искомый х,
//этим занимается функция ListDivitors, которая в соответствии с таблицей простых чисел пишет, какая степень у множителя того или иного числа,
//например для числа 40 массив из [3,0,1], где говорится, что оно делится на 2 в третьей степени, на три не делится, и на пять в степени 1.
//Таблицу простых чисел генерирует listSimple. И потом самая классная часть, нам нужно определить, какие степени простого числа Q надо брать, чтоб
//было максимально много операций. С этим справляется maxTerm, которая высчитывает максимальное количество слагаемых одного числа. Если у нас 2 в степени 16, оно напишет список 
//со всеми слагаемыми, и мы возьмем длину, чтоб узнать, сколько максимально будет действий. На всякий случай я оставляю массив, если вдруг нам понадобится степени.