/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.eniso.tp1;
import java.util.Scanner;

public class TP1 {
public static void Ex2(){
 Scanner read= new Scanner(System.in);
        System.out.println("Bonjour , mon premiere Tp en POO");
        System.out.println("quelle est votre nom ?");
    String name=read.next();
     System.out.println("\n bonjour "+name);
        System.out.println("quelle est votre age "+name+" ?");
      int a=read.nextInt();
      System.out.println(" "+name+" votre age est "+a);}



    public static void main(String[] args) {
   
       Integer L=0;
       Integer C=0;
     
       Scanner read= new Scanner(System.in);
       do{
        System.out.println("donner nombre de ligne");
         L=read.nextInt();
       }while(L<0);
        
     do{ System.out.println("donner le nombre de colonne "); 
      C=read.nextInt();
     
       }while(C<0);
     Integer n=0;
         Integer [][] image=new Integer[L][C];
       for(Integer i=0;i<L;i++)
           {
            for(Integer j=0;j<C;j++){
           
                do{ System.out.println("donner un nombre ["+i+"]["+j+"]"); 
      n=read.nextInt();
     
       }while(n<0 || n>255);
           
           image[i][j]=n;
           }
           }
      double [] P=  calculateProbability(image);
        for (Integer i=0;i<=255 ;i++){
        System.out.println("P ["+i+"]="+P[i]);

    }
     double  H = calculateEntropy(image);
                 System.out.println("Entropy ="+ H);
    }
    public static Integer occ(Integer i ,Integer[][] image ){
      Integer occ=0;
      for (Integer j=0;j<image.length;j++){
           for (Integer k=0;k<image[0].length ;k++){
    if(i==image[j][k]) occ++;
       
    
    }
 
    }
      return occ;
    }
    public static double[] calculateProbability(Integer[][] image){
    double [] P = new double[256];
    for (Integer i=0;i<=255 ;i++){ 
    P[i]=(double) occ(i,image)/image.length*image[0].length;
    }
    return P ;
    }
    
    
    public static double calculateEntropy(Integer[][] image){
    double H=0;
     double [] P=  calculateProbability(image);
    
    for(int i=0;i<=255;i++){
        if(P[i]>0) H= H+ (P[i]*(Math.log(P[i])/Math.log(2)));
    }
  
    H=-H;
    return H;
    }
    
}
