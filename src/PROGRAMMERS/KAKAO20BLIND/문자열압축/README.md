## ☑️풀이

### 문자열 자르기, 비교  
String.substring(fromIndex, toIndex) 를 사용하였고, return 값은 String, toIndex 는 포함하지 않음  
  
자를 때 편하게 마지막 range 는 String.length() 로 생각하면됨  
  
연속적으로 나오는 String 에 대해서만 판단을 해주면 됐기 때문에 비교적 쉬웠던 문제라고 생각한다.  
조금 더 꼬았다면 문자열 내에서 압축이 가능한 조합을 다 찾으라고 하거나, 시작 부분이 꼭 처음이 아니여도 되는 등의  
조건이 더 붙었을 것으로 예상한다.  
  
코드에서는 Integer.toString(num).length() 를 통해 자릿수를 구했고
Math.log10(num)+1 로도 구할 수 있는 것을 배웠다.  
  




  
