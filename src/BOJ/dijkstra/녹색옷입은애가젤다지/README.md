# ๐ฃ ์๊ณ ๋ฆฌ์ฆ : dijkstra (Breadth First Search)

์ ์ ๊ฐ์ ์ต๋จ ๊ฑฐ๋ฆฌ๋ฅผ ๊ตฌํ  ๋ ์ฌ์ฉํ  ์ ์๋ ์๊ณ ๋ฆฌ์ฆ  
  
ํ์ค์์๋ ๊ฐ ๋ผ์ฐํฐ ํน์ ์ด์ ์ ์ฌํ ๋ธ๋๊ฐ ์ต๋จ ํต์ ๊ฒฝ๋ก๋ฅผ ๊ตฌํ๋๋ฐ ์ฌ์ฉ๋  ์ ์๋ค๊ณ  ํ๋ค

๊ธฐ๋ณธ์ ์ธ ์์ด๋์ด๋ ํ์ฌ ์์นํ ์ ์ ๋ค์ ๊ธฐ์ค์ผ๋ก ๋ฐฉ๋ฌธํ  ์ ์๋ ๋ธ๋ ์ค ๊ฐ์ฅ ์ต๋จ๊ฑฐ๋ฆฌ์ ์๋ ๋ธ๋๋ฅผ ๋ฐฉ๋ฌธํ๋ ๊ฒ์ธ๋ฐ

ํ์ฌ ๋ด๊ฐ ๊ฐ ์ ์๋ ๊ณณ ์ค ์ต๋จ๊ฑฐ๋ฆฌ์ ์์นํ ๊ณณ์ ๋ค๋ฅธ ์ด๋ค ๊ณณ์ ๊ฒฝ์ ํด์ ๊ฐ๋ ๊ฒ ๋ณด๋ค ๊ธธ์ด๊ฐ ์งง๊ธฐ ๋๋ฌธ์ด๋ค

Min < other1 + other2 ...  
  
๊ทธ๋์ ํ์ฌ ์ ์ ๊น์ง ์ค๋๋ฐ ์์๋ ๋น์ฉ...1

ํด๋น ์ ์ ์ ๋ฐฉ๋ฌธํ๋์ง...2

๋ค์ ๋ฐฉ๋ฌธํ  ์ ์๋ ์ ์ ์ ๋์ฐฉํ  ์ ์๋ ๊ฒฝ์ฐ ์ค ๊ฐ์ฅ ์ต๋จ ๊ฑฐ๋ฆฌ๊ฐ ์ผ๋ง์ง...3

๋ฑ์ ์ ๋ณด๊ฐ ๊ธฐ๋ณธ์ ์ผ๋ก ํ์ํ๋ค

## โ ์๊ณ ๋ฆฌ์ฆ

๋จ ๋ฐฉํฅ์ผ๋ก ๋ฌธ์  ์ํฉ์ด ์ ๊ฐ๋๊ธฐ ๋๋ฌธ์ ๋ค์ต์คํธ๋ผ + BFS ๋ก ํด๊ฒฐํ  ์ ์๋๋ฌธ์ 

์ผ๋ฐ์ ์ธ BFS ๋ฌธ์ ์์๋ visited ๋ฅผ ์ด์ฉํด์ BFS ๋ก ๋ ์ง๋ฅผ ์ธ๋ ๋ฑ์ ๋ก์ง์ ์ฌ์ฉํ์๋๋ฐ

๊ทธ๋ฐ ๋ฌธํญ๊ณผ ๋ค์ ์ฐจ์ด๊ฐ ์๋ ๊ฒ์ BFS ๋ ๋ฌด์กฐ๊ฑด ๋จผ์  ๋ฐฉ๋ฌธํ๋ ์ผ์ด์ค๊ฐ ์ต์  ์ผ์ด์ค๋ผ๋ฉด  
  
๋ค์ต์คํธ๋ผ ๋ฌธํญ์์๋ pq ์์ ๋์ค๊ธฐ ์ ๊น์ง๋ ์ธ์ ๋ ์ง ๊ฒฝ๋ก๊ฐ ์์ ๋  ์ ์๋ค๋ ์ฐจ์ด์ ์ด ์กด์ฌํ๋ค๋ ๊ฒ์ด๋ค

## โ ์๊ณ ๋ฆฌ์ฆ ์ธ


## ๐ ์ ๋ฆฌ



