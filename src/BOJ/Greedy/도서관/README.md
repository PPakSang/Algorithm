# π£ μκ³ λ¦¬μ¦ : Greedy

νμμ€λ½κ³  μμ¬λ§μ μ λ΅μ ννλ€ ν΄μ Greedy νλ€κ³  λΆλ¦¬λ μ΄ μκ³ λ¦¬μ¦μ<br>
λμκ² λΉμ₯ κ°μ₯ λ§μ μ΄λμ κ°μ Έλ€ μ€ κ²μΌλ‘ μμλλ νλμ μ·¨νλ λ°©μμ΄λ€. ~~νν¬ν?~~<br>
μκ³ λ¦¬μ¦μ νμ΅νλ©΄μ λλμ μ μνμ μΈ λ¬Έν­μ ν λ μμ£Όλμ€κ³ , κ·Έλ κΈ° λλ¬Έμ μ‘°κ±΄μμ μ λ§λ€μ΄μΌνλ€.  
  
μκ³ λ¦¬μ¦μμ μ΅μ  νλΆ κ΅¬μ‘°λ₯Ό κ°μ§λ ννμ ν΄λ₯Ό μ°Ύλ κ²μ΄ ν΅μ¬  
μ¬μ€ μ΄ λ¬Έμ₯μ λ³΄κ³  νλ²μ μλΏμ§ μμλλ°, λ€μκ³Ό κ°μ μλ―Έλ₯Ό κ°μ§λ€κ³  νλ¨μ νμλ€.  
  
μ°μ  μ΅μ  νλΆ κ΅¬μ‘°λ₯Ό κ°μ§λ ν΄λ₯Ό μ°ΎκΈ° μν΄μλ λ§€ λ¬Έμ  μν©λ§λ€ μ΄μ μ ν΄κ° νμνμ§ μμ κ²½μ°κ° λ  κ²μ΄λ€.  
μλνλ©΄ μ΄μ μ ν΄κ° νμ¬μ λ¬Έμ μν©μ μν₯μ μ€λ€λ©΄ κ·Έλ¦¬λμ λ³Έμ§μΈ "νμ¬ μ νν  μ μλ κ°μ₯ μ΅μ μ ν΄" λ₯Ό μ€μ²ν  μ μμ κ²μ΄λ€.  
μ€νλ € DP κ° μ΅μ  νλΆ κ΅¬μ‘° λ° μ΄μ μ ν΄λ₯Ό μ΄μ©ν λ¬Έμ νμ΄μλ λ μ κ²©μΌ κ²μ΄λ€.  
  
λ€μ λμμμ νμ¬ λ¬Έμ  μν©μμ λ€μ λ¬Έμ μν©μΌλ‘ λμ΄κ° μ μλ μ νμ§ μ€ νμ¬ λ¬Έμ μν©μ κ°μ₯ ν¬κ²(?) ν΄κ²°ν  μ μλ ν΄λ₯Ό μ°Ύλλ€.<br>  

κ°λ¨ν μ¦λͺ(?) μ΄λΌκ³  νλ©΄, λ€μ λ¬Έμ  μν©μ΄ μ΄μ  ν΄μ μλ¬΄λ° μ°κ΄μ΄ μλ€λ μ μ κ° μκΈ° λλ¬Έμ   
λΉμ°ν νμ¬ κ°μ₯ μ΄λμ μ·¨ν  μ μλ ν΄λ₯Ό μ°Ύλ κ²μ΄ κ·Έ μ΄μ μ΄λ€.

## β μκ³ λ¦¬μ¦

μ€νμ μ΅μν ν΄μΌνλ€. λΆκ°μ μΌλ‘ λΆμ μ΄λμ κΎν  μ μλ μ‘°κ±΄μ μλμ κ°λ€.  
1. μ±μ μ¬λ¬κΆ λ€ μ μλ€.  
2. λ§μ§λ§μλ λμμ¬ νμκ° μλ€.

μ΄λ₯Ό λ°νμΌλ‘ κ·Έλ¦¬λμ κ΄μ μΌλ‘λ νλ²μ λ©λ¦¬μλ μ±μ μ¬λ¬κΆ μ±κ²¨λ€κ³  λ°°λ¬νκ³  μμΌ λ©λ¦¬ λ λ² κ° μΌμ΄ μ€μ΄λ€ μ μλ€λ κ²μ΄λ€.  
λν λ§μ§λ§μλ λμμ¬ νμκ° μλ€λ λ§μ΄ κ°μ₯ λ©λ¦¬ μλ κ³³μ μλ€ κ°λ€ ν  νμκ° μλ€λ μλ―Έκ° λ  κ²μ΄λ€.  
  
μ κ·Όκ±°λ₯Ό ν λλ‘ μ°μ  μ’, μ°λ‘ λμΈ μ± κ±°λ¦¬λ₯Ό λ°λ‘ μ λ ¬νλ€ (0 μ§μ μμ μ±μ μ΄μ°¨νΌ λ€μ κ°μ Έκ° μ μκΈ° λλ¬Έμ)  
μ’ μ° ν©μ³μ κ°μ₯ λ©λ¦¬μλ μμΉλΆν° mκ°μ μ± κΉμ§λ ν λ²λ§ λ°©λ¬Ένλ κ²μ΄ μ΄λμ΄κ³ , λλ¨Έμ§λ μλ€ κ°λ€ ν΄μΌνλ€.  
μλ€ κ°λ€ ν  λλ m κ°μ© λ¬Άμ΄μ κ°μ₯ λ¨Ό κ³³λ§ λ λ² μλ€ κ°λ€ νλ©΄λλ€.  
  
μ΄ λ μ΅μ  νλΆ κ΅¬μ‘°λ₯Ό κ΅¬νλ ν΅μ¬μ κ°μ₯ λ¨Ό κ³³ λΆν° κ°λ€ μμΌνλ κ²μΈλ°, κ·Έ μ΄μ κ° κ°κΉμ΄ κ³³ λΆν° m κ°μ© λ¬ΆμΌλ©΄  
μ±μ΄ λ± m κ°λ‘ λλ  λ¨μ΄μ§λ©΄ μκ΄ μμ§λ§ m - k κ°μ μ±μ΄ μ΅μ’μ μΌλ‘ λ¨μλ€λ©΄ μ‘°κΈ μμ¬μ΄ λ³΄ν­(?) μΈλ°  
μμ¬μ΄ λ³΄ν­μ μ§§μ κ±°λ¦¬λ₯Ό κ°λ κ²μ μ°λ κ²μ΄ μ΅μ μ ν΄λ₯Ό μ°Ύλ λ°©λ²μ΄λ€.
  
## β μκ³ λ¦¬μ¦ μΈ

μ λ ¬μ΄ νμν μΌμ΄μ€μ¬μ μ½μ μ­μ  νμ(subSet μμ±) λͺ¨λ logN μ΄ μμλλ TreeSet μ μ ννλ€  
μ΅μ μ μκ°μ λΌ κ²μ΄λΌ κΈ°λνμ§λ§ λ€λ₯Έ μ¬λλ€μ νμ΄λ₯Ό λ³΄λ Priority Queue λ₯Ό μ¬μ©νλ κ²λ λμμ§ μμ λ³΄μΈλ€.  
  
TreeSet μ subTree λ List μλ£νμ μ¬μ©νκΈ° λλ¬Έμ toArray νΈμΆμ΄ κ°λ₯νλ€.    
μ¬κΈ°μ μλ‘ μ λΆλΆμΈλ° toArray κ° reference νμμ κ²½μ°μλ Object[] λ‘ λ³ννλ€.  
μ°λ¦¬κ° μλνλκ±΄ ν΄λΉ List type Array λ³νμΈλ° μ΄λ toArray μ μΈμλ‘ size -> Array μμ±μ ν¨μλ₯Ό λκ²¨μ£Όλ©΄ λλ€.

## π μ λ¦¬

μμ 


