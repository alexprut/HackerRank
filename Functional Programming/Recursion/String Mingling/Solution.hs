mergeWords :: [a] -> [a] -> [a]
mergeWords (x:xs) (x1:xs1) = x : x1 : (mergeWords xs xs1)
mergeWords _ _ = []

main = do
    word <- getLine
    word1 <- getLine
    putStr (mergeWords word word1)
