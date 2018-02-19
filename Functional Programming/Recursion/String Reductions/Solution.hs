removeChar _ [] = []
removeChar m (x:xs)
    | m == x = removeChar m xs
    | otherwise = x : (removeChar m xs)


reduction (x:xs) = x : (reduction (removeChar x xs))
reduction [] = []

main = do
    input <- getLine
    putStr (reduction input)
