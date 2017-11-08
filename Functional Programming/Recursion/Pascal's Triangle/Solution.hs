factorial 0 = 1
factorial n = product [1..n]

calc row column = quot (factorial row) ((factorial column) * (factorial (row-column)))

getRow row 0 = [calc row 0]
getRow row column = (getRow row (column-1)) ++ [calc row column]

getRows 0 = [getRow 0 0]
getRows k = (getRows (k-1)) ++ [getRow k k]

main = do
    k <- getLine
    let r = (read k) - 1
    mapM_ (\x -> do
        mapM_ (\z -> putStr $ (show z) ++ " ") x
        putStr "\n") (getRows r)
