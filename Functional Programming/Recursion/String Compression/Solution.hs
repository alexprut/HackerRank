encode :: String -> Int -> String
encode (x1:x2:xs) n = if (x1 == x2)
  then encode (x1:xs) (n+1)
  else if n > 1
    then (x1:(show n) ++ (encode (x2:xs) 1))
    else (x1 : (encode (x2:xs) 1))

encode (x:[]) n = if n > 1
    then (x:(show n) ++ [])
    else (x:[])

encode _ _ = []

main = do
    e <- getLine
    putStr (encode e 1)
