countColors colors [] = colors
countColors (r, g, y, b) (x:xs)
    | x == 'R' = countColors (r + 1, g, y, b) xs
    | x == 'G' = countColors (r, g + 1, y, b) xs
    | x == 'Y' = countColors (r, g, y + 1, b) xs
    | otherwise = countColors (r, g, y, b + 1) xs

substractColor (r, g, y, b) x
    | x == 'R' = (r - 1, g, y, b)
    | x == 'G' = (r, g - 1, y, b)
    | x == 'Y' = (r, g, y - 1, b)
    | otherwise = (r, g, y, b - 1)

isPrefixOk [] _ = True
isPrefixOk (x:xs) (r, g, y, b) = if (abs (r - g)) <= 1 && (abs (y - b)) <= 1
    then isPrefixOk (xs) (substractColor (r, g, y, b) x)
    else False

isFullColor [] = True
isFullColor word = if r == g && y == b
    then (isPrefixOk word (r, g, y, b))
    else False
    where (r, g, y, b) = countColors (0, 0, 0, 0) word

main = do
    _ <- getLine
    lines <- getContents
    let ws = words lines
    mapM_ (\x -> putStrLn (if (isFullColor (reverse x)) then "True" else "False")) ws
