# π£ μκ³ λ¦¬μ¦ : BFS (Breadth First Search)

DFS(Depth First Search)μ κ΅¬λΆλλ νμλ² μ€ νλλ‘, μ νν λΈλμ μΈμ ν λΈλλ₯Ό λ¨Όμ  νμνλ μ λ΅μ΄λ€.<br>
νμλ² μ€μμλ μκ°μ΄ μ‘°κΈ κ±Έλ¦¬λλΌλ μ΄μ¨λ  λͺ¨λ  κ²½μ°λ₯Ό νμν΄λ΄μΌνλ κ²½μ°μ μμ£Ό μ¬μ©λλ€.<br>
μ΅λ¨ κ±°λ¦¬ μ°ΎκΈ°, μ΅λ¨ μκ°(ν λ§ν  λ¬Έμ ) λμΆ λ±μ μ¬μ©λλ€.<br><br>

λ°λλ‘, DFSλ μΌλ¨ λΉ¨λ¦¬ κΈΈ(λͺ©μ λΈλ)μ μ°Ύλκ² μ°μ μΈ κ²½μ°μ μ¬μ©

## β μκ³ λ¦¬μ¦

λͺ¨λ  λΈλλ λ€ μ°κ²°λμ΄μκ³  μ΄ λκ°μ§ λ°©λ²μΌλ‘ ν΄κ²°νλ€<br>
κ°μ₯ λ³΄νΈμ μΌλ‘ μ¬μ©λλ dfs λ₯Ό μ¬μ©ν΄μ ν λΈλμμ κ°μ₯ κΉμ κ³³μ μλ λΈλ νμ<br>
-> μ΄κ±΄ μ΄μ  κ°μ₯ λ°κΉ₯μͺ½μ μλ λΈλλ₯Ό μλ―Ένλ€<br>
κ°μ₯ λ°κΉ₯μͺ½ λΈλμμ λ€μ κ°μ₯ λ©λ¦¬μλ λΈλλ₯Ό μ°Ύλλ€λ©΄ κ°μ₯ λ°κΉ₯μͺ½μ μλ λ λΈλ μ¬μ΄μ κ±°λ¦¬κ° λλ―λ‘ μ§λ¦μ΄ λλ€.<br><br>

λ λ²μ§Έ λ°©λ²μΌλ‘λ λΈλ μ€μ¬μΌλ‘ κ°μ μ κΈΈμ΄κ° 1, 2 λ²μ§Έλ‘ κΈ΄ κ²μ κ³¨λΌμ λν κ²μ΄ μ΅λκ°μ΄ λλ κ²½μ°λ₯Ό μ°Ύλ κ²μ΄λ€.<br>
μ¬κ· ννλ‘ κ΅¬μ±μ νκΈ° λλ¬Έμ λͺ¨λ  subtree μ λν΄μλ λ€ νμΈν  μ μκ³  νλ² νμΈν κ°μ μ λ¦¬ν΄κ°μ ν¬ν¨μμΌμ(node.weight)<br>
λ°ννκΈ° λλ¬Έμ λ€μ νμΈν  μΌλ μλ€.

## β μκ³ λ¦¬μ¦ μΈ

μμμ λ€ νμν΄μΌνλ(μμκ° μκ΄μλ) κ²½μ°μλ LinkedList λ₯Ό μ¬μ©<br> 

## π μ λ¦¬

Node κ΅¬μ‘°κ° μ£Όμ΄μ‘μ λ μ΄λ»κ² ν΄λΉ κ΅¬μ‘°λ₯Ό κ΅¬νν μ§μ λν μ°μ΅ νμ


